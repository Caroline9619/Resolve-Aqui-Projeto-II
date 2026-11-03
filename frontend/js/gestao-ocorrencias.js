document.addEventListener('DOMContentLoaded', () => {
    // Dados para preencher o painel
    const dadosOcorrencias = {
        '1': {
            protocolo: 'RA-2026-000123',
            endereco: 'Rua das Flores, 120',
            prioridade: 'Alta',
            status: 'Encaminhada à Gestão',
            descricao: 'Poste com lâmpada queimada há mais de uma semana. Rua muito escura gerando insegurança para os moradores.',
            anexos: ['foto_poste_01.jpg', 'protocolo_iluminacao.pdf']
        },
        '2': {
            protocolo: 'RA-2026-000124',
            endereco: 'Praça Central',
            prioridade: 'Crítica',
            status: 'Em atraso',
            descricao: 'Praça abandonada com brinquedos quebrados, mato alto e acúmulo de lixo.',
            anexos: ['foto_praca_01.jpg', 'foto_praca_02.jpg']
        }
    };

    // Elementos da página
    const radios = document.querySelectorAll('input[name="ocorrencia"]');
    const painelVazio = document.getElementById('painelVazio');
    const painelOcorrencia = document.getElementById('painelOcorrencia');

    const elProtocolo = document.getElementById('protocolo');
    const elEndereco = document.getElementById('endereco');
    const elPrioridade = document.getElementById('prioridade');
    const elStatusAtual = document.getElementById('statusAtual');
    const elDescricao = document.getElementById('descricao');
    const elListaAnexos = document.getElementById('listaAnexos');

    const btnAtualizar = document.getElementById('btnAtualizar');
    const btnEncaminhar = document.getElementById('btnEncaminhar');

    let idSelecionado = null;

    // 1. Ação ao Clicar no Radio Button
    radios.forEach(radio => {
        radio.addEventListener('change', (e) => {
            idSelecionado = e.target.value;
            const dados = dadosOcorrencias[idSelecionado];

            if (dados) {
                // Preenche os dados
                elProtocolo.textContent = dados.protocolo;
                elEndereco.textContent = dados.endereco;
                elPrioridade.textContent = dados.prioridade;
                elStatusAtual.textContent = dados.status;
                elDescricao.value = dados.descricao;

                // Renderiza os anexos
                elListaAnexos.innerHTML = '';
                dados.anexos.forEach(anexo => {
                    const item = document.createElement('div');
                    item.className = 'anexo';
                    item.innerHTML = `<i class="fa-solid fa-paperclip"></i> <span>${anexo}</span>`;
                    elListaAnexos.appendChild(item);
                });

                // Exibe o painel de análise
                painelVazio.classList.add('oculto');
                painelOcorrencia.classList.remove('oculto');
            }
        });
    });

    // 2. Ação ao Clicar em "Atualizar Ocorrência"
    if (btnAtualizar) {
        btnAtualizar.addEventListener('click', () => {
            const solucao = document.getElementById('solucao').value.trim();
            const novoStatus = document.getElementById('novoStatus').value;

            if (!solucao || !novoStatus) {
                alert('Por favor, descreva a Solução e selecione o Novo Status.');
                return;
            }

            // Simulação de salvamento no histórico e notificação por e-mail/SMS
            console.log(`Notificação enviada ao cidadão para a ocorrência ${elProtocolo.textContent}.`);
            alert('Ocorrência atualizada com sucesso! Notificação enviada ao cidadão.');

            // Redireciona para a tela resultado-analise-gestao.html
            window.location.href = 'resultado-analise-gestao.html';
        });
    }

    // 3. Ação ao Clicar em "Encaminhar para Órgão Competente"
    if (btnEncaminhar) {
        btnEncaminhar.addEventListener('click', () => {
            // Redireciona para a tela orgao-competente.html
            window.location.href = 'orgao-competente.html';
        });
    }
});document.addEventListener('DOMContentLoaded', () => {
    // Banco de dados simulado
    const ocorrenciasDB = {
        '1': {
            protocolo: 'RA-2026-000123',
            endereco: 'Rua das Flores, 120',
            prioridade: 'Alta',
            status: 'Encaminhada à Gestão',
            descricao: 'Poste com lâmpada queimada há mais de uma semana. Rua muito escura gerando insegurança para os moradores no período noturno.',
            anexos: ['foto_poste_01.jpg', 'protocolo_iluminacao.pdf']
        },
        '2': {
            protocolo: 'RA-2026-000124',
            endereco: 'Praça Central',
            prioridade: 'Crítica',
            status: 'Em atraso',
            descricao: 'Praça abandonada com brinquedos do playground quebrados, mato alto e acúmulo de lixo na área central.',
            anexos: ['foto_praca_01.jpg', 'foto_praca_02.jpg']
        }
    };

    // Mapeamento dos elementos do DOM
    const painelVazio = document.getElementById('painelVazio');
    const painelOcorrencia = document.getElementById('painelOcorrencia');
    const tabela = document.getElementById('tabelaOcorrencias');

    const elProtocolo = document.getElementById('protocolo');
    const elEndereco = document.getElementById('endereco');
    const elPrioridade = document.getElementById('prioridade');
    const elStatusAtual = document.getElementById('statusAtual');
    const elDescricao = document.getElementById('descricao');
    const elListaAnexos = document.getElementById('listaAnexos');

    const elSolucao = document.getElementById('solucao');
    const elNovoPrazo = document.getElementById('novoPrazo');
    const elNovoStatus = document.getElementById('novoStatus');

    const btnAtualizar = document.getElementById('btnAtualizar');
    const btnEncaminhar = document.getElementById('btnEncaminhar');

    let ocorrenciaAtivaId = null;

    // Função para carregar os dados no painel
    function carregarPainel(id) {
        const dados = ocorrenciasDB[id];
        if (!dados) return;

        ocorrenciaAtivaId = id;

        // Preenche as informações
        elProtocolo.textContent = dados.protocolo;
        elEndereco.textContent = dados.endereco;
        elPrioridade.textContent = dados.prioridade;
        elStatusAtual.textContent = dados.status;
        elDescricao.value = dados.descricao;

        // Limpa e desenha os anexos
        elListaAnexos.innerHTML = '';
        if (dados.anexos && dados.anexos.length > 0) {
            dados.anexos.forEach(anexo => {
                const item = document.createElement('div');
                item.className = 'anexo';
                item.innerHTML = `<i class="fa-solid fa-paperclip"></i> <span>${anexo}</span>`;
                elListaAnexos.appendChild(item);
            });
        } else {
            elListaAnexos.innerHTML = '<p style="color:#777; font-size:13px;">Nenhum anexo encontrado.</p>';
        }

        // Alterna os painéis
        if (painelVazio) painelVazio.classList.add('oculto');
        if (painelOcorrencia) painelOcorrencia.classList.remove('oculto');
    }

    // Escuta cliques na tabela (seja na linha, no radio ou no botão Ver)
    if (tabela) {
        tabela.addEventListener('click', (e) => {
            const linha = e.target.closest('tr[data-id]');
            if (!linha) return;

            const id = linha.getAttribute('data-id');
            const radio = linha.querySelector('input[type="radio"]');
            
            if (radio) {
                radio.checked = true;
            }

            carregarPainel(id);
        });
    }

    // Botão "Atualizar Ocorrência"
    if (btnAtualizar) {
        btnAtualizar.addEventListener('click', (e) => {
            e.preventDefault();

            if (!ocorrenciaAtivaId) {
                alert('Selecione uma ocorrência primeiro.');
                return;
            }

            const solucao = elSolucao ? elSolucao.value.trim() : '';
            const novoStatus = elNovoStatus ? elNovoStatus.value : '';

            if (!solucao || !novoStatus) {
                alert('Por favor, informe a Solução da Gestão e selecione o Novo Status.');
                return;
            }

            // Grava histórico e simula envio de notificação
            const historico = JSON.parse(localStorage.getItem('historicoOcorrencias') || '[]');
            historico.push({
                protocolo: elProtocolo.textContent,
                solucao: solucao,
                novoPrazo: elNovoPrazo ? elNovoPrazo.value : '',
                novoStatus: novoStatus,
                dataHora: new Date().toLocaleString('pt-BR')
            });
            localStorage.setItem('historicoOcorrencias', JSON.stringify(historico));

            alert(`Ocorrência ${elProtocolo.textContent} atualizada!\nNotificação enviada ao cidadão via E-mail/SMS.`);

            // Redireciona para resultado-analise-gestao.html
            window.location.href = 'resultado-analise-gestao.html';
        });
    }

    // Botão "Encaminhar para Órgão Competente"
    if (btnEncaminhar) {
        btnEncaminhar.addEventListener('click', (e) => {
            e.preventDefault();

            if (ocorrenciaAtivaId) {
                localStorage.setItem('ocorrenciaEncaminhadaProtocolo', elProtocolo.textContent);
            }

            // Redireciona para orgao-competente.html
            window.location.href = 'orgao-competente.html';
        });
    }
});
document.addEventListener("DOMContentLoaded", function () {

    /*
     * ================================
     * NOME DO USUÁRIO
     * ================================
     *
     * Por enquanto estamos utilizando
     * um nome de exemplo.
     *
     * Posteriormente esse nome será
     * carregado do banco de dados
     * após o login do cidadão.
     */

    const nomeUsuario = document.getElementById("nomeUsuario");

    const nome = "João da Silva";

    nomeUsuario.textContent = nome;


    /*
     * ================================
     * OCORRÊNCIAS
     * ================================
     *
     * Estes registros são apenas
     * exemplos para visualizar
     * o funcionamento da tela.
     *
     * Posteriormente serão buscados
     * no banco de dados.
     */

    const ocorrencias = [
        {
            titulo: "Buraco na rua em frente à residência",
            data: "03/09/2026",
            protocolo: "RA-2026-000123",
            status: "Em análise"
        },

        {
            titulo: "Lâmpada de iluminação pública apagada",
            data: "01/09/2026",
            protocolo: "RA-2026-000098",
            status: "Resolvida"
        },

        {
            titulo: "Acúmulo de lixo em área pública",
            data: "28/08/2026",
            protocolo: "RA-2026-000075",
            status: "Recebida"
        }
    ];


    /*
     * Futuramente esta função poderá
     * receber os dados diretamente
     * da API / banco de dados.
     */

    function carregarOcorrencias() {

        console.log("Ocorrências carregadas:", ocorrencias);

    }

    carregarOcorrencias();

});
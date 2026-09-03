document.addEventListener("DOMContentLoaded", function () {

    /*NOME DO USUÁRIO*/

    const nomeUsuario = document.getElementById("nomeUsuario");

    const nome = "João da Silva";

    nomeUsuario.textContent = nome;


    /* OCORRÊNCIAS*/

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


    /* receber os dados diretamente da API / banco de dados. */

    function carregarOcorrencias() {

        console.log("Ocorrências carregadas:", ocorrencias);

    }

    carregarOcorrencias();

});
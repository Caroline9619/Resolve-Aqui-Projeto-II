document.addEventListener("DOMContentLoaded", function () {

    const resultado = JSON.parse(localStorage.getItem("resultadoServidor"));

    const agora = new Date();

    document.getElementById("dataAnalise").textContent =
        agora.toLocaleString("pt-BR");

    if (resultado) {

        document.getElementById("categoria").textContent = resultado.categoria;
        document.getElementById("protocolo").textContent = resultado.protocolo;
        document.getElementById("cidadao").textContent = resultado.cidadao;
        document.getElementById("statusAtual").textContent = resultado.status;

        // Se a ocorrência foi encaminhada para a Gestão Municipal
        if (resultado.encaminhado) {

            document.getElementById("tituloResultado").textContent =
                "Ocorrência encaminhada com sucesso!";

            document.getElementById("subtituloResultado").textContent =
                "A ocorrência foi encaminhada para a Gestão Municipal e o cidadão será notificado.";

            // Salva os dados que serão utilizados pela tela da Gestão
            localStorage.setItem("resultadoGestao", JSON.stringify({
                categoria: resultado.categoria,
                protocolo: resultado.protocolo,
                cidadao: resultado.cidadao,
                status: "Aguardando análise da Gestão Municipal",
                encaminhado: false
            }));
        }
    }

    alert("Notificação enviada ao cidadão pelo e-mail ou celular cadastrado.");
});
const btnVoltar = document.getElementById("btnVoltar");

btnVoltar.addEventListener("click", function () {

    const resultado = JSON.parse(localStorage.getItem("resultadoServidor"));

    if (resultado && resultado.encaminhado) {

        // Vai para o Painel da Gestão
        window.location.href = "gestao-ocorrencias.html";

    } else {

        // Volta para a lista do Servidor
        window.location.href = "ocorrencias-servidor.html";

    }

});
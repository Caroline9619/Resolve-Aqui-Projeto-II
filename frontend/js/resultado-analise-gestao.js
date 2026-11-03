document.addEventListener("DOMContentLoaded", function(){

    const agora = new Date();

    document.getElementById("dataAnalise").textContent =
        agora.toLocaleString("pt-BR");

    const resultado =
        JSON.parse(localStorage.getItem("resultadoGestao"));

    if(resultado){

        document.getElementById("categoria").textContent =
            resultado.categoria;

        document.getElementById("protocolo").textContent =
            resultado.protocolo;

        document.getElementById("cidadao").textContent =
            resultado.cidadao;

        document.getElementById("statusAtual").textContent =
            resultado.status;

        if(resultado.encaminhado){

            document.getElementById("tituloResultado").textContent =
                "Ocorrência encaminhada com sucesso!";

            document.getElementById("subtituloResultado").textContent =
                "A ocorrência foi encaminhada ao órgão competente e o cidadão será notificado.";

        }

        if(resultado.status === "Resolvida"){

            document.getElementById("statusAtual").textContent =
                "Resolvida";

        }

    }

    alert("Notificação enviada ao cidadão pelo e-mail ou celular cadastrado.");

});
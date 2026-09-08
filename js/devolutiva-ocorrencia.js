document.addEventListener("DOMContentLoaded", function(){

    // Recupera protocolo salvo na tela anterior

    const protocoloSalvo =
        localStorage.getItem("protocoloGerado");

    if(protocoloSalvo){

        document.getElementById("protocolo").textContent =
            protocoloSalvo;

    }

    // Data atual

    const hoje = new Date();

    document.getElementById("dataEnvio").textContent =
        hoje.toLocaleDateString("pt-BR");

});
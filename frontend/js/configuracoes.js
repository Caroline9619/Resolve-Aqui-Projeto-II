document.addEventListener("DOMContentLoaded", function(){

    document.querySelectorAll(".opcao[href='#']").forEach(function(botao){

        botao.addEventListener("click", function(e){

            e.preventDefault();

            alert("Esta funcionalidade será integrada na próxima versão do Resolve Aqui.");

        });

    });

});
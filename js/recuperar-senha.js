const formulario = document.getElementById("recuperacaoForm");

const email = document.getElementById("email");

const mensagemSucesso = document.getElementById("mensagemSucesso");


formulario.addEventListener("submit", function (evento) {

    evento.preventDefault();

    if (email.value.trim() === "") {

        alert("Digite seu e-mail.");

        email.focus();

        return;
    }


    if (!email.validity.valid) {

        alert("Digite um e-mail válido.");

        email.focus();

        return;
    }


    mensagemSucesso.style.display = "block";

    formulario.reset();

});
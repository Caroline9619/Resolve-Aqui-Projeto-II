const formulario = document.getElementById("redefinirForm");

const senha = document.getElementById("senha");

const confirmarSenha = document.getElementById("confirmarSenha");

const areaFormulario = document.getElementById("areaFormulario");

const mensagemSucesso = document.getElementById("mensagemSucesso");

const mensagemExpirada = document.getElementById("mensagemExpirada");


const criterioTamanho = document.getElementById("criterioTamanho");

const criterioMaiuscula = document.getElementById("criterioMaiuscula");

const criterioMinuscula = document.getElementById("criterioMinuscula");

const criterioNumero = document.getElementById("criterioNumero");

const criterioEspecial = document.getElementById("criterioEspecial");



function verificarSenha() {

    const valor = senha.value;


    const tamanho = valor.length >= 8;

    const maiuscula = /[A-Z]/.test(valor);

    const minuscula = /[a-z]/.test(valor);

    const numero = /[0-9]/.test(valor);

    const especial = /[^A-Za-z0-9]/.test(valor);


    criterioTamanho.textContent =
        (tamanho ? "✅ " : "❌ ") +
        "Pelo menos 8 caracteres";


    criterioMaiuscula.textContent =
        (maiuscula ? "✅ " : "❌ ") +
        "Pelo menos uma letra maiúscula";


    criterioMinuscula.textContent =
        (minuscula ? "✅ " : "❌ ") +
        "Pelo menos uma letra minúscula";


    criterioNumero.textContent =
        (numero ? "✅ " : "❌ ") +
        "Pelo menos um número";


    criterioEspecial.textContent =
        (especial ? "✅ " : "❌ ") +
        "Pelo menos um caractere especial";


    return (
        tamanho &&
        maiuscula &&
        minuscula &&
        numero &&
        especial
    );
}


senha.addEventListener("input", verificarSenha);



formulario.addEventListener("submit", function (evento) {

    evento.preventDefault();


    if (!verificarSenha()) {

        alert(
            "A senha não atende a todos os critérios de segurança."
        );

        senha.focus();

        return;
    }


    if (senha.value !== confirmarSenha.value) {

        alert("As senhas não coincidem.");

        confirmarSenha.focus();

        return;
    }


    areaFormulario.style.display = "none";

    mensagemSucesso.style.display = "block";

});
const btnCidadao = document.getElementById("btnCidadao");
const btnGestor = document.getElementById("btnGestor");

const usuario = document.getElementById("usuario");
const senha = document.getElementById("senha");


btnCidadao.addEventListener("click", function () {

    if (usuario.value.trim() === "") {
        alert("Digite seu e-mail ou CPF.");
        usuario.focus();
        return;
    }

    if (senha.value.trim() === "") {
        alert("Digite sua senha.");
        senha.focus();
        return;
    }

    alert("Login de cidadão realizado com sucesso!");

    // Futuramente:
    // window.location.href = "inicio.html";
});


btnGestor.addEventListener("click", function () {

    if (usuario.value.trim() === "") {
        alert("Digite seu e-mail ou CPF.");
        usuario.focus();
        return;
    }

    if (senha.value.trim() === "") {
        alert("Digite sua senha.");
        senha.focus();
        return;
    }

    alert("Login de Gestor/Servidor realizado com sucesso!");

    // Futuramente:
    // window.location.href = "painel-gestor.html";
});
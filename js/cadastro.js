// =========================================
// ELEMENTOS DO FORMULÁRIO
// =========================================

const form = document.getElementById("cadastroForm");

const cpf = document.getElementById("cpf");

const celular = document.getElementById("celular");

// =========================================
// MÁSCARA CPF
// =========================================

cpf.addEventListener("input", () => {

```
let valor = cpf.value.replace(/\D/g, "");

valor = valor.substring(0, 11);


if (valor.length > 3) {
    valor = valor.replace(
        /^(\d{3})(\d)/,
        "$1.$2"
    );
}


if (valor.length > 7) {
    valor = valor.replace(
        /^(\d{3})\.(\d{3})(\d)/,
        "$1.$2.$3"
    );
}


if (valor.length > 11) {
    valor = valor.replace(
        /^(\d{3})\.(\d{3})\.(\d{3})(\d{1,2})$/,
        "$1.$2.$3-$4"
    );
}


cpf.value = valor;
```

});

// =========================================
// MÁSCARA CELULAR
// =========================================

celular.addEventListener("input", () => {

```
let valor = celular.value.replace(/\D/g, "");

valor = valor.substring(0, 11);


if (valor.length > 2) {

    valor = valor.replace(
        /^(\d{2})(\d)/,
        "($1) $2"
    );

}


if (valor.length > 10) {

    valor = valor.replace(
        /(\d{5})(\d{4})$/,
        "$1-$2"
    );

}


celular.value = valor;
```

});

// =========================================
// VALIDAÇÃO DO FORMULÁRIO
// =========================================

form.addEventListener("submit", (e) => {

```
e.preventDefault();


const senha =
    document.getElementById("senha").value;

const confirmarSenha =
    document.getElementById("confirmarSenha").value;


// VERIFICA AS SENHAS

if (senha !== confirmarSenha) {

    alert("As senhas não coincidem.");

    return;

}


// VERIFICA TAMANHO DA SENHA

if (senha.length < 6) {

    alert("A senha deve ter pelo menos 6 caracteres.");

    return;

}


// CADASTRO

alert("Cadastro realizado com sucesso!");
```

});

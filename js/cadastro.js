// TIPO DE CONTA

const perfil =
document.querySelector(
'input[name="perfil"]:checked'
).value;

const nomes={
cidadao:"Cidadão",
servidor:"Servidor",
gestao:"Gestão Municipal"
};

alert(
`Cadastro realizado com sucesso!\n\nPerfil: ${nomes[perfil]}`
);
const camposFuncionario =
    document.getElementById(
        "camposFuncionario"
    );

const cargoGestao =
    document.getElementById(
        "cargoGestao"
    );

const matricula =
    document.getElementById(
        "matricula"
    );

const secretaria =
    document.getElementById(
        "secretaria"
    );

const cargo =
    document.getElementById(
        "cargo"
    );


perfis.forEach(function(perfil){

    perfil.addEventListener(
        "change",
        atualizarPerfil
    );

});


function atualizarPerfil(){

    const perfil =
        document.querySelector(
            'input[name="perfil"]:checked'
        ).value;


    if(perfil === "cidadao"){

        camposFuncionario.classList.add("oculto");

        cargoGestao.style.display="none";

        matricula.required=false;

        secretaria.required=false;

        cargo.required=false;

    }

    else{

        camposFuncionario.classList.remove("oculto");

        matricula.required=true;

        secretaria.required=true;

    }


    if(perfil === "gestao"){

        cargoGestao.style.display="block";

        cargo.required=true;

    }

    else{

        cargoGestao.style.display="none";

        cargo.required=false;

    }

}

atualizarPerfil();// ELEMENTOS DO FORMULÁRIO

const form = document.getElementById("cadastroForm");

const cpf = document.getElementById("cpf");

const celular = document.getElementById("celular");

// MÁSCARA CPF

cpf.addEventListener("input", () => {


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


});

// MÁSCARA CELULAR

celular.addEventListener("input", () => {


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

});

// VALIDAÇÃO DO FORMULÁRIO

form.addEventListener("submit", (e) => {

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

});

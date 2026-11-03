const telefone=document.getElementById("telefone");

// Máscara telefone

telefone.addEventListener("input",()=>{

let valor=telefone.value.replace(/\D/g,"");

valor=valor.substring(0,11);

valor=valor.replace(/^(\d{2})(\d)/,"($1) $2");

valor=valor.replace(/(\d{5})(\d)/,"$1-$2");

telefone.value=valor;

});

// Envio

document
.getElementById("formOrgao")
.addEventListener("submit",function(e){

e.preventDefault();

const dados={

nome:document.getElementById("nomeOrgao").value,

tipo:document.querySelector('input[name="tipo"]:checked').value,

email:document.getElementById("email").value,

endereco:document.getElementById("endereco").value,

telefone:document.getElementById("telefone").value,

status:"Resolvida",

data:new Date().toLocaleString("pt-BR")

};

// Salva para aparecer no histórico

localStorage.setItem(
"orgaoCompetente",
JSON.stringify(dados)
);

// Simulação de envio de notificação

alert(
"Encaminhamento registrado com sucesso!\n\n"+
"A ocorrência foi marcada como Resolvida.\n"+
"O cidadão será notificado pelo e-mail ou celular cadastrado."
);

// Redireciona

window.location.href="historico-ocorrencia.html";

});
document
.getElementById("formOrgao")
.addEventListener("submit", function(e){

    e.preventDefault();

    const dados = {

        nome: document.getElementById("nomeOrgao").value,
        tipo: document.querySelector('input[name="tipo"]:checked').value,
        email: document.getElementById("email").value,
        endereco: document.getElementById("endereco").value,
        telefone: document.getElementById("telefone").value,
        status: "Resolvida",
        data: new Date().toLocaleString("pt-BR")

    };

    localStorage.setItem(
        "orgaoCompetente",
        JSON.stringify(dados)
    );

    // Atualiza também o resultado da gestão
    const resultado = JSON.parse(localStorage.getItem("resultadoGestao"));

    if(resultado){

        resultado.status = "Resolvida";
        resultado.encaminhado = true;

        localStorage.setItem(
            "resultadoGestao",
            JSON.stringify(resultado)
        );

    }

    alert(
        "Encaminhamento registrado com sucesso!\nO cidadão será notificado."
    );

    // Vai para o resultado da gestão
    window.location.href = "resultado-analise-gestao.html";

});
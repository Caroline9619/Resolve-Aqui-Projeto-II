const prioridade = document.getElementById("filtroPrioridade");
const categoria = document.getElementById("filtroCategoria");
const status = document.getElementById("filtroStatus");

const btnAnalisar = document.getElementById("btnAnalisar");


function aplicarFiltros(){

    console.log("Filtros aplicados:");

    console.log("Prioridade:", prioridade.value);

    console.log("Categoria:", categoria.value);

    console.log("Status:", status.value);

}


prioridade.addEventListener("change", aplicarFiltros);

categoria.addEventListener("change", aplicarFiltros);

status.addEventListener("change", aplicarFiltros);


/* ANALISAR DEMANDA */

btnAnalisar.addEventListener("click", function(){

    const demandaSelecionada =
        document.querySelector(
            'input[name="demandaSelecionada"]:checked'
        );


    if(!demandaSelecionada){

        alert("Selecione uma demanda para analisar.");

        return;
    }


    const protocolo =
        demandaSelecionada.value;


        localStorage.setItem(
        "demandaSelecionada",
        protocolo
    );


    /*
     * Direciona para a tela de análise.
     */

    window.location.href =
        "analise-ocorrencia.html";

});
/* ALERTAS DO MENU LATERAL */

const btnPrioridades =
    document.getElementById("btnVerPrioridades");

btnPrioridades.addEventListener("click", function(){

    document.querySelector(".filtros-card")
        .scrollIntoView({
            behavior:"smooth"
        });

});


/* LEMBRETE AUTOMÁTICO*/

window.addEventListener("load", function(){

    const atrasadas = 2;
    const vencendo = 3;

    
    if(atrasadas > 0 || vencendo > 0){

        setTimeout(function(){

            alert(
                `Você possui ${atrasadas} demanda(s) atrasada(s) e ${vencendo} próxima(s) do vencimento.`
            );

        },1500);

    }

});
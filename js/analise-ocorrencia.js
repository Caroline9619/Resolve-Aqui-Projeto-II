document.addEventListener("DOMContentLoaded", function(){

    const protocoloSelecionado =
        localStorage.getItem("demandaSelecionada");

    const protocolo =
        document.getElementById("protocolo");


    if(protocoloSelecionado){

        protocolo.textContent =
            protocoloSelecionado;

    }


    /* SALVAR ANÁLISE */

    const btnSalvar =
        document.getElementById("btnSalvar");


    btnSalvar.addEventListener("click", function(){

        const prioridade =
            document.getElementById("prioridade").value;

        const prazo =
            document.getElementById("prazo").value;


        if(prioridade === ""){

            alert(
                "Selecione a prioridade da ocorrência."
            );

            return;
        }


        if(prazo === ""){

            alert(
                "Defina o prazo para resolução."
            );

            return;
        }


        alert(
            "Análise salva com sucesso!\n\n" +
            "Protocolo: " +
            protocolo.textContent
        );


        
    });


    /* ENCAMINHAR PARA GESTÃO */

    const btnEncaminhar =
        document.getElementById("btnEncaminhar");


    btnEncaminhar.addEventListener(
        "click",
        function(){

            const confirmar =
                confirm(
                    "Deseja encaminhar esta ocorrência para a Gestão Municipal?"
                );


            if(!confirmar){

                return;

            }


            alert(
                "Ocorrência encaminhada para a Gestão Municipal."
            );


                }
    );

});
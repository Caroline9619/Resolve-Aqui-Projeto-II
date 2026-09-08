document.addEventListener("DOMContentLoaded", function(){

    const protocolo =
        localStorage.getItem("protocoloGerado");

    if(protocolo){

        document.getElementById("protocolo").textContent =
            protocolo;

    }

});

document
.getElementById("btnRelatorio")
.addEventListener("click", gerarPDF);

function gerarPDF(){

    const { jsPDF } = window.jspdf;

    const doc = new jsPDF();

    const protocolo =
        document.getElementById("protocolo").textContent;

    doc.setFontSize(18);
    doc.text("Resolve Aqui",20,20);

    doc.setFontSize(15);
    doc.text("Relatório do Histórico da Ocorrência",20,32);

    doc.setFontSize(12);
    doc.text("Protocolo: "+protocolo,20,45);

    let y=60;

    doc.setFont(undefined,"bold");
    doc.text("Data",20,y);
    doc.text("Perfil",65,y);
    doc.text("Status",160,y);

    y+=8;

    doc.setFont(undefined,"normal");

    const linhas =
        document.querySelectorAll(
            "#tabelaHistorico tbody tr"
        );

    linhas.forEach(function(linha){

        const colunas=
            linha.querySelectorAll("td");

        const data=
            colunas[0].textContent;

        const perfil=
            colunas[1].textContent;

        const acao=
            colunas[2].textContent;

        const status=
            colunas[3].textContent;

        doc.text(data,20,y);
        doc.text(perfil,65,y);

        doc.text(status,160,y);

        y+=7;

        const texto=
            doc.splitTextToSize(acao,120);

        doc.text(texto,65,y);

        y+=texto.length*7;

        if(y>270){

            doc.addPage();

            y=20;

        }

    });

    doc.save("Historico_Ocorrencia_"+protocolo+".pdf");

}
const formulario = document.getElementById("ocorrenciaForm");

formulario.addEventListener("submit", function (evento) {

    evento.preventDefault();

    const categoria = document.getElementById("categoria").value.trim();
    const descricao = document.getElementById("descricao").value.trim();
    const endereco = document.getElementById("endereco").value.trim();
    const anexos = document.getElementById("anexos").files;

    // Categoria obrigatória
    if (categoria === "") {
        alert("Selecione a categoria da ocorrência.");
        document.getElementById("categoria").focus();
        return;
    }

    // Descrição obrigatória
    if (descricao.length < 20) {
        alert("A descrição deve conter pelo menos 20 caracteres.");
        document.getElementById("descricao").focus();
        return;
    }

    // Endereço obrigatório
    if (endereco === "") {
        alert("Informe o endereço da ocorrência.");
        document.getElementById("endereco").focus();
        return;
    }

    // Limite de arquivos
    if (anexos.length > 5) {
        alert("É permitido anexar no máximo 5 arquivos.");
        return;
    }

    // Limite de tamanho (10 MB por arquivo)
    for (let arquivo of anexos) {
        if (arquivo.size > 10 * 1024 * 1024) {
            alert(`O arquivo "${arquivo.name}" ultrapassa o limite de 10 MB.`);
            return;
        }
    }

    // Geração do protocolo (temporária)
    const protocolo =
        "RA-" +
        new Date().getFullYear() +
        "-" +
        Math.floor(Math.random() * 100000)
            .toString()
            .padStart(5, "0");

    alert(
        `Ocorrência enviada com sucesso!\n\nNúmero do protocolo: ${protocolo}`
    );

    formulario.reset();

});
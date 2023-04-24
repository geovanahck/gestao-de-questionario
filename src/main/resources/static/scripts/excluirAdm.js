function exibirMensagemConfirmacao() {
    // Cria um elemento <div> para agrupar a mensagem e os botões
    var div = document.createElement("div");
    // Cria o elemento span
    var spanConfirmacao = document.createElement("span");

    // Define o conteúdo do span
    spanConfirmacao.innerHTML = "Tem certeza que deseja excluir este administrador?";

    // Define o estilo do span
    spanConfirmacao.style.position = "fixed";
    spanConfirmacao.style.top = "50%";
    spanConfirmacao.style.left = "50%";
    spanConfirmacao.style.transform = "translate(-50%, -50%)";
    spanConfirmacao.style.backgroundColor = "#f1f1f1";
    spanConfirmacao.style.padding = "20px";
    spanConfirmacao.style.border = "1px solid #ddd";
    spanConfirmacao.style.borderRadius = "5px";
    spanConfirmacao.style.zIndex = "9999";
    spanConfirmacao.style.height = "200px"; // Adiciona a altura de 200 pixels

    // Adiciona o <span> ao <div>
    div.appendChild(spanConfirmacao);

    // Cria um botão de confirmar
    var botaoSim = document.createElement("button");
    botaoSim.innerHTML = "Excluir";
    botaoSim.style.backgroundColor = "#5c2472";
    botaoSim.style.color = "white";
    botaoSim.style.marginRight = "10px";

    // Adiciona um evento de clique no botão de confirmar
    botaoSim.onclick = function () {
        // Código a ser executado quando o usuário confirma
        spanConfirmacao.style.display = "none";
    }

    // Cria um botão de cancelar
    var botaoNao = document.createElement("button");
    botaoNao.innerHTML = "Não";
    botaoNao.style.backgroundColor = "#5c2472";
    botaoNao.style.color = "white";

    // Adiciona um evento de clique no botão de cancelamento
    botaoNao.onclick = function () {
        // Código a ser executado quando o usuário cancela
        spanConfirmacao.style.display = "none";
    }

    // Adiciona os botões ao span
    spanConfirmacao.appendChild(botaoSim);
    spanConfirmacao.appendChild(botaoNao);

    // Define o estilo do <div>
    div.style.display = "flex";
    div.style.flexDirection = "column";
    div.style.alignItems = "center";
    div.style.justifyContent = "flex-end";
    div.style.marginTop = "10px";

    // Adiciona o span à página
    document.body.appendChild(spanConfirmacao);
}
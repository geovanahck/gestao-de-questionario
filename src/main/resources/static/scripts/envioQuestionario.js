window.onload = function () {
    var areas = document.getElementsByName("area");
    var cargos = document.getElementsByName("cargo");
    var areaSelecionada = false;

    for (var i = 0; i < areas.length; i++) {
        if (areas[i].checked) {
            areaSelecionada = true;
            break;
        }
    }

    for (var i = 0; i < cargos.length; i++) {
        cargos[i].disabled = !areaSelecionada;

        if (!areaSelecionada && cargos[i].checked) {
            cargos[i].checked = false;
        }
    }

};

function verificarCargoSelecionado() {
    var areas = document.getElementsByName("area");
    var cargos = document.getElementsByName("cargo");
    var areaSelecionada = false;
    var cargoSelecionado = false;

    for (var i = 0; i < areas.length; i++) {
        if (areas[i].checked) {
            areaSelecionada = true;
            break;
        }
    }

    for (var i = 0; i < cargos.length; i++) {
        cargos[i].disabled = !areaSelecionada;

        if (!areaSelecionada) {
            cargos[i].checked = false;
        }

        if (cargos[i].checked) {
            cargoSelecionado = true;
        }
    }

    if (areaSelecionada && cargoSelecionado) {
        document.getElementById("questionarioForm").submit();
    }
}

function validateForm() {
    var areas = document.getElementsByName("area");
    var cargos = document.getElementsByName("cargo");
    var areaSelecionada = false;
    var cargoSelecionado = false;

    for (var i = 0; i < areas.length; i++) {
        if (areas[i].checked) {
            areaSelecionada = true;
            break;
        }
    }

    for (var i = 0; i < cargos.length; i++) {
        if (cargos[i].checked) {
            cargoSelecionado = true;
            break;
        }
    }

    if (!areaSelecionada) {
        return false;
    }

    if (!cargoSelecionado) {
        return false;
    }

    if (areaSelecionada && cargoSelecionado) {
        return true;
    } else {
        return false;
    }
}
function verificarSuperioresMarcados() {
    var checkboxes = document.getElementsByName('superiores');
    var marcado = false;
    for (var i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            marcado = true;
            break;
        }
    }
    if (!marcado) {
        alert('Selecione pelo menos um superior');
        return false; 
    }
    var dataInicio = document.getElementsByName("dataInicio")[0].value;
    var horaInicio = document.getElementsByName("horaInicio")[0].value;
    var dataFim = document.getElementsByName("dataFim")[0].value;
    var horaFim = document.getElementsByName("horaFim")[0].value;

    if (dataInicio === "" || horaInicio === "" || dataFim === "" || horaFim === "") {
        alert('Preencha os campos de data e hora');
        return false; 
    }

    var inicio = new Date(dataInicio + ' ' + horaInicio);
    var fim = new Date(dataFim + ' ' + horaFim);
    var atual = new Date();

    if (fim < atual || fim < inicio) {

        alert('A data e hora final deve ser posterior à data e hora atual');
        return false;
    }

    // Define os valores nos campos ocultos dentro do formulário
    document.getElementById("dataInicioInput").value = dataInicio;
    document.getElementById("horaInicioInput").value = horaInicio;
    document.getElementById("dataFimInput").value = dataFim;
    document.getElementById("horaFimInput").value = horaFim;
    document.getElementById('FormQuestionario').submit();
}
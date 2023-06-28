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
            console.log('bateu area1');
            break;
        }
    }

    for (var i = 0; i < cargos.length; i++) {
        if (cargos[i].checked) {
            cargoSelecionado = true;
            console.log('bateu cargo1');
            break;
        }
    }

    if (!areaSelecionada) {
        console.log('bateu area');
        return false;
    }

    if (!cargoSelecionado) {
        console.log('bateu cargo');
        return false;
    }

    if (areaSelecionada && cargoSelecionado) {
        console.log('bateu nos dois');
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
        return false; // Impede o envio do formulário
    }
    document.getElementById('FormQuestionario').submit();
}
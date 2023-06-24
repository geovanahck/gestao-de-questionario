function verificarCargoSelecionado() {
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
    }
}

function verificarAreaSelecionada() {
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
        if (!areaSelecionada) {
            cargos[i].checked = false;
        }
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
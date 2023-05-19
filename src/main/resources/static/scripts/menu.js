function esconderMenu() {
    var navMenu = document.querySelector(".menu-lateral");
    var spanMenus = navMenu.querySelectorAll("span");
    spanMenus.forEach(function (spanMenu) {
        spanMenu.style.display = "none";
    });

    var spanSidebaritem = navMenu.querySelectorAll("#sidebar-toggle-item");
    spanSidebaritem.forEach(function (spanMenu) {
        spanMenu.style.display = "none";
    });

    var svgIcons = document.querySelectorAll("#svg");
    svgIcons.forEach(function (svgIcon) {
        svgIcon.style.display = "none";
    });
}
function mostrarMenu() {
    var navMenu = document.querySelector(".menu-lateral");
    var spanMenus = navMenu.querySelectorAll("span");
    spanMenus.forEach(function (spanMenu) {
        spanMenu.style.display = "block";
    });

    var spanSidebaritem = navMenu.querySelectorAll("#sidebar-toggle-item");
    spanSidebaritem.forEach(function (spanMenu) {
        spanMenu.style.display = 'block';
    });

    var sublista = document.querySelector('.sublista');
    sublista.style.maxHeight = "none";

    var svgIcons = document.querySelectorAll("#svg");
    svgIcons.forEach(function (svgIcon) {
        svgIcon.style.display = "block";
    });
}

function openPopup() {
    document.getElementById('popup').style.display = 'block';
}

function closePopup() {
    var popup = document.getElementById("popup");
    popup.style.display = "none";
}

function deletarAdm(admId) {
    var options = {
        body: JSON.stringify({
            'souumcapo':'souumvalor'
        }),
        method: 'POST',
        headers: new Headers({
            'Accept': 'application/json'
        }),
        mode: 'cors' // verifique se o cors sera necessario
    }
    fetch(`https://url.com?adminid=${admId}`, options).then(function (response) {
        return response.json();
    }).then(function (dados) {
        console.log('dados da resposta', dados)
    })
}
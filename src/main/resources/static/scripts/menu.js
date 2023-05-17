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

function openPopup(element) {
    console.log(element);
    document.getElementById('popup').style.display = 'block';
}

function closePopup() {
    var popup = document.getElementById("popup");
    popup.style.display = "none";
}

function deleteAdmin(adminId) {
    console.log('bateu');
    console.log(adminId);

    fetch('/administradores/excluir/id', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ adminId: adminId }),
    })
        .then(response => {
            // Lógica para lidar com a resposta da exclusão
        })
        .catch(error => {
            // Lógica para lidar com erros
        });

}
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
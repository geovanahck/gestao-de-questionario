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

function openPopup(adminId) {
    document.getElementById('popup').style.display = 'block';
}
function closePopup() {
    var popup = document.getElementById("popup");
    popup.style.display = "none";
}

function deleteAdm(adminId) {
    console.log('Abrindo pop-up para o administrador com ID: ' + adminId);
    $.ajax({
        url: '/administradores/excluir/' + adminId,
        type: 'POST',
        data: { id: adminId },
        success: function (response) {
            // Lidar com a resposta da exclusão, por exemplo, atualizar a página ou exibir uma mensagem de sucesso
            console.log('Exclusão realizada com sucesso!');
            closePopup();
        },
        error: function (error) {
            // Lidar com erros, se houver
            console.error('Ocorreu um erro ao excluir o administrador.');

        }
    });

}


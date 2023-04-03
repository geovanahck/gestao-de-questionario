

function openPopup() {
    document.getElementById('popup').style.display = 'block';
    // popup.classList.add("");
    // popup.style.display = "block";
}
    

function closePopup() {
    var popup = document.getElementById("myPopup");
    popup.style.display = "none";
}

document.getElementById("myButton").addEventListener("click", openPopup);
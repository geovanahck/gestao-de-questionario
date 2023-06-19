const addAlternativeButton = document.getElementById('add-alternative');
const additionalAlternativesDiv = document.getElementById('additional-alternatives');
const cancelButton = document.getElementById('cancel');

let alternativeCount = 2;

addAlternativeButton.addEventListener('click', function() {
    const newAlternativeDiv = document.createElement('div');
    const alternativeIndex = alternativeCount++;

    newAlternativeDiv.innerHTML = `
        <input type="text" name="opcoes[${alternativeIndex}].descricao" required>
        <button type="button" class="remove-alternative">Remove</button>
    `;

    additionalAlternativesDiv.appendChild(newAlternativeDiv);

    const removeAlternativeButton = newAlternativeDiv.querySelector('.remove-alternative');
    removeAlternativeButton.addEventListener('click', function() {
        alternativeCount--;
        newAlternativeDiv.remove();
    });
});

cancelButton.addEventListener('click', function() {
    // Implement cancel logic here
    // For now, let's just redirect to a placeholder page
    window.location.href = "/cancel-page";
});

const typeRadios = document.querySelectorAll('input[type="radio"]');
const alternativesDiv = document.getElementById('alternatives-input');

function handleTypeChange() {
    if (this.value === 'MULTIPLA') {
        alternativesDiv.style.display = 'block';
    } else {
        alternativesDiv.style.display = 'none';
    }
}

// Add event listener to each type radio button
typeRadios.forEach(function(radio) {
    radio.addEventListener('change', handleTypeChange);
});

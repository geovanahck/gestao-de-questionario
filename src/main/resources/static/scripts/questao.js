const addAlternativeButton = document.getElementById('add-alternative');
const additionalAlternativesDiv = document.getElementById('additional-alternatives');

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

const typeRadios = document.querySelectorAll('input[type="radio"]');
const alternativesDiv = document.getElementById('alternatives-input');

function handleTypeChange() {
    let inputElements = alternativesDiv.querySelectorAll('input[type="text"]');
    if (this.value === 'MULTIPLA' || this.value === 'ALTERNATIVAS') {
        inputElements.forEach(function(inputElement) {
            inputElement.required = true;
        })
        alternativesDiv.style.display = 'block';
    } else {
        inputElements.forEach(function(inputElement) {
            inputElement.required = false;
        })
        alternativesDiv.style.display = 'none';
    }
}

// Add event listener to each type radio button
typeRadios.forEach(function(radio) {
    radio.addEventListener('change', handleTypeChange);
});

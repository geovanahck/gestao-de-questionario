

function openPopup() {
    document.getElementById('popup').style.display = 'block';
    // popup.classList.add("");
    // popup.style.display = "block";
}

function closePopup() {
    var popup = document.getElementById("myPopup");
    popup.style.display = "none";
}

function openAlternativas() {
    document.getElementById('alternativas').style.display = 'block';
}

function closeAlternativas() {
    var alternativas = document.getElementById("myAlternativas");
    alternativas.style.display = "none";
}

 // selecione o botão pelo ID
 var meuBotao = document.getElementById("fundo");
    
 // inicialize o contador
 var contador = 0;


function addQuestion() {
         // incrementa o contador em 1
         contador++;

         let question = `
     <div class="mb-5" id="question-${contador}">
        <table >
            <thead>
                <tr>
                    <th class="w-60 rounded-tl-md">Opção ${contador}<p id="questao"></p>
                    </th>
                    <td class="px-1">
                        <input class="w-full rounded-none px-2" type="text">
                    </td>
                </tr>
            </thead>
          </table>
     </div>`;
         document.getElementById('question').innerHTML += question;
}

function checkboxClicado(id) {
    var checkBox = document.getElementById('meuCheckbox');
    var meuElementoHTML = `<thead>
    <tr>
        <th class="w-60">Opção 1</th>
        <td class="px-1">
            <input class="w-full rounded-none px-2" type="text">
        </td>
    </tr>
    <tr>
        <th class="w-60">Opção 2</th>
        <td class="px-1">
            <input class="w-full rounded-none px-2" type="text">
        </td>
    </tr>
</thead>`;
    var domHTML = document.createElement("thead");
    domHTML.innerHTML = meuElementoHTML;
    var realElement = domHTML.querySelector("thead");
    console.table(realElement)
    console.log(domHTML);
    if (checkBox.checked == true) {

        var question = document.getElementById('question-' + id);
        question.querySelector('.alternativas').appendChild(domHTML);
        console.log(question);
        return;

        // adiciona o elemento HTML
        //   var meuParagrafo = document.createElement("p");
        //   var texto = document.createTextNode("Checkbox marcado!");
        //   meuParagrafo.appendChild(texto);
        //   console.table(realElement);
        //domHTML.appendChild(meuParagrafo);
        console.log("passou");
    } else {
        // remove o elemento HTML, se existir
        if (meuElementoHTML.firstChild != null) {
            //var question = document.getElementById('question-'+id);
            question.querySelector('.alternativas').removeChild(domHTML);
        }
    }
    checkBox.innerHTML += meuElementoHTML;
}


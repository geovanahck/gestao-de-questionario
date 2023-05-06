

function openPopup() {
    document.getElementById('popup').style.display = 'block';
    // popup.classList.add("");
    // popup.style.display = "block";
}


function closePopup() {
    var popup = document.getElementById("myPopup");
    popup.style.display = "none";
}

function addQuestion() {
    const questions = document.getElementById('question');
    const question = `
<div class="mb-5" id="question-${contador}">
   <table >
       <thead>
           <tr>
               <th class="w-60 rounded-tl-md">Questão ${contador}<p id="questao"></p>
               </th>
               <td class="px-1">
                   <input class="w-full rounded-none px-2" type="text">
               </td>
               <td class="w-16">&nbsp;</td>
           </tr>
       </thead>
       <tbody>
           <tr>
               <th>Tipo</th>
               <td class="px-1">
                   <input type="checkbox" id="color" name="vehicle1" value="0 a 10">
                   <label for="0a10">0 a 10 </label>
                   <input onchange="checkboxClicado('${contador}')" id="meuCheckbox" type="checkbox" name="vehicle2" value="Alternativas">
                   <label >Alternativas </label>
                   <input type="checkbox" id="color" name="vehicle3" value="Múltipla escolha">
                   <label for="multiplaEscolha">Múltipla escolha </label>
                   <input type="checkbox" id="color" name="vehicle3" value="Aberta">
                   <label for="vehicle3">Aberta </label>
               </td>
           </tr>
       </tbody>
       <thead class="alternativas">
            <!-- ...alternativas -->
       </thead>
   </table>
</div>`;
    questions.innerHTML += question;
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




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
    console.log("TESTE");
    const questions = document.getElementById('question');
    const question = `<div class="mb-5">
   <table>
       <thead>
           <tr>
               <th class="w-60 rounded-tl-md">Questão 1</th>
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
                   <input type="checkbox" id="color" name="vehicle2" value="Alternativas">
                   <label for="alternativas">Alternativas </label>
                   <input type="checkbox" id="color" name="vehicle3" value="Múltipla escolha">
                   <label for="multiplaEscolha">Múltipla escolha </label>
                   <input type="checkbox" id="color" name="vehicle3" value="Aberta">
                   <label for="vehicle3">Aberta </label>
               </td>
           </tr>
       </tbody>
   </table>
</div>`;
questions.innerHTML += question;
}


// document.getElementById("myButton").addEventListener("click", openPopup);

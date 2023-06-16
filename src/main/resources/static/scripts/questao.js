
function carregarQuestoes() {
    console.log("bateu");
    var lista = document.getElementById('lista');
    lista.style.display = "block";
}

function openPopup() {
    document.getElementById('popup').style.display = 'block';
}

function closePopup() {
    var popup = document.getElementById("popup");
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
                    
                    <td class="px-1">
                        <input class="w-full rounded-none px-2" type="text" placeholder="Digite a alternativa aqui">
                    </td>
                    
                </tr>
                
            </thead>
            <button onclick="openPopup();" id="fundo1"
                            class="w-fit h-fit py-1 px-3 bg-white rounded">+</button>
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


    function renderizarPagina() {
        var conteudoDiv = document.getElementById("conteudo");
        conteudoDiv.innerHTML = '<object type="text/html" data="listarQuestao.html" ></object>';
        conteudoDiv.classList.remove("hidden");
    }
}

    $(document).ready(function() {
        $('input:radio[name="custom_field[account][1]"]').on("change", function() {
            if (this.checked && this.value == '1') {
                $("#input-custom-field2, #input-custom-field3").show();
                $("#input-custom-field4, #input-custom-field5, #input-custom-field6").hide();
            } else {
                $("#input-custom-field4, #input-custom-field5, #input-custom-field6").show();
                $("#input-custom-field2, #input-custom-field3").hide();
            }
        });
    });
    

//    window.addEventListener("DOMContentLoaded", (event) => {
//   console.log("DOM fully loaded and parsed");
//   $('input:radio[name="custom_field[account][1]"]').on("change", function() {
//             if (this.checked && this.value == '1') {
//                 $("#input-custom-field2, #input-custom-field3").show();
//                 $("#input-custom-field4, #input-custom-field5, #input-custom-field6").hide();
//             } else {
//                 $("#input-custom-field4, #input-custom-field5, #input-custom-field6").show();
//                 $("#input-custom-field2, #input-custom-field3").hide();
//             }
//         });
// });


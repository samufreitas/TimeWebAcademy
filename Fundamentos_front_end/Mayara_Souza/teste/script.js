// let botao = document.querySelector('a#add');
// botao.addEventListener('click', funcaoA);
// botao.addEventListener('click', funcaoB);

// function funcaoA(){
//     alert('A');
// }

// function funcaoB(){
//     alert('B');
// }

let selectTema = document.querySelector('select#tema');
selectTema.addEventListener('change', evento => {
    let temaSelecionado = evento.target.value;
    // console.log(temaSelecionado);
    if (temaSelecionado){
        mudaTema(temaSelecionado);
        localStorage.setItem('tema', temaSelecionado)
    }
});

const mudaTema = (temaSelecionado) => {
    let linkTema = document.querySelector('#link-tema');
    let url = "/css/estilo-tema-" + temaSelecionado + ".css";
    linkTema.href = url;
}

let tema = localStorage.getItem('tema');
if (tema){
     mudaTema(tema);
}

const carregarProfissionais = () => {
   let url = "https://my-json-server.typicode.com/juniorlimeiras/json/profissionais";
   let tabela = document.querySelector('table');
   fetch(url).then(resposta => {
    return resposta.json();
   }).then(dados => {
    for (const item of dados){
        inserirProfissinal(item);
    }
    eventoExcluir();
   }).catch(erro => {
    console.error(erro);
   });
//    let xhr = new XMLHttpRequest();
//    xhr.open('GET', url);
//    xhr.addEventListener('readystatechange', () => {
//     if (xhr.readyState === 4 && xhr.status === 200){
//          dados = JSON.parse(xhr.responseText);
//         //  console.log(dados);
//         for (const item of dados ){
//             //Criando os elementos HTML
//             let linha = document.createElement('tr');
//             let id = document.createElement('td');
//             let nome = document.createElement('td');
//             let registroConselho = document.createElement('td');
//             let email = document.createElement('td');
//             let telefone = document.createElement('td');
//             let unidade = document.createElement('td');
//             let especialidade = document.createElement('td');
//             let acoes = document.createElement('td');
//             // Preencher os elementos
//             id.textContent = item.id;
//             nome.textContent = item.nome;
//             registroConselho.textContent = item.registro;
//             email.textContent = item.email
//             telefone.textContent = item.telefone;
//             unidade.textContent = item.unidade;
//             especialidade.textContent = item.especialidade;
//             acoes.innerHTML = `<a class="botao" href="javascript:void(0)">Editar</a> <a id="vermelho" class="botao"
//             href="javascript:void(0)">Excluir</a>`;

//             //Preencher a linha
//             linha.appendChild(id);
//             linha.appendChild(nome);
//             linha.appendChild(registroConselho);
//             linha.appendChild(email);
//             linha.appendChild(telefone);
//             linha.appendChild(unidade);
//             linha.appendChild(especialidade);
//             linha.appendChild(acoes);
            
//             //Preencher a tabela com uma linha
//             tabela.tBodies[0].appendChild(linha);

//         }
//     }
//     eventoExcluir();
//    });
//    xhr.send();
};

carregarProfissionais();

//Criar uma função para excluir um profissional
const eventoExcluir = () => {
    let botoes = document.querySelectorAll('a.botao#vermelho');
    for (const bt of botoes){
        bt.addEventListener('click', () => {
            bt.parentNode.parentNode.remove();
            contar();
    });
    };
};

// Adicionar
let botaoAdicionar = document.querySelector('a.adicionar#add');
let form = document.querySelector('form');
let botaoCancelar = document.querySelector('input#vermelho');

botaoAdicionar.addEventListener('click', () => {
    form.classList.remove('inativo');
    botaoAdicionar.classList.add('esconder');
});

botaoCancelar.addEventListener('click', () => {
    form.classList.add('inativo');
    form.reset();
    botaoAdicionar.classList.remove('esconder');
})

let tabela = document.querySelector('table');
// Adicionar um funcionamento para enviar os dados fo form para a tebela

form.addEventListener('submit', (evento) => {
    evento.preventDefault();
    botaoAdicionar.classList.remove('esconder');
    let profissional = {
        id : tabela.tBodies[0].rows.length + 1,
        nome : form.nome.value,
        registro : form.registro.value,
        telefone : form.telefone.value,
        email : form.email.value,
        unidade : form.unidade.options[form.unidade.selectedIndex].label,
        especialidade : form.especialidade.options[form.especialidade.selectedIndex].label
    };
    console.log(profissional);
    inserirProfissinal(profissional);
    form.reset();
    form.classList.add('inativo');
    eventoExcluir();
});

// Função que insere um objeto profissional na tabela HTML

const inserirProfissinal = (item) => {
    let linha = document.createElement('tr');
            let id = document.createElement('td');
            let nome = document.createElement('td');
            let registro = document.createElement('td');
            let email = document.createElement('td');
            let telefone = document.createElement('td');
            let unidade = document.createElement('td');
            let especialidade = document.createElement('td');
            let acoes = document.createElement('td');
            // Preencher os elementos
            id.textContent = item.id;
            nome.textContent = item.nome;
            registro.textContent = item.registro;
            email.textContent = item.email
            telefone.textContent = item.telefone;
            unidade.textContent = item.unidade;
            especialidade.textContent = item.especialidade;
            acoes.innerHTML = `<a class="botao" href="javascript:void(0)">Editar</a> <a id="vermelho" class="botao"
            href="javascript:void(0)">Excluir</a>`;

            //Preencher a linha
            linha.appendChild(id);
            linha.appendChild(nome);
            linha.appendChild(registro);
            linha.appendChild(email);
            linha.appendChild(telefone);
            linha.appendChild(unidade);
            linha.appendChild(especialidade);
            linha.appendChild(acoes);
            
            //Preencher a tabela com uma linha
            tabela.tBodies[0].appendChild(linha);
            contar();
}

const contar = () => {
    const contador = document.querySelector('.contador');
    let total = tabela.tBodies[0].rows.length;
    contador.textContent = total;
}
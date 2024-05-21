/*  let botao = document.querySelector('a#add');
botao.addEventListener('click', funcaoA);
botao.addEventListener('click', funcaoB);

function funcaoA(){
    alert('A');
}

function funcaoB(){
    alert('B');
}   */

//SETAR TEMA
let selectTema = document.querySelector('select#tema');
selectTema.addEventListener('change', evento => {
    let temaSelecionado = evento.target.value;
    //console.log(temaSelecionado);
    if (temaSelecionado){
        mudaTema(temaSelecionado);
        localStorage.setItem('tema', temaSelecionado)
    }

});

const mudaTema = (temaSelecionado) => {
    let linkTema = document.querySelector('#link-tema');
    let url = "/css/estilo_tema_" + temaSelecionado + ".css";
    linkTema.href = url;
}

let tema = localStorage.getItem('tema');
if (tema){
    mudaTema(tema);
}

//PREENCHER A TABELA
const carregarProfissionais = () => {
    let url = "https://my-json-server.typicode.com/juniorlimeiras/json/profissionais";
    let tabela = document.querySelector('table');
    fetch(url).then(resposta => {
        return resposta.json();
    }).then(dados => {
        for (const item of dados){
            inserirProfissional(item);
        }
        eventoExcluir();
    }).catch(erro => {
        console.error(erro);
    })
    // let xhr = new XMLHttpRequest ();
    // xhr.open('GET', url);
    
    // xhr.addEventListener('readystatechange', () => {
    //     if(xhr.readyState === 4 && xhr.status === 200){
    //         dados = JSON.parse(xhr.responseText);
    //         // console.log(dados);
    //         for(const item of dados){
    //             //Criando os elemento HTML
    //             let linha = document.createElement('tr');
    //             let id = document.createElement('td');
    //             let nome = document.createElement('td');
    //             let registroConselho = document.createElement('td');
    //             let email = document.createElement('td');
    //             let telefone= document.createElement('td');
    //             let unidade = document.createElement('td');
    //             let especialidade = document.createElement('td');
    //             let acoes = document.createElement('td');

    //             //Preencher os elementos
    //             id.textContent = item.id;
    //             nome.textContent = item.nome;
    //             registroConselho.textContent = item.registro;
    //             email.textContent = item.email;
    //             telefone.textContent = item.telefone;
    //             unidade.textContent = item.unidade;
    //             especialidade.textContent = item.especialidade;
    //             acoes.innerHTML = `<a class="botao" >Editar</a> <a id="vermelho" class="botao">Excluir</a>`;
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
    // });
    // xhr.send();
};

carregarProfissionais();

//Criar uma função para excluir um profissional

const eventoExcluir = () => {
    let botoes = document.querySelectorAll('a.botao#vermelho');
    for (const bt of botoes){
        bt.addEventListener('click', () => {
            bt.parentNode.parentNode.remove();
            linhaTotal(); //FUNÇÃO QUESTÃO 2
        });
    };
};

//[INDIVIDUAL] Alterar a forma como o usuário visualiza o botão Adicionar. (Entrega: 22/05/2024)
//O botão Adicionar não deve ser visualizado após ser clicado, mas somente quando o usuário clicar nos botões Enviar ou Cancelar.
let botaoAdicionar = document.querySelector('a.botao#add');
let botaoEnviar = document.querySelector('input#enviar');
let botaoCancelar = document.querySelector('input#vermelho');

// botaoAdicionar.addEventListener('click', () => {
//     form.classList.remove('inativo');
// });

// botaoCancelar.addEventListener('click', () => {
//     form.classList.add('inativo');
//     form.reset();
// });

//APERTAR ADICIONAR E APARECER O FORM OU APERTAR CANCELAR SUMIR O FORM E O QUE TIVER SIDO ESCRITO NELE
//let botaoAdicionar = document.querySelector('a.botao#add');
let form = document.querySelector('form');
//let botaoCancelar = document.querySelector('input#vermelho');

botaoAdicionar.addEventListener('click', () => {
    botaoAdicionar.classList.add('esconde');
    form.classList.remove('inativo');
});

botaoEnviar.addEventListener('click', () =>{
    botaoAdicionar.classList.remove('esconde')
});

botaoCancelar.addEventListener('click', () => {
    botaoAdicionar.classList.remove('esconde');
    form.classList.add('inativo');
    form.reset();
});

let tabela = document.querySelector('table');
//ADICIONAR UM FUNCIONAMENTO PARA ENVIAR OS DADOS DO FORM PARA A TABELA
form.addEventListener('submit', (evento) => {
    evento.preventDefault(); //EVITA QUE A PÁGINA SEJA RECARREGADA
    let profissional = {
        id: tabela.tBodies[0].rows.length + 1,
        nome: form.nome.value,
        registro: form.registroConselho.value,
        telefone: form.telefone.value,
        email: form.email.value,
        unidade: form.unidade.options[form.unidade.selectedIndex].label,
        especialidade: form.especialidade.options[form.especialidade.selectedIndex].label
    };
    console.log(profissional);
    inserirProfissional(profissional);
    form.reset();
    form.classList.add('inativo');
    eventoExcluir();
});

//FUNÇÃO QUE INSERE UM OBJETO PROFISSIONAL NA TABELA HTML
const inserirProfissional = (item) => {
    let linha = document.createElement('tr');
                let id = document.createElement('td');
                let nome = document.createElement('td');
                let registro = document.createElement('td');
                let email = document.createElement('td');
                let telefone= document.createElement('td');
                let unidade = document.createElement('td');
                let especialidade = document.createElement('td');
                let acoes = document.createElement('td');

                //Preencher os elementos
                id.textContent = item.id;
                nome.textContent = item.nome;
                registro.textContent = item.registro;
                email.textContent = item.email;
                telefone.textContent = item.telefone;
                unidade.textContent = item.unidade;
                especialidade.textContent = item.especialidade;
                acoes.innerHTML = `<a class="botao" >Editar</a> <a id="vermelho" class="botao">Excluir</a>`;
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
                linhaTotal(); //FUNÇÃO QUESTÃO 2
};

/*QUESTÃO 2- [INDIVIDUAL] Alterar o rodapé da tabela que mostra o total de profissionais para que seja atualizado conforme a quantidade de profissionais. (Entrega: 22/05/2024)
A atualização deve considerar todos os registros.*/
const linhaTotal = () =>{
    const rodapeTabela = document.getElementById('total');
    const numeroDeLinhas = tabela.tBodies[0].rows.length;
    rodapeTabela.textContent = 'Total de profissionais: '+ numeroDeLinhas;
}

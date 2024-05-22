//Exemplo de evento 
/* let botao = document.querySelector('a#add');
botao.addEventListener('click', funcaoA);
botao.addEventListener('click', funcaoB);

function funcaoA() {
    alert('A');
}
function funcaoB() {
    alert('B');
} */

// Altera o tema quando mudar a opção selecionada
let selectTema = document.querySelector('select#tema');
selectTema.addEventListener('change', evento => {
    let temaSelecionado = evento.target.value;
    //console.log(temaSelecionado);
    if (temaSelecionado) {
        mudaTema(temaSelecionado);
        // Salva a opção de tema escolhida pelo usuário no localStorage
        localStorage.setItem('tema', temaSelecionado);
    }
});

// Altera o tema o arquivo CSS de acordo com o tema selecionado
const mudaTema = (temaSelecionado) => {
    let linkTema = document.querySelector('#link-tema');
    //console.log(linkTema);
    let url = "../css/estilo-tema-" + temaSelecionado + ".css";
    linkTema.href = url;
}

// Recupera a opção de tema escolhida pelo usuário e
// altera o tema se houver uma opção salva no localStorage
let tema = localStorage.getItem('tema');
if (tema) {
    mudaTema(tema);
}

//Função que carrega dados dos profissionais a partir de um objeto JSON
const carregarUsuarios = () => {
    let url = "https://my-json-server.typicode.com/juniorlimeiras/json2/usuarios";
    let tabela = document.querySelector('table');
    fetch(url).then(resposta => {
        return resposta.json();
    }).then(dados => {
        for (const item of dados) {
            inserirUsuario(item);
        }
        eventoExcluir();
    }).catch(erro => {
        console.error(erro);
    });
    /* let xhr = new XMLHttpRequest();
    xhr.open('GET', url);
    xhr.addEventListener('readystatechange', () => {
        if (xhr.readyState === 4 && xhr.status === 200) {
            dados = JSON.parse(xhr.responseText);
            //console.log(dados);
            for (const item of dados) {
                //Criando os elementos HTML
                let linha = document.createElement('tr');
                let id = document.createElement('td');
                let nome = document.createElement('td');
                let registroConselho = document.createElement('td');
                let telefone = document.createElement('td');
                let email = document.createElement('td');
                let unidade = document.createElement('td');
                let especialidade = document.createElement('td');
                let acoes = document.createElement('td');
                //Preencher os elementos
                id.textContent = item.id;
                nome.textContent = item.nome;
                registroConselho.textContent = item.registro;
                telefone.textContent = item.telefone;
                email.textContent = item.email;
                unidade.textContent = item.unidade;
                especialidade.textContent = item.especialidade;
                acoes.innerHTML = `<a class="botao">Editar</a> <a id="vermelho" class="botao">Excluir</a>`;
                //Preencher a linha
                linha.appendChild(id);
                linha.append(nome);
                linha.appendChild(registroConselho);
                linha.appendChild(email);
                linha.appendChild(telefone);
                linha.appendChild(unidade);
                linha.appendChild(especialidade);
                linha.appendChild(acoes);
                //Preencher a tabela com uma linha
                tabela.tBodies[0].appendChild(linha);
            }
        }
        eventoExcluir();
    });
    xhr.send(); */
};
carregarUsuarios();

//Função para excluir um profissional
const eventoExcluir = () => {
    let botoes = document.querySelectorAll('a.botao#vermelho');
    for (const bt of botoes) {
        bt.addEventListener('click', () => {
            bt.parentNode.parentNode.remove();
            atualizaRegistros();
        });
    };
};

let botaoAdicionar = document.querySelector('a.botao#add');
let form = document.querySelector('form');
let botaoCancelar = document.querySelector('input#vermelho');

//Adiciona o evento de click ao botao Adicionar
botaoAdicionar.addEventListener('click', () => {
    form.classList.remove('inativo');
});

//Adiciona o evento de click ao botao Cancelar
botaoCancelar.addEventListener('click', () => {
    form.classList.add('inativo');
    form.reset();
})

let tabela = document.querySelector('table');

//Função que insere um objeto usuário na tabela HTML
const inserirUsuario = (item) => {
    //Criando os elementos HTML
    let linha = document.createElement('tr');
    let id = document.createElement('td');
    let nome_completo = document.createElement('td');
    let nome_usuario = document.createElement('td');
    let ativo = document.createElement('td');
    let senha = document.createElement('td');
    let papel = document.createElement('td');
    let acoes = document.createElement('td');
    //Preencher os elementos
    id.textContent = item.id;
    nome_completo.textContent = item.nome_completo;
    nome_usuario.textContent = item.nome_usuario;
    ativo.textContent = item.ativo;
    senha.textContent = item.senha;
    papel.textContent = item.papel;
    acoes.innerHTML = `<a class="botao">Editar</a> <a id="vermelho" class="botao">Excluir</a>`;
    //Preencher a linha
    linha.appendChild(id);
    linha.appendChild(nome_completo);
    linha.appendChild(nome_usuario);
    linha.appendChild(ativo);
    linha.appendChild(senha);
    linha.appendChild(papel);
    linha.appendChild(acoes);
    //Preencher a tabela com uma linha
    tabela.tBodies[0].appendChild(linha);
    atualizaRegistros();
};
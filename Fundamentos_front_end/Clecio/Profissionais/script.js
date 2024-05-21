/* let botao = document.querySelector('a#add');
botao.addEventListener('click', funcaoA);
botao.addEventListener('click', funcaoB);

function funcaoA() {
    alert('A');
}
function funcaoB() {
    alert('B');
} */

let selectTema = document.querySelector('select#tema');
selectTema.addEventListener('change', evento => {
    let temaSelecionado = evento.target.value;
    //console.log(temaSelecionado);
    if (temaSelecionado) {
        mudaTema(temaSelecionado);
        localStorage.setItem('tema', temaSelecionado);
    }
});

const mudaTema = (temaSelecionado) => {
    let linkTema = document.querySelector('#link-tema');
    //console.log(linkTema);
    let url = "/css/estilo-tema-" + temaSelecionado + ".css";
    linkTema.href = url;
}

let tema = localStorage.getItem('tema');
if (tema) {
    mudaTema(tema);
}

const carregarProfissionais = () => {
    let url = "https://my-json-server.typicode.com/juniorlimeiras/json/profissionais";
    let xhr = new XMLHttpRequest();
    xhr.open('GET', url);
    let tabela = document.querySelector('table');
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
    });
    xhr.send();
};
carregarProfissionais();

//Criar uma função para excluir um profissional

let botoes = document.querySelectorAll('a.botao#vermelho');
for (const bt of botoes) {
    bt.addEventListener('click', () => {
        bt.remove();
    });
};


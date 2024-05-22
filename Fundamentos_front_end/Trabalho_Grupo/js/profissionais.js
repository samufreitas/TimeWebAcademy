// Adiciona funcionalidade ao botão Enviar e envia os dados do formulário para a tabela
let idTabela = document.querySelector('table');
form.addEventListener('submit', (event) => {
    event.preventDefault();
    botaoAdicionar.classList.remove('esconder');
    // Cria um objeto com os dados do profissional
    let profissional = {
        id: idTabela.tBodies[0].rows.length + 1,
        nome: form.nomeProfissional.value,
        registro: form.registroProfissional.value,
        email: form.emailProfissional.value,
        telefone: form.telefoneProfissional.value, 
        unidade: form.unidadeProfissional.options[form.unidadeProfissional.selectedIndex].text,
        especialidade: form.especialidadeProfissional.options[form.especialidadeProfissional.selectedIndex].text
    };
    // Insere o profissional na tabela
    inserirProfissional(profissional);
    form.reset();
    form.classList.add('inativo');
});

// Adiciona as informações na tabela
const inserirProfissional = (item) => {
    let tabela = document.querySelector('table');

    // Cria elementos de célula para cada informação do profissional
    let linha = document.createElement('tr');
    let id = document.createElement('td');
    let nome = document.createElement('td');
    let conselho = document.createElement('td');
    let email = document.createElement('td');
    let telefone = document.createElement('td');
    let unidade = document.createElement('td');
    let especialidade = document.createElement('td');
    let acoes = document.createElement('td');

    // Define o texto de cada célula com as informações do profissional
    id.textContent = item.id;
    nome.textContent = item.nome;
    conselho.textContent = item.registro;
    email.textContent = item.email;
    telefone.textContent = item.telefone;
    unidade.textContent = item.unidade;
    especialidade.textContent = item.especialidade;

    // Adiciona os botões de ação na célula de ações
    acoes.innerHTML = ` <a class="editar">Editar</a>
                        <a class="excluir">Excluir</a>`;

    // Adiciona as células à linha da tabela
    linha.appendChild(id);
    linha.appendChild(nome);
    linha.appendChild(conselho);
    linha.appendChild(email);
    linha.appendChild(telefone);
    linha.appendChild(unidade);
    linha.appendChild(especialidade);
    linha.appendChild(acoes);

    // Adiciona a linha à tabela
    tabela.tBodies[0].appendChild(linha)

    // Adiciona a funcionalidade de exclusão ao botão "Excluir"
    let botaoExcluir = linha.querySelector('.excluir');
    botaoExcluir.addEventListener('click', () => {
        linha.remove();
        rodapeTabela();// chamaa  funçao para reduzir
    })
    rodapeTabela();//chama a funçao para adicionar 
};

// Carrega as Informações do JSON na tabela
const carregaTabela = () => {
    // Define a URL do arquivo JSON
    let url = 'https://my-json-server.typicode.com/juniorlimeiras/json/profissionais'
    // Realiza uma solicitação fetch para obter os dados do JSON
    fetch(url).then(resposta => {
        return resposta.json();
    }).then(dados => {
        // Para cada item no JSON, insere o profissional na tabela
        for(const item of dados) {
            inserirProfissional(item);
        }
    }).catch(erro => (
        console.error(erro)
    ));
}
// Chama a função para carregar a tabela quando a página é carregada
carregaTabela();

// Atualiza o rodapé para a quantidade de linha da tabela.
const rodapeTabela = () => {
    const totalSpan = document.getElementById('total');
    const totalRegistros = idTabela.tBodies[0].rows.length;
    totalSpan.textContent = totalRegistros;
};
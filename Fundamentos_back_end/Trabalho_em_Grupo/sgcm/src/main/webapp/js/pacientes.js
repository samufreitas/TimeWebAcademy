// Adiciona um evento ao campo de CEP que dispara a função
document.getElementById('cep').addEventListener('blur', function() {
    // Obtém o valor do campo CEP e remove todos os caracteres não numéricos
    const cep = this.value.replace(/\D/g, '');

    // Verifica se o CEP tem exatamente 8 dígitos
    if (cep.length === 8) {
        // Faz uma requisição à API ViaCEP utilizando o CEP fornecido
        fetch(`https://viacep.com.br/ws/${cep}/json/`)
            .then(response => response.json()) // Converte a resposta para JSON
            .then(data => {
                // Verifica se a API retornou um erro
                if (!data.erro) {
                    // Preenche os campos de estado e cidade com os dados retornados pela API
                    document.getElementById('estado').value = data.uf;
                    document.getElementById('cidade').value = data.localidade;
                } else {
                    // Alerta o usuário se o CEP não foi encontrado
                    alert('CEP não encontrado.');
                }
            })
            .catch(error => console.error('Erro ao buscar o CEP:', error)); // Trata erros na requisição
    } else {
        // Alerta o usuário se o CEP for inválido (não tem 8 dígitos)
        alert('CEP inválido.');
    }
});

// Adiciona funcionalidade ao botão Enviar e envia os dados do formulário para a tabela
let idTabela = document.querySelector('table');
form.addEventListener('submit', (event) => {
    event.preventDefault();
    // Cria um objeto com os dados do paciente
    let paciente = {
        id: idTabela.tBodies[0].rows.length + 1,
        nome: form.nome.value,
        email: form.email.value,
        data_nascimento: form.data_nascimento.value,
        sexo: form.sexo.options[form.sexo.selectedIndex].value,
        grupo_sanguineo: form.grupo_sanguineo.options[form.grupo_sanguineo.selectedIndex].value,
        cep: form.cep.value,
        estado: form.estado.value,
        cidade: form.cidade.value,
        endereco: form.endereco.value,
        telefone: form.telefone.value
    };
    // Insere o profissional na tabela
    inserirPaciente(paciente);
    form.reset();
    form.classList.add('inativo');
    botaoAdicionar.classList.remove('inativo');
});

// Adiciona as informações na tabela
const inserirPaciente = (item) => {
    let tabela = document.querySelector('table');

    // Cria elementos de célula para cada informação do paciente
    let linha = document.createElement('tr');
    let id = document.createElement('td');
    let nome = document.createElement('td');
    let email = document.createElement('td');
    let data_nascimento = document.createElement('td');
    let sexo = document.createElement('td');
    let grupo_sanguineo = document.createElement('td');
    let cep = document.createElement('td');
    let estado = document.createElement('td');
    let cidade = document.createElement('td');
    let endereco = document.createElement('td');
    let telefone = document.createElement('td');
    let acoes = document.createElement('td');

    // Define o texto de cada célula com as informações do paciente
    id.textContent = item.id;
    nome.textContent = item.nome;
    email.textContent = item.email;
    data_nascimento.textContent = item.data_nascimento;
    sexo.textContent = item.sexo;
    grupo_sanguineo.textContent = item.grupo_sanguineo;
    cep.textContent = item.cep;
    estado.textContent = item.estado;
    cidade.textContent = item.cidade;
    endereco.textContent = item.endereco;
    telefone.textContent = item.telefone;

    // Adiciona os botões de ação na célula de ações
    acoes.innerHTML = ` <a class="editar">Editar</a>
                        <a class="excluir">Excluir</a>`;

    // Adiciona as células à linha da tabela
    linha.appendChild(id);
    linha.appendChild(nome);
    linha.appendChild(email);
    linha.appendChild(data_nascimento);
    linha.appendChild(sexo);
    linha.appendChild(grupo_sanguineo);
    linha.appendChild(cep);
    linha.appendChild(estado);
    linha.appendChild(cidade);
    linha.appendChild(endereco);
    linha.appendChild(telefone);
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
    let url = 'https://my-json-server.typicode.com/juniorlimeiras/json/pacientes'
    // Realiza uma solicitação fetch para obter os dados do JSON
    fetch(url).then(resposta => {
        return resposta.json();
    }).then(dados => {
        // Para cada item no JSON, insere o paciente na tabela
        for(const item of dados) {
            inserirPaciente(item);
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
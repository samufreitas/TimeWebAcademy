// Identifica o tema selecionado na página
let selectTema = document.querySelector('select#tema');
selectTema.addEventListener('change', evento => {
    // Obtém o valor do tema selecionado
    let temaselecionado = evento.target.value;

    // Verifica se um tema foi selecionado
    if (temaselecionado){
        // Chama a função para mudar o tema e armazena o tema selecionado no armazenamento local
        mudaTema(temaselecionado);
        localStorage.setItem('tema', temaselecionado)
    }
})

// Define o tema da Página de acordo com o selecionado
const mudaTema = (temaselecionado) => {
    // Obtém o link para a folha de estilo do tema selecionado
    let linkTema = document.querySelector('#linkTema');
    let url = "../css/" + temaselecionado + '.css';
    // Define a nova URL para o link da folha de estilo
    linkTema.href = url;

    // Obtém o elemento da imagem do logotipo
    let imglogo = document.querySelector('#imglogo');
    // Verifica o tema selecionado e atualiza a imagem do logotipo de acordo
    if(temaselecionado == 'amarelo' || temaselecionado == 'vermelho'){
        imglogo.src = "../imagens/logo_branco(64).png"
    }
    else{
        imglogo.src = "../imagens/logo_azul(64).png"
    }
}

// Garante que o tema seja o mesmo com a atualização da página
let tema = localStorage.getItem('tema');
if (tema) {
    mudaTema(tema)
}

// Cria a funcionalidade que informa a pagina selecionada no menu
var elemento = document.querySelector('[href="#"]');
elemento.style.backgroundColor = "#cccccc";
elemento.style.color = "#333";

// Cria a funcionalidade dos botões adicionar e cancelar da página que controlam o formulário. funcao adicionada para esconder
let botaoAdicionar = document.querySelector('.adicionar');
let botaoCancelar = document.querySelector('.cancelar');
let form = document.querySelector('form');

// Ao clicar no botão Adicionar, remove a classe que esconde o formulário.
botaoAdicionar.addEventListener('click', (event) => {
    form.classList.remove('inativo');
    botaoAdicionar.classList.add('inativo');
    event.preventDefault();
});

// Ao clicar no botão Cancelar, adiciona a classe que esconde o formulário e o reseta. foi adicionado um variavel botaoEsconder2.classList.remove('.esconder');
botaoCancelar.addEventListener('click', (event) => {
    form.classList.add('inativo');
    form.reset();
    botaoAdicionar.classList.remove('inativo');
    event.preventDefault();
});

/* Script secundario criado para evitar conflitos nas codificações das funções */


//Adicionar um funcionamento para enviar os dados do form para a tabela
form.addEventListener('submit', (evento) => {
    evento.preventDefault(); //Evita que a página seja recarregada
    let usuario = { //Cria um objeto com os dados do form
        id: tabela.tBodies[0].rows.length + 1,
        nome_completo: form.nome.value,
        nome_usuario: form.nomeUS.value,
        senha: form.senha.value,
        ativo: form.ativo.options[form.ativo.selectedIndex].label,
        papel: form.papel.options[form.papel.selectedIndex].label
    };
    //console.log(usuario);
    inserirUsuario(usuario); //insere o profissional na tabela
    form.reset(); //Limpa os campos do form
    form.classList.add('inativo'); //Esconde o form
    eventoExcluir(); //Adiciona o evento de excluir ao botao criado ao inserir nova linha na tabela
});


// id, ativo, nome_completo, nome_usuario, papel, senha


// função para atualizar a linha q conta os registros
function atualizaRegistros()
{
    let totalRegistros = tabela.rows.length -2; // para nao contar o cabeçalho e rodapé
    let linhaRegistros = document.querySelector('td#total');
    linhaRegistros.textContent = 'Total de registros: '+totalRegistros;
}
atualizaRegistros();
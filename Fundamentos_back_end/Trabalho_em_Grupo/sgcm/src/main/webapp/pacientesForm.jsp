%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="Fundamentos_back_end.Trabalho_em_Grupo.sgcm.src.main.java.br.ufac.sgcm.model.Paciente" %>

<jsp:useBean id="controller" class="Fundamentos_back_end.Trabalho_em_Grupo.sgcm.src.main.java.br.ufac.sgcm.controller.PacienteController" />

<%
    List<Paciente> registros = controller.processListRequest(request);
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pacientes</title>
    <link rel="stylesheet" type="text/css" href="css/estilo.css">
    <link rel="stylesheet" type="text/css" href="css/estilo-tema-azul.css" id="linkTema">
    <script src="js/funcionalidades.js" defer></script>
    <script src="js/pacientes.js" defer></script>
</head>
<body>
    <header>
        <div class="logo">
            <img src="imagens/logo_branco.png" alt="Logo do SGCM" id="imglogo">
            <span>SGCM</span>
        </div>
        <div id="info">
            <span id="tema_nome">
                <p class="tema">Tema:</p>
                <select id="tema">
                    <option value="">Escolha um tema</option>
                    <option value="azul">Azul</option>
                    <option value="vermelho">Vermelho</option>
                    <option value="amarelo">Amarelo</option>
                </select>
            </span>
            <div class="usuario">
                <span>Usuário: Administrador</span>
                <span>Papel: ADMIN</span>
            </div>
        </div>
    </header>
    <nav>
        <div class="menu-toggle" id="menuToggle">
            <span></span>
            <span></span>
            <span></span>
        </div>
        <ul class="menu" id="menu">
            <li><a href="home.html" target="_parent">Home</a></li>
            <li><a href="#" target="_self">Pacientes</a></li>
            <li><a href="atendimentos.html" target="_parent">Atendimento</a></li>
            <li><a href="convenio.html" target="_parent">Convenio</a></li>
            <li><a href="profissionais.html" target="_parent">Profissionais</a></li>
            <li><a href="unidades.html" target="_parent">Unidades</a></li>
            <li><a href="especialidades.html" target="_parent">Especialidades</a></li>
            <li><a href="usuarios.html" target="_parent">Usuários</a></li>
        </ul>
    </nav>
    <main>
        <form action="" class="inativo">
            <div class="grid">

                <label for="nome">Nome Completo</label>
                <input type="text" name="nome" id="nome" required>

                <label for="email">Email</label>
                <input type="email" name="email" id="email" required>
        
                <label for="data_nascimento">Data de Nascimento</label>
                <input type="date" name="data_nascimento" id="data_nascimento" required>
        
                <label for="sexo">Sexo</label>
                <select name="sexo" id="sexo" required>
                    <option value=""></option>
                    <option value="M">Masculino</option>
                    <option value="F">Feminino</option>
                    <option value="--">Prefiro Não Informar</option>
                </select>
        
                <label for="grupo_sanguineo">Grupo Sanguíneo</label>
                <select name="grupo_sanguineo" id="grupo_sanguineo" required>
                    <option value=""></option>
                    <option value="A_POSITIVO">A+</option>
                    <option value="A_NEGATIVO">A-</option>
                    <option value="B_POSITIVO">B+</option>
                    <option value="B_NEGATIVO">B-</option>
                    <option value="AB_POSITIVO">AB+</option>
                    <option value="AB_NEGATIVO">AB-</option>
                    <option value="O_POSITIVO">O+</option>
                    <option value="O_NEGATIVO">O-</option>
                </select>
        
                <label for="cep">CEP</label>
                <input type="text" name="cep" id="cep" required>
        
                <label for="estado">Estado</label>
                <input type="text" name="estado" id="estado" readonly>
        
                <label for="cidade">Cidade</label>
                <input type="text" name="cidade" id="cidade" required>
        
                <label for="endereco">Endereço</label>
                <input type="text" name="endereco" id="endereco" required>
        
                <label for="telefone">Telefone</label>
                <input type="tel" name="telefone" id="telefone" required>
        
                <span></span>
                <input type="submit" value="Enviar" class="enviar">
                <span></span>
                <input type="button" value="Cancelar" class="cancelar">
                <span></span>
            </div>
        </form>
        
        <a href="" class="adicionar">Adicionar</a>
    </main>
    <footer>
        <div>
            <span>Telefone de contato: (68) 99913-2145</span>
            <span>|</span>
            <span>Email de contato <a href="#">suporte.sgcm@ufac.br</a></span>
        </div>
    </footer>
</body>
</html>
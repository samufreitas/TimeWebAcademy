<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="br.ufac.sgcm.model.Especialidade" %>

<jsp:useBean id="controller" class="br.ufac.sgcm.controller.EspecialidadeController" />

<%
    List<Especialidade> registros = controller.processListRequest(request);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, user-scalable=no">
        <title>SGCM - Profissionais</title>
        <link rel="stylesheet" href="./css/estilo.css">
        <link rel="stylesheet" href="./css/estilo-tema-azul.css" id="link-tema">
        <script src="./js/script.js" defer></script>
    </head>
    <body>
        <header>
            <div id="logo">
                <img src="imagens/logo_branco.png" alt="Logo SGCM">
                <span id="titulo">SGCM</span>
            </div>
            <div id="usuarioInfo">
                <span>Usuário: Administrador (admin)</span>
                <span>Papel: ADMIN</span>
                <select id="tema">
                    <option value="">Escolha um tema</option>
                    <option value="azul">Azul</option>
                    <option value="vermelho">Vermelho</option>
                    <option value="amarelo">Amarelo</option>
                </select>
                <a href="javascript:void(0)"
                   class="botao">Logout</a>
            </div>
        </header>
        <nav>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="pacientes.jsp">Pacientes</a></li>
                <li><a href="atendimento.jsp">Atendimento</a></li>
                <li><a href="convenios.jsp">Convênios</a></li>
                <li><a href="profissionais.jsp">Profissionais</a></li>
                <li><a href="unidades.jsp">Unidades</a></li>
                <li><a href="especialidades.jsp">Especialidades</a></li>
                <li><a href="usuarios.jsp">Usuários</a></li>
            </ul>
        </nav>
        <main>
            <form method="post">

                <div class="grid">

                </div>

                <input type="button" value="Cancelar" data-url="especialidades.jsp">
                <input type="submit" name="submit" value="Salvar">

            </form>
        </main>
        <footer>
            <span>SGCM - Sistema de Gerenciamento de Clínica Médica</span>
            <span>Suporte técnico: (68) 5555-5555 | <a href="mailto:suporte.sgcm@ufac.br">suporte.sgcm@ufac.br</a></span>
        </footer>
    </body>
</html>

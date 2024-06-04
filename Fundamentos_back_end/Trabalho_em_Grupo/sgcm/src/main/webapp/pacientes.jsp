<%@ page pageEncoding="UTF-8" %>
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
        <div id="comandos">
            <a href="pacientesForm.jsp"
               class="botao"
               id="add">
                Adicionar
            </a>
            <div>
                <label for="busca">Busca</label>
                <input type="search" name="busca" id="busca"
                       placeholder="Digite para buscar">
            </div>
        </div>
        <div class="table-container">
            <table>
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>Nome</td>
                        <td>Email</td>
                        <td>Nascimento</td>
                        <td>Sexo</td>
                        <td>Grupo Sanguíneo</td>
                        <td>CEP</td>
                        <td>Estado</td>
                        <td>Cidade</td>
                        <td>Endereço</td>
                        <td>Telefone</td>
                        <td>Ações</td>
                    </tr>
                </thead>
                <tbody>
                    <% for (Paciente item : registros) { %>
                        <tr>
                            <td> <% item.getId() %> </td>
                            <td><% item.getNome() %></td>
                            <td><% item.getEmail() %></td>
                            <td><% item.getData_nascimento() %></td>
                            <td><% item.getSexo() %></td>
                            <td><% item.getGrupo_sanguineo() %></td>
                            <td><% item.getCep() %></td>
                            <td><% item.getEstado() %></td>
                            <td><% item.getCidade() %></td>
                            <td><% item.getEndereco() %></td>
                            <td><% item.getTelefone() %></td>
                            <td>
                                <a href="pacientesForm.jsp?id=<%=item.getId()%>" class="botao">Editar</a>
                                <a href="pacientes.jsp.jsp?excluir=<%= item.getId()%>" class="excluir">Excluir</a>
                            </td>
                        </tr>
                        <% } %>
                    </tbody>
                </tbody>
                <tfoot>
                    <tr>
                        <td colspan="12">Total de registros <span id="total"></span></td>
                    </tr>
                </tfoot>
            </table>
        </div>
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
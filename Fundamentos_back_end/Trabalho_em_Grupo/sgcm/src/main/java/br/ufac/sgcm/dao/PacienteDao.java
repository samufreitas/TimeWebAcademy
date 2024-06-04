package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Fundamentos_back_end.Trabalho_em_Grupo.sgcm.src.main.java.br.ufac.sgcm.model;
import br.ufac.sgcm.model.Paciente;
import br.ufac.sgcm.model.Profissional;

public class PacienteDao implements IDao<Paciente> {
    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;

    public PacienteDao() {
        conexao = ConexaoDB.getConexao();
    }

    @Override
    public List<Paciente> get() {
        List<Paciente> registros = new ArrayList<>();
        String sql = "SELECT * FROM paciente";
        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Paciente registro = new Paciente();
                registro.setId(rs.getLong("id"));
                registro.setCep(rs.getString("cep"));
                registro.setCidade(rs.getString("cidade"));
                registro.setDataNascimento(rs.getDate("data_nascimento"));
                registro.setEmail(rs.getString("email"));
                registro.setEndereco(rs.getString("endereco"));
                registro.setEstado(rs.getString("estado"));
                registro.setGrupoSanguineo(rs.getString("grupo_sanguineo"));
                registro.setNome(rs.getString("nome"));
                registro.setSexo(rs.getString("sexo"));
                registro.setTelefone(rs.getString("telefone"));
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    // Retorna um Paciente pelo id
    @Override
    public Paciente get(Long id) {
        Paciente registro = new Paciente();
        String sql = "SELECT * FROM paciente WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                registro.setId(rs.getLong("id"));
                registro.setCep(rs.getString("cep"));
                registro.setCidade(rs.getString("cidade"));
                registro.setDataNascimento(rs.getDate("data_nascimento"));
                registro.setEmail(rs.getString("email"));
                registro.setEndereco(rs.getString("endereco"));
                registro.setEstado(rs.getString("estado"));
                registro.setGrupoSanguineo(rs.getString("grupo_sanguineo"));
                registro.setNome(rs.getString("nome"));
                registro.setSexo(rs.getString("sexo"));
                registro.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registro;
    }


    // Retorna os Pacientes conforme termo de busca no nome ou email
    @Override
    public List<Paciente> get(String termoDeBusca) {
        List<Paciente> registros = new ArrayList<>();
        String sql = "SELECT * FROM paciente WHERE nome LIKE ? OR email LIKE ?";
        try {
            ps = conexao.prepareStatement(sql);
            String likeTerm = "%" + termoDeBusca + "%";
            ps.setString(1, likeTerm);
            ps.setString(2, likeTerm);
            rs = ps.executeQuery();
            while (rs.next()) {
                Paciente registro = new Paciente();
                registro.setId(rs.getLong("id"));
                registro.setCep(rs.getString("cep"));
                registro.setCidade(rs.getString("cidade"));
                registro.setDataNascimento(rs.getDate("data_nascimento"));
                registro.setEmail(rs.getString("email"));
                registro.setEndereco(rs.getString("endereco"));
                registro.setEstado(rs.getString("estado"));
                registro.setGrupoSanguineo(rs.getString("grupo_sanguineo"));
                registro.setNome(rs.getString("nome"));
                registro.setSexo(rs.getString("sexo"));
                registro.setTelefone(rs.getString("telefone"));
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

        // Insere um novo Paciente
    @Override
    public int insert(Paciente objeto) {
        int registrosAfetados = 0;
        String sql = "INSERT INTO paciente (cep, cidade, data_nascimento, email, endereco, estado, grupo_sanguineo, " +
                "nome, sexo, telefone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getCep());
            ps.setString(2, objeto.getCidade());
            ps.setDate(3, new java.sql.Date(objeto.getDataNascimento().getTime()));
            ps.setString(4, objeto.getEmail());
            ps.setString(5, objeto.getEndereco());
            ps.setString(6, objeto.getEstado());
            ps.setString(7, objeto.getGrupoSanguineo());
            ps.setString(8, objeto.getNome());
            ps.setString(9, objeto.getSexo());
            ps.setString(10, objeto.getTelefone());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    // Atualiza um Paciente
    @Override
    public int update(Paciente objeto) {
        String sql = "UPDATE paciente SET cep = ?, cidade = ?, data_nascimento = ?, email = ?, endereco = ?, " +
                "estado = ?, grupo_sanguineo = ?, nome = ?, sexo = ?, telefone = ? WHERE id = ?";
        int registrosAfetados = 0;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getCep());
            ps.setString(2, objeto.getCidade());
            ps.setDate(3, new java.sql.Date(objeto.getDataNascimento().getTime()));
            ps.setString(4, objeto.getEmail());
            ps.setString(5, objeto.getEndereco());
            ps.setString(6, objeto.getEstado());
            ps.setString(7, objeto.getGrupoSanguineo());
            ps.setString(8, objeto.getNome());
            ps.setString(9, objeto.getSexo());
            ps.setString(10, objeto.getTelefone());
            ps.setLong(11, objeto.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    // Deleta um Paciente
    @Override
    public int delete(Paciente objeto) {
        String sql = "DELETE FROM paciente WHERE id = ?";
        int registrosAfetados = 0;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, objeto.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

}

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

public class PacienteDao {
    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;

    public PacienteDao() {
        conexao = ConexaoDB.getConexao();
    }

    @Override
    public int delete(Paciente objeto) {
        // TODO Auto-generated method stub
        return 0;
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

}

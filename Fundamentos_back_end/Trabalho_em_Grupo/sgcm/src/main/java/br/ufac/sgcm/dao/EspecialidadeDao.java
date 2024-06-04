package Fundamentos_back_end.Trabalho_em_Grupo.sgcm.src.main.java.br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Fundamentos_back_end.Trabalho_em_Grupo.sgcm.src.main.java.br.ufac.sgcm.model.Especialidade;

public class EspecialidadeDao implements IDao<Especialidade> {
    Connection conexao;
    PreparedStatement ps;
    ResultSet rs;
    
    public EspecialidadeDao() {
        this.conexao = ConexaoDB.getConexao();
    }

    /// Retornar todas as Especialidade
    @Override
    public List<Especialidade> get() {
        List<Especialidade> registros = new ArrayList<>();
        String sql = "SELECT * FROM especialidade";
        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Especialidade registro = new Especialidade();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registros.add(registro);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    // Retornar uma Especialidade pelo id
    @Override
    public Especialidade get(Long id) {
        Especialidade registro = new Especialidade();
        String sql = "SELECT * FROM especialidade WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registro;
    }

    // Retornar as Especialidades conforme o termo de busca
    @Override
    public List<Especialidade> get(String termoBusca) {
        List<Especialidade> registros = new ArrayList<>();
        String sql = "SELECT * FROM especialidade WHERE nome LIKE ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, "%" + termoBusca + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Especialidade registro = new Especialidade();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registros.add(registro);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    // Insere uma Especialidade
    @Override
    public int insert(Especialidade objeto) {
        int registrosAfetados = 0;
        String sql = "INSERT INTO especialidade (nome) VALUES (?)";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    // Atualiza uma Especialidade
    @Override
    public int update(Especialidade obejeto) {
        String sql = "UPDATE especialidade SET nome = ? WHERE id = ?";
        int registrosAfetados = 0;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, obejeto.getNome());
            ps.setLong(2, obejeto.getId());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    // Exclui uma Especialidade
    @Override
    public int delete(Especialidade objeto) {
        String sql = "DELETE FROM especialidade WHERE id = ?";
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
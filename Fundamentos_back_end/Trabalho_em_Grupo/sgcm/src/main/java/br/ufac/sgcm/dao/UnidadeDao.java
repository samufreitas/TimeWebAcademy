package Fundamentos_back_end.Trabalho_em_Grupo.sgcm.src.main.java.br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Fundamentos_back_end.Trabalho_em_Grupo.sgcm.src.main.java.br.ufac.sgcm.model.Unidade;

public class UnidadeDao implements IDao<Unidade> {
    private Connection conexao;
    private PreparedStatement ps;
    ResultSet rs;
    
    public UnidadeDao() {
        this.conexao = ConexaoDB.getConexao();
    }
    
    // Retorna todas as Unidades
    @Override
    public List<Unidade> get() {
        List<Unidade> registros = new ArrayList<>();
        String sql = "SELECT * FROM unidade";
        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Unidade registro = new Unidade();
                registro.setId(rs.getLong("id"));
                registro.setEndereco(rs.getString("endereco"));
                registro.setNome(rs.getString("nome"));
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    // Retorna uma Unidade pelo id
    @Override
    public Unidade get(Long id) {
        Unidade registro = new Unidade();
        String sql = "SELECT * FROM unidade WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEndereco(rs.getString("endereco"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registro;
    }

    // Retorna as Unidades conforme termo de busca
    @Override
    public List<Unidade> get(String termoDeBusca) {
        List<Unidade> registros = new ArrayList<>();
        String sql = "SELECT * FROM unidade WHERE nome LIKE ? OR endereco LIKE ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, "%" + termoDeBusca + "%");
            ps.setString(2, "%" + termoDeBusca + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Unidade registro = new Unidade();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEndereco(rs.getString("enderco"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    // Insere uma nova Unidade
    @Override
    public int insert(Unidade objeto) {
        int registrosAfetados = 0;
        String sql = "INSERT INTO unidade (endereco, nome) VALUES (?, ?)";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getEndereco());
            ps.setString(2, objeto.getNome());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    // Atualiza uma Unidade
    @Override
    public int update(Unidade objeto) {
        String sql = "UPDATE unidade SET endereco = ?, nome = ? WHERE id = ?";
        int registrosAfetados = 0;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getEndereco());
            ps.setString(2, objeto.getNome());
            ps.setLong(3, objeto.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    // Exclui uma Unidade
    @Override
    public int delete(Unidade obejeto) {
        String sql = "DELETE FROM unidade WHERE id = ?";
        int registrosAfetados = 0;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, obejeto.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }
}
package Fundamentos_back_end.Maria_Clara.sgcm.src.main.java.br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Fundamentos_back_end.Maria_Clara.sgcm.src.main.java.br.ufac.sgcm.model.Especialidade;

public class EspecialidadeDao {
    Connection conexao;
    PreparedStatement ps;
    ResultSet rs;

    public EspecialidadeDao(){
        conexao = ConexaoDB.getConexao();
    }

    //Retorna todas as especialidades
    public List<Especialidade> get(){
        List<Especialidade> registros = new ArrayList<>();
        String sql = "SELECT * FROM especialidade";
        try{
            ps = conexao.prepareStatement(sql); //Avisa para o banco que pode realizar execuções de comando sql
            rs = ps.executeQuery(); //Executa o código sql, ou seja, guarda o resultado da pesquisa
            while(rs.next()){
                Especialidade registro = new Especialidade();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registros.add(registro);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return registros;
    }
    
   //Retorna um objeto do tipo Especialidade, um específico, pelo id dele na tabela
   public Especialidade get(Long id){
    Especialidade registro = new Especialidade();
    String sql = "SELECT * FROM especialidade WHERE id = ?";
    try {
        ps = conexao.prepareStatement(sql);
        ps.setLong(1, id);
        rs = ps.executeQuery();
        if(rs.next()){
            registro.setId(rs.getLong("id"));
            registro.setNome(rs.getString("nome"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return registro;
   }

    //Retorna conforme um tempo de busca
    public  List<Especialidade> get(String termoBusca){
        List<Especialidade> registros = new ArrayList<>();
        String sql = "SELECT * FROM especialidade WHERE nome LIKE ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1,"%"+termoBusca+"%");
            rs = ps.executeQuery();
            while(rs.next()){
                Especialidade registro = new Especialidade();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    //Inserir uma Especialidade
    public int insert(Especialidade objeto){
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

    //Atualizar uma Especialidade
    public int update(Especialidade objeto){
        int registrosAfetados = 0;
        String sql = "UPDATE especialidade SET nome = ? WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setLong(2, objeto.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    //Excluir uma Especialidade
    public int delete(Especialidade objeto){
        int registrosAfetados = 0;
        String sql = "DELETE FROM especialidade WHERE id = ?";
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

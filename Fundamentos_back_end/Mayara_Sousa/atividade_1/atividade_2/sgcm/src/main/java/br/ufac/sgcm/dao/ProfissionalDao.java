package atividade_2.sgcm.src.main.java.br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import atividade_2.sgcm.src.main.java.br.ufac.sgcm.model.Profissional;
import atividade_2.sgcm.src.main.java.br.ufac.sgcm.model.Unidade;

public class ProfissionalDao implements IDao<Profissional>{
    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;
    private EspecialidadeDao eDao;
    private UnidadeDao uDao;

    public ProfissionalDao(){
        conexao = ConexaoDB.getConexao();
    }

    @Override
    public int delete(Profissional objeto) {
        int registrosAfetados = 0;
        String sql = "DELETE FROM profissional WHERE id = ?";
        try{
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, objeto.getId());
            registrosAfetados = ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    @Override
    public List<Profissional> get() {
        List<Profissional> registros = new ArrayList<>();
        String sql = "SELECT * FROM profissional";
        String sql2 = "SELECT P.id, p.nome, p.email, p.registro_conselho, p.telefone, e.nome, u.nome * FROM profissional AS p especialidade AS e, AS u" +
            "JOIN e.id ON p.especialidade_id AND" +
            "JOIN u.id ON p.unidade_id";
        try{
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Profissional resgistro = new Profissional();
                resgistro.setId(rs.getLong("id"));
                resgistro.setNome(rs.getString("nome"));
                resgistro.setEmail(rs.getString("email"));
                resgistro.setRegistro(rs.getString("registro conselho"));
                resgistro.setTelefone(rs.getString("telefone"));
                eDao = new EspecialidadeDao();
                resgistro.setEspecialidade(eDao.get(rs.getLong("especialidade_id")));
                uDao = new UnidadeDao();
                Unidade u = uDao.get(rs.getLong("unidade_id"));
                resgistro.setUnidade(u);
                registros.add(resgistro);
            } 

        }catch (SQLException e){
            e.printStackTrace();
        }
        return registros;
    }

    @Override
    public Profissional get(long id) {
        Profissional registro = new Profissional();
        String sql = "SELECT * FROM profissional WHERE id = ?";
        try{
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()){
                Profissional resgistro = new Profissional();
                resgistro.setId(rs.getLong("id"));
                resgistro.setNome(rs.getString("nome"));
                resgistro.setEmail(rs.getString("email"));
                resgistro.setRegistro(rs.getString("registro conselho"));
                resgistro.setTelefone(rs.getString("telefone"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return registro;   
    }

    @Override
    public List<Profissional> get(String termoBusca) {
        List<Profissional> registros = new ArrayList<>();
        String sql = "SELECT * FROM profissional WHERE nome LIKE ? OR email LIKE ? registro_conselho LIKE ? telefone LIKE ?";
        try{
            ps = conexao.prepareStatement(sql);
            ps.setString(1, "%"+termoBusca+"%");
            ps.setString(2, "%"+termoBusca+"%");
            rs = ps.executeQuery();
            while(rs.next()){
                Profissional resgistro = new Profissional();
                resgistro.setId(rs.getLong("id"));
                resgistro.setNome(rs.getString("nome"));
                resgistro.setEmail(rs.getString("email"));
                resgistro.setRegistro(rs.getString("registro conselho"));
                resgistro.setTelefone(rs.getString("telefone"));
                eDao = new EspecialidadeDao();
                resgistro.setEspecialidade(eDao.get(rs.getLong("especialidade_id")));
                uDao = new UnidadeDao();
                Unidade u = uDao.get(rs.getLong("unidade_id"));
                resgistro.setUnidade(u);
                registros.add(resgistro);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return registros; 
        
    }

    @Override
    public int insert(Profissional objeto) {
        int registrosAfetados = 0;
        String sql = "INSERT INTO profissional (nome, email, telefone, registro_conselho) VALUES ??";
        try{
            ps= conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getEmail());
            ps.setString(3, objeto.getTelefone());
            ps.setString(4, objeto.getRegistro());
            registrosAfetados = ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
        return registrosAfetados;
        
    }

    @Override
    public int update(Profissional objeto) {
        int registrosAfetados = 0;
        String sql = "UPDATE profissional SET nome = ?, email = ?, telefone = ?, registro_conselho = ?, " + "WHERE id = ?";
        try{
            ps= conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getEmail());
            ps.setString(3, objeto.getTelefone());
            ps.setString(4, objeto.getRegistro());
            registrosAfetados = ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
        return registrosAfetados;
    }

}

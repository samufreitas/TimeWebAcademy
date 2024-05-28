package Fundamentos_back_end.Maria_Clara.sgcm.src.main.java.br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import Fundamentos_back_end.Maria_Clara.sgcm.src.main.java.br.ufac.sgcm.dao.ProfissionalDao;
import Fundamentos_back_end.Maria_Clara.sgcm.src.main.java.br.ufac.sgcm.model.Profissional;
import Fundamentos_back_end.Maria_Clara.sgcm.src.main.java.br.ufac.sgcm.model.Unidade;
import Fundamentos_back_end.Maria_Clara.sgcm.src.main.java.br.ufac.sgcm.dao.EspecialidadeDao;
import Fundamentos_back_end.Maria_Clara.sgcm.src.main.java.br.ufac.sgcm.dao.UnidadeDao;
import Fundamentos_back_end.Maria_Clara.sgcm.src.main.java.br.ufac.sgcm.model.Especialidade;


public class ProfissionalDao implements IDao<Profissional>{

    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;
    private EspecialidadeDao eDao;
    private UnidadeDao uDao;

    public ProfissionalDao(){
        conexao = ConexaoDB.getConexao();
    }

    //REALIZAÇÃO DA ATIVIDADE DE CRIAR O DELEE, INSERT E UPDATE
    @Override
    public int delete(Profissional objeto) {
        int registrosAfetados = 0;
        String sql = "DELETE FROM profissional WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, objeto.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    @Override
    public List<Profissional> get() {
        List<Profissional> registros = new ArrayList<>();
        String sql = "SELECT * FROM profissional";
        String sql2 = "SELECT p.id, p.nome, p.email, p.registro_conselho, p.telefone, e.nome, u.nome FROM profissional AS p, especialidade AS e, unidade AS u JOIN e.id ON p.especialidade_id AND JOIN u.id ON p.unidade_id";
        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Profissional registro = new Profissional();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEmail(rs.getString("email"));
                registro.setRegistro(rs.getString("registro_conselho"));
                registro.setTelefone(rs.getString("telefone"));
                eDao = new EspecialidadeDao();
                registro.setEspecialidade(eDao.get(rs.getLong("especialidade_id")));
                uDao = new UnidadeDao();
                Unidade u = uDao.get(rs.getLong("unidade_id"));
                registro.setUnidade(u);
                registros.add(registro);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    @Override
    public Profissional get(Long id) {
        Profissional registro = new Profissional();
        String sql = "SELECT * FROM profissional WHERE id= ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEmail(rs.getString("email"));
                registro.setRegistro(rs.getString("registro_conselho"));
                registro.setTelefone(rs.getString("telefone"));
                eDao = new EspecialidadeDao();
                registro.setEspecialidade(eDao.get(rs.getLong("especialidade_id")));
                uDao = new UnidadeDao();
                Unidade u = uDao.get(rs.getLong("unidade_id"));
                registro.setUnidade(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registro;
    }

    @Override
    public List<Profissional> get(String termoBusca) {
        List<Profissional> registros = new ArrayList<>();
        String sql = "SELECT * FROM profissional WHERE nome LIKE ? OR email LIKE ? OR telefone LIKE ? OR registro_conselho LIKE ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, "%"+termoBusca+"%");
            ps.setString(2, "%"+termoBusca+"%");
            ps.setString(3, "%"+termoBusca+"%");
            ps.setString(4, "%"+termoBusca+"%");
            rs = ps.executeQuery();
            while(rs.next()){
                Profissional registro = new Profissional();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEmail(rs.getString("email"));
                registro.setRegistro(rs.getString("registro_conselho"));
                registro.setTelefone(rs.getString("telefone"));
                eDao = new EspecialidadeDao();
                registro.setEspecialidade(eDao.get(rs.getLong("especialidade_id")));
                uDao = new UnidadeDao();
                Unidade u = uDao.get(rs.getLong("unidade_id"));
                registro.setUnidade(u);
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    @Override
    public int insert(Profissional objeto) {
       int registrosAfetados = 0;
       String sql = "INSERT INTO profissional (nome, email, telefone, registro_conselho) VALUE (?, ?, ?, ?)";
       try {
        ps = conexao.prepareStatement(sql);
        ps.setString(1, objeto.getNome());
        ps.setString(2, objeto.getEmail());
        ps.setString(3, objeto.getTelefone());
        ps.setString(4, objeto.getRegistro());
        registrosAfetados = ps.executeUpdate();
       } catch (SQLException e) {
            e.printStackTrace();
       }
        return registrosAfetados;
    }

    @Override
    public int update(Profissional objeto) {
        int registrosAfetados = 0;
        String sql = "UPDATE profissional SET nome = ?, email = ?, telefone = ?, registro_conselho = ? WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getEmail());
            ps.setString(3, objeto.getTelefone());
            ps.setString(4, objeto.getRegistro());
            ps.setLong(5, objeto.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }
    
}


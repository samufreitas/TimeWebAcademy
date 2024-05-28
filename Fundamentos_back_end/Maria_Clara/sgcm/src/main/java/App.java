package Fundamentos_back_end.Maria_Clara.sgcm.src.main.java;
import Fundamentos_back_end.Maria_Clara.sgcm.src.main.java.br.ufac.sgcm.dao.ConexaoDB;
import Fundamentos_back_end.Maria_Clara.sgcm.src.main.java.br.ufac.sgcm.dao.EspecialidadeDao;
import Fundamentos_back_end.Maria_Clara.sgcm.src.main.java.br.ufac.sgcm.model.Especialidade;
import Fundamentos_back_end.Maria_Clara.sgcm.src.main.java.br.ufac.sgcm.model.Unidade;
import Fundamentos_back_end.Maria_Clara.sgcm.src.main.java.br.ufac.sgcm.model.Profissional;
import java.sql.Connection;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Profissional p1 = new Profissional();
        p1.setNome("Clara");
        p1.setEmail("clara@ufac.br");
        p1.setTelefone("11111111");
        p1.setRegistro("CRM/AC-123");

        Unidade u1 = new Unidade();
        u1.setId(1L);
        u1.setNome("Pronto Atendimento");
        u1.setEndereco("Av. Ceará");

        Especialidade e1 = new Especialidade();
        e1.setId(1L);
        e1.setNome("Oncologista Alterado 3");

        p1.setUnidade(u1);
        p1.setEspecialidade(e1);

        System.out.println(p1.getNome());
        System.out.println(p1.getUnidade().getNome());
        System.out.println(p1.getEspecialidade().getNome());

        ConexaoDB conexao = new ConexaoDB();
        Connection instancia = ConexaoDB.getConexao();
        if(instancia != null){
            System.out.println("Conectou");
        }else{
            System.out.println("Falhou");
        }
        
        EspecialidadeDao eDao = new EspecialidadeDao();
        List<Especialidade> listaEspecialidade = eDao.get();
        System.out.println("Lista de Especialidades:");
        for(Especialidade item : listaEspecialidade){
            System.out.println(item.getId()+" | "+item.getNome());
        }
        Especialidade esp = eDao.get(2L);
        System.out.println("Uma Especialidade:");
        System.out.println(esp.getId()+" | "+esp.getNome());

        System.out.println("Lista com termo de busca:gia");
        List<Especialidade> listaBusca = eDao.get("gia");
        for (Especialidade item : listaBusca){
            System.out.println(item.getId()+" | "+item.getNome());
        }

        //INSERINDO UMA ESPECIALIDADE
        // if (eDao.insert(e1) == 1){
        //     System.out.println("Especialidade inserida com sucesso!");
        //     listaEspecialidade = eDao.get(); //Recarregando a lista
        //     for(Especialidade item : listaEspecialidade){
        //         System.out.println(item.getId()+" | "+item.getNome());
        //     }
        // }

        //Atualizando uma especialidade
        // eDao.update(e1);
        // System.out.println("Especialidade Alterada: " + eDao.get(1L).getNome());

        //Deletando uma especialidade
        eDao.delete(e1);
        listaEspecialidade = eDao.get();
        System.out.println("Lista de Especialidades:");
        for(Especialidade item : listaEspecialidade){
            System.out.println(item.getId()+" | "+item.getNome());
        }


    }
}

package atividade_2.sgcm.src.main.java;
import java.sql.Connection;
import java.util.List;

import atividade_2.sgcm.src.main.java.br.ufac.sgcm.dao.ConexaoDB;
import atividade_2.sgcm.src.main.java.br.ufac.sgcm.dao.EspecialidadeDao;
import atividade_2.sgcm.src.main.java.br.ufac.sgcm.model.Especialidade;
import atividade_2.sgcm.src.main.java.br.ufac.sgcm.model.Profissional;
import atividade_2.sgcm.src.main.java.br.ufac.sgcm.model.Unidade;

public class App {
    public static void main(String[] args){
        atividade_2.sgcm.src.main.java.br.ufac.sgcm.model.Profissional p1 = new Profissional();
        p1.setNome("May");
        p1.setEmail("may@gmail.com");
        p1.setTelefone("999999999");
        p1.setRegistro("CRM/AC");

        Unidade u1 = new Unidade();
        u1.setId(1L);
        u1.setNome("Pronto Atendimento");
        u1.setEndereco("AV. Céara");

        Especialidade e1 = new Especialidade();
        e1.setId(1L);
        e1.setNome("Oncologista Alterado 3");

        p1.setUnidade(u1);
        p1.setEspecialidade(e1);

        System.out.println(p1.getNome());
        System.out.println(p1.getUnidade().getNome());
        System.out.println(p1.getEspecialidade().getNome());

        ConexaoDB conexao = new ConexaoDB();
        Connection instancia = conexao.getConexao();
        if(instancia != null){
            System.out.println("Conectou");
        }else{
            System.out.println("Falhou");
        }

        EspecialidadeDao eDao = new EspecialidadeDao();
        List<Especialidade> listaEspecialidade = eDao.get();
        System.out.println("Lista de Especialidades");
        for (Especialidade item : listaEspecialidade){
            System.out.println(item.getId()+"|"+item.getNome());
        }
        System.out.println("Uma Especialidade");
        Especialidade esp = eDao.get(2L);
        System.out.println(esp.getId()+ "|" +esp.getNome());

        System.out.println("Lista com termo de busca: gia");
        List<Especialidade> listaBusca = eDao.get("gia");
        for (Especialidade item : listaBusca){
            System.out.println(item.getId()+ "|" +item.getNome());
        }

        //Insrindo uma Especialidade
        // if (eDao.insert(e1) == 1){
        //     System.out.println("Especialidade inserida com sucesso!");
        //     listaEspecialidade = eDao.get();
        //     for (Especialidade item : listaEspecialidade){
        //         System.out.println(item.getId()+"|"+item.getNome());
        //     }
        // }

         //atualizar uma especialidade
        // eDao.update(e1);
        // System.out.println("Especialidade Alterada:"+ eDao.get(1L).getNome());

        //excluir uma especialidade
        eDao.delete(e1);
        listaEspecialidade = eDao.get();
        System.out.println("Lista de Especialidades");
        for (Especialidade item : listaEspecialidade){
            System.out.println(item.getId()+"|"+item.getNome());
        }

    }

}
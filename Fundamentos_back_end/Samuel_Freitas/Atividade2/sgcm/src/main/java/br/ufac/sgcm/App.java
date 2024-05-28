package br.ufac.sgcm;

import java.sql.Connection;
import java.util.List;

import br.ufac.sgcm.dao.ConexaoDB;
import br.ufac.sgcm.dao.EspecialidadeDao;
import br.ufac.sgcm.dao.ProfissionalDao;
import br.ufac.sgcm.model.Especialidade;
import br.ufac.sgcm.model.Profissional;
import br.ufac.sgcm.model.Unidade;

public class App {
    public static void main(String[] args) {
        Profissional p1 = new Profissional();
        p1.setId(1L);
        p1.setNome("Limeira");
        p1.setEmail("limeira@ufac.br");
        p1.setTelefone("999999999");
        p1.setRegistro("CRM-123");

        Unidade u1 = new Unidade();
        u1.setId(1L);
        u1.setNome("Pronto Atendimento");
        u1.setEndereco("Av. Rocha Viana");

        Especialidade e1 = new Especialidade();
        e1.setId(15L);
        e1.setNome("Clínico Geral");

        p1.setUnidade(u1);
        p1.setEspecialidade(e1);

        System.out.println(p1.getNome());
        System.out.println(p1.getUnidade().getNome());
        System.out.println(p1.getEspecialidade().getNome());

        // Parte de conexão com o banco de dados 
        ConexaoDB conexao = new ConexaoDB();
        Connection instancia = conexao.getConexao();
        if (instancia != null) {
            System.out.println("Conectou");
        } else {
            System.out.println("Falhou");
        }
        //Recebendo os dados de especialidade do banco de dados
        EspecialidadeDao eDao = new EspecialidadeDao();
        List<Especialidade> listaEspecialidades = eDao.get();
        System.out.println("Lista de especialidades:");
        for(Especialidade item: listaEspecialidades){
            System.out.println("| "+item.getId() + " | " + item.getNome()+"|");
        }
        System.out.println("Uma especialidade por id:");
        Especialidade esp = eDao.get(2L);

        System.out.println(esp.getId()+" | "+ esp.getNome());

        //lista com os termos de busca 
        System.out.println("Lista com termo de busca:");
        List<Especialidade> listaBusca = eDao.get("URO");
        for(Especialidade item: listaBusca){
            System.out.println(item.getId()+ " | " +item.getNome() );
        }
        //Inserindo uma especialidade 
        // if (eDao.insert(e1) == 1){
        //     System.out.println("Especialidade inserida com sucesso!");
        // }
        // //Listando novamente as especialidades 
        // System.out.println("Lista de especialidades 2:");
        // listaEspecialidades = eDao.get();
        // for(Especialidade item: listaEspecialidades){
        //     System.out.println("| "+item.getId() + " | " + item.getNome()+"|");
        // }

        //Atualizando uma especialidade
        // eDao.update(e1);
        // System.out.println("Especialidade alterada: "+ eDao.get(15L));

        //Delete em uma especialidade 
        /* 
        eDao.delete(e1); 
        listaEspecialidades = eDao.get();
        System.out.println("Deletando especialidade");
        for(Especialidade item: listaEspecialidades){
            System.out.println("| "+item.getId() + " | " + item.getNome()+"|");
        }
        */


        //Inserindo um profissional!
        ProfissionalDao pDao = new ProfissionalDao();
         Unidade u2 = new Unidade();
        u2.setId(1L);

        Especialidade e2 = new Especialidade();
        e2.setId(1L);

        Profissional p2 = new Profissional();
        p2.setId(7L);
        p2.setNome("Samuel Freitas dos Santos");
        p2.setEmail("samuel.freitas@sou.ufac.br");
        p2.setTelefone("(68) 99212-7887");
        p2.setRegistro("CRM-2024");
        

        // Inserindo profissional 
        /* 
        if (pDao.insert(p2) == 1) {
            System.out.println("Profissional inserido com sucesso!");
        } else {
            System.out.println("Erro ao inserir o profissional.");
        }*/
        

        //Parte de deletar profissional

        /* if(pDao.delete(p2) == 1){
            System.out.println("Profissional deletado com sucesso!");
        } else {
            System.out.println("Erro ao deletar o profissional.");
        }*/
        
        //Realizando update de profissional

        /*if(pDao.update(p2) == 1){
            System.out.println("Profissional atualizado com sucesso!");
        } else {
            System.out.println("Erro na atualização do profissional.");
        } */

        //Profissional por id 
        System.out.println("========================================================");
        System.out.println("Pesquisando um Profissional por id:");
        Profissional ob = pDao.get(7L);

        System.out.println(ob.getId()+" | "+ ob.getNome()+" | "+ ob.getEmail()+" | "+ ob.getEspecialidade().getNome());

        System.out.println("========================================================");

        System.out.println("Pesquisando profissionais por termo de busca:");
        List<Profissional> listaBuscaProfissional = pDao.get("68");
        for(Profissional item: listaBuscaProfissional){
            System.out.println(item.getId()+" | "+ item.getNome()+" | "+ item.getEmail()+" | "+ item.getEspecialidade().getNome());

        }

        
        

    }
}

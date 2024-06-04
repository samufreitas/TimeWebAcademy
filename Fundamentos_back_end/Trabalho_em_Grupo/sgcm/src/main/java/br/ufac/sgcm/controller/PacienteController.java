package main.java.br.ufac.sgcm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Fundamentos_back_end.Trabalho_em_Grupo.sgcm.src.main.java.br.ufac.sgcm.dao.PacienteDao;
import Fundamentos_back_end.Trabalho_em_Grupo.sgcm.src.main.java.br.ufac.sgcm.model.Paciente;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class PacienteController implements IController<Paciente> {

    private PacienteDao pDao;

    public PacienteController() {
        pDao = new PacienteDao();
    }

//delete
    @Override
    public int delete(Paciente objeto) {
        int registrosAfetados = pDao.delete(objeto);
        return registrosAfetados;
    }

//gets
    @Override
    public List<Paciente> get() {
        List<Paciente> registros = pDao.get();
        return registros;
    }

    @Override
    public Paciente get(Long id) {
        Paciente registro = pDao.get(id);
        return registro;
    }

    @Override
    public List<Paciente> get(String termoDeBusca) {
        List<Paciente> registros = pDao.get(termoDeBusca);
        return registros;
    }

// save?
    @Override
    public int save(Paciente objeto) {
        int registrosAfetados;
        if (objeto.getId() == null) {
            registrosAfetados = pDao.insert(objeto);
        } else {
            registrosAfetados = pDao.update(objeto);
        }
        return registrosAfetados;
    }


    // falta os metodos do servlet
}

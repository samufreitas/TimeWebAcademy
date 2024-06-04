package main.java.br.ufac.sgcm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Fundamentos_back_end.Trabalho_em_Grupo.sgcm.src.main.java.br.ufac.sgcm.dao.PacienteDao;
import Fundamentos_back_end.Trabalho_em_Grupo.sgcm.src.main.java.br.ufac.sgcm.model.Paciente;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class PacienteController implements IController<Especialidade> {

    private PacienteDao eDao;

    public PacienteController() {
        eDao = new PacienteDao();
    }

    @Override
    public int delete(Paciente objeto) {
        int registrosAfetados = eDao.delete(objeto);
        return registrosAfetados;
    }

}

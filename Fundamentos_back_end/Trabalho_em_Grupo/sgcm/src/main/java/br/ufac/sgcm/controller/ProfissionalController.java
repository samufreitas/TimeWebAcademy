package br.ufac.sgcm.controller;

import java.util.List;

import br.ufac.sgcm.dao.ProfissionalDao;
import br.ufac.sgcm.model.Profissional;

public class ProfissionalController implements IController<Profissional>{
    private ProfissionalDao pDao;

    public ProfissionalController() {
        pDao = new ProfissionalDao();
    }

    @Override
    public List<Profissional> get() {
        List<Profissional> registros = pDao.get();
        return registros;
    }

    @Override
    public Profissional get(Long id) {
        Profissional registro = pDao.get(id);
        return registro;
    }

    @Override
    public List<Profissional> get(String termoDeBusca) {
        List<Profissional> registros = pDao.get(termoDeBusca);
        return registros;
    }

    @Override
    public int delete(Profissional objeto) {
        int registrosAfetados = pDao.delete(objeto);
        return registrosAfetados;
    }

    @Override
    public int save(Profissional objeto) {
        int registrosAfetados;
        if (objeto.getId() == null) {
            registrosAfetados = pDao.insert(objeto);
        } else {
            registrosAfetados = pDao.update(objeto);
        }
        return registrosAfetados;
    }
    
}

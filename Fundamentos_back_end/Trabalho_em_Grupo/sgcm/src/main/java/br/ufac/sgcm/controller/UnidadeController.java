package br.ufac.sgcm.controller;

import java.util.List;

import br.ufac.sgcm.dao.UnidadeDao;
import br.ufac.sgcm.model.Unidade;

public class UnidadeController implements IController<Unidade> {
    
    private UnidadeDao uDao;

    public UnidadeController() {
        uDao = new UnidadeDao();
    }

    @Override
    public List<Unidade> get() {
        List<Unidade> registros = uDao.get();
        return registros;
    }

    @Override
    public Unidade get(Long id) {
        Unidade registro = uDao.get(id);
        return registro;
    }

    @Override
    public List<Unidade> get(String termoDeBusca) {
        List<Unidade> registros = uDao.get(termoDeBusca);
        return registros;
    }

    @Override
    public int delete(Unidade objeto) {
        int registrosAfetados = uDao.delete(objeto);
        return registrosAfetados;
    }

    @Override
    public int save(Unidade objeto) {
        int registrosAfetados;
        if (objeto.getId() == null) {
            registrosAfetados = uDao.insert(objeto);
        } else {
            registrosAfetados = uDao.update(objeto);
        }
        return registrosAfetados;
    }
}

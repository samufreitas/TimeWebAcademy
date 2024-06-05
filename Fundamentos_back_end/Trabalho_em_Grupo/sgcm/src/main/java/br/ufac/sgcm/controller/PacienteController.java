package main.java.br.ufac.sgcm.controller;

import java.util.List;

import javax.lang.model.element.PackageElement;

import br.ufac.sgcm.dao.PacienteDao;
import br.ufac.sgcm.model.Paciente;
import br.ufac.sgcm.model.Profissional;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PacienteController implements IController<Paciente>{
    private PacienteDao pacDao;

    public PacienteController() {
        pacDao = new PacienteDao();
    }

    @Override
    public int delete(Paciente objeto) {
        int registrosAfetados = pacDao.delete(objeto);
        return registrosAfetados;
    }

    @Override
    public List<Paciente> get() {
        List<Paciente> registros = pacDao.get();
        return registros;
    }

    @Override
    public Paciente get(Long id) {
        Paciente registro = pacDao.get(id);
        return registro;
    }

    @Override
    public List<Paciente> get(String termoBusca) {
        List<Paciente> registros = pacDao.get(termoBusca);
        return registros;
    }

    @Override
    public Paciente processFormRequest(HttpServletRequest request, HttpServletResponse response) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Paciente> processListRequest(HttpServletRequest request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int save(Paciente objeto) {
        int registrosAfetados;
        if (objeto.getId() == null) {
            registrosAfetados = pacDao.insert(objeto);
        } else {
            registrosAfetados = pacDao.update(objeto);
        }
        return registrosAfetados;
    }




    
// Metodos do Servlet
    public List<Paciente> processListRequest(HttpServletRequest req) {
        List<Paciente> registros = new ArrayList<>();
        String paramExcluir = req.getParameter("excluir");// excluir
        if (paramExcluir != null && !paramExcluir.isEmpty()) {
            Paciente esp = new Paciente();
            Long id = Long.parseLong(paramExcluir);
            esp = this.get(id);
            this.delete(esp);
        }
        registros = this.get();
        return registros;
    }


    public Paciente processFormRequest(HttpServletRequest req, HttpServletResponse res) {
        Paciente item = new Paciente();
        String submit = req.getParameter("submit");
        String paramId = req.getParameter("id");
        if (paramId != null && !paramId.isEmpty()) {
            Long id = Long.parseLong(paramId);
            item.setId(id);
            this.save(item);
        }
        if (submit != null) {
            item.setNome(req.getParameter("nome"));
            this.save(item);
        }
        try {
            res.sendRedirect("Paciente.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item;
    }

}
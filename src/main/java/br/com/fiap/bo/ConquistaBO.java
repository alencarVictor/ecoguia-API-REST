package br.com.fiap.bo;

import br.com.fiap.dao.ConquistaDAO;
import br.com.fiap.to.ConquistaTO;

import java.time.LocalDate;
import java.util.ArrayList;

public class ConquistaBO {
    private ConquistaDAO conquistaDAO;

    public ArrayList<ConquistaTO> findAll(){
        conquistaDAO = new ConquistaDAO();
        //regra de negocin
        return conquistaDAO.findAll();
    }

    public ConquistaTO findByCodigo(Integer idConquista){
        conquistaDAO = new ConquistaDAO();
        //regra de negocin
        return conquistaDAO.findByCodigo(idConquista);
    }

    public ConquistaTO save(ConquistaTO conquista){
        conquistaDAO = new ConquistaDAO();
        //regra de negocio: se a data nao vier, usa a data de hoje
        if (conquista.getDataConquista() == null) {
            conquista.setDataConquista(LocalDate.now());
        }
        return conquistaDAO.save(conquista);
    }

    public boolean delete (Integer idConquista){
        conquistaDAO = new ConquistaDAO();
        //regra de negocin
        return conquistaDAO.delete(idConquista);
    }

    public ConquistaTO update(ConquistaTO conquista){
        conquistaDAO = new ConquistaDAO();
        //regra de negocio: se a data nao vier, usa a data de hoje
        if (conquista.getDataConquista() == null) {
            conquista.setDataConquista(LocalDate.now());
        }
        return conquistaDAO.update(conquista);
    }
}

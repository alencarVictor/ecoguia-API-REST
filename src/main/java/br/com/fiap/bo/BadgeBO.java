package br.com.fiap.bo;


import br.com.fiap.dao.BadgeDAO;
import br.com.fiap.to.BadgeTO;
import java.util.ArrayList;

public class BadgeBO {
    private BadgeDAO badgeDAO;

    public ArrayList<BadgeTO> findAll(){
        badgeDAO = new BadgeDAO();
        //regra de negocin
        return  badgeDAO.findAll();
    }

    public BadgeTO findByCodigo(Integer idBadge){
        badgeDAO = new BadgeDAO();
        //regra de negocin
        return  badgeDAO.findByCodigo(idBadge);
    }

    public BadgeTO save(BadgeTO badge){
        badgeDAO = new BadgeDAO();
        //regra de negocin
        return  badgeDAO.save(badge);
    }

    public boolean delete (Integer idBadge){
        badgeDAO = new BadgeDAO();
        //regra de negocin
        return  badgeDAO.delete(idBadge);
    }

    public BadgeTO update(BadgeTO badge){
        badgeDAO = new BadgeDAO();
        //regra de negocin
        return badgeDAO.update(badge);
    }
}

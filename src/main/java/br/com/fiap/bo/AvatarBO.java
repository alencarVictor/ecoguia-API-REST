package br.com.fiap.bo;

import br.com.fiap.dao.AvatarDAO;
import br.com.fiap.to.AvatarTO;

import java.util.ArrayList;

public class AvatarBO {

    private AvatarDAO avatarDAO;

    public ArrayList<AvatarTO>findAll(){
        avatarDAO = new AvatarDAO();
        //regra de negocin
        return avatarDAO.findAll();
    }

    public AvatarTO findByCodigo(Integer idAvatar){
        avatarDAO = new AvatarDAO();
        //regra de negocin
        return avatarDAO.findByCodigo(idAvatar);
    }

    public AvatarTO save(AvatarTO avatar){
        avatarDAO = new AvatarDAO();
        //regra de negocin
        return avatarDAO.save(avatar);
    }

    public boolean delete (Integer idAvatar){
        avatarDAO = new AvatarDAO();
        //regra de negocin
        return avatarDAO.delete(idAvatar);
    }

    public AvatarTO update(AvatarTO avatar){
        avatarDAO = new AvatarDAO();
        //regra de negocio: a cada 1000 xp o avatar sobe 1 nivel
        avatar.setNivelAtual((int) (avatar.getXpAtual()/1000) + 1);
        return avatarDAO.update(avatar);
    }



}

package br.com.fiap.bo;


import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.to.UsuarioTO;


import java.util.ArrayList;

public class UsuarioBO {

    private UsuarioDAO usuarioDAO;

    public ArrayList<UsuarioTO> findAll(){
        usuarioDAO = new UsuarioDAO();
        //regra de negocin
        return usuarioDAO.findAll();
    }

    public UsuarioTO findByCodigo(Integer idUsuario){
        usuarioDAO = new UsuarioDAO();
        //regra de negocin
        return usuarioDAO.findByCodigo(idUsuario);
    }

    public UsuarioTO save(UsuarioTO usuario){
        usuarioDAO = new UsuarioDAO();
        //regra de negocin
        return usuarioDAO.save(usuario);
    }

    public boolean delete (Integer idUsuario){
        usuarioDAO = new UsuarioDAO();
        //regra de negocin
        return usuarioDAO.delete(idUsuario);
    }

    public UsuarioTO update(UsuarioTO usuario){
        usuarioDAO = new UsuarioDAO();
        //regra de negocin
        return usuarioDAO.update(usuario);
    }
}

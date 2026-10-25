package br.com.fiap.dao;


import br.com.fiap.to.UsuarioTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {
    public ArrayList<UsuarioTO> findAll(){ //Arraylist que vai retornar objeto de UsuarioTO
        ArrayList<UsuarioTO> usuarios = new ArrayList<>();
        String sql = "select * from t_usuario order by id_usuario";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ResultSet rs = ps.executeQuery();
            if(rs != null){
                while ( rs.next()){
                    UsuarioTO usuario = new UsuarioTO();
                    usuario.setIdUsuario(rs.getInt("id_usuario"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setSenha(rs.getString("senha"));
                    usuario.setCidade(rs.getString("cidade"));
                    usuario.setIdAvatar(rs.getInt("id_avatar"));
                    usuario.setOfensivaAtual(rs.getInt("ofensiva_atual"));
                    usuarios.add(usuario);
                }
            }else {
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro ao listar: "+e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return usuarios;
    }

    public UsuarioTO findByCodigo(Integer idUsuario){
        UsuarioTO usuario = new UsuarioTO();
        String sql = "select * from  t_usuario where id_usuario = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setInt(1,idUsuario);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setCidade(rs.getString("cidade"));
                usuario.setIdAvatar(rs.getInt("id_avatar"));
                usuario.setOfensivaAtual(rs.getInt("ofensiva_atual"));
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar por id: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return usuario;
    }

    public UsuarioTO save (UsuarioTO usuario) {
        String sql = "insert into t_usuario (nome, email, senha,cidade,id_avatar,ofensiva_atual) values(?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1,usuario.getNome());
            ps.setString(2,usuario.getEmail());
            ps.setString(3,usuario.getSenha());
            ps.setString(4,usuario.getCidade());
            ps.setInt(5,usuario.getIdAvatar());
            ps.setInt(6,usuario.getOfensivaAtual());
            if (ps.executeUpdate() > 0) {
                return usuario;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public boolean delete (Integer idUsuario){
        String sql = "delete from t_usuario where id_usuario =?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setInt(1 ,idUsuario);
            return ps.executeUpdate() > 0;

        }catch (SQLException e){
            System.out.println("Erro ao excluir: "+e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public UsuarioTO update(UsuarioTO usuario){
        String sql = "update t_usuario set nome=?, email=?, senha=? ,cidade=?,id_avatar=?, ofensiva_atual=? where id_usuario =?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setString(1,usuario.getNome());
            ps.setString(2,usuario.getEmail());
            ps.setString(3,usuario.getSenha());
            ps.setString(4,usuario.getCidade());
            ps.setInt(5,usuario.getIdAvatar());
            ps.setInt(6,usuario.getOfensivaAtual());
            ps.setInt(7,usuario.getIdUsuario());

            if(ps.executeUpdate()> 0){
                return usuario;
            }else{
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}

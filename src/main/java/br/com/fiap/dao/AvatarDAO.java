package br.com.fiap.dao;

import br.com.fiap.to.AvatarTO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AvatarDAO {

    public ArrayList<AvatarTO> findAll(){ //Arraylist que vai retornar objeto de AvatarTO
        ArrayList<AvatarTO> avatars = new ArrayList<>();
        String sql = "select * from t_avatar order by id_avatar";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ResultSet rs = ps.executeQuery();
            if(rs != null){
                while ( rs.next()){
                    AvatarTO avatar = new AvatarTO();
                    avatar.setIdAvatar(rs.getInt("id_avatar"));
                    avatar.setNome(rs.getString("nome"));
                    avatar.setNivelAtual(rs.getInt("nivel_atual"));
                    avatar.setXpAtual(rs.getDouble("xp_atual"));
                    avatars.add(avatar);
                }
            }else {
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro ao listar: "+e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return avatars;
    }

    public AvatarTO findByCodigo(Integer idAvatar){
        AvatarTO avatar = new AvatarTO();
        String sql = "select * from t_avatar where id_avatar = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setInt(1,idAvatar);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                    avatar.setIdAvatar(rs.getInt("id_avatar"));
                    avatar.setNome(rs.getString("nome"));
                    avatar.setNivelAtual(rs.getInt("nivel_atual"));
                    avatar.setXpAtual(rs.getDouble("xp_atual"));
                }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar por id: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return avatar;
    }

    public AvatarTO save (AvatarTO avatar) {
        String sql = "insert into t_avatar (nome, nivel_atual, xp_atual) values(?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1,avatar.getNome());
            ps.setInt(2,avatar.getNivelAtual());
            ps.setDouble(3,avatar.getXpAtual());
            if (ps.executeUpdate() > 0) {
                return avatar;
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

    public boolean delete (Integer idAvatar){
        String sql = "delete from t_avatar where id_avatar =?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setInt(1 ,idAvatar);
            return ps.executeUpdate() > 0;

        }catch (SQLException e){
            System.out.println("Erro ao excluir: "+e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public AvatarTO update(AvatarTO avatar){
        String sql = "update t_avatar set nome=?, nivel_atual=?, xp_atual=? where id_avatar =?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setString(1,avatar.getNome());
            ps.setInt(2,avatar.getNivelAtual());
            ps.setDouble(3, avatar.getXpAtual());
            ps.setInt(4,avatar.getIdAvatar());

            if(ps.executeUpdate()> 0){
                return avatar;
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

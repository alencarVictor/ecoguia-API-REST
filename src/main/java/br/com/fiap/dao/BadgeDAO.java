package br.com.fiap.dao;


import br.com.fiap.to.BadgeTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BadgeDAO {
    public ArrayList<BadgeTO> findAll(){ //Arraylist que vai retornar objeto de BadgeTO
        ArrayList<BadgeTO> badges = new ArrayList<>();
        String sql = "select * from t_badge order by id_badge";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ResultSet rs = ps.executeQuery();
            if(rs != null){
                while ( rs.next()){
                    BadgeTO badge = new BadgeTO();
                    badge.setIdBadge(rs.getInt("id_badge"));
                    badge.setNome(rs.getString("nome"));
                    badge.setTipo(rs.getString("tipo"));
                    badge.setDescricao(rs.getString("descricao"));
                    badges.add(badge);
                }
            }else {
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro ao listar: "+e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return badges;
    }

    public BadgeTO findByCodigo(Integer idBadge){
        BadgeTO badge = new BadgeTO();
        String sql = "select * from t_badge where id_badge = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setInt(1,idBadge);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                badge.setIdBadge(rs.getInt("id_badge"));
                badge.setNome(rs.getString("nome"));
                badge.setTipo(rs.getString("tipo"));
                badge.setDescricao(rs.getString("descricao"));
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar por id: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return badge;
    }

    public BadgeTO save (BadgeTO badge) {
        String sql = "insert into t_badge (nome, tipo,descricao) values(?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1,badge.getNome());
            ps.setString(2,badge.getTipo());
            ps.setString(3,badge.getDescricao());
            if (ps.executeUpdate() > 0) {
                return badge;
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

    public boolean delete (Integer idBadge){
        String sql = "delete from  t_badge where id_badge =?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setInt(1 ,idBadge);
            return ps.executeUpdate() > 0;

        }catch (SQLException e){
            System.out.println("Erro ao excluir: "+e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public BadgeTO update(BadgeTO badge){
        String sql = "update t_badge set nome=?, tipo=?, descricao=? where id_badge =?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setString(1,badge.getNome());
            ps.setString(2,badge.getTipo());
            ps.setString(3, badge.getDescricao());
            ps.setInt(4,badge.getIdBadge());

            if(ps.executeUpdate()> 0){
                return badge;
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

package br.com.fiap.dao;



import br.com.fiap.to.ConquistaTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConquistaDAO {
    public ArrayList<ConquistaTO> findAll(){ //Arraylist que vai retornar objeto de ConquistaTO
        ArrayList<ConquistaTO> conquistas = new ArrayList<>();
        String sql = "select * from t_conquista order by id_conquista";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ResultSet rs = ps.executeQuery();
            if(rs != null){
                while ( rs.next()){
                    ConquistaTO conquista = new ConquistaTO();
                    conquista.setIdConquista(rs.getInt("id_conquista"));
                    conquista.setIdUsuario(rs.getInt("id_usuario"));
                    conquista.setIdBadge(rs.getInt("id_badge"));
                    conquista.setDataConquista(rs.getDate("data_conquista").toLocalDate());
                    conquistas.add(conquista);
                }
            }else {
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro ao listar: "+e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return conquistas;
    }

    public ConquistaTO findByCodigo(Integer idConquista){
        ConquistaTO conquista = new ConquistaTO();
        String sql = "select * from  t_conquista where id_conquista = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setInt(1,idConquista);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                conquista.setIdConquista(rs.getInt("id_conquista"));
                conquista.setIdUsuario(rs.getInt("id_usuario"));
                conquista.setIdBadge(rs.getInt("id_badge"));
                conquista.setDataConquista(rs.getDate("data_conquista").toLocalDate());
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar por id: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return conquista;
    }

    public ConquistaTO save (ConquistaTO conquista) {
        String sql = "insert into t_conquista  (id_usuario, id_badge, data_conquista) values(?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setInt(1,conquista.getIdUsuario());
            ps.setInt(2,conquista.getIdBadge());
            ps.setDate(3, Date.valueOf(conquista.getDataConquista()));

            if (ps.executeUpdate() > 0) {
                return conquista;
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

    public boolean delete (Integer idConquista){
        String sql = "delete from t_conquista where id_conquista =?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setInt(1 ,idConquista);
            return ps.executeUpdate() > 0;

        }catch (SQLException e){
            System.out.println("Erro ao excluir: "+e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public ConquistaTO update(ConquistaTO conquista){
        String sql = "update t_conquista set id_usuario=?, id_badge=?, data_conquista=? where id_conquista =?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ps.setInt(1,conquista.getIdUsuario());
            ps.setInt(2,conquista.getIdBadge());
            ps.setDate(3, Date.valueOf(conquista.getDataConquista()));
            ps.setInt(4,conquista.getIdConquista());

            if(ps.executeUpdate()> 0){
                return conquista;
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

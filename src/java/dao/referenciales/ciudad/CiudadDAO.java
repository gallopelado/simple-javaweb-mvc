package dao.referenciales.ciudad;

import genericos.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.referenciales.ciudad.CiudadModel;

/**
 *
 * @author juan
 */
public class CiudadDAO {
    
    private ConexionBD conexion;
    //private PreparedStatement ps;
    //private ResultSet rs;

    public CiudadDAO() {
        this.conexion = new ConexionBD();
    }
    
    public List<CiudadModel> seleccionarTodos() {
        String querySQL = "SELECT id, descripcion FROM ciudades";
        try(PreparedStatement st = conexion.obtenerConexion().prepareStatement(querySQL); ResultSet rs = st.executeQuery();) {
            List<CiudadModel> lista_ciudades = new ArrayList<>();
            while(rs.next()) {
                lista_ciudades.add(new CiudadModel(rs.getInt("id"), rs.getString("descripcion")));
            }
            return lista_ciudades;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public CiudadModel seleccionarPorId(Integer id) {
        String querySQL = "SELECT id, descripcion FROM ciudades WHERE id = ?";
        try(PreparedStatement st = conexion.obtenerConexion().prepareStatement(querySQL);) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                return new CiudadModel(rs.getInt("id"), rs.getString("descripcion"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Boolean agregar(CiudadModel ciudad) {
        String insertSQL = "INSERT INTO ciudades(descripcion) VALUES(?)";
        try(PreparedStatement st = conexion.obtenerConexion().prepareStatement(insertSQL)) {
            conexion.Transaccion(ConexionBD.TR.INICIAR);
            st.setString(1, ciudad.getDescripcion());
            if(st.executeUpdate() > 0) {
                conexion.Transaccion(ConexionBD.TR.CONFIRMAR);
                return true;
            } else {
                conexion.Transaccion(ConexionBD.TR.CANCELAR);
            }
        } catch(Exception e) {
            conexion.Transaccion(ConexionBD.TR.CANCELAR);
            e.printStackTrace();
        }
        return false;
    }
    
    public Boolean modificar(CiudadModel ciudad) {
        String updateSQL = "UPDATE ciudades SET descripcion=? WHERE id=?";
        try(PreparedStatement st = conexion.obtenerConexion().prepareStatement(updateSQL)) {
            conexion.Transaccion(ConexionBD.TR.INICIAR);
            st.setString(1, ciudad.getDescripcion());
            st.setInt(2, ciudad.getId());
            if(st.executeUpdate() > 0) {
                conexion.Transaccion(ConexionBD.TR.CONFIRMAR);
                return true;
            } else {
                conexion.Transaccion(ConexionBD.TR.CANCELAR);
            }
        } catch(Exception e) {
            conexion.Transaccion(ConexionBD.TR.CANCELAR);
            e.printStackTrace();
        }
        return false;
    }
    
    public Boolean eliminar(Integer id) {
        String deleteSQL = "DELETE FROM ciudades WHERE id=?";
        try(PreparedStatement st = conexion.obtenerConexion().prepareStatement(deleteSQL)) {
            conexion.Transaccion(ConexionBD.TR.INICIAR);
            st.setInt(1, id);
            if(st.executeUpdate() > 0) {
                conexion.Transaccion(ConexionBD.TR.CONFIRMAR);
                return true;
            } else {
                conexion.Transaccion(ConexionBD.TR.CANCELAR);
            }
        } catch(Exception e) {
            conexion.Transaccion(ConexionBD.TR.CANCELAR);
            e.printStackTrace();
        }
        return false;
    }
}

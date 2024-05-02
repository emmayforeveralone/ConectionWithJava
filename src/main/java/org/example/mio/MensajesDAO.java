package org.example.mio;

import org.example.mio.Conect.DBConect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDAO {

    public static void createMensaje(MensajesModelo mensajes){
        DBConect db = new DBConect();

        try (Connection con = db.get_connection()){

            PreparedStatement statement = null;
            try {
                String query = "INSERT INTO mensaje (mensaje, autor_mensaje) VALUES (?,?);";
                statement = con.prepareStatement(query);
                statement.setString(1, mensajes.getMensaje());
                statement.setString(2, mensajes.getAutor_mensaje());
                statement.executeUpdate();
                System.out.println();
                System.out.println("Mensaje Creado");

            }catch (SQLException e){
                System.out.println("Error creando mensaje: "+e);
                e.printStackTrace();
            }

        }catch (SQLException e) {
            System.out.println("ERROR AL CREAR: " + e);
            throw new RuntimeException(e);
        }
    }

    public static void readMensaje(){
        DBConect db = new DBConect();

        try (Connection con = db.get_connection()) {

            PreparedStatement statement = null;
            ResultSet rs = null;

                String query = "SELECT * FROM mensaje;";
                statement = con.prepareStatement(query);
                rs = statement.executeQuery();

                while (rs.next()) {
                    System.out.println();
                    System.out.println("Id: "+rs.getInt("id_mensaje"));
                    System.out.println("Mensaje: "+rs.getString("mensaje"));
                    System.out.println("Autor: "+rs.getString("autor_mensaje"));
                    System.out.println();
                }

        } catch (SQLException e) {
            System.out.println("ERROR AL LEER: " + e);
            throw new RuntimeException(e);
        }

    }

    public static void deleteMensaje(int id_mensaje)  {
        DBConect db = new DBConect();

        try (Connection con = db.get_connection()){
            PreparedStatement statement = null;

            String query = "DELETE FROM mensaje WHERE id_mensaje = ?";
            statement = con.prepareStatement(query);
            statement.setInt(1, id_mensaje);
            statement.executeUpdate();
            System.out.println("SE ELIMINO CON EXITO EL MENSAJE");

        } catch (SQLException e) {
            System.out.println("ERROR AL BORRAR: " + e);
            throw new RuntimeException(e);
        }
    }

    public static void updateMensaje(MensajesModelo mensajes){

        DBConect db = new DBConect();

        try(Connection con = db.get_connection()){

            PreparedStatement statement = null;
            String query = "UPDATE mensaje SET mensaje = ? WHERE id_mensaje = ?;";
            statement = con.prepareStatement(query);
            statement.setString(1, mensajes.getMensaje());
            statement.setInt(2, mensajes.getId_mensaje());
            statement.executeUpdate();
            System.out.println("Mensaje Actualizado");

        } catch (SQLException e) {
            System.out.println("ERROR AL ACTUALIZAR: " + e);
            throw new RuntimeException(e);
        }

    }
}

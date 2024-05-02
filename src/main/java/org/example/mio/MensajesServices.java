package org.example.mio;

import java.sql.SQLException;
import java.util.Scanner;

public class MensajesServices {

    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------");
        System.out.println("Escribe un mensaje");
        String mensaje = sc.nextLine();

        System.out.println("---------------");
        System.out.println("Escribe tu nombre:");
        String autor = sc.nextLine();

        MensajesModelo modelo = new MensajesModelo();
        modelo.setMensaje(mensaje);
        modelo.setAutor_mensaje(autor);

        MensajesDAO.createMensaje(modelo);
    }

    public static void listarMensaje(){
        MensajesDAO.readMensaje();
    }

    public static void eliminarMensaje()  {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------");
        System.out.println("Escribe el id del mensaje");
        int id = sc.nextInt();
        MensajesDAO.deleteMensaje(id);


    }

    public static void editarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------");
        System.out.println("Escribe el mensaje actualizado");
        String mensaje = sc.nextLine();

        System.out.println("Escribe el id del mensaje");
        int id = sc.nextInt();

        MensajesModelo modelo = new MensajesModelo();
        modelo.setMensaje(mensaje);
        modelo.setId_mensaje(id);

        MensajesDAO.updateMensaje(modelo);
    }
}

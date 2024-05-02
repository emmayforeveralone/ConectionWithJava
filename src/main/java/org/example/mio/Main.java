package org.example.mio;

import org.example.mio.Conect.DBConect;

import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("----------------");
            System.out.println(" Aplicacion de mensajes ");
            System.out.println(" 1. crear mensajes");
            System.out.println(" 2. listar mensajes");
            System.out.println(" 3. editar mensajes");
            System.out.println(" 4. eliminar mensajes");
            System.out.println(" 5. salir de la aplicacion");

            //leer la opcion del usuario
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    MensajesServices.crearMensaje();
                    break;

                case 2:
                    MensajesServices.listarMensaje();
                    break;
                case 3:
                    MensajesServices.editarMensaje();
                    break;
                case 4:
                    MensajesServices.eliminarMensaje();
                    break;
                case 5:

                    break;
                default:
                    break;
            }


        }while (opcion != 5);

       /*

       DBConect db = new DBConect();

        try {
            db.get_connection();
        } catch (Exception e) {
            System.out.println("Error en el MAIN: " + e);
        }

        */


    }
}
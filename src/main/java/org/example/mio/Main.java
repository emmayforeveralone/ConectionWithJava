package org.example.mio;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        DBConect db = new DBConect();

        try {
            db.get_connection();
        } catch (Exception e) {
            System.out.println("Error en el MAIN: " + e);
        }


    }
}
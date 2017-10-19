package fr.unice.iut.info.coo;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{


    public static void main( String[] args ) throws InterruptedException {
        UI gui = new UI();

        Object o = Save.read("BusManager.obj");
        if (o != null) {
            if (o instanceof BusManager) {
                HashMap<String, Bus> p = ((BusManager) o).getPool();
                BusManager.instance().setPool(p);
            }
        }

        gui.afficherMenu();
    }

}

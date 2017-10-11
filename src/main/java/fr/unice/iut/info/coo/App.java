package fr.unice.iut.info.coo;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    private static Scanner sc = new Scanner(System.in);
    private static String e;
    private static Bus b1 = new Bus("Circulation Nice");


    public static void main( String[] args ) throws InterruptedException {
        afficherMenu();
    }

    private static void afficherMenu() {
        System.out.println("Que voulez vous faire ? Entrez un chiffre pour valider votre choix");
        System.out.println("(1) Creer box");
        System.out.println("(2) Ecrire message");
        System.out.println("(3) Demande d'infos");
        e = sc.nextLine();
        switch(e) {
            case "1":
                System.out.println("Entrer le nom de la box :");
                e = sc.nextLine();
                b1.getBoxMap().put(e, new Box(e));
                System.out.println("Bus crée ! retour au menu");
                afficherMenu();
                break;

            case "2":
                System.out.println("Sélectionner box");
                int i = 1;
                HashMap<Integer, Box> table = new HashMap<>();
                for (Box b : b1.getAllBox()) {
                    System.out.println(i+" "+b.getName());
                    table.put(i, b);
                    i++;
                }
                e = sc.nextLine();
                System.out.println("Ecrivez votre msg");
                Message m = new Message(sc.nextLine());
                table.get(Integer.parseInt(e)).getMsgBox().add(m);
                System.out.println("Message bien ajouté! retour au menu");
                afficherMenu();
                break;

            case "3":
                System.out.println("Sélectionner box");
                int j = 1;
                HashMap<Integer, Box> table2 = new HashMap<>();
                for (Box b : b1.getAllBox()) {
                    System.out.println(j+" "+b.getName());
                    table2.put(j, b);
                    j++;
                }
                e = sc.nextLine();
                System.out.println(table2.get(Integer.parseInt(e)).getInfo());
                System.out.println("Retour au menu");
                afficherMenu();
                break;

            default:
                System.out.println("Entrée non reconnue. Veuillez recommencer.");
                break;
        }
    }
}

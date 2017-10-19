package fr.unice.iut.info.coo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UI {

    private static Scanner sc = new Scanner(System.in);
    private static String input = "";


    public static void afficherMenu() {

        save();

        System.out.println("Que voulez vous faire ? Entrez un chiffre pour valider votre choix");
        System.out.println("(1) Créer bus");
        System.out.println("(2) Sélectionner un bus existant");
        input = sc.nextLine();
        switch (input) {
            case "1":
                System.out.println("Entrez le nom du bus :");
                input = sc.nextLine();
                if (BusManager.instance().createBus(input)) {
                    System.out.println("Bus crée ! retour au menu");
                } else {
                    System.out.println("Erreur lors de la création du bus. Retour au menu");
                }
                afficherMenu();
                break;

            case "2":
                System.out.println("Quel bus ?");
                HashMap<String, Bus> pool = BusManager.instance().getPool();
                int j = 1;
                HashMap<Integer, Bus> getBusFromInput = new HashMap<>();
                for (Map.Entry<String, Bus> entry : pool.entrySet()) {
                    String n = entry.getKey();
                    Bus b = entry.getValue();
                    System.out.println(j + " " + n);
                    getBusFromInput.put(j, b);
                    j++;
                }
                input = sc.nextLine();
                if (getBusFromInput.containsKey(Integer.parseInt(input))) {
                    afficherMenuPourBus(BusManager.instance().getPool().get(getBusFromInput.get(Integer.parseInt(input)).getName()));
                }
                else {
                    System.out.println("Bus non trouvé ! retour au menu");
                    afficherMenu();
                }
        }

    }

    private static void afficherMenuPourBus(Bus b) {

        save();

        System.out.println("Bus sélectionné : "+b.getName());
        System.out.println("(1) Creer box");
        System.out.println("(2) Ecrire message");
        System.out.println("(3) Demande d'infos");
        System.out.println("(4) Retour");
        input = sc.nextLine();
        switch(input) {
            case "1":
                System.out.println("Entrer le nom de la box :");
                input = sc.nextLine();
                b.getBoxMap().put(input, new Box(input));
                System.out.println("Box crée ! retour au menu");
                afficherMenu();
                break;

            case "2":
                System.out.println("Sélectionner box");
                int i = 1;
                HashMap<Integer, Box> table = new HashMap<>();
                for (Box box : b.getAllBox()) {
                    System.out.println(i+" "+box.getName());
                    table.put(i, box);
                    i++;
                }
                input = sc.nextLine();

                if (table.containsKey(Integer.parseInt(input))) {
                    System.out.println("Ecrivez votre msg");
                    Message m = new Message(sc.nextLine());
                    table.get(Integer.parseInt(input)).getMsgBox().add(m);
                    System.out.println("Message bien ajouté! retour au menu");
                }
                else {
                    System.out.println("Box non trouvée ! retour au menu");
                }
                afficherMenu();
                break;

            case "3":
                System.out.println("Sélectionner box");
                int j = 1;
                HashMap<Integer, Box> table2 = new HashMap<>();
                for (Box box : b.getAllBox()) {
                    System.out.println(j+" "+box.getName());
                    table2.put(j, box);
                    j++;
                }
                input = sc.nextLine();
                if (table2.containsKey(Integer.parseInt(input))) {
                    System.out.println(table2.get(Integer.parseInt(input)).getInfo());
                } else {
                    System.out.println("Box non trouvée.");
                }
                System.out.println("Retour au menu");
                afficherMenu();
                break;

            case "4":
                afficherMenu();
                break;

            default:
                System.out.println("Entrée non reconnue. Veuillez recommencer.");
                break;
        }
    }

    private static void save() {
        Save.save(BusManager.instance(), "BusManager.obj");
    }

}

package fr.unice.iut.info.coo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Virgile on 22/09/2017.
 * TU VOLES TU PAIES
 */
public class Box implements Serializable {

    private String name;
    private ArrayList<Message> MsgBox;

    public Box(String n) {
        this.name = n;
        this.MsgBox = new ArrayList<Message>();
    }

    private boolean anyInfo() {
        if (this.MsgBox.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getInfo() {
        if (this.anyInfo()) {
            String s = "";
            for (int i = 0; i < this.MsgBox.size(); i++) {
                s += this.MsgBox.get(i).toString()+"\n\n";
            }
            return s;
        } else {
            return "No messages found !";
        }
    }

    public ArrayList<Message> getMsgBox() {
        return this.MsgBox;
    }


}

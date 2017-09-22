package fr.unice.iut.info.coo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Virgile on 22/09/2017.
 * TU VOLES TU PAIES
 */
public class Bus {

    private String name;
    private ArrayList<Message> MsgBus;

    public Bus(String n) {
        this.name = n;
        this.MsgBus = new ArrayList<Message>();
    }

    private boolean anyInfo() {
        if (this.MsgBus.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public String getInfo() {
        if (this.anyInfo()) {
            String s = "";
            for (int i = 0; i < this.MsgBus.size(); i++) {
                s += this.MsgBus.get(i).toString()+"\n\n";
            }
            return s;
        } else {
            return "No messages found !";
        }
    }

    public ArrayList<Message> getMsgBus() {
        return this.MsgBus;
    }


}

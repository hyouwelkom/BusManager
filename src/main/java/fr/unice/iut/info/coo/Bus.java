package fr.unice.iut.info.coo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Virgile on 22/09/2017.
 * TU VOLES TU PAIES
 */
public class Bus {

    final private String name;
    final private HashMap<String, Box> BoxMap;

    public Bus(String n)
    {
        name = n;
        BoxMap = new HashMap<String, Box>();
        BoxMap.put("default", new Box("default"));
    }

    public HashMap<String, Box> getBoxMap() {
        return this.BoxMap;
    }

    public Collection<Box> getAllBox() {
        return this.BoxMap.values();
    }


}

package fr.unice.iut.info.coo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Virgile on 22/09/2017.
 * TU VOLES TU PAIES
 */
public class BusManager implements Serializable {

    private static BusManager i;
    public static BusManager instance() {

        if (BusManager.i == null) { BusManager.i = new BusManager(); }
        return BusManager.i;
    }

    private HashMap<String, Bus> pool;
    private final String defaultBus;

    BusManager() {
        this.pool = new HashMap<>();
        this.defaultBus = "default";
        this.createBus(this.defaultBus);
    }


    public boolean createBus(String n) {
        if (this.pool.containsKey(n)) {
            return false;
        }
        this.pool.put(n, new Bus(n));
        return true;
    }

    public HashMap<String, Bus> getPool() {
        return this.pool;
    }

    public void setPool(HashMap<String, Bus> pool) {
        this.pool = pool;
    }
}

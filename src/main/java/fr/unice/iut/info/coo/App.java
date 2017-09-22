package fr.unice.iut.info.coo;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        Message m = new Message("Wallah y a vlà les bouchons");
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Message n = new Message("Ah bah non en fait");
        Bus b = new Bus("Nice-circu");
        b.getMsgBus().add(m);
        b.getMsgBus().add(n);
        System.out.println(b.getInfo());
    }
}

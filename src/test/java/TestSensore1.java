import org.junit.Test;
import sensori.*;

/**
 * Created by palla on 13/01/16.
 */
public class TestSensore1 {

    @Test
    public void initTestSensore1() {
        Sensori s = new Sensore1();
        s.callSensor();

        System.out.println("Sensore di riferimento: " + s.getName());
        System.out.println("Temperatura attuale: " + s.getTemp());
        System.out.println("Temperatura Massima: " + s.getTemp_min());
        System.out.println("Temperatura Minima: " +s.getTemp_max());
        System.out.println("Data di rilevazione: " +s.getTime());
    }

}

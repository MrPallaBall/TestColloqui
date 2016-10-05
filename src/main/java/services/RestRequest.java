package services;

import sensori.Sensori;

import java.util.List;

/**
 * Created by palla on 13/01/16.
 */
public interface RestRequest {
    public List<Sensori> getTemperatureFromSensor();
}

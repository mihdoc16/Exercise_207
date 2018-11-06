/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;

/**
 *
 * @author Dominik
 */
public class Wetterstation implements Comparable<Wetterstation>, Serializable{
    private String place;
    private int seaLevel;
    private double temperature;
    private int humidity;
    private boolean col;

//    public boolean isCol() {
//        return col;
//    }
//
//    public void setCol(boolean col) {
//        this.col = col;
//    }

    public Wetterstation(String place, int seaLevel, double temperature, int humidity) throws Exception {
        this.place = place;
        this.seaLevel = seaLevel;
        setTemperature(temperature);
        setHumidity(humidity);
    }

    public String getPlace() {
        return place;
    }

    public int getSeaLevel() {
        return seaLevel;
    }

    public double getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setTemperature(double temperature) throws Exception{
        if(temperature<-35 || temperature>45){
            throw new Exception("Temperatur ist nicht im logischen Maße");
        }
        else{
        this.temperature = temperature;
        }
    }
    
    public void setHumidity(int humidity) throws Exception{
        if(humidity<0 || humidity>100){
            throw new Exception("Humidity ist nicht im logischen Maße");
        }
        else{
            this.humidity = humidity;
        }
    }
    
    public int getColValue(int col){
        return col;
    }

    @Override
    public int compareTo(Wetterstation t) {
        return this.place.compareTo(t.place);
    }
}

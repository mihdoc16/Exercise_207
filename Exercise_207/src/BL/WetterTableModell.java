/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Dominik
 */
public class WetterTableModell extends AbstractTableModel{
    private static String[] colNames = {"Place", "Sea Level", "Temperature", "rel. Humidity"};
    private ArrayList<Wetterstation> list = new ArrayList<>();

    public void add(Wetterstation w){
        list.add(w);
        fireTableDataChanged();
    }
    
    public void delete(int i){
        list.remove(i);
        fireTableDataChanged();
    }
    
    public void changeTemperature(double temp, int i) throws Exception{
        Wetterstation w = list.get(i);
        w.setTemperature(temp);
        fireTableDataChanged();
    }
    
    public void changeHumidity(int temp, int i) throws Exception{
        Wetterstation w = list.get(i);
        w.setHumidity(temp);
        fireTableDataChanged();
    }
    
    public void save(File f) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        
        for (Wetterstation a : list) {
            oos.writeObject(a);
        }
        
        oos.flush();
        oos.close();
    }
    
    public void load(File f) throws Exception{    
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        try {
            Object o;
            while ((o = ois.readObject()) != null) {
                list.add((Wetterstation) o);
            }
        } catch (EOFException eofExc) {
            //this catch is only to determine end of file
        }
        ois.close();
    }
    
    public void sort(){
        Collections.sort(list);
        fireTableDataChanged();
    }
    
//    public void hideColumn(int numCols){
//        colNames = new String[numCols];
//        if(numCols==3){
//            colNames[0] = "Place";
//            colNames[1] = "Temperatue";
//            colNames[2] = "rel. Humidity";
//        }
//        else{
//            colNames[0] = "Place";
//            colNames[1] = "Sea Level";
//            colNames[2] = "Temperature";
//            colNames[3] = "rel. Humidity";
//        }
//        fireTableStructureChanged();
//    }
    
    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return list.get(i);
    }
    
}

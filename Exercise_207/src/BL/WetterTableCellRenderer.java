/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Dominik
 */
public class WetterTableCellRenderer implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int column) {
        JLabel label = new JLabel();
        Wetterstation w = (Wetterstation) o;
        label.setOpaque(true);
        
        switch(column){
            case 0: label.setText(w.getPlace());break;
            case 1: label.setText(String.valueOf(w.getSeaLevel())+"m");break;
            case 2: label.setText(String.valueOf(w.getTemperature())+"°");break;
            case 3: label.setText(String.valueOf(w.getHumidity())+"%");break;
        }
        return label;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class DeModel extends DefaultTableModel{
    
    public DeModel(){
        super();
        this.addColumn("Mã Đế");
        this.addColumn("Độ Cao");
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Class getColumnClass(int column) {
        switch (column) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            default:
                return String.class;
        }
    }
    
    
}

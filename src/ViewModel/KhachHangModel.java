/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

import javax.swing.table.DefaultTableModel;



/**
 *
 * @author UyTin
 */
public class KhachHangModel extends DefaultTableModel{

    public KhachHangModel() {
        super();
        
        this.addColumn("Mã Khách hàng");
        this.addColumn("Tên Khách Hàng");
        this.addColumn("Ngày Sinh");
        this.addColumn("Giới Tinh");
        this.addColumn("Số Điện Thoại");
        this.addColumn("Email");
        this.addColumn("Địa Chỉ");
        this.addColumn("Trạng Thái");
      
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;
import java.sql.*;



public class JDBCHelper {
    public static ResultSet excuteQuery(String sql,Object ...args){
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            con=DBConnection.getConnection();
            ps=con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
                
            }
            rs=ps.executeQuery();
        } catch (Exception e) {
        }
        return rs;
    }
    public static Integer executeUpdate(String sql,Object ...args){
        Connection con=null;
        PreparedStatement ps=null;
        int row=0;
        try {
            con=DBConnection.getConnection();
            ps=con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
                
            }
            row=ps.executeUpdate();
        } catch (Exception e) {
        }
        return row;
    }
}

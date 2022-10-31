/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

import java.sql.*;
import java.util.ArrayList;


public class ListModel
{
    public ArrayList<modelJDBC> list = new ArrayList<>();
    
    public ListModel()
    {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:C://sqlite//music.db");
            
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from mp3");
            
            while(rs.next())
            {
                String c1 = rs.getString("tenBaiHat");
                String c2 = rs.getString("tenCaSi");
                int c3 = rs.getInt("time");
                String c4 = rs.getString("src");
                modelJDBC temp = new modelJDBC(c1, c2, c3, c4);
                list.add(temp);
            }
            
            con.close();
            stm.close();
            
        } catch (Exception ex) {}
    }
}

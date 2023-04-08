/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;



import connect.ConnectDB;
import entity.CongDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NDT
 */
public class DAO_CongDung {

    private Connection con;

    public DAO_CongDung() {
        try {
            con = ConnectDB.getInstances().getConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_CongDung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<CongDung> getListCongDung() {
        ArrayList<CongDung> dsCongDung = new ArrayList<>();
        try {
            String sql = "SELECT * FROM CongDung";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maCongDung = rs.getString("maCongDung");
                String tenCongDung = rs.getString("congDung");
                String nhomCongDung = rs.getString("nhomCongDung");

                CongDung congDung = new CongDung(maCongDung, nhomCongDung, tenCongDung);
                dsCongDung.add(congDung);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsCongDung;
    }

    public CongDung getCongDungByMaCongDung(String maCongDung) {
        CongDung c = new CongDung();
        String sql = "select * from CongDung where maCongDung='" + maCongDung + "'";
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String ma = rs.getString(1);

                String congdung = rs.getString(2);

                String nhomcongdung = rs.getString(3);
                c = new CongDung(ma, nhomcongdung, congdung);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return c;
    }
}

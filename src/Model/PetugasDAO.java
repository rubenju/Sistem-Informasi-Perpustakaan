/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Wind10
 */
public class PetugasDAO {

    Connection koneksi;

    public PetugasDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(
                    "jdbc:mysql://localhost/perpustakaan",
                    "root", "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String SelectAll1() {
        String nama = null;

        return nama;
    }

    public List<Petugas> SelectAll() {
        List<Petugas> listPetugas = new ArrayList<>();
        try {
            String sql_select = "SELECT * FROM petugas";
            PreparedStatement statement = koneksi.prepareStatement(sql_select);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                listPetugas.add(new Petugas(result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listPetugas;
    }

    public List<Petugas> SelectByIdPetugasNama(String id_petugas, String nama) {
        List<Petugas> listPetugas = new ArrayList<>();
        try {
            String sql_select = "SELECT * FROM petugas WHERE id_petugas = ? OR nama LIKE ?";
            PreparedStatement statement = koneksi.prepareStatement(sql_select);
            statement.setString(1, id_petugas);
            statement.setString(2, "%" + nama + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                listPetugas.add(new Petugas(result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4)));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }

        return listPetugas;
    }
}

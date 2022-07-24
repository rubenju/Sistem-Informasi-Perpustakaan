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
public class AnggotaDAO {

    Connection koneksi;

    public AnggotaDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(
                    "jdbc:mysql://localhost/perpustakaan",
                    "root", "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Anggota> SelectAll() {
        List<Anggota> listAnggota = new ArrayList<>();
        try {
            String sql_select = "SELECT * FROM anggota";
            PreparedStatement statement = koneksi.prepareStatement(sql_select);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                listAnggota.add(new Anggota(result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listAnggota;
    }

    public List<Anggota> SelectByNimNama(String nim, String nama) {
        List<Anggota> listAnggota = new ArrayList<>();
        try {
            String sql_select = "SELECT * FROM anggota WHERE nim = ? OR nama LIKE ?";
            PreparedStatement statement = koneksi.prepareStatement(sql_select);
            statement.setString(1, nim);
            statement.setString(2, "%" + nama + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                listAnggota.add(new Anggota(result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4)));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }

        return listAnggota;
    }

    public void InsertAnggota(Anggota anggota) {
        try {
            String sql_insert = "INSERT INTO `anggota`"
                    + "(`nim`, `nama`, `jurusan`, `tgl_daftar`) "
                    + "VALUES (?,?,?,?)";
            PreparedStatement statement = koneksi.prepareStatement(sql_insert);
            statement.setString(1, anggota.getNim());
            statement.setString(2, anggota.getNama());
            statement.setString(3, anggota.getJurusan());
            statement.setString(4, anggota.getTgl_daftar());
            statement.execute();
            JOptionPane.showMessageDialog(null, "Data Baru Berhasil Disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }

    public void UpdateAnggota(Anggota anggota) {
        try {
            String sql_update = "UPDATE `anggota` SET `nim`=?, `nama`=?, "
                    + "`jurusan`=?, `tgl_daftar`=? WHERE nim =?";
            PreparedStatement statement = koneksi.prepareStatement(sql_update);
            statement.setString(1, anggota.getNim());
            statement.setString(2, anggota.getNama());
            statement.setString(3, anggota.getJurusan());
            statement.setString(4, anggota.getTgl_daftar());
            statement.setString(5, anggota.getNim2());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diperbarui");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }

    public void DeleteAnggota(Anggota anggota) {
        try {
            String sql_delete = "DELETE FROM `anggota`"
                    + "WHERE nim = '" + anggota.getNim() + "'";
            PreparedStatement statement = koneksi.prepareStatement(sql_delete);
            //statement.setString(1, anggota.getNim());
            statement.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }
}

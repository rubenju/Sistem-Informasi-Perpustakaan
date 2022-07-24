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
public class BukuDAO {

    Connection koneksi;

    public BukuDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(
                    "jdbc:mysql://localhost/perpustakaan",
                    "root", "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Buku> SelectAll() {
        List<Buku> listBuku = new ArrayList<>();
        try {
            String sql_select = "SELECT * FROM buku";
            PreparedStatement statement = koneksi.prepareStatement(sql_select);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                listBuku.add(new Buku(result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getInt(5),
                        result.getString(6),
                        result.getInt(7)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listBuku;
    }

    public List<Buku> SelectByIdBukuJudul(String id_buku, String judul) {
        List<Buku> listBuku = new ArrayList<>();
        try {
            String sql_select = "SELECT * FROM buku WHERE id_buku = ? OR judul LIKE ?";
            PreparedStatement statement = koneksi.prepareStatement(sql_select);
            statement.setString(1, id_buku);
            statement.setString(2, "%" + judul + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                listBuku.add(new Buku(result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getInt(5),
                        result.getString(6),
                        result.getInt(7)));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }

        return listBuku;
    }

    public void InsertBuku(Buku buku) {
        try {
            String sql_insert = "INSERT INTO `buku`"
                    + "(`id_buku`, `judul`, `penerbit`, `penulis`, tahun, tgl_masuk, stok) "
                    + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement statement = koneksi.prepareStatement(sql_insert);
            statement.setInt(1, buku.getId_buku());
            statement.setString(2, buku.getJudul());
            statement.setString(3, buku.getPenerbit());
            statement.setString(4, buku.getPenulis());
            statement.setInt(5, buku.getTahun());
            statement.setString(6, buku.getTgl_masuk());
            statement.setInt(7, buku.getStok());
            statement.execute();
            JOptionPane.showMessageDialog(null, "Data Baru Berhasil Disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }

    public void UpdateBuku(Buku buku) {
        try {
            String sql_update = "UPDATE `buku` SET"
                    + "`id_buku`=?, `judul`=?, `penerbit`=?, `penulis`=?, tahun=?, tgl_masuk=?, stok=? "
                    + "WHERE id_buku=?";
            PreparedStatement statement = koneksi.prepareStatement(sql_update);
            statement.setInt(1, buku.getId_buku());
            statement.setString(2, buku.getJudul());
            statement.setString(3, buku.getPenerbit());
            statement.setString(4, buku.getPenulis());
            statement.setInt(5, buku.getTahun());
            statement.setString(6, buku.getTgl_masuk());
            statement.setInt(7, buku.getStok());
            statement.setInt(8, buku.getId_buku2());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diperbarui");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }

    public void DeleteBuku(Buku buku) {
        try {
            String sql_delete = "DELETE FROM `buku`"
                    + "WHERE id_buku = '" + buku.getId_buku() + "'";
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

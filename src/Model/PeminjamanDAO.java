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
public class PeminjamanDAO {

    Connection koneksi;

    public PeminjamanDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(
                    "jdbc:mysql://localhost/perpustakaan",
                    "root", "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Peminjaman> SelectAll() {
        List<Peminjaman> listPeminjaman = new ArrayList<>();
        try {
            String sql_select = "SELECT * FROM peminjaman";
            PreparedStatement statement = koneksi.prepareStatement(sql_select);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                listPeminjaman.add(new Peminjaman(result.getInt(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listPeminjaman;
    }

    public List<Peminjaman> SelectByNimNama(String nim, String nama) {
        List<Peminjaman> listPeminjaman = new ArrayList<>();
        try {
            String sql_select = "SELECT * FROM peminjaman WHERE nim = ? OR peminjam LIKE ?";
            PreparedStatement statement = koneksi.prepareStatement(sql_select);
            statement.setString(1, nim);
            statement.setString(2, "%" + nama + "%");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                listPeminjaman.add(new Peminjaman(result.getInt(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getString(7)));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }

        return listPeminjaman;
    }

    public void InsertPeminjaman(Peminjaman peminjaman) {
        try {
            String sql_insert = "INSERT INTO `peminjaman`"
                    + "(`id_buku`, `judul`, `nim`, `peminjam`, tgl_pinjam, tgl_kembali) "
                    + "VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = koneksi.prepareStatement(sql_insert);
            statement.setInt(1, peminjaman.getId_buku());
            statement.setString(2, peminjaman.getJudul());
            statement.setString(3, peminjaman.getNim());
            statement.setString(4, peminjaman.getPeminjam());
            statement.setString(5, peminjaman.getTgl_pinjam());
            statement.setString(6, peminjaman.getTgl_kembali());
            statement.execute();
            JOptionPane.showMessageDialog(null, "Data Baru Berhasil Disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }

    public void UpdatePeminjaman(Peminjaman peminjaman) {
        try {
            String sql_update = "UPDATE peminjaman SET id_buku=?, judul=?, nim=?, "
                    + "peminjam=?, tgl_pinjam=?, tgl_kembali=? WHERE id_buku=? AND nim=?";
            PreparedStatement statement = koneksi.prepareStatement(sql_update);
            statement.setInt(1, peminjaman.getId_buku());
            statement.setString(2, peminjaman.getJudul());
            statement.setString(3, peminjaman.getNim());
            statement.setString(4, peminjaman.getPeminjam());
            statement.setString(5, peminjaman.getTgl_pinjam());
            statement.setString(6, peminjaman.getTgl_kembali());
            statement.setInt(7, peminjaman.getId_buku2());
            statement.setString(8, peminjaman.getNim2());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diperbarui");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }

    public void DeletePeminjaman(Peminjaman peminjaman) {
        try {
            String sql_delete = "DELETE FROM `peminjaman`"
                    + "WHERE id_buku = '" + peminjaman.getId_buku() + "' AND nim = '"
                    + peminjaman.getNim() + "'";
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

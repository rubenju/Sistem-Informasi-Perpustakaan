/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Wind10
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AkunDAO {

    Connection koneksi;

    public AkunDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(
                    "jdbc:mysql://localhost/perpustakaan",
                    "root", "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Akun> SelectAll() {
        List<Akun> listAkun = new ArrayList<>();
        try {
            String sql_select = "SELECT * FROM akun";
            PreparedStatement statement = koneksi.prepareStatement(sql_select);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                listAkun.add(new Akun(result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listAkun;
    }

    public boolean SelectAkun(Akun akun) {
        String uname = null, pass = null, userpass = null;
        boolean valid = false;
        int type = 0;
        try {
            String sql_select = "SELECT * FROM akun";
            PreparedStatement statement = koneksi.prepareStatement(sql_select);
            //statement.setString(1, akun.getUsername());
            //statement.setString(2, akun.getPassword());
            ResultSet hasil = statement.executeQuery();
            while (hasil.next()) {
                uname = hasil.getString("username");
                pass = hasil.getString("password");
                if (akun.getUsername().equals(uname)) {
                    if (akun.getPassword().equals(pass)) {
                        valid = true;
                        break;
                    } else {
                        type = 1;
                    }
                }
            }
            if (!valid && type == 0) {
                JOptionPane.showMessageDialog(null, "Maaf, username Anda tidak terdaftar");
            } else if (!valid && type == 1) {
                JOptionPane.showMessageDialog(null, "Maaf, password Anda salah");
            } else {
                valid = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return valid;
        //userpass = uname+"/"+pass;                
    }

    public void InsertAkun(Akun akun) {
        try {
            String sql_insert = "INSERT INTO `akun`"
                    + "(`username`, `password`, `nama`, `email`) "
                    + "VALUES (?,?,?,?)";
            PreparedStatement statement = koneksi.prepareStatement(sql_insert);
            statement.setString(1, akun.getUsername());
            statement.setString(2, akun.getPassword());
            statement.setString(3, akun.getNama());
            statement.setString(4, akun.getEmail());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
    }
}

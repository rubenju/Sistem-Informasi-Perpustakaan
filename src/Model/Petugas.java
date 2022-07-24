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
public class Petugas {

    private int id_petugas;
    private String nama;
    private String alamat;
    private String email;

    public Petugas(int id_petugas, String nama, String alamat, String email) {
        this.id_petugas = id_petugas;
        this.nama = nama;
        this.alamat = alamat;
        this.email = email;
    }

    public Petugas(int id_petugas) {
        this.id_petugas = id_petugas;
    }

    public int getId_petugas() {
        return id_petugas;
    }

    public void setId_petugas(int id_petugas) {
        this.id_petugas = id_petugas;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

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
public class Anggota {

    private String nim;
    private String nama;
    private String jurusan;
    private String tgl_daftar;
    private String nim2;

    public Anggota(String nim, String nama, String jurusan, String tgl_daftar, String nim2) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.tgl_daftar = tgl_daftar;
        this.nim2 = nim2;
    }

    public Anggota(String nim, String nama, String jurusan, String tgl_daftar) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.tgl_daftar = tgl_daftar;
    }

    public Anggota(String nim) {
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getTgl_daftar() {
        return tgl_daftar;
    }

    public void setTgl_daftar(String tgl_daftar) {
        this.tgl_daftar = tgl_daftar;
    }

    public String getNim2() {
        return nim2;
    }

    public void setNim2(String nim2) {
        this.nim2 = nim2;
    }

}

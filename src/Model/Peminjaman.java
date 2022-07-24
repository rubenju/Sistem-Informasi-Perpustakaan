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
public class Peminjaman {

    //private int id;
    private int id_buku;
    private String judul;
    private String nim;
    private String peminjam;
    private String tgl_pinjam;
    private String tgl_kembali;
    private int id_buku2;
    private String nim2;

    public Peminjaman(int id_buku, String judul, String nim, String peminjam, String tgl_pinjam, String tgl_kembali, int id_buku2, String nim2) {
        this.id_buku = id_buku;
        this.judul = judul;
        this.nim = nim;
        this.peminjam = peminjam;
        this.tgl_pinjam = tgl_pinjam;
        this.tgl_kembali = tgl_kembali;
        this.id_buku2 = id_buku2;
        this.nim2 = nim2;
    }

    public Peminjaman(int id_buku, String judul, String nim, String peminjam, String tgl_pinjam, String tgl_kembali) {
        //this.id = id;
        this.id_buku = id_buku;
        this.judul = judul;
        this.nim = nim;
        this.peminjam = peminjam;
        this.tgl_pinjam = tgl_pinjam;
        this.tgl_kembali = tgl_kembali;
    }

    public Peminjaman(int id_buku, String nim) {
        this.id_buku = id_buku;
        this.nim = nim;
    }

    /*
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     */
    public int getId_buku() {
        return id_buku;
    }

    public void setId_buku(int id_buku) {
        this.id_buku = id_buku;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getPeminjam() {
        return peminjam;
    }

    public void setPeminjam(String peminjam) {
        this.peminjam = peminjam;
    }

    public String getTgl_pinjam() {
        return tgl_pinjam;
    }

    public void setTgl_pinjam(String tgl_pinjam) {
        this.tgl_pinjam = tgl_pinjam;
    }

    public String getTgl_kembali() {
        return tgl_kembali;
    }

    public void setTgl_kembali(String tgl_kembali) {
        this.tgl_kembali = tgl_kembali;
    }

    public int getId_buku2() {
        return id_buku2;
    }

    public void setId_buku2(int id_buku2) {
        this.id_buku2 = id_buku2;
    }

    public String getNim2() {
        return nim2;
    }

    public void setNim2(String nim2) {
        this.nim2 = nim2;
    }

}

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
public class Buku {

    private int id_buku;
    private String judul;
    private String penerbit;
    private String penulis;
    private int tahun;
    private String tgl_masuk;
    private int stok;
    private int id_buku2;

    public Buku(int id_buku, String judul, String penerbit, String penulis, int tahun, String tgl_masuk, int stok, int id_buku2) {
        this.id_buku = id_buku;
        this.judul = judul;
        this.penerbit = penerbit;
        this.penulis = penulis;
        this.tahun = tahun;
        this.tgl_masuk = tgl_masuk;
        this.stok = stok;
        this.id_buku2 = id_buku2;
    }

    public Buku(int id_buku, String judul, String penerbit, String penulis, int tahun, String tgl_masuk, int stok) {
        this.id_buku = id_buku;
        this.judul = judul;
        this.penerbit = penerbit;
        this.penulis = penulis;
        this.tahun = tahun;
        this.tgl_masuk = tgl_masuk;
        this.stok = stok;
    }

    public Buku(int id_buku) {
        this.id_buku = id_buku;
    }

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

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public String getTgl_masuk() {
        return tgl_masuk;
    }

    public void setTgl_masuk(String tgl_masuk) {
        this.tgl_masuk = tgl_masuk;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getId_buku2() {
        return id_buku2;
    }

    public void setId_buku2(int id_buku2) {
        this.id_buku2 = id_buku2;
    }

}

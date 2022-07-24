/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Wind10
 */
import Model.Anggota;
import Model.AnggotaDAO;
import Model.Buku;
import Model.BukuDAO;
import Model.Peminjaman;
import Model.PeminjamanDAO;
import Model.Petugas;
import Model.PetugasDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class MainFrameController {

    AnggotaDAO anggotaDAO;
    BukuDAO bukuDAO;
    PeminjamanDAO peminjamanDAO;
    PetugasDAO petugasDAO;

    public MainFrameController() {
        anggotaDAO = new AnggotaDAO();
        bukuDAO = new BukuDAO();
        peminjamanDAO = new PeminjamanDAO();
        petugasDAO = new PetugasDAO();
    }

    DefaultTableModel setTableModel1(List<Anggota> listAnggota) {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new Object[]{
            "NIM", "Nama", "Jurusan", "Angkatan"});

        for (Anggota anggota : listAnggota) {
            tableModel.addRow(new Object[]{
                anggota.getNim(),
                anggota.getNama(),
                anggota.getJurusan(),
                anggota.getTgl_daftar()
            });
        }
        return tableModel;
    }

    DefaultTableModel setTableModel2(List<Buku> listBuku) {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new Object[]{
            "ID Buku", "Judul", "Penerbit", "Penulis",
            "Tahun", "Tanggal Masuk", "Stok"});

        for (Buku buku : listBuku) {
            tableModel.addRow(new Object[]{
                buku.getId_buku(),
                buku.getJudul(),
                buku.getPenerbit(),
                buku.getPenulis(),
                buku.getTahun(),
                buku.getTgl_masuk(),
                buku.getStok()
            });
        }
        return tableModel;
    }

    DefaultTableModel setTableModel3(List<Peminjaman> listPeminjaman) {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new Object[]{
            "ID Buku", "Judul", "NIM", "Nama",
            "Tanggal Pinjam", "Tanggal Kembali"});

        for (Peminjaman peminjaman : listPeminjaman) {
            tableModel.addRow(new Object[]{
                peminjaman.getId_buku(),
                peminjaman.getJudul(),
                peminjaman.getNim(),
                peminjaman.getPeminjam(),
                peminjaman.getTgl_pinjam(),
                peminjaman.getTgl_kembali()
            });
        }
        return tableModel;
    }

    DefaultTableModel setTableModel4(List<Petugas> listPetugas) {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(new Object[]{
            "ID Petugas", "Nama", "Alamat", "Email"});

        for (Petugas petugas : listPetugas) {
            tableModel.addRow(new Object[]{
                petugas.getId_petugas(),
                petugas.getNama(),
                petugas.getAlamat(),
                petugas.getEmail()
            });
        }
        return tableModel;
    }

    public DefaultTableModel SelectAll1() {
        List<Anggota> listAnggota = anggotaDAO.SelectAll();
        return setTableModel1(listAnggota);
    }

    public DefaultTableModel SelectByNimNama(String nim, String nama) {
        List<Anggota> listAnggota = anggotaDAO.SelectByNimNama(nim, nama);
        return setTableModel1(listAnggota);
    }

    public void InsertAnggota(String nim, String nama, String jurusan, String tgl_daftar) {
        anggotaDAO.InsertAnggota(new Anggota(nim, nama, jurusan, tgl_daftar));
    }

    public void UpdateAnggota(String nim, String nama, String jurusan, String tgl_daftar, String nim2) {
        anggotaDAO.UpdateAnggota(new Anggota(nim, nama, jurusan, tgl_daftar, nim2));
    }

    public void DeleteAnggota(String nim) {
        anggotaDAO.DeleteAnggota(new Anggota(nim));
    }

    public DefaultTableModel SelectAll2() {
        List<Buku> listBuku = bukuDAO.SelectAll();
        return setTableModel2(listBuku);
    }

    public DefaultTableModel SelectByIdBukuJudul(String id_buku, String judul) {
        List<Buku> listBuku = bukuDAO.SelectByIdBukuJudul(id_buku, judul);
        return setTableModel2(listBuku);
    }

    public void InsertBuku(int id_buku, String judul, String penerbit, String penulis, int tahun, String tgl_masuk, int stok) {
        bukuDAO.InsertBuku(new Buku(id_buku, judul, penerbit, penulis, tahun, tgl_masuk, stok));
    }

    public void UpdateBuku(int id_buku, String judul, String penerbit, String penulis, int tahun, String tgl_masuk, int stok, int id_buku2) {
        bukuDAO.UpdateBuku(new Buku(id_buku, judul, penerbit, penulis, tahun, tgl_masuk, stok, id_buku2));
    }

    public void DeleteBuku(int id_buku) {
        bukuDAO.DeleteBuku(new Buku(id_buku));
    }

    public DefaultTableModel SelectAll3() {
        List<Peminjaman> listPeminjaman = peminjamanDAO.SelectAll();
        return setTableModel3(listPeminjaman);
    }

    public DefaultTableModel SelectByNimNama2(String nim, String nama) {
        List<Peminjaman> listPeminjaman = peminjamanDAO.SelectByNimNama(nim, nama);
        return setTableModel3(listPeminjaman);
    }

    public void InsertPeminjaman(int id_buku, String judul, String nim, String peminjam, String tgl_pinjam, String tgl_kembali) {
        peminjamanDAO.InsertPeminjaman(new Peminjaman(id_buku, judul, nim, peminjam, tgl_pinjam, tgl_kembali));
    }

    public void UpdatePeminjaman(int id_buku, String judul, String nim, String peminjam, String tgl_pinjam, String tgl_kembali, int id_buku2, String nim2) {
        peminjamanDAO.UpdatePeminjaman(new Peminjaman(id_buku, judul, nim, peminjam, tgl_pinjam, tgl_kembali, id_buku2, nim2));
    }

    public void DeletePeminjaman(int id_buku, String nim) {
        peminjamanDAO.DeletePeminjaman(new Peminjaman(id_buku, nim));
    }

    public DefaultTableModel SelectAll4() {
        List<Petugas> listPetugas = petugasDAO.SelectAll();
        return setTableModel4(listPetugas);
    }

    public DefaultTableModel SelectByIdPetugasNama(String id_petugas, String nama) {
        List<Petugas> listPetugas = petugasDAO.SelectByIdPetugasNama(id_petugas, nama);
        return setTableModel4(listPetugas);
    }

}

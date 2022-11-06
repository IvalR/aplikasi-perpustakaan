package entity;

public class Buku {

    private Integer idBuku;
    private String namaBuku;
    private String kategori;
    private String pengarang;
    private String penerbit;
    private Integer noRak;
    private Integer stok;

    public Buku() {
    }

    public Buku(
            String namaBuku, String kategori, String pengarang,
            String penerbit, Integer noRak, Integer stok
    ) {
        this.namaBuku = namaBuku;
        this.kategori = kategori;
        this.pengarang = pengarang;
        this.penerbit = penerbit;
        this.noRak = noRak;
        this.stok = stok;
    }

    public void setIdBuku(Integer idBuku) {
        this.idBuku = idBuku;
    }

    public void setNamaBuku(String namaBuku) {
        this.namaBuku = namaBuku;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public void setNoRak(Integer noRak) {
        this.noRak = noRak;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public Integer getIdBuku() {
        return idBuku;
    }

    public String getNamaBuku() {
        return namaBuku;
    }

    public String getKategori() {
        return kategori;
    }

    public String getPengarang() {
        return pengarang;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public Integer getNoRak() {
        return noRak;
    }

    public Integer getStok() {
        return stok;
    }
}

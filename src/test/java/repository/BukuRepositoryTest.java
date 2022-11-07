package repository;

import com.zaxxer.hikari.HikariDataSource;
import entity.Buku;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.DatabaseUtil;

import java.util.ArrayList;
import java.util.List;

public class BukuRepositoryTest {

    private HikariDataSource dataSource;
    private BukuRepository bukuRepository;

    @BeforeEach
    void setUp() {
        dataSource = DatabaseUtil.getHikariDataSource();
        bukuRepository = new BukuRepositoryImpl(dataSource);
    }

    @Test
    void testAdd() {

        Buku buku = new Buku();
        buku.setNamaBuku("Belajar Phyton Lengkap");
        buku.setKategori("Ilmu Teknologi");
        buku.setPengarang("Ival");
        buku.setPenerbit("Bukan Gramedia");
        buku.setNoRak(10);
        buku.setStok(18);

        bukuRepository.add(buku);
    }

    @Test
    void testGetAll() {

        List<Buku> bukuList = bukuRepository.getAll();

        for (var value : bukuList){
            System.out.println(value.getIdBuku() + " | " + value.getNamaBuku()
            + " | " + value.getKategori() + " | " + value.getPengarang() + " | "
            + value.getPenerbit() + " | " +value.getNoRak() + " | " + value.getStok());
        }
    }

    @Test
    void testDelete() {

        bukuRepository.delete(2);
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}

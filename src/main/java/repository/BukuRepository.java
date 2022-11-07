package repository;

import entity.Buku;

import java.util.List;

public interface BukuRepository {

    List<Buku> getAll();
    void add(Buku buku);
    void delete(Integer number);
    void edit(Integer number);
}

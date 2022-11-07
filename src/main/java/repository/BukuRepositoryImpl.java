package repository;

import com.mysql.cj.protocol.a.SqlDateValueEncoder;
import entity.Buku;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BukuRepositoryImpl implements BukuRepository{

    private DataSource dataSource;

    public BukuRepositoryImpl(DataSource dataSource){
        this.dataSource = dataSource;
    }


    @Override
    public List<Buku> getAll() {
        String sql = "SELECT * FROM tabel_buku";

        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
          ){

            List<Buku> listBuku = new ArrayList<>();
            while (resultSet.next()){
                Buku buku = new Buku();
                buku.setIdBuku(resultSet.getInt("id_buku"));
                buku.setNamaBuku(resultSet.getString("nama_buku"));
                buku.setKategori(resultSet.getString("kategori"));
                buku.setPengarang(resultSet.getString("pengarang"));
                buku.setPenerbit(resultSet.getString("penerbit"));
                buku.setNoRak(resultSet.getInt("no_rak"));
                buku.setStok(resultSet.getInt("stok"));

                listBuku.add(buku);
            }

            return listBuku;
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void add(Buku buku) {

        String sql = """
                INSERT INTO tabel_buku(nama_buku,kategori,pengarang,penerbit,no_rak,stok)
                VALUES (?,?,?,?,?,?)
                """;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, buku.getNamaBuku());
            statement.setString(2, buku.getKategori());
            statement.setString(3, buku.getPengarang());
            statement.setString(4, buku.getPenerbit());
            statement.setInt(5,buku.getNoRak());
            statement.setInt(6,buku.getStok());

            statement.executeUpdate();

        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void delete(Integer number) {
        String sql = "DELETE FROM tabel_buku WHERE id_buku = ?";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,number);
            statement.executeUpdate();

        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }



    }

    @Override
    public void edit(Integer number) {

    }
}

package Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.dao;

import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.entities.Seller;

import java.util.List;

public interface SellerDao {
    void insert(Seller sl);
    void update(Seller sl);
    void deleteById(Integer Id);
    void findById(Integer Id);
    List<Seller> findAll();
}

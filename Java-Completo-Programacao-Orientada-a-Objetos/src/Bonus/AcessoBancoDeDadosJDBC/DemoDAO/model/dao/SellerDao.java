package Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.dao;

import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.entities.Seller;

import java.util.List;

public interface SellerDao {
    void insert(Seller dp);
    void update(Seller dp);
    void deleteById(Integer Id);
    void findById(Integer Id);
    List<Seller> findAll();
}

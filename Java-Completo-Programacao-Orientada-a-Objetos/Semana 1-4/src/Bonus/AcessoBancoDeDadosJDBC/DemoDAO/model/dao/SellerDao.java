package Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.dao;

import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.entities.Department;
import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.entities.Seller;

import java.util.List;

public interface SellerDao {
    void insert(Seller sel);
    void update(Seller sel);
    void deleteById(Integer Id);
    Seller findById(Integer Id);
    List<Seller> findAll();
    List<Seller> findByDepartment(Department department);
}

package model.dao;

import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public interface SellerDao {
    void insert(Seller sel);
    void update(Seller sel);
    void deleteById(Integer Id);
    Seller findById(Integer Id);
    List<Seller> findAll();
    List<Seller> findByDepartment(Department department);
}

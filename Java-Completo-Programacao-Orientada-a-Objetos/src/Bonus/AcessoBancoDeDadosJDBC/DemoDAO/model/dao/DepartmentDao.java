package Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.dao;

import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.entities.Department;

import java.util.List;

public interface DepartmentDao {

    void insert(Department dp);
    void update(Department dp);
    void deleteById(Integer Id);
    void findById(Integer Id);
    List<Department> findAll();
}

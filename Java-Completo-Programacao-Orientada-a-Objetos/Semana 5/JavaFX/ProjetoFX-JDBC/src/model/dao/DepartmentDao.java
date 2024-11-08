package model.dao;

import model.entities.Department;

import java.util.List;

public interface DepartmentDao {

    void insert(Department dp);
    void update(Department dp);
    void deleteById(Integer Id);
    Department findById(Integer Id);
    List<Department> findAll();
}

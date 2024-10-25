package Bonus.AcessoBancoDeDadosJDBC.DemoDAO.application;

import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.dao.DaoFactory;
import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.dao.DepartmentDao;
import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.entities.Department;
import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.entities.Department;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DepartmentMain {
    public static void main(String[] args) {
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();


        System.out.println("=== TEST 1 Department FindById ===");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);
        System.out.println("=======================");
        

        System.out.println("=== TEST 2 Department FindAll ===");
        List<Department> list = new ArrayList<>();
        list = departmentDao.findAll();
        for (Department sel: list){
            System.out.println(sel);
        }
        System.out.println("=======================");

        System.out.println("=== TEST 4 Department Insert ===");
        Department newDepartment = new Department(null,"Food");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());
        System.out.println("=======================");

        System.out.println("=== TEST 5 Department Update ===");
        dep = departmentDao.findById(1);
        dep.setName("PC's");
        departmentDao.update(dep);
        System.out.println("Update Completed");
        System.out.println("=======================");

        System.out.println("=== TEST 6 Department Delete ===");
        departmentDao.deleteById(8);
        System.out.println("Delete Completed");
        System.out.println("=======================");

    }
}

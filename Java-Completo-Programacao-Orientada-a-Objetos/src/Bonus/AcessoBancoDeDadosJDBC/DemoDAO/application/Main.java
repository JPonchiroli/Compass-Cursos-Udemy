package Bonus.AcessoBancoDeDadosJDBC.DemoDAO.application;

import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.dao.DaoFactory;
import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.dao.SellerDao;
import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.entities.Department;
import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1 FindById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        System.out.println("=======================");

        System.out.println("=== TEST 2 FindByDepartment ===");
        Department dep = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(dep);
        for (Seller sel: list){
            System.out.println(sel);
        }
        System.out.println("=======================");
    }
}

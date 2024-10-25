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

        System.out.println("=== TEST 1 Seller FindById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        System.out.println("=======================");

        System.out.println("=== TEST 2 Seller FindByDepartment ===");
        Department dep = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(dep);
        for (Seller sel: list){
            System.out.println(sel);
        }
        System.out.println("=======================");

        System.out.println("=== TEST 3 Seller FindByDepartment ===");
        list = sellerDao.findAll();
        for (Seller sel: list){
            System.out.println(sel);
        }
        System.out.println("=======================");

        System.out.println("=== TEST 4 Seller Insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, dep);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id: " + newSeller.getId());
        System.out.println("=======================");

        System.out.println("=== TEST 5 Seller Update ===");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update Completed");
        System.out.println("=======================");

        System.out.println("=== TEST 6 Seller Delete ===");
        sellerDao.deleteById(1);
        System.out.println("Delete Completed");
        System.out.println("=======================");
    }
}

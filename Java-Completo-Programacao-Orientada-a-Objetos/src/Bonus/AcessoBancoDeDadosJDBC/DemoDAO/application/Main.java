package Bonus.AcessoBancoDeDadosJDBC.DemoDAO.application;

import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.dao.DaoFactory;
import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.dao.SellerDao;
import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.entities.Department;
import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.entities.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Department dp = new Department(1, "Books");
        Seller sl = new Seller(21, "bob", "bob@gmail.com", new Date(), 3000.0, dp);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println(dp);
        System.out.println(sl);
    }
}

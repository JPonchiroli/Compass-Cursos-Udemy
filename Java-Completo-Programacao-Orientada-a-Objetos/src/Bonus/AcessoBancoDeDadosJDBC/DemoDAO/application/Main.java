package Bonus.AcessoBancoDeDadosJDBC.DemoDAO.application;

import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.dao.DaoFactory;
import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.dao.SellerDao;
import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.entities.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        Seller seller = sellerDao.findById(3);

        System.out.println(seller);
    }
}

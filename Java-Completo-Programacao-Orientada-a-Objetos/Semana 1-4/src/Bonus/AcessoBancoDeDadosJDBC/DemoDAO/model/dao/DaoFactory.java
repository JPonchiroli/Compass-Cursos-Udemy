package Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.dao;

import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.db.DB;
import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.dao.impl.DepartmentDaoJDBC;
import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartmentDao createDepartmentDao(){
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}

package Bonus.AcessoBancoDeDadosJDBC.DemoDAO.db;

public class DbIntegrityException extends RuntimeException{
    public DbIntegrityException(String msg){
        super(msg);
    }
}

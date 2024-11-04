package Bonus.AcessoBancoDeDadosJDBC.DemoCRUD.Aplicacao;

import Bonus.AcessoBancoDeDadosJDBC.DemoCRUD.db.DB;
import Bonus.AcessoBancoDeDadosJDBC.DemoCRUD.db.DbException;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class Transacao {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;

        try {
            conn = DB.getConnection();

            conn.setAutoCommit(false);

            st = conn.createStatement();

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

            /*
            int x = 1;
            if(x > 0){
                throw new SQLException("Fake error")
            }
            */

            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            conn.commit();

            System.out.println("rows1: " + rows1);
            System.out.println("rows2: " + rows2);

        } catch (SQLException e) {
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back! Caused by: " +  e.getMessage());
            } catch (SQLException ex) {
                throw new DbException("Error trying to rollback! Caused by: " +  ex.getMessage());
            }
        } finally {
            DB.fecharStatement(st);
            DB.fecharConexao();
        }
    }
}
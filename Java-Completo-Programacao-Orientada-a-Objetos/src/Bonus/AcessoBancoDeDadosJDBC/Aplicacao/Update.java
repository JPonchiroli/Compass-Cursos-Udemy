package Bonus.AcessoBancoDeDadosJDBC.Aplicacao;

import Bonus.AcessoBancoDeDadosJDBC.db.DB;

import java.sql.*;

public class Update {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "UPDATE seller "
                      + "SET BaseSalary = BaseSalary + ? "
                      + "WHERE "
                      + "(DepartmentId = ?)");

            st.setDouble(1, 200.0);
            st.setInt(2, 2);

            int rowsAffected = st.executeUpdate();
            System.out.println("Done! Rows Affected: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.fecharStatement(st);
            DB.fecharConexao();
        }
    }
}

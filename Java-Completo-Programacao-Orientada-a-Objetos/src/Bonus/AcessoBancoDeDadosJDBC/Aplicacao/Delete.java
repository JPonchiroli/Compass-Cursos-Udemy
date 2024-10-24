package Bonus.AcessoBancoDeDadosJDBC.Aplicacao;

import Bonus.AcessoBancoDeDadosJDBC.db.DB;
import Bonus.AcessoBancoDeDadosJDBC.db.DbIntegrityException;

import java.sql.*;

public class Delete {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "DELETE FROM department "
                            + "WHERE "
                            + "Id = ? ");

            st.setInt(1, 6);

            int rowsAffected = st.executeUpdate();
            System.out.println("Done! Rows Affected: " + rowsAffected);

        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.fecharStatement(st);
            DB.fecharConexao();
        }
    }
}

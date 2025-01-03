package Bonus.AcessoBancoDeDadosJDBC.DemoCRUD.Aplicacao;

import Bonus.AcessoBancoDeDadosJDBC.DemoCRUD.db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DB.getConnection();

            st = conn.createStatement();

            rs = st.executeQuery("select * from department");

            while (rs.next()){
                System.out.println(rs.getInt("Id") +  ", " + rs.getString("Name"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.fecharResultSet(rs);
            DB.fecharStatement(st);
            DB.fecharConexao();
        }

    }
}

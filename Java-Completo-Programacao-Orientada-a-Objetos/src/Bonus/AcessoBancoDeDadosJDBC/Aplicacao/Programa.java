package Bonus.AcessoBancoDeDadosJDBC.Aplicacao;

import Bonus.AcessoBancoDeDadosJDBC.db.DB;

import java.sql.Connection;

public class Programa {
    public static void main(String[] args) {
        Connection conn = DB.getConnection();
        DB.fecharConexao();
    }
}

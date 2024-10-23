package Bonus.AcessoBancoDeDadosJDBC.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    public static Connection getConnection(){
        if(conn == null){
            try {
                Properties props = carregarPropriedades();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url,props);
                System.out.println("Conexao Efetuada com Sucesso!");
            } catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    public static void fecharConexao(){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    private static Properties carregarPropriedades(){
        try (FileInputStream fs = new FileInputStream("db.propriedades")){
            Properties props = new Properties();
            props.load(fs);
            return props;

        }  catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }
}

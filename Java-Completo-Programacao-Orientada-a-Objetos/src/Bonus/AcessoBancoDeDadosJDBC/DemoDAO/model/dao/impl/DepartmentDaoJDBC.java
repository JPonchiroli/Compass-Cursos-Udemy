package Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.dao.impl;

import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.db.DB;
import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.db.DbException;
import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.dao.DepartmentDao;
import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.entities.Department;
import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.entities.Seller;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Department dep) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "INSERT INTO department " +
                            "(Name) " +
                            "VALUES " +
                            "(?) ",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, dep.getName());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()){
                    int id = rs.getInt(1);
                    dep.setId(id);
                }
                DB.fecharResultSet(rs);
            } else {
                throw new DbException("Unexpected error! No rows affected!");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.fecharStatement(st);
        }
    }

    @Override
    public void update(Department dep) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "UPDATE department " +
                            "SET Name = ? " +
                            "WHERE Id = ? ",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, dep.getName());
            st.setInt(2, dep.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.fecharStatement(st);
        }
    }

    @Override
    public void deleteById(Integer Id) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "DELETE FROM department WHERE Id = ? ",
                    Statement.RETURN_GENERATED_KEYS);

            st.setInt(1, Id);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.fecharStatement(st);
        }
    }

    @Override
    public Department findById(Integer Id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT * " +
                            "FROM department " +
                            "WHERE Id = ? ");

            st.setInt(1, Id);
            rs = st.executeQuery();
            if (rs.next()){
                Department dep = instantiateDepartment(rs);

                return dep;
            }
            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.fecharStatement(st);
            DB.fecharResultSet(rs);
        }
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT * FROM department");


            rs = st.executeQuery();

            List<Department> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while (rs.next()){

                Department dep = map.get(rs.getInt("Id"));

                if (dep == null){
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("Id"), dep);
                }

                list.add(dep);
            }
            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.fecharStatement(st);
            DB.fecharResultSet(rs);
        }
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("Id"));
        dep.setName(rs.getString("Name"));
        return dep;
    }
}

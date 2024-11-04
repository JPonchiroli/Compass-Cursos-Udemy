package Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.dao.impl;

import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.db.DB;
import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.db.DbException;
import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.dao.SellerDao;
import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.entities.Department;
import Bonus.AcessoBancoDeDadosJDBC.DemoDAO.model.entities.Seller;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerDaoJDBC implements SellerDao {

    private Connection conn;

    public SellerDaoJDBC(Connection conn){
        this.conn = conn;
    }


    @Override
    public void insert(Seller sel) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "INSERT INTO seller " +
                            "(Name, Email, BirthDate, BaseSalary, DepartmentId) " +
                            "VALUES " +
                            "(?, ?, ?, ?, ?) ",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, sel.getName());
            st.setString(2, sel.getEmail());
            st.setDate(3, new java.sql.Date(sel.getBirthDate().getTime()));
            st.setDouble(4, sel.getBaseSalary());
            st.setInt(5, sel.getDepartment().getId());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()){
                    int id = rs.getInt(1);
                    sel.setId(id);
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
    public void update(Seller sel) {
        PreparedStatement st = null;

        try {
            st = conn.prepareStatement(
                    "UPDATE seller " +
                         "SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ?\n" +
                         "WHERE Id = ? ",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, sel.getName());
            st.setString(2, sel.getEmail());
            st.setDate(3, new java.sql.Date(sel.getBirthDate().getTime()));
            st.setDouble(4, sel.getBaseSalary());
            st.setInt(5, sel.getDepartment().getId());
            st.setInt(6, sel.getId());

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
                    "DELETE FROM seller WHERE Id = ? ",
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
    public Seller findById(Integer Id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName " +
                        "FROM seller INNER JOIN department " +
                        "ON seller.DepartmentId = department.Id " +
                        "WHERE seller.Id = ? ");

            st.setInt(1, Id);
            rs = st.executeQuery();
            if (rs.next()){
                Department dep = instantiateDepartment(rs);
                Seller sel = instantiateSeller(rs, dep);

                return sel;
            }
            return null;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.fecharStatement(st);
            DB.fecharResultSet(rs);
        }
    }

    private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
        Seller sel = new Seller();
        sel.setId(rs.getInt("Id"));
        sel.setName(rs.getString("Name"));
        sel.setEmail(rs.getString("Email"));
        sel.setBaseSalary(rs.getDouble("BaseSalary"));
        sel.setBirthDate(rs.getDate("BirthDate"));
        sel.setDepartment(dep);
        return sel;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("DepartmentId"));
        dep.setName(rs.getString("DepName"));
        return dep;
    }

    @Override
    public List<Seller> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName " +
                            "FROM seller INNER JOIN department " +
                            "ON seller.DepartmentId = department.Id " +
                            "ORDER BY Name ");

            rs = st.executeQuery();

            List<Seller> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while (rs.next()){

                Department dep = map.get(rs.getInt("DepartmentId"));

                if (dep == null){
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }

                Seller sel = instantiateSeller(rs, dep);

                list.add(sel);
            }
            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.fecharStatement(st);
            DB.fecharResultSet(rs);
        }
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement(
                    "SELECT seller.*,department.Name as DepName " +
                            "FROM seller INNER JOIN department " +
                            "ON seller.DepartmentId = department.Id " +
                            "WHERE DepartmentId = ? " +
                            "ORDER BY Name ");

            st.setInt(1, department.getId());
            rs = st.executeQuery();

            List<Seller> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while (rs.next()){

                Department dep = map.get(rs.getInt("DepartmentId"));

                if (dep == null){
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("DepartmentId"), dep);
                }

                Seller sel = instantiateSeller(rs, dep);

                list.add(sel);
            }
            return list;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.fecharStatement(st);
            DB.fecharResultSet(rs);
        }
    }
}
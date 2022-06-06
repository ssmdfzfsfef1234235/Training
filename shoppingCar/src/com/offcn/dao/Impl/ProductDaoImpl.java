package com.offcn.dao.Impl;

import com.offcn.bean.Product;
import com.offcn.dao.ProductDao;
import com.offcn.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private QueryRunner queryRunner = new QueryRunner();
    @Override
    public Product selectById(Integer id) {
        Connection connection = null;
        Product product = null;
        try {
            connection= JDBCUtils.getConnection();
            String sql="select * from product where pid = ?";
            product= queryRunner.query(connection, sql, new BeanHandler<>(Product.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return product;
    }

    @Override
    public List<Product> selectAll() {
        Connection connection = null;
        List<Product> l = null;
        try {
            connection= JDBCUtils.getConnection();
            String sql="select * from product";
             l= queryRunner.query(connection, sql, new BeanListHandler<>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return l;
    }
}

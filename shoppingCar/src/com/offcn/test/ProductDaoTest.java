package com.offcn.test;


import com.offcn.bean.Product;
import com.offcn.dao.Impl.ProductDaoImpl;
import com.offcn.dao.ProductDao;
import org.junit.Test;

import java.util.List;

public class ProductDaoTest {

    private ProductDao productDao=new ProductDaoImpl();

    @Test
    public void selectById() {
        Product product = productDao.selectById(1);
        System.out.println("product = " + product);
    }

    @Test
    public void selectAll() {
        List<Product> list = productDao.selectAll();
        System.out.println("list = " + list);
    }
}
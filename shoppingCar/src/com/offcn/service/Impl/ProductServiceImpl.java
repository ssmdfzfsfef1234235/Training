package com.offcn.service.Impl;

import com.offcn.bean.Product;
import com.offcn.dao.Impl.ProductDaoImpl;
import com.offcn.dao.ProductDao;
import com.offcn.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public Product selectById(Integer id) {
        return productDao.selectById(id);
    }

    @Override
    public List<Product> selectAll() {
        return productDao.selectAll();
    }
}

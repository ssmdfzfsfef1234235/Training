package com.offcn.dao;

import com.offcn.bean.Product;

import java.util.List;

public interface ProductDao {

    Product selectById(Integer id);

    List<Product> selectAll();
}

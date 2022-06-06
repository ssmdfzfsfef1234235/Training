package com.offcn.service;

import com.offcn.bean.Product;

import java.util.List;

public interface ProductService {

    Product selectById(Integer id);

    List<Product> selectAll();
}

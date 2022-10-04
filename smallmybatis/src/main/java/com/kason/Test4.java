package com.kason;

import com.kason.entity.ProductCategory;
import com.kason.mapper.ProductCategoryMapper;

public class Test4 {

    public static void main(String[] args) {


        ProductCategoryMapper mapper = SqlSession.getMapper(ProductCategoryMapper.class);

        ProductCategory p = new ProductCategory();
        p.setCategoryId(10001);
        p.setCategoryName("tets2");
        p.setCategoryType(2);
        ProductCategory xxx = mapper.select(102, "xxx");
        System.out.println(xxx);




    }
}

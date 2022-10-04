package com.kason;

import com.kason.entity.ProductCategory;
import com.kason.mapper.ProductCategoryMapper;

import java.util.List;

public class Test5 {

    public static void main(String[] args) {


        ProductCategoryMapper mapper = SqlSession.getMapper(ProductCategoryMapper.class);

        ProductCategory p = new ProductCategory();
        p.setCategoryType(2);
        List<ProductCategory> productCategories = mapper.selectLists(p);
        for (ProductCategory productCategory : productCategories) {
            System.out.println(productCategory);
        }




    }
}

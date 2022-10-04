package com.kason;

import com.kason.mapper.ProductCategoryMapper;
import com.kason.utils.JDBCUtils;

public class Test2 {

    public static void main(String[] args) {


        ProductCategoryMapper mapper = SqlSession.getMapper(ProductCategoryMapper.class);

        int test = mapper.insert(102, "test", 2);
        System.out.println(test);




    }
}

package com.kason;

import com.kason.utils.JDBCUtils;

import java.sql.Connection;

public class Test {

    public static void main(String[] args) {


        String sql = "insert into product_category(category_id,category_name,category_type) values (?,?,?)";
        int update = JDBCUtils.update(sql, 101, "随便", 4);
        System.out.println(update);




    }
}

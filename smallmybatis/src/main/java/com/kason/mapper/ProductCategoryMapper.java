package com.kason.mapper;


import com.kason.annotations.ExtInsert;
import com.kason.annotations.ExtParam;
import com.kason.annotations.ExtSelect;
import com.kason.annotations.Mapper;
import com.kason.entity.ProductCategory;

import java.util.List;

@Mapper("productCategoryMapper")
public interface ProductCategoryMapper {


    @ExtInsert("insert into product_category(category_id,category_name,category_type) values (#{categoryId},#{categoryName},#{categoryType})")
    int insert(@ExtParam("categoryId") Integer categoryId, @ExtParam("categoryName") String categoryName, @ExtParam("categoryType") Integer categoryType);


    @ExtInsert("insert into product_category(category_id,category_name,category_type) values (#{categoryId},#{categoryName},#{categoryType})")
    int insert(ProductCategory productCategory);


    @ExtSelect("select * from product_category where category_id = #{categoryId} or category_name = #{categoryName}")
    ProductCategory select(@ExtParam("categoryId") Integer categoryId, @ExtParam("categoryName") String categoryName);

    @ExtSelect("select * from product_category where category_id = #{categoryId} or category_name = #{categoryName}")
    List<ProductCategory> selectLists(@ExtParam("categoryId") Integer categoryId, @ExtParam("categoryName") String categoryName);


    @ExtSelect("select * from product_category where category_type = #{categoryType}")
    List<ProductCategory> selectLists(ProductCategory productCategory);

}

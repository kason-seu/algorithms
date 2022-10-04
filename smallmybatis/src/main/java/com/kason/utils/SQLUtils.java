package com.kason.utils;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLUtils {

    /**
     * #{} 转换为 ?
     * @param sql
     * @return
     */
    public static String sqlMatchSharpTransferToQuestion(String sql) {
        Pattern pattern = Pattern.compile("#\\{[\\w]*\\}");
        Matcher matcher = pattern.matcher(sql);
        //循环，字符串中有多少个符合的，就循环多少次
        while(matcher.find()){
            //每一个符合正则的字符串
            String e = matcher.group();
            //截取出括号中的内容
            String substring = e.substring(2, e.length()-1);
            //进行替换
            sql = sql.replaceAll("#\\{"+substring+"\\}", "?");
        }
        return sql;
    }

    public static List<String> sqlMatchSharpTransferToQuestionNames(String sql) {
        Pattern pattern = Pattern.compile("#\\{[\\w]*\\}");
        Matcher matcher = pattern.matcher(sql);
        List<String> paramNames = new ArrayList<>();
        //循环，字符串中有多少个符合的，就循环多少次
        while(matcher.find()){
            //每一个符合正则的字符串
            String e = matcher.group();
            //截取出括号中的内容
            String substring = e.substring(2, e.length()-1);
            paramNames.add(substring);

        }
        return paramNames;
    }



    public static Tuple2<List<String>, String> sqlMatchSharpTransferToQuestionCombine(String sql) {
        Pattern pattern = Pattern.compile("#\\{[\\w]*\\}");
        Matcher matcher = pattern.matcher(sql);
        //循环，字符串中有多少个符合的，就循环多少次
        List<String> ans = new ArrayList<>();
        while(matcher.find()){
            //每一个符合正则的字符串
            String e = matcher.group();
            //截取出括号中的内容
            String substring = e.substring(2, e.length()-1);
            ans.add(substring);
            //进行替换
            sql = sql.replaceAll("#\\{"+substring+"\\}", "?");
        }
        return new Tuple2<>(ans, sql);
    }
    public static void main(String[] args) {
        String sql = "insert into product_category(category_id,category_name,category_type) values(#{categoryId},#{categoryName},#{categoryType})";

        String s = SQLUtils.sqlMatchSharpTransferToQuestion(sql);
        System.out.println(s);

        List<String> strings = SQLUtils.sqlMatchSharpTransferToQuestionNames(sql);
        System.out.println(strings);

        Tuple2<List<String>, String> listStringTuple2 = SQLUtils.sqlMatchSharpTransferToQuestionCombine(sql);
        System.out.println(listStringTuple2.getLeft());
        System.out.println(listStringTuple2.getRight());


    }

}

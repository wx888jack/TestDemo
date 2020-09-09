package com.agile.operator.service.impl;

import com.agile.persistent.po.TestClass;
import com.agile.sys.routeStation.Test;
import org.hibernate.annotations.SourceType;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by huangximing on 2020/4/21.
 */
public class TestService {

    public static void main(String[] args) {
        List<TestClass> list=new ArrayList<>();
        list.add(TestClass.builder().name("小李").age(11).build());
        list.add(TestClass.builder().name("小花").age(13).build());
        list.add(TestClass.builder().name("小草").age(9).build());
        list.add(TestClass.builder().name("小东").age(10).build());

        List<TestClass> sortList=list.stream().sorted((a,b)->b.getAge().compareTo(a.getAge())).collect(Collectors.toList());
        System.out.println(String.valueOf(sortList).toString());
    }



}

package com.offcn.test;

import com.offcn.utils.PageUtils;
import org.junit.Test;

public class PageUtilsTest {

    @Test
    public void test1(){

        PageUtils pageUtils = new PageUtils(32,"1");
        System.out.println("pageUtils = " + pageUtils);
    }
}

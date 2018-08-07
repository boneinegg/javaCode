package com.liupp.test;

import com.liupp.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.liupp.pojo.Category;
import com.liupp.pojo.Product;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest {
    @Autowired
    Category category;

    @Test
    public void test() {
        System.out.println(category.getName());
    }

//    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
//                new String[] {"applicationContext.xml"});
//        Product product = (Product) applicationContext.getBean("product");
//        ProductService productService = (ProductService) applicationContext.getBean("service");
//        Category category;
//        category = (Category) applicationContext.getBean("category");
//        System.out.println(category.getName());
//        productService.doService();
//        System.out.println(product.getName());
//        System.out.println(product.getCategory().getName());
//    }
}

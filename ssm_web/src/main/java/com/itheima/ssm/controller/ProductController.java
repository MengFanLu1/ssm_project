package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("findall.do")
    public ModelAndView findAll() throws Exception {
        List<Product> productlist = productService.findAll();
        ModelAndView mv = new ModelAndView();

        mv.addObject("productList",productlist);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("save.do")
    public String save(Product product) throws Exception {

        System.out.println(product);

            productService.save(product);

        return "forward:findall.do";
    }

}

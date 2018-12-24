package com.itheima.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("orders")
public class OrdersController {

    @Autowired
    private IOrdersService service;

    /*@RequestMapping("findAll")
    public ModelAndView findAll() throws Exception {
        List<Orders> ordersList = service.findAll();
        ModelAndView mv = new ModelAndView();
            mv.addObject("ordersList",ordersList);
            mv.setViewName("orders-list");
        return mv;
    }*/

    @RequestMapping("findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required=true,defaultValue = "1") int page,
                                @RequestParam(name = "size",required=true,defaultValue = "4") int size) throws Exception {
        List<Orders> ordersList = service.findAll(page,size);

        PageInfo pageInfo = new PageInfo(ordersList);

        ModelAndView mv = new ModelAndView();
            mv.addObject("ordersList",pageInfo);
            mv.setViewName("orders-page-list");
        return mv;
    }
}

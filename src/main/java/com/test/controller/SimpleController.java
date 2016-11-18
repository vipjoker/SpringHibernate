package com.test.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.test.model.Item;
import com.test.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by omakhobei on 11/11/2016.
 */

@Controller
public class SimpleController {
    @Autowired

    private ApplicationContext appContext;
    @Autowired
    private ItemService mService;
//    @Autowired(required = true)
//    public void setItemService(ItemService service){
//        this.mService = service;
//    }

    @RequestMapping(value="/" , method = RequestMethod.GET)
    public String helloWorld(Model model){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-'W'ww-u");
        String formattedDate = format.format(date);

        model.addAttribute("serverTime",mService == null? "Service is null":mService.getInfo());
        return  "home";
    }

    @RequestMapping(value = "/db", method = RequestMethod.GET)
    public String getDb(Model model){


        // <beans:bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource"

        // BasicData appContext.getBean("dataSource");
        return "home";
    }


    @RequestMapping(value = "/items",method = RequestMethod.GET)
    public String getAllItems(Model model){
        model.addAttribute("serverTime" ,"Items list works ");
        return "home";
//        return mService.listItems();
    }

    @RequestMapping(value = "item/{id}")
    public String getItemById(@PathVariable("id") long id ,Model model){
//        mService.getItemById(id);

        model.addAttribute("serverTime","Get item by id = " + id);
        return "home";
    }



}

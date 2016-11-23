package com.test.controller;

import com.test.model.Item;
import com.test.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by omakhobei on 11/11/2016.
 */

@Controller
public class UsersController {
    @Autowired
    private ApplicationContext appContext;
    @Autowired
    private ItemService mService;


    Logger logger = Logger.getLogger(UsersController.class.getName());


    @RequestMapping(value="/" , method = RequestMethod.GET)
    public String helloWorld(Model model){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-'W'ww-u");
        String formattedDate = format.format(date);

        model.addAttribute("items",mService.listItems());
        return  "home";
    }

    @PostMapping("/create")
    public String createUser(Model model,@ModelAttribute("command")Item item){


        logger.info("***************name " + item.toString());
        mService.addItem(item);
        List<Item> items = mService.listItems();
        model.addAttribute("items",items);
        return "redirect:/";
    }

    @GetMapping("/create" )
    public String createPage(Model model){
        Item item = new Item();
        model.addAttribute("command",item);
        logger.info("crete invoked");
        return "create";
    }




    @RequestMapping(value = "/items",method = RequestMethod.GET)
    public String getAllItems(Model model){
        model.addAttribute("serverTime" ,"Items list works ");
        return "home";
    }



}

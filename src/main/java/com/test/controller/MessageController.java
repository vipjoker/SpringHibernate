package com.test.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by omakhobei on 11/23/2016.
 */
public class MessageController {



    @PostMapping(value = "/{userId}/create")
    public String getItemById(@PathVariable("userId") String userId, Model model){
        model.addAttribute("userId",userId);
        return "messages";
    }

    @GetMapping("/{userId}/messages")
    public String getMessagesById(Model model,@PathVariable("userId")String userId){
        model.addAttribute("userId",userId);

        return "messages";
    }

}


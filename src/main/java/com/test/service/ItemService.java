package com.test.service;

import com.test.model.Item;

import java.util.List;

/**
 * Created by omakhobei on 11/14/2016.
 */
public interface ItemService {
    void addItem(Item item);
    void updateItem(Item item);
    List<Item> listItems();
    Item getItemById(long id);
    void removeItem(long id);


    String getInfo();
}

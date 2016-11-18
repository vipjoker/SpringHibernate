package com.test.service;

import com.test.dao.ItemDao;
import com.test.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by omakhobei on 11/14/2016.
 */


@Service
public class ItemServiceImpl implements ItemService{


    @Autowired
    private ItemDao itemDao;

    public void setItemDao(ItemDao itemDao){
        this.itemDao = itemDao;
    }

    public String getInfo(){
        return "Service works" + itemDao.listItems();
    }

    @Transactional
    public void addItem(Item item) {
        this.itemDao.addItem(item);
    }

    @Transactional
    public void updateItem(Item item) {
        this.itemDao.updateItem(item);
    }
    @Transactional
    public List<Item> listItems() {
        return this.itemDao.listItems();
    }

    @Transactional
    public Item getItemById(long id) {
        return this.itemDao.getItemById(id);
    }
    @Transactional
    public void removeItem(long id) {
        this.itemDao.removeItem(id);
    }
}

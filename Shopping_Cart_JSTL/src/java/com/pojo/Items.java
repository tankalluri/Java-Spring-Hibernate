/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tankalluri
 */
public class Items {
    public Items(){
        
    }
    List<BeanItems> cartItems= new ArrayList<>();
    public List<BeanItems> addItems(String itemName){
        BeanItems b = new BeanItems();
        b.setItem(itemName);
        cartItems.add(b);
        return cartItems;
    }
    public List<BeanItems> removeItem(String itemToRemove){
        for(BeanItems item: cartItems){
        if(itemToRemove.equalsIgnoreCase(item.getItem())){
            cartItems.remove(item);
            return cartItems;
        } 
    }
       return cartItems; 
}
}

package com.javatechie.spring.ajax.api.model.objects.roomobjects;


import com.javatechie.spring.ajax.api.model.objects.items.Items;

import java.util.ArrayList;
import java.util.HashMap;

public class Seller extends RoomObjects {
    private HashMap<Items, Integer> ItemsForSell;

    public Seller (){
        ItemsForSell = new HashMap<>() ;
    }

    public void AddItem(Items I) {
        ItemsForSell.put(I , I.getPrice()) ;
    }
    public void RemoveItem(Items I)
    {
        ItemsForSell.remove(I , I.getPrice()) ;
    }
    public HashMap<Items,Integer>getItems(){
        return ItemsForSell ;
    }

    public  Items checkItem( String ItemName){
        Items item = null ;
        ArrayList<Items> SellerItems = listItems();
        for (Items sellerItem : SellerItems) {
            if (sellerItem.getName().equals(ItemName)) {
                item = sellerItem;
                break;
            }
        }
        return item ;
    }
    public ArrayList<Items> listItems() {
        ArrayList<Items>tmp = new ArrayList<>() ;
        ItemsForSell.forEach((key, value) -> tmp.add(key));
        return tmp ;
    }

    @Override
    public String toString() {
        return "Seller";
    }
}

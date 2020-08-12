package com.javatechie.spring.ajax.api.model.maze;

import com.javatechie.spring.ajax.api.model.objects.items.Items;
import com.javatechie.spring.ajax.api.model.objects.items.Keys;
import com.javatechie.spring.ajax.api.model.objects.roomobjects.*;

import java.util.HashMap;

public interface Builder {
    Mirror AddMirror();
    Keys AddKey(String keyName );
    Door AddDoor(boolean isLocked);
    Seller AddSeller(HashMap<Items, Integer> SellerItems);
    PlainWall AddPlainWall();
    Paint AddPaint();
    Chest AddChest( boolean needKey);

}
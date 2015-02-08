package com.neddevteam.costumefrenzy.button;

import com.neddevteam.costumefrenzy.utils.BoundingBox;

import java.util.UUID;

/**
 * Created by mcat on 8/02/15.
 */
public abstract class Button {
    private UUID uuid;
    public Button(){
        uuid = UUID.randomUUID();
    }

    public abstract BoundingBox getBoundingBox();
    public abstract boolean checkClicked(int xrel,int yrel);

    public UUID getUUID(){return uuid;}
}
package com.neddevteam.costumefrenzy.button;

import com.neddevteam.costumefrenzy.utils.BoundingBox;
import com.neddevteam.costumefrenzy.utils.Point;

/**
 * Created by mcat on 8/02/15.
 */
public class SquareButton extends Button {

    private BoundingBox box;

    public SquareButton(Point p1,Point p2){
        super();
        box = new BoundingBox(p1,p2);
    }

    @Override
    public BoundingBox getBoundingBox() {
        return box;
    }

    @Override
    public boolean checkClicked(int xrel, int yrel) {
        return true;//Always true
    }

}

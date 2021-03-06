package com.neddevteam.nedcore.event.predefined;

import com.neddevteam.nedcore.button.Button;
import com.neddevteam.nedcore.event.Event;

/**
 * Created by gdefermin on 2/9/15.
 */
public class ButtonPressedEvent extends Event {

    private Button button;

    public ButtonPressedEvent(Button button){
        this.button = button;
    }

    public Button getButton() {
        return button;
    }
}

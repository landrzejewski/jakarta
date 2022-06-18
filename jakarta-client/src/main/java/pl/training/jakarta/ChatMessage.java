package pl.training.jakarta;

import java.io.Serializable;

public class ChatMessage implements Serializable {

    private String text;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}

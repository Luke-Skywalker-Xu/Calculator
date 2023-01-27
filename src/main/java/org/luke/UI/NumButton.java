package org.luke.UI;

import javafx.scene.control.Button;


public class NumButton extends Button {

    public static String css = "button.css";
    double minWidth = 55;
    //最小长度
    double minHeight = minWidth * 0.618;
    //最大宽度
    double maxWidth = 70;
    //最大长度
    double maxHeight = maxWidth * 0.618;
    //是否可以获取焦点
    boolean setFocusTraversable = false;

    public NumButton(String text) {
        super(text);
        //最小宽度


//-----------------------------------------------------------------------------------//

        //设置最小尺寸
        setMinSize(minWidth, minHeight);

        //设置最大尺寸
        setMaxSize(maxWidth, maxHeight);

        //是否可以获取焦点
        setFocusTraversable(setFocusTraversable);

        //设置样式
        getStylesheets().add(css);



    }
}

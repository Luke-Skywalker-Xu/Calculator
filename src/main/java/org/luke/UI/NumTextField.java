package org.luke.UI;

import javafx.scene.control.TextField;

public class NumTextField extends TextField {


    public NumTextField() {
        super();

        //首选宽度
        //double numTextFieldWidth = 0;
        //样式
        String style = "-fx-font-size: 24px;" +
                "fx-border-width:0;" +
                "-fx-border-color: transparent;" +
                "fx-border-insets:0;" +
                "-fx-border-radius: 0;";

        //是否可以编辑
        boolean setEditable = true;
        //是否可以获取焦点
        boolean setFocusTraversable = false;

//-----------------------------------------------------------------------------------//

        //设置首选尺寸
        //setPrefHeight(numTextFieldWidth);

        //设置样式
        setStyle(style);

        //是否可以编辑
        setEditable(setEditable);

        //是否可以获取焦点
        setFocusTraversable(setFocusTraversable);


    }
}

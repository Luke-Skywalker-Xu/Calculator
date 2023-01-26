package org.luke;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.luke.UI.NumButton;
import org.luke.UI.NumTextField;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.function.UnaryOperator;

public class MainApplication extends Application {


    //设置固定窗口大小
    boolean setResizable = false;

    //设置图标图片
    String iconSrc = "img/icon.png";

    //设置标题
    String Tittle = "计算器";
    //场景高度
    double primaryStageHeight = 360;

    //场景宽度
    double primaryStageWidth = 270;

    // 定义一个字符串来存储当前的运算符
    private String operator = "";

    // 定义一个变量来存储当前的第一个数字
    private double firstNumber = 0;

    // 定义一个变量来存储当前的第二个数字
    private double secondNumber = 0;

    @Override
    //在应用程序(Application)中创建主场景(primaryStage)
    public void start(Stage primaryStage) {

//-----------------------------------------------------------------------------------//
        // 创建菜单栏
        MenuBar menuBar = new MenuBar();

//-----------------------------------------------------------------------------------//

        //typeMenu菜单栏

        //创建typeMenu
        Menu typeMenu = new Menu("种类");

        //创建typeMenuItem
        MenuItem standardMenuItem = new MenuItem("标准");
        MenuItem scienceMenuItem = new MenuItem("科学");
        MenuItem programmerMenuItem = new MenuItem("程序员");
        MenuItem currencyMenuItem = new MenuItem("货币");

        //把typeMenuItem加到typeMenu
        typeMenu.getItems().addAll(standardMenuItem, scienceMenuItem, programmerMenuItem, currencyMenuItem);

//-----------------------------------------------------------------------------------//

        //fileMenu菜单栏

        //创建fileMenu
        Menu fileMenu = new Menu("文件");

//-----------------------------------------------------------------------------------//

        //创建fileMenuItem
        MenuItem setMenuItem = new MenuItem("设置");


//-----------------------------------------------------------------------------------//

        //退出菜单项
        MenuItem editItem = new MenuItem("退出");
        //执行动作
        editItem.setOnAction(event -> {
            //退出软件
            Platform.exit();
        });

//-----------------------------------------------------------------------------------//

        //把setMenuItem加到fileMenu
        fileMenu.getItems().addAll(setMenuItem, editItem);


//-----------------------------------------------------------------------------------//

        //helpMenu菜单栏

        //创建helpMenu
        Menu helpMenu = new Menu("帮助");

        //创建helpMenuItem
        MenuItem AboutMenuItem = new MenuItem("关于");
        double width = primaryStageWidth;
        double height = primaryStageHeight;
        AboutMenuItem.setOnAction(event -> {
            Alert aboutMenuItemalert = new Alert(Alert.AlertType.INFORMATION);


//-----------------------------------------------------------------------------------//

            Hyperlink linkGitHub = new Hyperlink("开源仓库");
            linkGitHub.setUnderline(false);//是否需要下划线
            linkGitHub.setPadding(new Insets(10, 0, 0, 2));
            linkGitHub.setOnAction(event1 -> {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/Luke-Skywalker-Xu/Calculator"));
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
            });

//-----------------------------------------------------------------------------------//

            //"关于"文本
            Text textAuthor = new Text();
            textAuthor.setText(" 2023年1月25日 构建");
            textAuthor.setStyle(" -fx-line-spacing: 10px;");

//-----------------------------------------------------------------------------------//

            //作者贡献者滑动栏
            //贡献者名单
            String textContributors = "作者: 许轲 (Luke)\n开源贡献者: ";
            //贡献者名单css
            String textContributorsCss = "-fx-line-spacing: 10px;";
            //创建文本块
            TextArea textAreaContributors = new TextArea();
            //设置自动换行
            textAreaContributors.setWrapText(true);
            //设置文本
            textAreaContributors.setText(textContributors);
            //设置css样式
            textAreaContributors.setStyle(textContributorsCss);
            //设置不可以编辑
            textAreaContributors.setEditable(false);

            ScrollPane scrollPaneContributors = new ScrollPane();
            scrollPaneContributors.setContent(textAreaContributors);
            scrollPaneContributors.setFitToWidth(true);
            scrollPaneContributors.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
            scrollPaneContributors.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);


            VBox vBoxContributors = new VBox(textAreaContributors, scrollPaneContributors);
            vBoxContributors.setPadding(new Insets(10, 0, 0, 0));


//-----------------------------------------------------------------------------------//
            //创建垂直布局管理器
            VBox vBox = new VBox(textAuthor, linkGitHub, vBoxContributors);

            //设置垂直布局管理器侧边距
            vBox.setPadding(new Insets(20, 10, 10, 20));

            //把垂直布局管理器插入关于菜单提示面板
            aboutMenuItemalert.getDialogPane().setContent(vBox);

//-----------------------------------------------------------------------------------//

            //图片地址
            String img = "img/icon.png";
            //图片缩小比例
            double FitWidth = 50;
            //图片是否按比例缩放
            boolean isPreserveRatio = true;
            //创建图片对象
            Image image = new Image(img);
            //创建图片视图对象
            ImageView imageView = new ImageView(image);
            //设置图片视图的缩小比例
            imageView.setFitWidth(FitWidth);
            //是否应保留图像的高宽比(按比例缩放)
            imageView.setPreserveRatio(isPreserveRatio);
            //把图片视图放在图像管理中做为定义好的图片
            aboutMenuItemalert.setGraphic(imageView);

//-----------------------------------------------------------------------------------//


            //菜单提示框
            //标题
            String tittle = "关于 计算器";

            //头文字
            String HeaderText = "  计算器 v0.1.0-alpha";

            //设置的标题
            aboutMenuItemalert.setTitle(tittle);

            //设置头文字
            aboutMenuItemalert.setHeaderText(HeaderText);

            //设置宽和高
            aboutMenuItemalert.getDialogPane().setPrefSize(width, height);

            //设置对话框的 icon 图标，参数是主窗口的 stage
            aboutMenuItemalert.initOwner(primaryStage);

            //运行模态窗口
            aboutMenuItemalert.showAndWait();

        });

//-----------------------------------------------------------------------------------//

        //把菜单项添入菜单
        helpMenu.getItems().addAll(AboutMenuItem);


//-----------------------------------------------------------------------------------//

        //把菜单添加到菜单栏
        menuBar.getMenus().addAll(typeMenu, fileMenu, helpMenu);

//-----------------------------------------------------------------------------------//


//-----------------------------------------------------------------------------------//

        //使用 JavaFX 的 TextFormatter 来限制文本框中只能输入数字和小数点
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String text = change.getText();
            if (text.matches("[0-9]*(\\.[0-9]*)?")) {
                return change;
            }
            return null;
        };

        // 定义计算器的文本框
        TextField numTextField = new NumTextField();
        numTextField.setTextFormatter(new TextFormatter<>(filter));

        // 创建数字按钮
        Button button0 = new NumButton("0");
        Button button1 = new NumButton("1");
        Button button2 = new NumButton("2");
        Button button3 = new NumButton("3");
        Button button4 = new NumButton("4");
        Button button5 = new NumButton("5");
        Button button6 = new NumButton("6");
        Button button7 = new NumButton("7");
        Button button8 = new NumButton("8");
        Button button9 = new NumButton("9");

        Button buttonDel = new NumButton("⌫");// U+232B
        Button buttonClear = new NumButton("C");
        Button buttonDot = new NumButton("‧");//= U+2027
        Button buttonPlus = new NumButton("＋");
        Button buttonMinus = new NumButton("－");
        Button buttonMultiply = new NumButton("×");
        Button buttonDivide = new NumButton("÷");
        Button buttonEqual = new NumButton("＝");
        Button buttonCopy = new NumButton("⎘");//U+2398
        Button buttonMod = new NumButton("M");


        // 为数字按钮设置单击事件处理器
        button0.setOnAction(e -> numTextField.setText(numTextField.getText() + "0"));
        button1.setOnAction(e -> numTextField.setText(numTextField.getText() + "1"));
        button2.setOnAction(e -> numTextField.setText(numTextField.getText() + "2"));
        button3.setOnAction(e -> numTextField.setText(numTextField.getText() + "3"));
        button4.setOnAction(e -> numTextField.setText(numTextField.getText() + "4"));
        button5.setOnAction(e -> numTextField.setText(numTextField.getText() + "5"));
        button6.setOnAction(e -> numTextField.setText(numTextField.getText() + "6"));
        button7.setOnAction(e -> numTextField.setText(numTextField.getText() + "7"));
        button8.setOnAction(e -> numTextField.setText(numTextField.getText() + "8"));
        button9.setOnAction(e -> numTextField.setText(numTextField.getText() + "9"));

        buttonClear.setOnAction(e -> {
            System.out.println("height:" + primaryStage.getHeight());
            System.out.println("Width:" + primaryStage.getWidth());
            numTextField.setText("");
            firstNumber = 0;
            secondNumber = 0;
            operator = "";
        });

        buttonCopy.setOnAction(e -> {
            final Clipboard clipboard = Clipboard.getSystemClipboard();
            final ClipboardContent content = new ClipboardContent();
            content.putString(numTextField.getText());
            clipboard.setContent(content);
            Alert alertCopy = new Alert(Alert.AlertType.INFORMATION);
            alertCopy.initOwner(primaryStage);//设置对话框的 icon 图标，参数是主窗口的 stage
            alertCopy.setTitle("提示");
            alertCopy.setHeaderText("您已复制运算结果");
            alertCopy.setContentText("结果为" + numTextField.getText());
            alertCopy.showAndWait();
        });


        // 为运算符按钮设置单击事件处理器
        buttonDel.setOnAction(e -> {
            String temp = numTextField.getText();
            if (temp.length() > 0) {
                temp = temp.substring(0, temp.length() - 1);
                numTextField.setText(temp);
            }
        });
        buttonPlus.setOnAction(e -> {
            String temp = numTextField.getText();
            if (temp.equals("") || temp.equals(".")) {
                return;
            }
            operator = "+";
            firstNumber = Double.parseDouble(numTextField.getText());
            numTextField.setText("");
        });
        buttonMinus.setOnAction(e -> {
            String temp = numTextField.getText();
            if (temp.equals("") || temp.equals(".")) {
                return;
            }
            operator = "-";
            firstNumber = Double.parseDouble(numTextField.getText());
            numTextField.setText("");
        });
        buttonMultiply.setOnAction(e -> {
            String temp = numTextField.getText();
            if (temp.equals("") || temp.equals(".")) {
                return;
            }
            operator = "*";
            firstNumber = Double.parseDouble(numTextField.getText());
            numTextField.setText("");
        });
        buttonDivide.setOnAction(e -> {
            String temp = numTextField.getText();
            if (temp.equals("") || temp.equals(".")) {
                return;
            }
            operator = "/";
            firstNumber = Double.parseDouble(numTextField.getText());
            numTextField.setText("");
        });
        buttonMod.setOnAction(e -> {
            String temp = numTextField.getText();
            if (temp.equals("") || temp.equals(".")) {
                System.out.println("height:" + primaryStage.getHeight());
                System.out.println("Width:" + primaryStage.getWidth());
                return;
            }
            operator = "%";
            firstNumber = Double.parseDouble(numTextField.getText());
            numTextField.setText("");
        });
        buttonDot.setOnAction(e -> {
            if (numTextField.getText().equals("")) {
                numTextField.setText("0.");
            } else if (!numTextField.getText().contains(".")) {
                numTextField.setText(numTextField.getText() + ".");
            }
        });
        // 为等于按钮设置单击事件处理器
        buttonEqual.setOnAction(e -> {
            String temp = numTextField.getText();
            if (temp.equals("") || temp.equals(".")) {
                return;
            }
            secondNumber = Double.parseDouble(numTextField.getText());
            switch (operator) {
                case "+":
                    numTextField.setText(String.valueOf(firstNumber + secondNumber));
                    break;
                case "-":
                    numTextField.setText(String.valueOf(firstNumber - secondNumber));
                    break;
                case "*":
                    numTextField.setText(String.valueOf(firstNumber * secondNumber));
                    break;
                case "/":
                    numTextField.setText(String.valueOf(firstNumber / secondNumber));
                    break;
                case "%":
                    numTextField.setText(String.valueOf(firstNumber % secondNumber));
                    break;
                default:
                    break;
            }
        });

//-----------------------------------------------------------------------------------//

        // 使用GridPane布局管理器来布置按钮和文本框
        GridPane standardGridPan = new GridPane();
        standardGridPan.setPadding(new Insets(5, 5, 5, 5));
        standardGridPan.setVgap(5);
        standardGridPan.setHgap(5);

        // 将数字按钮添加到第二、三、四行

        GridPane.setConstraints(button7, 1, 2);
        GridPane.setConstraints(button8, 2, 2);
        GridPane.setConstraints(button9, 3, 2);
        GridPane.setConstraints(button4, 1, 3);
        GridPane.setConstraints(button5, 2, 3);
        GridPane.setConstraints(button6, 3, 3);
        GridPane.setConstraints(button1, 1, 4);
        GridPane.setConstraints(button2, 2, 4);
        GridPane.setConstraints(button3, 3, 4);
        GridPane.setConstraints(button0, 2, 5);

        standardGridPan.getChildren().addAll(button7, button8, button9, button4, button5, button6, button1, button2, button3, button0);

        GridPane.setConstraints(buttonClear, 1, 1);
        GridPane.setConstraints(buttonPlus, 4, 3);
        GridPane.setConstraints(buttonMinus, 4, 2);
        GridPane.setConstraints(buttonMultiply, 3, 1);
        GridPane.setConstraints(buttonDivide, 2, 1);
        GridPane.setConstraints(buttonEqual, 4, 4);
        GridPane.setConstraints(buttonDot, 3, 5);
        GridPane.setConstraints(buttonDel, 4, 1);
        GridPane.setConstraints(buttonCopy, 4, 5);
        GridPane.setConstraints(buttonMod, 1, 5);

        standardGridPan.getChildren().addAll(buttonClear, buttonPlus, buttonMinus, buttonMultiply, buttonDivide, buttonEqual, buttonDot, buttonDel, buttonCopy, buttonMod);

//-----------------------------------------------------------------------------------//

        //将menuBar和standardGridPan添加到Vbox布局
        VBox vBoxlayout = new VBox(menuBar, numTextField, standardGridPan);

//-----------------------------------------------------------------------------------//

        //把vBoxlayout放入主窗口(primaryStage)

        primaryStage.setScene(new Scene(vBoxlayout));
        primaryStage.setWidth(primaryStageWidth);
        primaryStage.setHeight(primaryStageHeight);
        primaryStage.setResizable(setResizable);
        primaryStage.show();

        //主窗口(primaryStage)设置图标
        primaryStage.getIcons().add(new Image(iconSrc));

        //主窗口(primaryStage)设置标题
        primaryStage.setTitle(Tittle);

        //展示主窗口(primaryStage)
        primaryStage.show();


    }

//-----------------------------------------------------------------------------------//

    public static void main(String[] args) {
        //启动
        launch();
    }
}
package Project2.version3;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import Project2.version1.person.*;

import java.io.*;

public class PersonGUI extends Application {
    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {
        //将在版本二中写入好的文件反序列化到数组中去
        File file = new File("D:\\Intellij IDEA\\课程设计\\Person.txt");
        Person[] person = readFile(file);

        //将对象数组中的每个对象存入到obList当中去
        ObservableList<Person> obList = FXCollections.observableArrayList();
        for (int i = 0; i < person.length; i ++) {
            obList.add(person[i]);
        }

        //创建TableView组件
        TableView<Person> tableView = new TableView<Person>(obList);

        tableView.getSelectionModel().setCellSelectionEnabled(true);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //创建一个监听器，输出选择的行列参数及单元格里的内容
        tableView.getSelectionModel().getSelectedCells().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                ObservableList<TablePosition> obList = (ObservableList<TablePosition>) observable;
                for (int i = 0; i < obList.size(); i ++) {
                    TablePosition tablePosition = obList.get(i);
                    Object object = tablePosition.getTableColumn().getCellData(tablePosition.getRow());
                    System.out.println("行 = " + tablePosition.getRow() + " 列 = " + tablePosition.getColumn() + " 内容 = " + object.toString());
                }
            }
        });

        //创建列，并将Person类的数据域写入进去
        TableColumn<Person,String> tc_name = new TableColumn<Person,String>("姓名");
        TableColumn<Person,String> tc_address = new TableColumn<Person,String>("地址");
        TableColumn<Person,String> tc_phoneNumber = new TableColumn<Person,String>("电话");
        TableColumn<Person,String> tc_emailAddress = new TableColumn<Person,String>("电子邮箱");

        tc_name.setPrefWidth(100);
        tc_address.setPrefWidth(300);
        tc_phoneNumber.setPrefWidth(300);
        tc_emailAddress.setPrefWidth(300);

        tc_name.setCellValueFactory(new PropertyValueFactory<Person,String>("name"));
        tc_address.setCellValueFactory(new PropertyValueFactory<Person,String>("address"));
        tc_phoneNumber.setCellValueFactory(new PropertyValueFactory<Person,String>("phoneNumber"));
        tc_emailAddress.setCellValueFactory(new PropertyValueFactory<Person,String>("emailAddress"));

        //创建四个按钮，分别对应增删改查
        Button btAdd = new Button("增加");
        Button btDelete = new Button("删除");
        Button btRevise = new Button("修改");
        Button btFind = new Button("查找");

        //设置五个文本框，其中四个是要求输入增加的人员人员信息，另一个是要求输入查找的信息
        TextField tfName = new TextField();
        TextField tfAddress = new TextField();
        TextField tfPhoneNumber = new TextField();
        TextField tfEmailAddress = new TextField();
        TextField tfFind = new TextField();

        //用Label组件将文本框附上标签
        Label lName = new Label("姓名",tfName);
        lName.setContentDisplay(ContentDisplay.RIGHT);
        Label lAddress = new Label("地址",tfAddress);
        lAddress.setContentDisplay(ContentDisplay.RIGHT);
        Label lPhoneNumber = new Label("电话",tfPhoneNumber);
        lPhoneNumber.setContentDisplay(ContentDisplay.RIGHT);
        Label lEmailAddress = new Label("电子邮箱",tfEmailAddress);
        lEmailAddress.setContentDisplay(ContentDisplay.RIGHT);

        //利用Hbox将按钮与文本框整齐地排列
        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setSpacing(30);
        hBox1.getChildren().addAll(btAdd,btDelete,btRevise,btFind,tfFind);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setSpacing(30);
        hBox2.getChildren().addAll(lName,lAddress,lPhoneNumber,lEmailAddress);

        //给四个按钮分别附有相应的动作指令
        btAdd.setOnAction(actionEvent -> {
            obList.add(new Person(tfName.getText(),tfAddress.getText(),tfPhoneNumber.getText(),tfEmailAddress.getText()));
            tfName.clear();
            tfAddress.clear();
            tfPhoneNumber.clear();
            tfEmailAddress.clear();
        });

        btDelete.setOnAction(actionEvent ->{
            obList.remove(tableView.getSelectionModel().getSelectedIndex());
        });

        btRevise.setOnAction(actionEvent -> {

            tableView.setEditable(true);
            tc_name.setCellFactory(TextFieldTableCell.forTableColumn());
            tc_address.setCellFactory(TextFieldTableCell.forTableColumn());
            tc_phoneNumber.setCellFactory(TextFieldTableCell.forTableColumn());
            tc_emailAddress.setCellFactory(TextFieldTableCell.forTableColumn());
        });

        btFind.setOnAction(actionEvent -> {
            tableView.getSelectionModel().clearSelection();

            int i = 0;
            while (tc_name.getCellData(i) != null) {
                if (tc_name.getCellData(i).contains(tfFind.getText())) {
                    tableView.getSelectionModel().select(i, tc_name);
                    tableView.requestFocus();
                }
                i ++;
            }

            int j = 0;
            while (tc_address.getCellData(j) != null) {
                if (tc_address.getCellData(j).contains(tfFind.getText())) {
                    tableView.getSelectionModel().select(j, tc_address);
                    tableView.requestFocus();
                }
                j ++;
            }

            int k = 0;
            while (tc_phoneNumber.getCellData(k) != null) {
                if (tc_phoneNumber.getCellData(k).contains(tfFind.getText())) {
                    tableView.getSelectionModel().select(k, tc_phoneNumber);
                    tableView.requestFocus();
                }
                k ++;
            }

            int t = 0;
            while (tc_emailAddress.getCellData(t) != null) {
                if (tc_emailAddress.getCellData(t).contains(tfFind.getText())) {
                    tableView.getSelectionModel().select(t, tc_emailAddress);
                    tableView.requestFocus();
                }
                t ++;
            }
        });

        //设置场景并生成舞台
        tableView.getColumns().addAll(tc_name,tc_address,tc_phoneNumber,tc_emailAddress);
        BorderPane borderPane = new BorderPane(tableView);
        borderPane.setTop(hBox1);
        borderPane.setBottom(hBox2);
        Scene scene = new Scene(borderPane,1000,600);
        stage.setScene(scene);
        stage.show();
    }

    //wdnmd我tm终于会把多个对象同时从文件中反序列化出来了，首先序列化时就应该读取的是对象数组，然后反序列化出来的也会是对象数组，这样就可以反序列化出多个对象了，wdnmd这问题困扰老子整整一天++
    public static Person[] readFile(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream(file));
        Person[] person = (Person[]) ooi.readObject();;
        ooi.close();
        return person;
    }
}


//2021\6\22 16：05 记录两个找的我怀疑人生的两个bug
//一个是idea这软件抽风了,obList.add()总是显示cannot access...,找了半天找不到问题,百度后在File > Invalidate Caches /Restart重启一下成功解决
//另一个是TableView总是显示报错,就算敲的代码跟规范的一模一样也是报错,最后发现原来是我导错包了,一个类可能从属于不同的包,千万不要导错了
//再加一个,tmmd以后运行就只点那个绿色小三角了,再也不按shift+f10了,按shift+f10tm的给我运行到别的代码去了,我说我咋一只看不到输出结果

/*一个无法使用的过滤方法，脑壳痛
    tfFind.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                    FilteredList<Person> flList = obList.filtered(new Predicate<Person>() {
                        @Override
                        public boolean test(Person person) {
                            if (person.getName().contains(t1))
                                return true;
                            else
                                return false;
                        }
                    });
                }
            });*/
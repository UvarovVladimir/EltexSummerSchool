package ru.eltex;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ru.eltex.entity.User;

import java.io.IOException;

public class App extends Application {
    public static void main(String[] args) {
        Client.userRequest();

        System.out.println("Sleep");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Wake up");
        Integer i;

        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
// установка надписи
        Label first = new Label("Id");
        Label second = new Label("FIO");
        Label third = new Label("Phone");

        GridPane root = new GridPane();
        root.getColumnConstraints().add(new ColumnConstraints(120));
        root.getColumnConstraints().add(new ColumnConstraints(150));
        root.getColumnConstraints().add(new ColumnConstraints(300));

        root.setGridLinesVisible(true); // делаем видимой сетку строк и столбцов
        root.setColumnIndex(first, 0);
        root.setColumnIndex(second, 1);
        root.setColumnIndex(third, 2);
        root.getChildren().addAll(first, second, third);

        ObjectMapper mapper = new ObjectMapper();
        User[] users = mapper.readValue(Storage.getLine(), User[].class);

        for (int i = 0; i < users.length; i++) {
            root.add(new Label(users[i].getId().toString()), 0, i + 1);
            root.add(new Label(users[i].getFio()), 1, i + 1);
            root.add(new Label(users[i].getPhone()), 2, i + 1);
        }

        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.setTitle("First Application");
        stage.setWidth(700);
        stage.setHeight(750);
        stage.show();
    }


}
package ru.eltex;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.text.Text;
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) {
// установка надписи
        Text text = new Text("Hello from JavaFX!");
        text.setLayoutY(80); text.setLayoutX(100);
        Group group = new Group(text);
        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.setTitle("First Application");
        stage.setWidth(300); stage.setHeight(250);
        stage.show();
    }
}
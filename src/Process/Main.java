package Process;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        URL f11 = getClass().getResource("CSS.fxml");
       Parent root = FXMLLoader.load(f11);
        Image ico = new Image("sources/Kalikuliator.png");
        primaryStage.getIcons().add(ico);
        primaryStage.setTitle("Калькулятор");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

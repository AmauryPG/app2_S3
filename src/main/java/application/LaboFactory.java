package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LaboFactory extends Application {
	private BorderPane rootLayout; 
	
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(LaboFactory.class.getResource("UI.fxml"));
        
        rootLayout = (BorderPane)loader.load();

        primaryStage.setTitle("Prottotype 0");
        primaryStage.setScene(new Scene(rootLayout));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
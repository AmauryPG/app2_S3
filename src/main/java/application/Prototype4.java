package application;
 
import javafx.application.Application;
import javafx.fxml.FXMLLoader; 
import javafx.scene.Scene; 
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Prototype4 extends Application {
	private BorderPane rootLayout; 
	
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Prototype4.class.getResource("UI.fxml"));
         
        rootLayout = (BorderPane)loader.load();

        primaryStage.setTitle("Prototype 4");
        primaryStage.setScene(new Scene(rootLayout));
        primaryStage.show();
    } 
 

    public static void main(String[] args) {
       launch(args); 
    }    
}
 

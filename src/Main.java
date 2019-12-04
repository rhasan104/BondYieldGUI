import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
    	
    	//Intro.fxml is controlled by IntroController.java
        Parent root = FXMLLoader.load(getClass().getResource("Intro.fxml"));
        primaryStage.setTitle("Bond Yield Calculator");
        primaryStage.setScene(new Scene(root, 500, 300));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
    	
    	//Calls the function to load the landing page
        launch(args);
    }
}

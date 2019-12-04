import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class IntroController {
    @FXML
    private JFXButton btnCP;

    @FXML
    private JFXButton btnBY;

    @FXML
    private JFXButton btnQuit;

    //the following method is invoked when you click on Yield Calculator button
    @FXML
    void calcBYClicked(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("YieldCalculator.fxml"));
            Stage stage = (Stage) btnBY.getScene().getWindow();

            Scene scene = new Scene(loader.load());
            stage.setScene(scene);

        } catch (Exception e){
            System.err.print(e.getMessage());
        }
    }

    //the following method is invoked when you click on Price Calculator button
    @FXML
    void calcCPClicked(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PriceCalculator.fxml"));
            Stage stage = (Stage) btnCP.getScene().getWindow();

            Scene scene = new Scene(loader.load());
            stage.setScene(scene);

        } catch (Exception e){
            System.err.print(e.getMessage());
        }
    }

    //this method is called when you click on exit button
    @FXML
    void quitClicked(MouseEvent event) {
        System.exit(0);
    }

}

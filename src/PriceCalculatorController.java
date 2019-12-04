import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PriceCalculatorController {

    PriceCalculator pc = null;

    @FXML
    private JFXTextField txtfldCouponRate;

    @FXML
    private JFXTextField txtfldYears;

    @FXML
    private JFXTextField txtfldFV;

    @FXML
    private JFXTextField txtfldYR;

    @FXML
    private JFXButton btnCalcCP;

    @FXML
    public void initialize() {
        pc = new PriceCalculator();
    }

    @FXML
    void calcCP(MouseEvent event) {
        try {
            pc.setCoupon(Double.parseDouble(txtfldCouponRate.getText()));
            pc.setYears(Integer.parseInt(txtfldYears.getText()));
            pc.setFace(Double.parseDouble(txtfldFV.getText()));
            pc.setRate(Double.parseDouble(txtfldYR.getText()));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Calculated Price");
            alert.setHeaderText(null);
            alert.setContentText(pc.calculate());

            alert.showAndWait();

            try {
                FXMLLoader loader = new FXMLLoader(IntroController.class.getResource("Intro.fxml"));
                Stage stage = (Stage) btnCalcCP.getScene().getWindow();

                Scene scene = new Scene(loader.load());
                stage.setScene(scene);

            } catch (Exception e){
                System.err.print(e.getMessage());
            }
        }
        catch (NumberFormatException nfe) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Input");

            alert.showAndWait();
            txtfldCouponRate.clear();
            txtfldYears.clear();
            txtfldFV.clear();
            txtfldYR.clear();
        }
    }

}

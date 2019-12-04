import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class YieldCalculatorController {

    YieldCalculator yc = null;

    @FXML
    private JFXTextField txtfldCouponRate;

    @FXML
    private JFXTextField txtfldYears;

    @FXML
    private JFXTextField txtfldFV;

    @FXML
    private JFXTextField txtfldPrice;

    @FXML
    private JFXButton btnCalcCY;

    @FXML
    public void initialize() {
        yc = new YieldCalculator();
    }

    @FXML
    void calcCP(MouseEvent event) {
        try {
            yc.setCoupon(Double.parseDouble(txtfldCouponRate.getText()));
            yc.setYears(Integer.parseInt(txtfldYears.getText()));
            yc.setFace(Double.parseDouble(txtfldFV.getText()));
            yc.setPrice(Double.parseDouble(txtfldPrice.getText()));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Calculated Yield");
            alert.setHeaderText(null);
            alert.setContentText(yc.calculate());

            alert.showAndWait();

            try {
                FXMLLoader loader = new FXMLLoader(IntroController.class.getResource("Intro.fxml"));
                Stage stage = (Stage) btnCalcCY.getScene().getWindow();

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
            txtfldPrice.clear();
        }
    }

}
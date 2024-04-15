package principal;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class startController {

    private Stage stage;
    private Scene scene;

    @FXML
    private AnchorPane telaInicial;

    @FXML
    private Button botaoStart;

    @FXML
    private ImageView startImage;

    @FXML
    void iniciarGame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("entrada.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    
}

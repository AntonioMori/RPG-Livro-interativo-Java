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

public class idleControler {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button botao2;

    @FXML
    private Button botao1;

    @FXML
    private AnchorPane telaIdle;

    @FXML
    private ImageView idleImage;

    @FXML
    void opcao2(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("transitionIntroducaoCap1Opcao2.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void opcao1(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("transitionIntroducaoCap1.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}

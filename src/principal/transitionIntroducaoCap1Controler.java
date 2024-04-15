package principal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import javafx.animation.PauseTransition;

public class transitionIntroducaoCap1Controler {

    @FXML
    private AnchorPane telaTransitionIntroducao;

    public void initialize() {
        
        PauseTransition pause = new PauseTransition(Duration.seconds(2.3));
        
        
        pause.setOnFinished(event -> {
            try {
                // Carrega a próxima cena do arquivo FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("opcao1file.fxml"));
                Parent root = loader.load();
                
                // Configura a cena
                Scene scene = new Scene(root);
                Stage stage = (Stage) telaTransitionIntroducao.getScene().getWindow(); 
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        
        // Inicia a transição de pausa
        pause.play();
    }
}

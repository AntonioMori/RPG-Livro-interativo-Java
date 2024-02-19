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

public class entradaControler {
      
    
    @FXML
    private AnchorPane telaEntrada;

    public void initialize() {
        // Crie uma transição de pausa de 2 segundos
        PauseTransition pause = new PauseTransition(Duration.seconds(1.17));
        
        // Configura um evento para ocorrer após a pausa
        pause.setOnFinished(event -> {
            try {
                // Carrega a próxima cena do arquivo FXML
                FXMLLoader loader = new FXMLLoader(getClass().getResource("idle.fxml"));
                Parent root = loader.load();
                
                // Configura a cena
                Scene scene = new Scene(root);
                Stage stage = (Stage) telaEntrada.getScene().getWindow(); // Supondo que você tem uma referência ao AnchorPane
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        
        // Inicia a transição de pausa
        pause.play();
    }
}

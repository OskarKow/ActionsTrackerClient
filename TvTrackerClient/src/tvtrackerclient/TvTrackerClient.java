
package tvtrackerclient;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Oskar Kowalewski
 */
public class TvTrackerClient extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try{
            GridPane myPane = (GridPane)FXMLLoader.load(getClass().getResource("gui.fxml"));
            Scene scene = new Scene(myPane,1200,700);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

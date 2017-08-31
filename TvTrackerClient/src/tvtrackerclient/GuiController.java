/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tvtrackerclient;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author Oskar Kowalewski
 */
public class GuiController implements Initializable{
    
    @FXML TableView DBprogramTable;
    @FXML TableView DBchannelTable;
    @FXML ChoiceBox searchOption;
    @FXML TextField searchTextField;
    
    @FXML
    public void displayPrograms()
    {
        DBchannelTable.setVisible(false);
        DBprogramTable.setVisible(true);
    }
    
    @FXML
    public void displayChannels()
    {
        DBchannelTable.setVisible(true);
        DBprogramTable.setVisible(false);
    }
    
    @FXML
    public void search()
    {
        //sending GET request to web service and getting HTML document in response here
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    
}

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import tvtrackerclient.http.HtmlProcessor;
import tvtrackerclient.http.RequestsHandler;
import tvtrackerclient.model.Channel;
import tvtrackerclient.model.ProgramBroadcast;

/**
 *
 * @author Oskar Kowalewski
 */
public class GuiController implements Initializable{
    
    @FXML TableView DBprogramTable;
    @FXML TableView DBchannelTable;
    @FXML TableView<ProgramBroadcast> channelSearchTable;
    @FXML TableView programSearchTable;
    @FXML TableColumn<ProgramBroadcast, String> programNameColumn;
    @FXML TableColumn<ProgramBroadcast, String> programTimeColumn;
    @FXML ChoiceBox searchOption;
    @FXML TextField searchTextField;
    
    private Channel searchedChannel;
    
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
    public void searchOptionChosen()
    {
        if(searchOption.getValue().equals("Program"))
        {
            channelSearchTable.setVisible(false);
            programSearchTable.setVisible(true);
        }
        else{
            channelSearchTable.setVisible(true);
            programSearchTable.setVisible(false);
        }
    }
    
    @FXML
    public void search()
    {
        //sending GET request to web service and getting HTML document in response here
        String searchPhrase = searchTextField.getText();
        String htmlDocument;
        String webURL;
        if(!searchPhrase.equals("Enter Search Phrase")) //default text field message
        {
            if(searchOption.getValue().equals("Channel")) //we search for channel
            {
                searchPhrase = RequestsHandler.replaceCharacters(' ', '_', searchPhrase);
                webURL = "http://www.telemagazyn.pl/" + searchPhrase;
                htmlDocument = RequestsHandler.sendGetRequest(webURL);
                searchedChannel.setName(searchPhrase);
                HtmlProcessor.fillChannelBroadcasts(htmlDocument, searchedChannel);
                channelSearchTable.getItems().clear();
                channelSearchTable.getItems().setAll(searchedChannel.getBroadcasts());
            }
        }
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchedChannel = new Channel("empty");
        programNameColumn.setCellValueFactory(new PropertyValueFactory<ProgramBroadcast, String>("programName"));
        programTimeColumn.setCellValueFactory(new PropertyValueFactory<ProgramBroadcast, String>("stringTimeRepresentation"));
        //channelSearchTable.getItems().setAll(searchedChannel.getBroadcasts());
    }
    
    public Channel getSearchedChannel()
    {
        return searchedChannel;
    }

    
}

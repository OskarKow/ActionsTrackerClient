
package tvtrackerclient;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
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
import tvtrackerclient.model.ChannelBroadcast;
import tvtrackerclient.model.Program;
import tvtrackerclient.model.ProgramBroadcast;

/**
 *
 * @author Oskar Kowalewski
 */
public class GuiController implements Initializable{
    
    @FXML TableView DBprogramTable;
    @FXML TableView DBchannelTable;
    @FXML TableView<ProgramBroadcast> channelSearchTable;
    @FXML TableColumn<ProgramBroadcast, String> programNameColumn;
    @FXML TableColumn<ProgramBroadcast, String> programTimeColumn;
    @FXML TableView<ChannelBroadcast> programSearchTable;
    @FXML TableColumn<ChannelBroadcast, String> channelNameColumn;
    @FXML TableColumn<ChannelBroadcast, String> channelDateColumn;
    @FXML TableColumn<ChannelBroadcast, String> channelTimeColumn;
    @FXML ChoiceBox searchOption;
    @FXML TextField searchTextField;
    
    private Channel searchedChannel;
    private Program searchedProgram;
    
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
                searchPhrase = searchPhrase.replace(' ','_');
                webURL = "http://www.telemagazyn.pl/" + searchPhrase;
                htmlDocument = RequestsHandler.sendGetRequest(webURL);
                searchedChannel.setName(searchPhrase);
                HtmlProcessor.fillChannelBroadcasts(htmlDocument, searchedChannel);
                channelSearchTable.getItems().clear();
                channelSearchTable.getItems().setAll(searchedChannel.getBroadcasts());
            }
            else{
                searchedProgram.setName(searchPhrase);
                searchPhrase = searchPhrase.replace(' ','+');
                webURL = "http://www.telemagazyn.pl/szukaj/?q=" + searchPhrase;
                htmlDocument = RequestsHandler.sendGetRequest(webURL);
                HtmlProcessor.fillProgramBroadcasts(htmlDocument, searchedProgram);
                programSearchTable.getItems().clear();
                programSearchTable.getItems().setAll(searchedProgram.getBroadcasts());
            }
        }
    }
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        searchedChannel = new Channel("empty");
        searchedProgram = new Program("empty");
        programNameColumn.setCellValueFactory(new PropertyValueFactory<ProgramBroadcast, String>("programName"));
        programTimeColumn.setCellValueFactory(new PropertyValueFactory<ProgramBroadcast, String>("stringTimeRepresentation"));
        channelNameColumn.setCellValueFactory(new PropertyValueFactory<ChannelBroadcast, String>("channelName"));
        channelDateColumn.setCellValueFactory(new PropertyValueFactory<ChannelBroadcast, String>("emissionDate"));
        channelTimeColumn.setCellValueFactory(new PropertyValueFactory<ChannelBroadcast, String>("emissionTime"));
    }
    
    public Channel getSearchedChannel()
    {
        return searchedChannel;
    }

    
}

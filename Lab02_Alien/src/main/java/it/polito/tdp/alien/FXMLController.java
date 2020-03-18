/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	AlienDictionary dizionario;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtinsert"
    private TextField txtinsert; // Value injected by FXMLLoader

    @FXML // fx:id="btntranslate"
    private Button btntranslate; // Value injected by FXMLLoader

    @FXML // fx:id="txtresult"
    private TextArea txtresult; // Value injected by FXMLLoader

    @FXML // fx:id="btnclear"
    private Button btnclear; // Value injected by FXMLLoader

    @FXML
    void doReset(ActionEvent event) {
    	txtresult.clear();
    	dizionario.getLista().clear();
    }


    @FXML
    void doTranslate(ActionEvent event) {
    	String tmp=txtinsert.getText();
    	String parole[]= tmp.split(" ");
    	if(parole.length>1) {
    	String parolaaliena=parole[0];
    	ArrayList <String> traduzione=new ArrayList<String>();
    	for(int i=1;i<parole.length;i++) {
    	traduzione.add(parole[i]);
    	}
    	if(dizionario.controllo(parolaaliena)==false || dizionario.controllostringa(traduzione)==false) {
    		txtresult.appendText("inserire lettere\n");
    		return;
    	}
    	parolaaliena=parolaaliena.toLowerCase();
    	for(String parola: traduzione)
    	parola=parola.toLowerCase();
    	dizionario.addWord(parolaaliena, traduzione);
    	txtresult.appendText("inserita la parola aliena "+ parolaaliena+ " verrà tradotta con :\n");
    			for(String parola: traduzione) {
    				txtresult.appendText(parola+"\n");
    			}
    	}
    	if(parole.length==1)
    	{
    	String parolaaliena=parole[0];
    	if(dizionario.controllo(parolaaliena)==false) {
    		txtresult.appendText("inserire lettere\n");
    		return;
    	}
    	parolaaliena=parolaaliena.toLowerCase();
    	ArrayList <String> traduzione=new ArrayList<String>();
    	traduzione=dizionario.translateWord(parolaaliena);
    	if(traduzione.size()==0) {
    		txtresult.appendText("parola non trovata\n");
    		return;
    	}
    	txtresult.appendText("inserita la parola aliena "+ parolaaliena+ " è tradotta con : "+ traduzione.size()+"\n");
		for(String parola: traduzione) {
			txtresult.appendText(parola+"\n");
		}
}
    	}



    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtinsert != null : "fx:id=\"txtinsert\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btntranslate != null : "fx:id=\"btntranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtresult != null : "fx:id=\"txtresult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnclear != null : "fx:id=\"btnclear\" was not injected: check your FXML file 'Scene.fxml'.";
        dizionario=new AlienDictionary();

    }
}

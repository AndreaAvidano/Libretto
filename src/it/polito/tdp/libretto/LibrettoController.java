/**
 * Sample Skeleton for 'Libretto.fxml' Controller Class
 */

package it.polito.tdp.libretto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LibrettoController {
	
	LibrettoModel model; // creo anche il setModel

    /**
	 * @param model the model to set
	 */
	public void setModel(LibrettoModel model) {
		this.model = model;
	}

	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtCodice"
    private TextField txtCodice; // Value injected by FXMLLoader

    @FXML // fx:id="txtTitolo"
    private TextField txtTitolo; // Value injected by FXMLLoader

    @FXML // fx:id="txtDocente"
    private TextField txtDocente; // Value injected by FXMLLoader

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="btnCerca"
    private Button btnCerca; // Value injected by FXMLLoader

    @FXML // fx:id="txtMessage"
    private TextArea txtMessage; // Value injected by FXMLLoader

    @FXML
    void handleCerca(ActionEvent event) {
    	
    	String codice = txtCodice.getText();
    	
    	if(codice.length()<5){
    		txtMessage.appendText("Codice non valido\n");
    		return;
    	}
    	Esame e = model.trovaEsame(codice);
    	
    	if(e == null){
    		txtMessage.appendText("Codice non trovato\n");
    	} else {
    		txtMessage.appendText("Codice "+codice+" trovato\n");
    		
    		txtCodice.setText(e.getCodice());
    		txtTitolo.setText(e.getTitolo());
    		txtDocente.setText(e.getDocente());
    	}

    }

    @FXML
    void handleInserisci(ActionEvent event) {
    	
    	/* prima verifico se la richiesta è legittima: controllo se i dati dell'interfaccia sono validi
    	 * poi chiedo al Model di effettuare l'operazione (IMPORTANTISSIMO)
    	 * poi aggiorno la vista col risultato dell'operazione
    	 */

    	/* come fa il modello ad interagire con la vista? potrei crearlo Model = new...errato!
    	 * dichiaro Model model, ma dichiaro un setModel così il Main mi dice con quale modello sto interagendo
    	 */
    	
    	// recupero dati
    	
    	String codice = txtCodice.getText();
    	String titolo = txtTitolo.getText();
    	String docente = txtDocente.getText();
    	
    	txtCodice.clear();
		txtTitolo.clear();
		txtDocente.clear();
    	
    	// validità dati
    	
    	if(codice.length()<5 || titolo.length()==0 || docente.length()==0){
    		// lo dico all'utente
    		
    		txtMessage.appendText("Dati esame insufficienti\n");
    		
    		
    		
    		// e mi rifiuto di andare avanti
    		
    		return;
    	}
    	
    	// effettuo l'operazione
    	
    	Esame e = new Esame(codice, titolo, docente);
    	
    	boolean result = model.addEsame(e);
    	
    	// aggiorno l'utente di cosa é successo
    	
    	if(result == true){
    		txtMessage.appendText("Esame aggiunto correttamente\n");
    	} else {
    		txtMessage.appendText("Esame non aggiunto (codice duplicato)\n");
    	}
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtMessage != null : "fx:id=\"txtMessage\" was not injected: check your FXML file 'Libretto.fxml'.";

    }
}

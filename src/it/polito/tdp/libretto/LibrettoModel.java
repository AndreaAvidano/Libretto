package it.polito.tdp.libretto;

import java.util.*;

public class LibrettoModel {

	private List<Esame> listaEsami;
	
	public LibrettoModel() {
		this.listaEsami = new LinkedList<Esame>();
	}
	
	/* a differenza di Lamberti aggiungo direttamente l'esame, quindi dovrò definirlo nella classe Controller
	 * Comunque verifico prima che non ci sia l'esame
	 */
	public boolean addEsame(Esame e){ // devo far sapere all'utente se son riuscito o no ad aggiungerlo: boolean
		
		if(!listaEsami.contains(e)) {
			// se passo il mouse sopra contains vedo che esso usa il metodo equals, quindi ho fatto bene a crearlo
		listaEsami.add(e);
		return true;
		} return false;
	}
	
	// cerca (se esiste) un esame da un codice e lo restituisce, altrimenti restituisce null	
	public Esame trovaEsame(String codice){
		
		/*for(Esame e : listaEsami){
			if(e.getCodice().compareTo(codice)==0)
				return e;
		} return null;                     
		
		potrei farlo così, però ho scritto 4 righe di codice. Meglio usare l'indexof e vedere se c'é 
		o no l'esame che ha quel codice: creo un esame temporaneo con quel codice e vedo se é uguale 
		a uno presente nella mia lista di esami...
		
		*/
		
		int pos = listaEsami.indexOf(new Esame(codice, null, null));
		if(pos == -1)
			return null;
		return listaEsami.get(pos);
	}
	
}

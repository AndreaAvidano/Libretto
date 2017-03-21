package it.polito.tdp.libretto;

import java.time.LocalDate;

/* Oggetto semplice che contiene i dati ad un singolo esame
 * 
 * dati privati (proprietà)**
 * costruttore
 * get/set methods
 * metodi di servizio = toString(), equals(...), compareTo(...), hashCode()
 * 
 */

public class Esame {
	
	private String codice;
	private String titolo;
	// private Docente docente;  		so che é giusto, ma per ora lo faccio con la stringa (prof dixit)
	private String docente;
	private boolean superato;
	private int voto;
	private LocalDate dataSuperamento; // importo il package java.time che é molto utile
	
	/**
	 * 
	 * Nuovo esame, non ancora superato, creato dal costruttore
	 * @param codice dell'esame
	 * @param titolo denominazione del corso
	 * @param docente cognome e nome del docente titolare
	 */
	public Esame(String codice, String titolo, String docente) {
		this.codice = codice;
		this.titolo = titolo;
		this.docente = docente;
		this.superato = false;
	}

	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * @param codice the codice to set
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * @param titolo the titolo to set
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * @return the docente
	 */
	public String getDocente() {
		return docente;
	}

	/**
	 * @param docente the docente to set
	 */
	public void setDocente(String docente) {
		this.docente = docente;
	}

	/**
	 * @return the superato
	 */
	public boolean isSuperato() {
		return superato;
	}

	/**
	 * @param superato the superato to set
	 */
	public void setSuperato(boolean superato) {
		this.superato = superato;
	}

	/**
	 * @return the voto solo se l'esame é stato superato, altrimenti genero un'eccezione
	 */
	public int getVoto() {
		if(this.superato)
		return voto;
		throw new IllegalStateException("Esame non ancora superato\n");
	}

	/**
	 * @param voto the voto to set
	 */
	private void setVoto(int voto) {
		this.voto = voto;
	}

	/**
	 * @return the dataSuperamento
	 */
	public LocalDate getDataSuperamento() {
		if(this.superato)
		return dataSuperamento;
		throw new IllegalStateException("Esame non ancora superato\n");
	}

	/**
	 * @param dataSuperamento the dataSuperamento to set
	 */
	private void setDataSuperamento(LocalDate dataSuperamento) {
		this.dataSuperamento = dataSuperamento;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Esame [codice=" + codice + ", titolo=" + titolo + ", docente=" + docente + ", superato=" + superato
				+ ", voto=" + voto + ", dataSuperamento=" + dataSuperamento + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		return result;
	}
	
	/* Le liste (o mappe) hanno già il metodo equals (contains, indexOf) però confrontano l'indirizzo di memoria:
	 * se due oggetti non hanno lo stesso indirizzo di memoria, anche se hanno gli attributi identici,
	 * vengono differiti. Allora lo creo io e gli dico che un esame é uguale a un altro esame se hanno
	 * lo stesso codice
	 */
	

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}
	
	/* definisco un metodo che mi modifica in una volta sola il superamento, il voto e la data
	 * se l'esame non é ancora superato, mette voto e data
	 * se l'esame é già stato registrato superato allora genero un errore
	 * 
	 * così dichiaro private i metodi di set
	 */
	
	public void supera(int voto, LocalDate data){
		
		if(! this.superato){
			this.superato = true;
			this.voto = voto;
			this.dataSuperamento = data;
		} else{
			// scateno eccezione!
			throw new IllegalStateException("Esame "+this.codice+" già superato\n");
		}
	}
	

	
	
}

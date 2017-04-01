package it.polito.tdp.libretto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.libretto.Esame;

public class EsameDAO {
	
	// la classe DAO é l'unica classe che fa tutte le query
	
	public Esame find(String codice){
		
		String sql = "SELECT codice, titolo, docente, superato, voto, data_superamento "+
						"FROM esame "+
				
						// "WHERE codice = '"+codice+"'";     non mettere ' "+codice+" ' perché ho problemi di sicurezza
						
						"WHERE codice = ? "; // gli metto il ? e uso preparedStatement
		
		// posso ora aprire una connessione ed eseguire questa query
		
		String jdbcURL = "jdbc:mysql://localhost/libretto?user=root";
		
		Esame result = null;
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			
			// non uso più Statement ma PreparedStatement
			
			PreparedStatement st = conn.prepareStatement(sql);
			
			// rimpiazzo il ? con un valore specifico
			
			st.setString(1, codice);
			
			// eseguo la query
			
			ResultSet res = st.executeQuery();
			
			if(res.next()){
				// posizionami sulla prima riga, ma la prima riga c'era? se non c'é il res set é vuoto e posso ritornare null
				// se invece c'é costruisco l'oggetto Esame
				
				Esame ex = new Esame(res.getString("codice"), res.getString("titolo"), res.getString("docente"));
				
				result = ex;
			
			} else {
				result = null; // TODO
			}
			
			conn.close();
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}

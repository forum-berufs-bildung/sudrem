package fbb.sudrem.db;

import java.sql.Timestamp;

import org.jsoup.select.Elements;

/**
 * 
 * @author id
 * 
 * container mit den daten 
 * stadt
 * datum
 * temperatur
 *
 */
public class WetterItem {

	/* daten sind public */
	public String stadt;
	public Timestamp datum;
	public int temp;
	
	
	public String toString() {
		
		return "[" + stadt + "|" + temp + "|" 
				+ SudremDB.ts2Str(datum) + "]";
	}
}

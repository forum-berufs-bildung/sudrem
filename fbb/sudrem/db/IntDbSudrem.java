/**
 * 
 */
package fbb.sudrem.db;

import java.util.ArrayList;

/**
 * @author id
 * 
 * Interface zur DB
 *
 */


public interface IntDbSudrem {

	/**
	 * neuer eintrag in die TBL. aus den gecrawlten daten
	 * 
	 * @param wetter welches in DB geschreiben werden soll
	 * @return autoincremented ID
	 */
	int insert(WetterItem wetter);
	
	/**
	 * ausslesen der daten einer Stadt aus der TBL.
	 * 
	 * @param stadt als String
	 * @return ArrayList mit WetterItems
	 */
	ArrayList<WetterItem> select(String stadt);
}

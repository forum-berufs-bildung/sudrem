package fbb.sudrem.db;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class TestDB {

	public static void main(String[] args) throws SQLException {

		/*
		DBConnection db = new DBConnection();
		db.dbhost = "fbb.dasgoldeneclo.de";
		db.dbuser = "sudrem";
		db.dbname = "sudrem";
		db.dbpass = "2SJ..dsafoiew,,+++67342vaee";

		
		try {
			db.open();
			
			
			if ( ! db.conn.isClosed() )
				System.out.println("DB conn is open");
			
			db.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		SudremDB db = new SudremDB();
		
		WetterItem wi = new WetterItem();
		wi.stadt = "BLN";
		wi.temp = 14;
		wi.datum = new Timestamp(System.currentTimeMillis());
		
		db.insert(wi);
		
		ArrayList<WetterItem> list = db.select("BLN");
		
		for ( WetterItem w : list ) {
			System.out.println(w.toString());
		}
		db.close();
		
	}

}

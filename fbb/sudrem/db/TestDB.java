package fbb.sudrem.db;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import fbb.sudrem.crawler.Crawler;

public class TestDB {

	public static void main(String[] args) throws SQLException {

		/*
		DBConnection db = new DBConnection();
		db.dbhost = "fbb.dasgoldeneclo.de";
		db.dbuser = "sudrem";
		db.dbname = "sudrem";
		db.dbpass = "";

		
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
		Crawler tempt = new Crawler();
		WetterItem wi = new WetterItem();
		wi.stadt = "BLN";
		// temp geht von -5 bis 33 Grad
		System.out.println(tempt.maxGrad + "." );
		wi.temp = Integer.parseInt(tempt.maxGrad);
		wi.datum = new Timestamp(System.currentTimeMillis());
		
		//db.insert(wi);
		
		ArrayList<WetterItem> list = db.select("Berlin");
		
		for ( WetterItem w : list ) {
			System.out.println(w.toString());
		}
		db.close();
		
	}

}

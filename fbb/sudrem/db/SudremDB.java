package fbb.sudrem.db;

import java.sql.SQLException;

public class SudremDB extends DBConnection {
	
	
	public SudremDB() throws SQLException {
		
		open();
	}
	
	public void open() throws SQLException {
		
		dbhost = "fbb.dasgoldeneclo.de";
		dbuser = "sudrem";
		dbname = "sudrem";
		dbpass = "2SJ..dsafoiew,,+++67342vaee";

		super.open();
	}
	
	
	
}

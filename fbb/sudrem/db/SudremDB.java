package fbb.sudrem.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SudremDB extends DBConnection implements IntDbSudrem {
	
	
	public SudremDB() throws SQLException {
		
		open();
	}
	
	public void open() throws SQLException {
		
		dbhost = "fbb.dasgoldeneclo.de";
		dbuser = "sudrem";
		dbname = "sudrem";
		dbpass = "";

		super.open();
	}
	
	
	public static final String INSERT_SQL = 
			"INSERT INTO tempera VALUES (0,'#001',#002,'#003')";
	@Override
	public int insert(WetterItem wetter) throws SQLException {
		 
		int id = -1;
		
		String sql = INSERT_SQL.replace("#001", wetter.stadt);
		sql = sql.replace("#002", ""+wetter.temp);
		sql = sql.replace("#003", ts2Str(wetter.datum));
		
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		
		ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()){
            id=rs.getInt(1);
        }
        rs.close();
        stmt.close();
		
		return id;
	}

	public static final String SELECT_SQL = 
			"SELECT * FROM tempera WHERE stadt='#001'";
	
	@Override
	public ArrayList<WetterItem> select(String stadt) throws SQLException {
		
		ArrayList<WetterItem> list = new ArrayList<WetterItem>();
		String sql = SELECT_SQL.replace("#001", stadt);
		
		System.out.println(sql);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while ( rs.next() ) {
			WetterItem wi = new WetterItem();
			wi.stadt = rs.getString("stadt");
			wi.temp = rs.getInt("temperatur");
			wi.datum = rs.getTimestamp("datum");
			list.add(wi);
		}
		
		rs.close();
		stmt.close();
		return list;
	}
	
	
	public static String ts2Str( Timestamp ts) {
		
		
		Date date = new Date();
		date.setTime(ts.getTime());
		String r = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(date);
		
		return r;
	}
	
	public static Timestamp str2Ts( String d ) {
		
//		String format = "yyyy-MM-dd HH:mm:ss.S";
//		DateFormat formatter = new SimpleDateFormat(format);
//		Date date = formatter.parse(d);
		
		Timestamp ts = Timestamp.valueOf(d);
		return ts;
	}
}

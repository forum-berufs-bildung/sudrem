<<<<<<< HEAD
package fbb.sudrem.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

//import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * Holds the credis for connection to DB and the connection
 * @author id
 *
 */
public class DBConnection {

	public Connection conn = null;
	
	public DBConnection() { }

	public String dbuser = null;
	public String dbpass = null;
	public String dbhost = null;
	public String dbname = null;

	public int dbport = 3306;
	
	public void open() throws SQLException {
		
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser(dbuser);
		dataSource.setPassword(dbpass);
		dataSource.setServerName(dbhost);
		dataSource.setDatabaseName(dbname);
		dataSource.setPort(dbport);
		
		conn = dataSource.getConnection();
	}
	

	public void close() throws SQLException {
		if ( conn != null )
			if ( ! conn.isClosed() )
				conn.close();
	}
}
=======
package fbb.sudrem.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 * Holds the credis for connection to DB and the connection
 * @author id
 *
 */
public class DBConnection {

	public Connection conn = null;
	
	public DBConnection() { }

	public String dbuser = null;
	public String dbpass = null;
	public String dbhost = null;
	public String dbname = null;

	public int dbport = 3306;
	
	public void open() throws SQLException {
		
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser(dbuser);
		dataSource.setPassword(dbpass);
		dataSource.setServerName(dbhost);
		dataSource.setDatabaseName(dbname);
		dataSource.setPort(dbport);
		
		conn = dataSource.getConnection();
	}
	

	public void close() throws SQLException {
		if ( conn != null )
			if ( ! conn.isClosed() )
				conn.close();
	}
}
>>>>>>> branch 'master' of https://github.com/forum-berufs-bildung/sudrem.git

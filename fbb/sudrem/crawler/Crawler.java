package fbb.sudrem.crawler;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import fbb.sudrem.db.SudremDB;
import fbb.sudrem.db.WetterItem;


public class Crawler {

	public String maxGrad = "4";

	public Crawler () {
		try {
			
			Document doc = Jsoup.connect("https://www.wetter.com/deutschland/berlin/DE0001020.html").get();
			System.out.println(doc.title());
			Elements stadt = doc.select("title");
			
			maxGrad = doc.select("table tr td span.beta").first().text();
			maxGrad = maxGrad.substring(0, maxGrad.length()-1);
			String minGrad = doc.select("table tr td.text--center span.gamma").first().text();
			
			System.out.println("max Temperatur: " + maxGrad);
			System.out.println("min Temperatur: " + minGrad);
			
			SudremDB db = new SudremDB();
			
			WetterItem wi = new WetterItem();
			wi.stadt = "Berlin";
			// temp geht von -5 bis 33 Grad
			wi.temp = Integer.parseInt(maxGrad);
			wi.datum = new Timestamp(System.currentTimeMillis());
			
			db.insert(wi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		new Crawler();

	}
}

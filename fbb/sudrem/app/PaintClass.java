package fbb.sudrem.app;

import java.awt.Color;
import java.awt.Graphics;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;

import fbb.sudrem.db.SudremDB;
import fbb.sudrem.db.WetterItem;

public class PaintClass extends JPanel {
	SudremDB db;
    public PaintClass() throws SQLException{
        super();
		db = new SudremDB();

    }
    
    public void paint(Graphics g){
		ArrayList<WetterItem> list;
		try {
			
			list = db.select("BLN");
			for (int i = 0; i < list.size() -1; i++) {
				WetterItem w = list.get(i);
				WetterItem w2 = list.get(i + 1);

				if(w.temp < 15) {
					g.setColor(Color.BLUE);
				}else {
					g.setColor(Color.RED);
				}
				g.fillRect(10 * i, 100 - (w.temp * 2), 3, 3);
				g.drawLine(10 * i, 100 - (w.temp * 2), 10 * i +10, 100 - (w2.temp * 2));
				System.out.println(w.toString());
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


    }
    
    public static void main(String[] args){
    	
    }

}

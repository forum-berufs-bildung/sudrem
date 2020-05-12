package fbb.sudrem.app;

import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class App {

 

    
    public static void main(String[] args) throws SQLException {
    
      /* Erzeugung eines neuen Frames mit dem 
        Titel "Wetter vom FBB" */             
     JFrame meinFrame = new JFrame("Wetter vom FBB");
     /* Wir setzen die Breite und die Höhe 
        unseres Fensters auf 200 Pixel */          
     meinFrame.setSize(800,800);
     /* Hinzufügen einer einfachen Komponente  */
     meinFrame.add(new PaintClass());
     // Wir lassen unseren Frame anzeigen
     meinFrame.setVisible(true);
    	
     
     
     
     
    }

}


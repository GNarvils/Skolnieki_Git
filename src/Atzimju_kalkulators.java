import javax.swing.JOptionPane;

public class Atzimju_kalkulators {
   
	public static void main(String[] args) {
		int prieksmeti = Integer.parseInt(JOptionPane.showInputDialog("Cik macibas gribat vertet?"));
		String[] Macibas = new String[prieksmeti];
		int[] svars = new int[prieksmeti];
		String[] skolens = new String[prieksmeti];
		int[][] vertejums = new int[prieksmeti][prieksmeti];
		int[] galaV = new int[prieksmeti];
		for(int i=0; i<=prieksmeti-1; i++){
			Macibas[i] = JOptionPane.showInputDialog("Kads bus prieksmets?");
		}
		int svarigums=100;
		int pags=0;
		
		for(int i=0; i<=prieksmeti-1; i++){
		do{
		    do{
		    svars[i] = Integer.parseInt(JOptionPane.showInputDialog("Kads bus svarigums "+Macibas[i]+" ir iespejami but tik svarigai "+svarigums));
		    }while(svars[i]>svarigums);
		    pags = svarigums;
		    svarigums = svarigums - svars[i];
		    
		    if(svarigums<0 || svarigums>100 ){
		    	svarigums = pags;
		    	}
		}while(svars[i]<0 || svars[i]>100);
		}
		for(int i=0; i<=prieksmeti-1; i++){
			skolens[i] = JOptionPane.showInputDialog("Kads ir skolena vards?");
			for(int j=1; j<=prieksmeti; j++){
			vertejums[i][0] = Integer.parseInt(JOptionPane.showInputDialog("Kads ir vina vertejums "+Macibas[j]));
		}
		}
		
		}

	}



import java.text.DecimalFormat;
import javax.swing.JOptionPane;
public class Atzimju_kalkulators {
	static int skaitsS(int skaits){
		do {
		skaits = Integer.parseInt(JOptionPane.showInputDialog("Kāds būs skolēnu skaits?"));
	    }while(skaits<1);
		return skaits;
	}
	static int skaitsK(int skaits){
		do {
		skaits = Integer.parseInt(JOptionPane.showInputDialog("Kāds būs kritēriju skaits?"));
	    }while(skaits<1);
		return skaits;
	}
	static String[] skoleni(String masivs[]){
		for(int i=0; i<masivs.length; i++) {
			masivs[i] = JOptionPane.showInputDialog("Ievadi "+(i+1)+". studentu");
		}
		return masivs;
	}
	static String[] kriteriji(String masivs[], int i){
		masivs[i] = JOptionPane.showInputDialog("Ievadi "+(i+1)+". kritēriju");
		return masivs;
	}
	static int[] svars(int masivs[], int i, int svars, int sk){
		do {
			masivs[i] = Integer.parseInt(JOptionPane.showInputDialog("Ievadi "+(i+1)+". kritērija svaru"));
		}while(masivs[i]>svars || 
				masivs[i]<1 || 
				(masivs[0]==100 && sk > 1));
		svars -= masivs[i];
		return masivs;
	}
	static int[][] kriterijasV(int masivs[][], int i, int j, String studenti[],String kriteriji[] ){
		do {
			masivs[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Ievadi "+studenti[i]+" vērtējumu par kritēriju "+kriteriji[j]));
		}while(masivs[i][j]<0 || masivs[i][j]>10);
		return masivs;
	}
	static double[] rezultats(String studenti[], String kriteriji[],int kriterijaVertejums[][],int kriterijaSvars[], double[] semestraVertejums){
		double rezultats;
		for(int i=0; i<studenti.length; i++) {
			rezultats=0;
			for(int j=0; j<kriteriji.length; j++) {
				rezultats += ((double) kriterijaSvars[j]/100)*kriterijaVertejums[i][j];
			}
			semestraVertejums[i] = rezultats;
		}
		return semestraVertejums;
	}
	static void izvadit(String studenti[],String kriteriji[],int kriterijaVertejums[][],int kriterijaSvars[],double[] semestraVertejums){
		DecimalFormat df = new DecimalFormat("0.#");
		for(int i=0; i<studenti.length; i++) {	
			for(int j=0; j<kriteriji.length; j++) {
				JOptionPane.showMessageDialog(null, "Studenta "+studenti[i]+" vērtējums par kritēriju "+kriteriji[j]+" ir "+kriterijaVertejums[i][j]+", kura svars ir "+kriterijaSvars[j] );
			}
			JOptionPane.showMessageDialog(null, "Semestra vērtējums ir "+df.format(semestraVertejums[i])+"\n");
		}
	}
	public static void main(String[] args) {                 
		int studSk=0,kritSk=0;
	   studSk = skaitsS(studSk);
	   kritSk = skaitsK(kritSk);
		String[] studenti = new String[studSk];
		String[] kriteriji = new String[kritSk];
		int[] kriterijaSvars = new int[kritSk];
		int[][] kriterijaVertejums = new int[studSk][kritSk];
		double[] semestraVertejums = new double[studSk];		
		skoleni(studenti);
		int maxSvars = 100;
		for(int i=0; i<kriteriji.length; i++) {
			kriteriji(kriteriji, i);
			svars(kriterijaSvars, i, maxSvars, kritSk);
		}
		for(int i=0; i<kriterijaVertejums.length; i++) {
			for(int j=0; j<kriterijaVertejums[i].length; j++) {
				kriterijasV(kriterijaVertejums, i, j, studenti, kriteriji);
			}
		}
		rezultats(studenti, kriteriji, kriterijaVertejums, kriterijaSvars, semestraVertejums);
		izvadit(studenti, kriteriji, kriterijaVertejums, kriterijaSvars, semestraVertejums);		
}
}
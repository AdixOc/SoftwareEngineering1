public class Bezahlautomat_Parkhaus {
	
	private int bP; // basisPreis
	private int sP; // stundenPreis
	private int limit; // Limit des Preises
	
	public Bezahlautomat_Parkhaus(int bP, int sP, int limit) {
		this.bP = bP;
		this.sP = sP;
		this.limit = limit;
	}
	
	public int getbP() {
		return bP;
	}
	
	public int getsP() {
		return sP;
	}
	
	public int getLimit() {
		return limit;
	}
	
	public int berechne(int stunden) { // Minuten spielen keine Rolle
		System.out.println("Ihr Ticket wird nun berechnet.. Bitte warten");
		if(stunden<0) {
			System.out.println("Ein Fehler ist aufgetreten! ");
			return 0;
		}
		
		int finalP = bP;
		finalP = finalP + sP*stunden;
		if(finalP > limit) {
			System.out.println("Das Limit wurde erreicht. Ihr Betrag liegt bei " + limit); 
			return limit;
		} else {
			System.out.println("Ihr Betrag liegt bei " + finalP);
			return finalP;
		}
	}
}


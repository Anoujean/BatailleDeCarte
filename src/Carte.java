
public class Carte {
	
	private String couleur;
	private int valeur;
	
	public Carte(String couleur, int valeur) {
		this.couleur = couleur;
		this.valeur = valeur;
	}

	public int getValeur() {
		return valeur;
	}
	
	public void changeCarte(String couleur, int valeur) {
		this.valeur = valeur;
		this.couleur = couleur;
	}
	
	public boolean isBigger (Carte uneCarte) {
		boolean isBig = false;
		
		if (this.valeur > uneCarte.getValeur()) {
			isBig = true;
		}
		
		return isBig;
	}
	
	public boolean isEqual(Carte uneCarte) {
		boolean isEq = false;
		
		if (this.valeur == uneCarte.getValeur()) {
			isEq = true;
		}
		
		return isEq;
	}

	@Override
	public String toString() {
		String result = "";
		
		if (this.valeur == 11) {
			result += "Valet";
		}
		else if (this.valeur == 12) {
			result += "Dame";
		}
		else if (this.valeur == 13) {
			result += "Roi";
		}
		else if (this.valeur == 1) {
			result += "As";
		}
		else {
			result += this.valeur;
		}
		
		result += " de "+this.couleur;
		
		return result;
	}
	
	
	

}

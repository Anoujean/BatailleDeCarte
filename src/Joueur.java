import java.util.ArrayList;

public class Joueur {
	
	private ArrayList<Carte> lesCartes;
	private int points;
	
	public Joueur() {
		super();
		this.lesCartes = new ArrayList<>();
		this.points = 0;
	}

	public ArrayList<Carte> getLesCartes() {
		return lesCartes;
	}

	public int getPoints() {
		return points;
	}
	
	public Carte tirerCarte(int rang) {
		return this.lesCartes.get(rang);
	}
	
	public void enleverCarte(Carte uneCarte) {
		this.lesCartes.remove(uneCarte);
	}
	
	
	public void ajouterCarte(Carte uneCarte) {
		this.lesCartes.add(uneCarte);
	}
	
	public void ajouterPoint() {
		this.points++;
	}
	
}

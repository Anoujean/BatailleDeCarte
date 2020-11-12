import java.util.ArrayList;
import java.util.Collections;

public class Bataille {

	public static void main(String[] args) {
		//Definition du tableau de couleur ainsi que de la list de carte
		String[] lesCouleurs = {"coeur", "pique", "carreau", "trèfle"};
		ArrayList<Carte> paquetDeCarte = new ArrayList<>();
		
		//création du paquet de carte
		for (int i = 0; i < lesCouleurs.length; i++) {
			for (int j = 1; j < 14; j++) {
				paquetDeCarte.add(new Carte(lesCouleurs[i], j));
			}
		}
		//affichage du paquet de carte
		System.out.println(paquetDeCarte);
		
		//mélange du paquet de carte
		Collections.shuffle(paquetDeCarte);
		
		//création des deux joueurs
		Joueur j1 = new Joueur();
		Joueur j2 = new Joueur();
		
		//distribution des cartes pour les deux joueurs
		for (int k = 0; k < paquetDeCarte.size(); k+=2) {
			j1.ajouterCarte(paquetDeCarte.get(k));
			j2.ajouterCarte(paquetDeCarte.get(k+1));
		}
		
		//mise en place d'un compteur de paquet de carte
		int compteur = 0;
		
		//Tant que la taille des deux paquets sont inférieurs au compteur, nous allons tirer deux cartes de chaques paquet et vérifier laquelle est la plus grande.
		//Le joueur ayant la carte la plus petite récupère sa carte et celle du joueur adverse et le joueur ayant la plus grande carte gagne un point.
		//Dans le cas d'une égalité aucune carte n'est replacé et aucun point n'est attribué
		while (compteur < j1.getLesCartes().size() && compteur < j2.getLesCartes().size()) {
			System.out.println(">>> "+compteur+"\n Joueur 1 joue "+j1.tirerCarte(compteur)+" et Joueur 2 joue "+j2.tirerCarte(compteur));
			if (j1.tirerCarte(compteur).isBigger(j2.tirerCarte(compteur))) {
				j1.ajouterPoint();
				j2.ajouterCarte(j2.tirerCarte(compteur));
				j2.ajouterCarte(j1.tirerCarte(compteur));
				System.out.println("Joueur 1 gagne 1 point et joueur 2 récupère : '"+j1.tirerCarte(compteur)+"' et remet '"+j2.tirerCarte(compteur)+"' dans son paquet");
			}
			else if(j1.tirerCarte(compteur).isEqual(j2.tirerCarte(compteur))) {
				System.out.println("Aucun points gagné par les joueurs");
			}
			else {
				j2.ajouterPoint();
				j1.ajouterCarte(j1.tirerCarte(compteur));
				j1.ajouterCarte(j2.tirerCarte(compteur));
				System.out.println("Joueur 2 gagne 1 point et joueur 1 récupère : "+j2.tirerCarte(compteur)+"' et remet '"+j1.tirerCarte(compteur)+"' dans son paquet");
			}
			System.out.println("Joueur 1 a : "+j1.getPoints()+" points");
			System.out.println("Joueur 2 a : "+j2.getPoints()+" points");
			compteur++;
		}
		
		//déclaration du vainqueur
		if (j1.getPoints() > j2.getPoints()) {
			System.out.println("\n >>> Le Joueur 1 gagne ("+j1.getPoints()+"pts) contre le Joueur 2 ("+j2.getPoints()+"pts)");
		}
		else if(j1.getPoints() == j2.getPoints()) {
			System.out.println("\n >>> Le Joueur 1 ("+j1.getPoints()+"pts) et le Joueur 2 ("+j2.getPoints()+"pts) sont à égalité");
		}
		else {
			System.out.println("\n >>> Le Joueur 2 gagne ("+j2.getPoints()+"pts) contre le Joueur 1 ("+j1.getPoints()+"pts)");
		}

	}

}

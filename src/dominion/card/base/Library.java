package dominion.card.base;
import dominion.Player;
import dominion.card.ActionCard;

/**
 * Carte Bibliothèque (Library)
 * 
 * Piochez jusqu'à ce que vous ayez 7 cartes en main. Chaque carte Action piochée peut être mise de côté. Défaussez les cartes mises de côté lorsque vous avez terminé de piocher.
 */
public class Library extends ActionCard {

	public Library() {
		super("Bibliotheque", 5);
	}

	@Override
	public void play(Player p) {
		//TODO
	}
}
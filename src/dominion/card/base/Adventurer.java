package dominion.card.base;
import dominion.Player;
import dominion.card.ActionCard;

/**
 * Carte Aventurier (Adventurer)
 * 
 * Dévoilez des cartes de votre deck jusqu'à ce que 2 cartes Trésor soient dévoilées. Ajoutez ces cartes Trésor à votre main et défaussez les autres cartes dévoilées.
 */
public class Adventurer extends ActionCard {

	public Adventurer() {
		super("Aventurier", 6);
	}

	@Override
	public void play(Player p) {
		//TODO
	}
}
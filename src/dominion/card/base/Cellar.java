package dominion.card.base;
import dominion.Player;
import dominion.card.ActionCard;

/**
 * Carte Cave (Cellar)
 * 
 * +1 Action.
 * Défaussez autant de cartes que vous voulez.
 * +1 Carte par carte défaussée.
 */
public class Cellar extends ActionCard {

	public Cellar() {
		super("Cave", 2);
	}

	@Override
	public void play(Player p) {
		
	}
}
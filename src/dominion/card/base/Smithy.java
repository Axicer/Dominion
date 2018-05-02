package dominion.card.base;
import dominion.Player;
import dominion.card.ActionCard;

/**
 * Carte Forgeron (Smithy)
 * 
 * +3 Cartes.
 */
public class Smithy extends ActionCard {

	public Smithy() {
		super("Forgeron", 4);
	}

	@Override
	public void play(Player p) {
		for(int i = 0 ; i < 3 ; i++)p.drawCard();
	}
}
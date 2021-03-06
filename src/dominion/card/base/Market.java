package dominion.card.base;
import dominion.Player;
import dominion.card.ActionCard;

/**
 * Carte Marché (Market)
 * 
 * +1 Carte.
 * +1 Action.
 * +1 Achat.
 * +1 Pièce.
 */
public class Market extends ActionCard {

	public Market() {
		super("Market", 5);
	}

	@Override
	public void play(Player p) {
		p.getHand().add(p.drawCard());
		p.incrementActions(1);
		p.incrementBuys(1);
		p.incrementMoney(1);
	}
}
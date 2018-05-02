package dominion.card.base;
import dominion.Player;
import dominion.card.ActionCard;
import dominion.card.Card;

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
		p.incrementActions(1);
		String carte = p.chooseCard("Choissisez une carte à défausser: ", p.getHand(), true);
		while(carte != ""){
			p.handToDiscard(p.getHand().getCard(carte));
			p.drawCard();
			carte = p.chooseCard("Choissisez une carte à défausser: ", p.getHand(), true);
		}
	}
}
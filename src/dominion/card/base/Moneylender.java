package dominion.card.base;
import dominion.Player;
import dominion.card.ActionCard;
import dominion.card.Card;
import dominion.card.common.Copper;

/**
 * Carte Prêteur sur gages (Moneylender)
 * 
 * Écartez une carte Cuivre de votre main.
 * Dans ce cas, +3 Pièces.
 */
public class Moneylender extends ActionCard {

	public Moneylender() {
		super("Moneylender", 4);
	}

	@Override
	public void play(Player p) {
		Card c = p.getHand().stream().filter(ca -> ca.getClass().equals(Copper.class)).findFirst().orElse(null);
		if(c !=null){	
			p.getGame().getTrashedCards().add(c);
			p.getHand().remove(c);
			p.incrementMoney(3);
		}
	}
}
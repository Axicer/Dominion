package dominion.card.base;
import dominion.Player;
import dominion.card.ActionCard;
import dominion.card.Card;

/**
 * Carte Salle du trône (Throne Room)
 * 
 * Choisissez 1 carte Action de votre main.
 * Jouez-la deux fois.
 */
public class ThroneRoom extends ActionCard {

	public ThroneRoom() {
		super("Salle du trône", 4);
	}

	@Override
	public void play(Player p) {
		//ask for card
		String cardName = p.chooseCard("choisissez une carte", p.getActionCards(), false);
		//get the card
		Card card = p.getHand().getCard(cardName);
		//play twice (one from card and the second from player to draw her)
		p.getHand().remove(card);
		p.getInPlay().add(card);
		for(int i = 0 ; i < 2 ; i ++)card.play(p);
	}
}
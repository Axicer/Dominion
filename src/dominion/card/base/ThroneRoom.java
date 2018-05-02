package dominion.card.base;
import java.util.List;
import java.util.stream.Collectors;

import dominion.Player;
import dominion.card.ActionCard;
import dominion.card.Card;
import dominion.card.CardList;
import dominion.card.CardType;

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
		//get a list of actions cards
		List<Card> cards = p.getHand().stream().filter(c -> c.getTypes().contains(CardType.Action)).collect(Collectors.toList());
		//ask for card
		String cardName = p.chooseCard("choisissez une carte", new CardList(cards), false);
		//get the card
		Card card = p.getHand().getCard(cardName);
		//play twice (one from card and the second from player to draw her)
		card.play(p);
		p.playCard(card);
	}
}
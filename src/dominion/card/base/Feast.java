package dominion.card.base;
import java.util.List;
import java.util.stream.Collectors;

import dominion.Player;
import dominion.card.ActionCard;
import dominion.card.Card;
import dominion.card.CardList;

/**
 * Carte Festin (Feast)
 * 
 * Écartez cette carte.
 * Recevez une carte coûtant jusqu'à 5 Pièces.
 */
public class Feast extends ActionCard {

	public Feast() {
		super("Festin", 4);
	}

	@Override
	public void play(Player p) {
		//get a list of cards corresponding to a cost <= 5
		List<Card> cards = p.getGame().availableSupplyCards().stream().filter(c -> c.getCost()<=5).collect(Collectors.toList());
		//ask for a card
		String cardName = p.chooseCard("choisissez une carte parmi la liste", new CardList(cards), false);
		//get the card
		Card choosen = p.getGame().getFromSupply(cardName);
		
		//remove from supply and gain the card
		p.getGame().removeFromSupply(choosen.getName());
		p.gain(choosen);
		//ajoute la carte à la trashedCards List et la retire de la main
		p.getGame().getTrashedCards().add(this);
		p.getHand().remove(this);
	}
}
package dominion.card.base;
import dominion.Player;
import dominion.card.ActionCard;
import dominion.card.Card;
import dominion.card.CardList;

/**
 * Carte Atelier (Workshop)
 * 
 * Recevez une carte coûtant jusqu'à 4 Pièces.
 */
public class Workshop extends ActionCard {

	public Workshop() {
		super("Workshop", 3);
	}

	@Override
	public void play(Player p) {
		//get a list of cards corresponding to a cost <= 4
		CardList cards = new CardList();
		p.getGame().availableSupplyCards().stream().filter(c -> c.getCost()<=4).forEach(cards::add);
		//ask for a card
		String cardName = p.chooseCard("["+p.getName()+"]> choisissez une carte parmi la liste", new CardList(cards), false);
		//get the card
		Card choosen = p.getGame().getFromSupply(cardName);
		
		//remove from supply and gain the card
		p.getGame().removeFromSupply(choosen.getName());
		p.gain(choosen);
	}
}
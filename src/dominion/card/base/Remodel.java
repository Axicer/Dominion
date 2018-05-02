package dominion.card.base;
import dominion.Player;
import dominion.card.ActionCard;
import dominion.card.Card;
import dominion.card.CardList;

/**
 * Carte Rénovation (Remodel)
 * 
 * Écartez une carte de votre main.
 * Recevez une carte coûtant jusqu'à 2 Pièces de plus que la carte écartée.
 */
public class Remodel extends ActionCard {

	public Remodel() {
		super("Rénovation", 4);
	}

	@Override
	public void play(Player p) {
		String choice = p.chooseCard("choisissez une carte de votre main:", p.getHand(), false);
		Card c = p.getHand().getCard(choice);
		int cost = c.getCost();
		p.getGame().getTrashedCards().add(c);
		p.getHand().remove(c);
		
		//get all cards available
		CardList choices = new CardList();
		p.getGame().availableSupplyCards().stream().filter(ca -> ca.getCost() <= cost+2).forEach(choices::add);
		
		//choose a card
		String choosen = p.chooseCard("choisissez une carte:", choices, false);
		Card choosenCard = choices.getCard(choosen);
		p.getGame().removeFromSupply(choosen);
		p.gain(choosenCard);
	}
}
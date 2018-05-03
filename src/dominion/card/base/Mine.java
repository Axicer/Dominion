package dominion.card.base;
import dominion.Player;
import dominion.card.ActionCard;
import dominion.card.Card;
import dominion.card.CardList;

/**
 * Carte Mine
 * 
 * Écartez une carte Trésor de votre main.
 * Recevez une carte Trésor coûtant jusqu'à 3 Pièces de plus,
 * ajoutez cette carte à votre main.
 */
public class Mine extends ActionCard {

	public Mine() {
		super("Mine", 5);
	}

	@Override
	public void play(Player p) {
		String choosenName = p.chooseCard("choisissez parmi vos carte tresors:", p.getTreasureCards(), false);
		Card choosenCard = p.getTreasureCards().getCard(choosenName);
		int cost = choosenCard.getCost();
		p.getHand().remove(choosenCard);
		p.getGame().getTrashedCards().add(choosenCard);
		
		//get all cards available
		CardList choices = new CardList();
		p.getGame().availableSupplyCards().stream().filter(ca -> ca.getCost() <= cost+3).forEach(choices::add);
		
		//choose a card
		String choosen = p.chooseCard("choisissez une carte:", choices, false);
		Card winchoosenCard = choices.getCard(choosen);
		
		//gain it
		p.getGame().removeFromSupply(choosen);
		p.gainHand(winchoosenCard);
	}
}
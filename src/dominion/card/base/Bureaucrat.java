package dominion.card.base;
import dominion.Player;
import dominion.card.AttackCard;
import dominion.card.Card;

/**
 * Carte Bureaucrate (Bureaucrat)
 * 
 * Recevez une carte Argent; placez-la sur votre deck.
 * Tous vos adversaires dévoilent une carte Victoire et la placent sur leur deck (sinon ils dévoilent leur main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire).
 */
public class Bureaucrat extends AttackCard {

	public Bureaucrat(String name, int cost) {
		super("Bureaucrate", 4);
	}

	@Override
	public void play(Player p) {
		Card c = p.getGame().removeFromSupply("Silver");
		p.getDraw().add(c);
		for(Player o : p.otherPlayers()){
			if(o.getVictoryCards().isEmpty())System.out.println(o.cardsInHand());
			else{
				Card v = o.getHand().getCard(o.chooseCard("Choississez une carte victoire.", o.getVictoryCards(), false));
				System.out.println(v);
				o.getDraw().add(v);
				o.getHand().remove(v);
			}
		}
	}
}

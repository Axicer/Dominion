package dominion.card.base;
import dominion.Player;
import dominion.card.AttackCard;

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
		//TODO
	}
}
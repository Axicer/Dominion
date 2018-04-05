package dominion.card.base;
import dominion.Player;
import dominion.card.AttackCard;

/**
 * Carte Milice (Militia)
 * 
 * 2 Pièces.
 * Tous vos adversaires défaussent leurs cartes de façon à n'avoir que 3 cartes en main.
 */
public class Militia extends AttackCard {

	public Militia() {
		super("milice", 4);
	}

	@Override
	public void play(Player p) {
		//TODO
	}
}
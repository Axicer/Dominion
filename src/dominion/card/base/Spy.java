package dominion.card.base;
import dominion.Player;
import dominion.card.AttackCard;

/**
 * Carte Espion (Spy)
 * 
 * +1 Carte.
 * +1 Action.
 * Tous les joueurs (vous aussi) dévoilent la première carte de leur deck. Vous décidez ensuite si chaque carte dévoilée est défaussée ou replacée sur son deck.
 */
public class Spy extends AttackCard {

	public Spy() {
		super("Espion", 4);
	}

	@Override
	public void play(Player p) {
		//TODO
	}
}
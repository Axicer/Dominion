package dominion.card.base;
import dominion.Player;
import dominion.card.AttackCard;

/**
 * Carte Sorcière (Witch)
 * 
 * +2 Cartes.
 * Tous vos adversaires recoivent une carte Curse.
 */
public class Witch extends AttackCard {

	public Witch() {
		super("Sorciere", 5);
	}

	@Override
	public void play(Player p) {
		//TODO
	}
}
package dominion.card.base;
import dominion.Player;
import dominion.card.ActionCard;

/**
 * Carte Chambre du conseil (Council Room)
 * 
 * +4 Cartes.
 * +1 Achat.
 * Tous vos adversaires piochent 1 carte.
 */
public class CouncilRoom extends ActionCard {

	public CouncilRoom() {
		super("Chambre du conseil", 5);
	}

	@Override
	public void play(Player p) {
		//TODO
	}
}
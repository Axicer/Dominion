package dominion.card.base;
import dominion.Player;
import dominion.card.ActionCard;

/**
 * Carte Salle du trône (Throne Room)
 * 
 * Choisissez 1 carte Action de votre main.
 * Jouez-la deux fois.
 */
public class ThroneRoom extends ActionCard {

	public ThroneRoom() {
		super("Salle du trône", 4);
	}

	@Override
	public void play(Player p) {
		//TODO
	}
}
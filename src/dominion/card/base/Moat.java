package dominion.card.base;
import dominion.Player;
import dominion.card.ReactionCard;

/**
 * Carte Douves (Moat)
 * 
 * +2 Cartes.
 * Lorsqu’un adversaire joue une carte Attaque,
 * vous pouvez dévoiler cette carte de votre main.
 * Dans ce cas, l’Attaque n’a pas d’effet sur vous.
 */
public class Moat extends ReactionCard {

	public Moat() {
		super("Douves", 2);
	}

	@Override
	public void play(Player p) {
		for(int i = 0 ; i < 2 ; i++)p.drawCard();
	}
}
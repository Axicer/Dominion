package dominion.card.base;
import dominion.Player;
import dominion.card.VictoryCard;

/**
 * Carte Jardins (Gardens)
 * 
 * Vaut 1VP pour chaque 10 cartes dans votre deck (arrondi à l'unité inférieure).
 */
public class Gardens extends VictoryCard {

	public Gardens() {
		super("Jardins", 4);
	}

	@Override
	public void play(Player p) {}
	
	public int victoryValue(Player p){
		return p.totalCards().size()/10;
	}
}
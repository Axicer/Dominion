package dominion.card.base;
import dominion.Player;
import dominion.card.ActionCard;

/**
 * Carte Cave (Cellar)
 * 
 * +1 Action.
 * Défaussez autant de cartes que vous voulez.
 * +1 Carte par carte défaussée.
 */
public class Cellar extends ActionCard {

	public Cellar() {
		super("Cellar", 2);
	}

	@Override
	public void play(Player p) {
		//Compteur pour le nombre de cartes à piocher
		int i = 0;
		//On donne au joueur une action supplémentaire
		p.incrementActions(1);
		//On choisit une carte qui est mise sous forme de String
		String carte = p.chooseCard("["+p.getName()+"]> Choissisez une carte à défausser dans la main: ", p.getHand(), true);
		//On boucle jusqu'à ce que la chaîne vide soit renvoyée
		while(!carte.equals("")){
			//La carte choisie passe de la main du joueur à la défausse
			p.handToDiscard(p.getHand().getCard(carte));
			//On incrémente le nombre de cartes à piocher
			i++;
			//On choisit une nouvelle carte
			carte = p.chooseCard("["+p.getName()+"]> Choissisez une carte à défausser dans la main: ", p.getHand(), true);
		}
		//On pioche le nombre de cartes désigné par le compteur
		for(int j = 0; j < i; j++){
			p.getHand().add(p.drawCard());
		}
	}
}
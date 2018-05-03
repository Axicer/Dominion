package dominion.card.base;
import dominion.Player;
import dominion.card.ActionCard;
import dominion.card.Card;

/**
 * Carte Chapelle (Chapel)
 * 
 * Écartez jusqu'à 4 cartes de votre main.
 */
public class Chapel extends ActionCard {

	public Chapel() {
		super("Chapelle", 2);
	}

	@Override
	public void play(Player p) {
		//Création d'un compteur pour limiter la défausse à 4 cartes
		int i = 0;
		//On choisit une carte qui est mise sous forme de String
		String choosenCard = p.chooseCard("["+p.getName()+"]> Choississez une carte à écarter de votre main: ", p.getHand(), true);
		//Boucle tant que l'on a pas défaussé 4 cartes ou tant que la chaîne vide n'est pas renvoyée
		while(!choosenCard.equals("") && i < 4){
			//Conversion du String en une carte
			Card c = p.getHand().getCard(choosenCard);
			//On retire la carte de la main du joueur
			p.getHand().remove(c);
			//On écarte la carte en question
			p.getGame().getTrashedCards().add(c);
			//On choisi une nouvelle carte
			choosenCard = p.chooseCard("["+p.getName()+"]> Choississez une carte à écarter de votre main: ", p.getHand(), true);
			i++;
		}
	}
}
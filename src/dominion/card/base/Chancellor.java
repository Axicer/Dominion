package dominion.card.base;
import java.util.Arrays;
import java.util.List;

import dominion.Player;
import dominion.card.ActionCard;

/**
 * Carte Chancellier (Chancellor)
 * 
 * +2 Pièces.
 * Vous pouvez immédiatement défausser votre deck.
 */
public class Chancellor extends ActionCard {

	public Chancellor() {
		super("Chancellier", 3);
	}

	@Override
	public void play(Player p) {
			//On incrémente la money du joueur de 2
			p.incrementMoney(2);
			//Création d'une liste de choix
			List<String> choices = Arrays.asList("y","n");
			if(p.choose("["+p.getName()+"]> Voulez-vous défausser vote deck ? (y/n)", choices, false).equals("y")){
				//Ajoute toutes les cartes du deck dans la discard
				p.getDiscard().addAll(p.getDraw());
				//Supprime toutes les cartes du deck
				p.getDraw().clear();
			}
	}
}
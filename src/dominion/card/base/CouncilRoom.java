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
		//Le joueur pioche 4 cartes
		for(int i = 0; i < 4; i++)p.drawCard();
		//Ajoute un achat au joueur
		p.incrementBuys(1);
		//Les joueurs adversaires piochent une carte
		for(Player o : p.otherPlayers())o.drawCard();
	}
}
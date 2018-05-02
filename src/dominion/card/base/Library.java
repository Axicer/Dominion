package dominion.card.base;
import java.util.Arrays;
import java.util.List;

import dominion.Player;
import dominion.card.ActionCard;
import dominion.card.Card;
import dominion.card.CardList;

/**
 * Carte Bibliothèque (Library)
 * 
 * Piochez jusqu'à ce que vous ayez 7 cartes en main. Chaque carte Action piochée peut être mise de côté. Défaussez les cartes mises de côté lorsque vous avez terminé de piocher.
 */
public class Library extends ActionCard {

	public Library() {
		super("Bibliotheque", 5);
	}

	@Override
	public void play(Player p) {
		CardList defausse = new CardList();
		while(p.getHand().size() <= 7){
			Card c = p.drawCard();
			System.out.println(c);
			List<String> choices = Arrays.asList("y","n");
			if(p.choose("Voulez-vous garder cette carte ?", choices, false).equals("y")){
				p.getHand().add(c);
			}else{
				defausse.add(c);
			}
		}
		p.getDiscard().addAll(defausse);
	}
}
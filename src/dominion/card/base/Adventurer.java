package dominion.card.base;
import dominion.Player;
import dominion.card.ActionCard;
import dominion.card.Card;
import dominion.card.CardList;
import dominion.card.TreasureCard;

/**
 * Carte Aventurier (Adventurer)
 * 
 * Dévoilez des cartes de votre deck jusqu'à ce que 2 cartes Trésor soient dévoilées. Ajoutez ces cartes Trésor à votre main et défaussez les autres cartes dévoilées.
 */
public class Adventurer extends ActionCard {

	public Adventurer() {
		super("Aventurier", 6);
	}

	@Override
	public void play(Player p) {
		CardList tresor = new CardList();
		CardList defausse = new CardList();
		for(Card c : p.getDraw()){
			if(c instanceof TreasureCard){
				tresor.add(c);
			}else{
				defausse.add(c);
			}
			if(tresor.size() >= 2)break;
		}
		for(Card c : tresor){
			p.gainHand(c);
		}
		for(Card c : defausse){
			p.gain(c);
		}
	}
}
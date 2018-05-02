package dominion.card.base;
import dominion.Player;
import dominion.card.AttackCard;
import dominion.card.Card;

/**
 * Carte Sorcière (Witch)
 * 
 * +2 Cartes.
 * Tous vos adversaires recoivent une carte Curse.
 */
public class Witch extends AttackCard {

	public Witch() {
		super("Sorciere", 5);
	}

	@Override
	public void play(Player p) {
		//draw 2 cards
		for(int i = 0 ; i < 2 ; i++){
			p.drawCard();
		}
		//for each other players get a Curse Card from supply and gain it
		for(Player opl : p.getGame().otherPlayers(p)){
			Card c = p.getGame().removeFromSupply("Curse");
			opl.gain(c);
		}
	}
}
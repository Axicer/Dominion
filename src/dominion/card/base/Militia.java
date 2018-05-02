package dominion.card.base;
import dominion.Player;
import dominion.card.AttackCard;
import dominion.card.Card;
import dominion.events.list.AttackCardSentEvent;

/**
 * Carte Milice (Militia)
 * 
 * 2 Pièces.
 * Tous vos adversaires défaussent leurs cartes de façon à n'avoir que 3 cartes en main.
 */
public class Militia extends AttackCard {

	public Militia() {
		super("milice", 4);
	}

	@Override
	public void play(Player p) {
		p.incrementMoney(2);
		for(Player o : p.getGame().otherPlayers(p)){
			//send attack event
			AttackCardSentEvent event = new AttackCardSentEvent(o);
			p.getGame().getEventManager().sendEvent(event);
			if(event.isCancelled())continue;
			
			while(p.getHand().size() > 3){
				Card first = p.getHand().get(p.getHand().size()-1);
				p.getHand().remove(first);
				p.getDiscard().add(first);
			}
		}
	}
}
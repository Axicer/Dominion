package dominion.card.base;
import dominion.Player;
import dominion.card.AttackCard;
import dominion.card.Card;
import dominion.events.list.AttackCardSentEvent;

/**
 * Carte Bureaucrate (Bureaucrat)
 * 
 * Recevez une carte Argent; placez-la sur votre deck.
 * Tous vos adversaires dévoilent une carte Victoire et la placent sur leur deck (sinon ils dévoilent leur main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire).
 */
public class Bureaucrat extends AttackCard {

	public Bureaucrat() {
		super("Bureaucrate", 4);
	}

	@Override
	public void play(Player p) {
		Card c = p.getGame().removeFromSupply("Silver");
		p.getDraw().add(c);
		for(Player o : p.otherPlayers()){
			//send attack event
			AttackCardSentEvent event = new AttackCardSentEvent(o);
			p.getGame().getEventManager().sendEvent(event);
			if(event.isCancelled())continue;
			
			if(o.getVictoryCards().isEmpty())System.out.println(o.cardsInHand());
			else{
				System.out.println("test");
				Card v = o.getHand().getCard(o.chooseCard("["+o.getName()+"]> Choississez une carte victoire.", o.getVictoryCards(), false));
				System.out.println("["+p.getName()+"]> Carte victoire de "+o.getName()+" devoilée et placée sur le deck: "+v);
				o.getDraw().add(v);
				o.getHand().remove(v);
			}
		}
	}
}

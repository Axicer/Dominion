package dominion.card.base;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dominion.Player;
import dominion.card.AttackCard;
import dominion.card.Card;
import dominion.events.list.AttackCardSentEvent;

/**
 * Carte Espion (Spy)
 * 
 * +1 Carte.
 * +1 Action.
 * Tous les joueurs (vous aussi) dévoilent la première carte de leur deck.
 * Vous décidez ensuite si chaque carte dévoilée est défaussée ou replacée sur son deck.
 */
public class Spy extends AttackCard {

	public Spy() {
		super("Spy", 4);
	}

	@Override
	public void play(Player p) {
		p.getHand().add(p.drawCard());
		p.incrementActions(1);
		List<Player> players = new ArrayList<Player>();
		players.add(p);
		players.addAll(p.getGame().otherPlayers(p));
		for(Player pl : players){ 
			if(!pl.equals(p)){
				//send attack event
				AttackCardSentEvent event = new AttackCardSentEvent(pl);
				p.getGame().getEventManager().sendEvent(event);
				if(event.isCancelled())continue;
			}
			
			Card first = pl.drawCard();
			System.out.println("premiere carte du deck de ["+pl.getName()+"] : "+first);
			List<String> choices = Arrays.asList("y","n");
			String choice = p.choose("["+p.getName()+"]> voulez vous defausser cette carte", choices, true);
			if(choice.equals("y")){
				pl.getDiscard().add(first);
			}else{
				pl.getDraw().add(first);
			}
		}
	}
}
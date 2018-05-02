package dominion.card.base;
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
		super("Espion", 4);
	}

	@Override
	public void play(Player p) {
		p.drawCard();
		p.incrementActions(1);
		List<Player> players = p.getGame().otherPlayers(p);
		players.add(p);
		for(Player pl : players){ 
			if(!pl.equals(p)){
				//send attack event
				AttackCardSentEvent event = new AttackCardSentEvent(pl);
				p.getGame().getEventManager().sendEvent(event);
				if(event.isCancelled())continue;
			}
			
			Card first = pl.getDraw().get(pl.getDraw().size()-1);
			List<String> choices = Arrays.asList("y","n");
			String choice = p.choose("voulez vous defausser cette carte", choices, true);
			if(choice.equals("y")){
				pl.drawToDiscard(first);
			}
		}
	}
}
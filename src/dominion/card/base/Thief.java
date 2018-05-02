package dominion.card.base;
import dominion.Player;
import dominion.card.AttackCard;
import dominion.card.Card;
import dominion.card.CardList;
import dominion.card.CardType;
import dominion.events.list.AttackCardSentEvent;

/**
 * Carte Voleur (Thief)
 * 
 * Tous vos adversaires dévoilent les 2 premières cartes de leur deck.
 * S'ils dévoilent des cartes Trésor, ils en écartent 1 de votre choix.
 * Parmi ces cartes Trésor écartées, recevez celles de votre choix.
 * Les autres cartes dévoilées sont défaussées.
 */
public class Thief extends AttackCard {

	public Thief() {
		super("Voleur", 4);
	}

	@Override
	public void play(Player p) {
		CardList recup = new CardList();
		for(Player opl : p.getGame().otherPlayers(p)){
			//send attack event
			AttackCardSentEvent event = new AttackCardSentEvent(opl);
			p.getGame().getEventManager().sendEvent(event);
			if(event.isCancelled())continue;
			
			CardList treasureCard = new CardList();
			CardList revealedCard = new CardList();
			for(int i = 0 ; i < 2 || i < opl.getDraw().size() ; i++){
				revealedCard.add(opl.getDraw().get(i));
			}
			System.out.println("["+p.getName()+"]> carte révélés de "+opl.getName()+":");
			revealedCard.stream().map(Card::getName).forEach(System.out::println);
			//add all treasure card to treasureCard list
			revealedCard.stream().filter(c -> c.getTypes().contains(CardType.Treasure)).forEach(treasureCard::add);
			//if there is some treasure cards
			if(treasureCard.size() != 0){
				//choose a card
				String choose = p.chooseCard("["+p.getName()+"]> choisissez une carte", treasureCard, false);
				Card choosenCard = treasureCard.getCard(choose);
				//add to the future recup card list
				recup.add(choosenCard);
				//remove from the treasure card list
				treasureCard.remove(choosenCard);
			}
			//discard all remaining cards
			treasureCard.forEach(c -> {
				opl.handToDiscard(c);
			});
		}
	}
}
package dominion.card;

import java.util.List;

/**
 * Les cartes Réaction
 * Rmq: les cartes Réaction sont toutes des cartes Action
 */
public abstract class ReactionCard extends ActionCard {

	public ReactionCard(String name, int cost) {
		super(name, cost);
	}
	
	@Override
	public List<CardType> getTypes() {
		List<CardType> types = super.getTypes();
		types.add(CardType.Reaction);
		return types;
	}
}
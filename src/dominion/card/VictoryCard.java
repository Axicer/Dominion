package dominion.card;

import java.util.List;

/**
 * Les cartes Victoire
 */
public abstract class VictoryCard extends Card {

	public VictoryCard(String name, int cost) {
		super(name, cost);
	}
	
	@Override
	public List<CardType> getTypes() {
		List<CardType> types = super.getTypes();
		types.add(CardType.Victory);
		return types;
	}
}
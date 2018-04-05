package dominion.card;

import java.util.List;

/**
 * Les cartes Malédiction
 */
public abstract class CurseCard extends Card {

	public CurseCard(String name, int cost) {
		super(name, cost);
	}
	
	@Override
	public List<CardType> getTypes() {
		List<CardType> types = super.getTypes();
		types.add(CardType.Curse);
		return types;
	}
}
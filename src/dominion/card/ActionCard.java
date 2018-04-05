package dominion.card;

import java.util.List;

/**
 * Les cartes Action
 */
public abstract class ActionCard extends Card {

	public ActionCard(String name, int cost) {
		super(name, cost);
	}
	
	@Override
	public List<CardType> getTypes() {
		List<CardType> types = super.getTypes();
		types.add(CardType.Action);
		return types;
	}
}
package dominion.card;

import java.util.List;

/**
 * Les cartes Attaque
 * Rmq: les cartes Attaque sont toutes des cartes Action
 */
public abstract class AttackCard extends ActionCard {

	public AttackCard(String name, int cost) {
		super(name, cost);
	}
	
	@Override
	public List<CardType> getTypes() {
		List<CardType> list = super.getTypes();
		list.add(CardType.Attack);
		return list;
	}
}
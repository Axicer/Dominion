package dominion.events.list;

import dominion.Player;
import dominion.events.AbstractEvent;

public class AttackCardSentEvent extends AbstractEvent {
	
	private boolean cancelled;
	private Player target;
	
	public AttackCardSentEvent(Player target) {
		this.cancelled = false;
		this.target = target;
	}

	public boolean isCancelled() {
		return this.cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public Player getTarget() {
		return target;
	}

	public void setTarget(Player target) {
		this.target = target;
	}
	
}

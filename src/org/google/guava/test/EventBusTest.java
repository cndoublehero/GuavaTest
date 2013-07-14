package org.google.guava.test;

import org.junit.Test;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class EventBusTest {

	public class ChangeEvent {
		private String chageReason;

		public ChangeEvent(String chageReason, String changeType) {
			super();
			this.chageReason = chageReason;
			this.changeType = changeType;
		}

		private String changeType;

		public String getChageReason() {
			return chageReason;
		}

		public void setChageReason(String chageReason) {
			this.chageReason = chageReason;
		}

		public String getChangeType() {
			return changeType;
		}

		public void setChangeType(String changeType) {
			this.changeType = changeType;
		}
	}

	public class EventBusChangeRecorder {
		@Subscribe
		public void processChage(ChangeEvent event) {
			System.out.println(event.getChageReason());
		}
	}

	@Test
	public void testObserve() {
		EventBus bus = new EventBus();
		bus.register(new EventBusChangeRecorder());
		bus.post(new ChangeEvent("wrong", "0010"));
		bus.post(new ChangeEvent("", "0011"));
		bus.post(new ChangeEvent(null, null));
		
	}
}

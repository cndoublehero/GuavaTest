package org.google.guava.test;

import org.junit.Test;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import static org.junit.Assert.*;

public class EventBusTest2 {

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

	public class EventBusChangeRecorder1 {
		@Subscribe
		public void processChage(ChangeEvent event) {
			System.out.println("name==" + event.getChageReason());
		}
	}

	public class EventBusChangeRecorder2 {
		@Subscribe
		public void processChage(ChangeEvent event, String value) {
			System.out.println("name==" + event.getChageReason());
		}
	}

	@Test
	public void testObserve() {
		EventBus bus = new EventBus();
		bus.register(new EventBusChangeRecorder());
		EventBusChangeRecorder1 handler = new EventBusChangeRecorder1();
		bus.register(handler);
		try {
			bus.register(new EventBusChangeRecorder2());
			fail("canot be here");
		} catch (IllegalArgumentException e) {
		}
		bus.post(new ChangeEvent("wrong", "0010"));
		bus.post(new ChangeEvent("", "0011"));
		bus.post(new ChangeEvent(null, null));
		try {
			bus.unregister(null);
			fail("canot be here");
		} catch (Exception e) {
		}
		bus.register("s");
		bus.unregister("ss");
		bus.unregister(handler);		
		bus.post(new ChangeEvent("wrong", "0010"));
		bus.post(new ChangeEvent("", "0011"));
		bus.post(new ChangeEvent(null, null));
		try {
			bus.unregister(new EventBusChangeRecorder1());
			fail("canot be here");
		} catch (Exception e) {
		}
	}
}

package com.garak.ingestor.conf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EventRuleVO {
	
	private String eventId;
	private String eventName;
	private float upperlimit;
	private float underlimit;
	
	private String eventDescription;
	
	@Override
	public int hashCode() {
		return this.eventId.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		EventRuleVO other = (EventRuleVO) obj;
		if (this.eventId == null) {
			if (other.eventId != null) {
				return false;
			}
		}
		else if (!this.eventId.equals(other.eventId)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "event [eventId=" + this.eventId + ", eventName=" + this.eventName + "]";
	}
}

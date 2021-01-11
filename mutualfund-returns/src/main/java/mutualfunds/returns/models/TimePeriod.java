package mutualfunds.returns.models;

import java.time.LocalDate;

public class TimePeriod {

	private LocalDate start;

	private LocalDate end;

	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}

}

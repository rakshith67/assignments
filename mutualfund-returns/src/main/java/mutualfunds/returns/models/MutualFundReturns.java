package mutualfunds.returns.models;

import java.time.LocalDate;

public class MutualFundReturns {

	private LocalDate month;

	private double returns;

	private TimePeriod period;

	public LocalDate getMonth() {
		return month;
	}

	public void setMonth(LocalDate month) {
		this.month = month;
	}

	public double getReturns() {
		return returns;
	}

	public void setReturns(double returns) {
		this.returns = returns;
	}

	public TimePeriod getPeriod() {
		return period;
	}

	public void setPeriod(TimePeriod period) {
		this.period = period;
	}

}

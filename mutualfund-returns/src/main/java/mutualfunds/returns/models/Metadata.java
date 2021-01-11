package mutualfunds.returns.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Metadata {

	@JsonProperty("fund_house")
	private String fundHouse;

	@JsonProperty("scheme_type")
	private String schemeType;

	@JsonProperty("scheme_category")
	private String schemeTategory;

	@JsonProperty("scheme_code")
	private String schemeCode;

	@JsonProperty("scheme_name")
	private String schemeName;

	public String getFundHouse() {
		return fundHouse;
	}

	public void setFundHouse(String fundHouse) {
		this.fundHouse = fundHouse;
	}

	public String getSchemeType() {
		return schemeType;
	}

	public void setSchemeType(String schemeType) {
		this.schemeType = schemeType;
	}

	public String getSchemeTategory() {
		return schemeTategory;
	}

	public void setSchemeTategory(String schemeTategory) {
		this.schemeTategory = schemeTategory;
	}

	public String getSchemeCode() {
		return schemeCode;
	}

	public void setSchemeCode(String schemeCode) {
		this.schemeCode = schemeCode;
	}

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

}

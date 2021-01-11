package web.scrapper.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ErrorResponse {
	private String code = null;

	private String message = null;

	private String traceid = null;

	private String link = null;

	private List<Parameter> responseParameter = null;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTraceid() {
		return traceid;
	}

	public void setTraceid(String traceid) {
		this.traceid = traceid;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public ErrorResponse responseParameter(List<Parameter> responseParameter) {
		this.responseParameter = responseParameter;
		return this;
	}

	public ErrorResponse addResponseParameterItem(Parameter responseParameterItem) {
		if (this.responseParameter == null) {
			this.responseParameter = new ArrayList<>();
		}
		this.responseParameter.add(responseParameterItem);
		return this;
	}

	public List<Parameter> getResponseParameter() {
		return responseParameter;
	}

	public void setResponseParameter(List<Parameter> responseParameter) {
		this.responseParameter = responseParameter;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ErrorResponse errorResponse = (ErrorResponse) o;
		return Objects.equals(this.code, errorResponse.code) && Objects.equals(this.message, errorResponse.message)
				&& Objects.equals(this.traceid, errorResponse.traceid) && Objects.equals(this.link, errorResponse.link)
				&& Objects.equals(this.responseParameter, errorResponse.responseParameter);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, message, traceid, link, responseParameter);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ErrorResponse {\n");

		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    message: ").append(toIndentedString(message)).append("\n");
		sb.append("    traceid: ").append(toIndentedString(traceid)).append("\n");
		sb.append("    link: ").append(toIndentedString(link)).append("\n");
		sb.append("    responseParameter: ").append(toIndentedString(responseParameter)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}

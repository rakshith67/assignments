package todo.list.application;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class CustomConfiguration extends Configuration {

	@NotNull
	private int timeout;

	@NotNull
	private String cluster;

	@NotNull
	private String bucket;

	@JsonCreator
	public CustomConfiguration(@JsonProperty("timeout") int timeout, @JsonProperty("cluster") String cluster,
			@JsonProperty("bucket") String bucket) {
		this.timeout = timeout;
		this.cluster = cluster;
		this.bucket = bucket;
	}

	public int getTimeout() {
		return timeout;
	}

	public String getCluster() {
		return cluster;
	}

	public String getBucket() {
		return bucket;
	}

}

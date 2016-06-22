package com.test.dropwizard;

import java.util.Collections;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

public class DropwizardTestAppConfiguration extends Configuration {
	// TODO: implement service configuration
	
	@Valid
	@NotNull
	@JsonProperty
	private DataSourceFactory database = new DataSourceFactory();
	
	@NotNull
	@JsonProperty
	private Map<String, Map<String, String>> views = Collections.emptyMap();

	public DataSourceFactory getDatabase() {
		return database;
	}

	public void setDatabase(DataSourceFactory database) {
		this.database = database;
	}

	public Map<String, Map<String, String>> getViews() {
		return views;
	}

	public void setViews(Map<String, Map<String, String>> views) {
		this.views = views;
	}

}

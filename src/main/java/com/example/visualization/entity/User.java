package com.example.visualization.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long intensity;

public String likelihood;

public String relevance;

public String end_year;

private String country;

private String topic;

private String region;

private String city;
public User() {
	// TODO Auto-generated constructor stub
}


public User(long intensity, String likelihood, String relevance, String end_year, String country, String topic,
		String region, String city) {
	super();
	this.intensity = intensity;
	this.likelihood = likelihood;
	this.relevance = relevance;
	this.end_year = end_year;
	this.country = country;
	this.topic = topic;
	this.region = region;
	this.city = city;
}

public long getIntensity() {
	return intensity;
}

public void setIntensity(long intensity) {
	this.intensity = intensity;
}

public String getLikelihood() {
	return likelihood;
}

public void setLikelihood(String likelihood) {
	this.likelihood = likelihood;
}

public String getRelevance() {
	return relevance;
}

public void setRelevance(String relevance) {
	this.relevance = relevance;
}

public String getEnd_year() {
	return end_year;
}

public void setEnd_year(String end_year) {
	this.end_year = end_year;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String getTopic() {
	return topic;
}

public void setTopic(String topic) {
	this.topic = topic;
}

public String getRegion() {
	return region;
}

public void setRegion(String region) {
	this.region = region;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}




}

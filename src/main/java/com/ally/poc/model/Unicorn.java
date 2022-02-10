package com.ally.poc.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "unicorns")
public class Unicorn {
	
	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	private long unicornId;
	@NotNull
	private String name;
	@NotNull
	private String hairColor;
	@NotNull
	private Integer hornLength;
	@NotNull
	private String hornColor;
	@NotNull
	private String eyeColor;
	@NotNull
	private Integer height;
	@NotNull
	private String heightUnit;
	@NotNull
	private Integer weight;
	@NotNull
	private String weightUnit;
	@NotNull
	private List<IdentifiableMark> identifiableMarks;
	public long getUnicornId() {
		return unicornId;
	}
	public void setUnicornId(long unicornId) {
		this.unicornId = unicornId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHairColor() {
		return hairColor;
	}
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	public Integer getHornLength() {
		return hornLength;
	}
	public void setHornLength(Integer hornLength) {
		this.hornLength = hornLength;
	}
	public String getHornColor() {
		return hornColor;
	}
	public void setHornColor(String hornColor) {
		this.hornColor = hornColor;
	}
	public String getEyeColor() {
		return eyeColor;
	}
	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public String getHeightUnit() {
		return heightUnit;
	}
	public void setHeightUnit(String heightUnit) {
		this.heightUnit = heightUnit;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getWeightUnit() {
		return weightUnit;
	}
	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}
	public List<IdentifiableMark> getIdentifiableMarks() {
		return identifiableMarks;
	}
	public void setIdentifiableMarks(List<IdentifiableMark> identifiableMarks) {
		this.identifiableMarks = identifiableMarks;
	}
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}
	
	
	
	
}

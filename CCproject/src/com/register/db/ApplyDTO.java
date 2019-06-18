package com.register.db;

import java.time.LocalDateTime;

public class ApplyDTO {
	private String id;
	private String gender;
	private String college;
	private String hometown;
	private String age;
	private String minheight;
	private String maxheight;
	private String interesting;
	private String character;
	private LocalDateTime time; 

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMinheight() {
		return minheight;
	}
	public void setMinheight(String minheight) {
		this.minheight = minheight;
	}
	public String getMaxheight() {
		return maxheight;
	}
	public void setMaxheight(String maxheight) {
		this.maxheight = maxheight;
	}
	public String getInteresting() {
		return interesting;
	}
	public void setInteresting(String interesting) {
		this.interesting = interesting;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
}

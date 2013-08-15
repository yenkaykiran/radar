package com.rest.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "host")

public class Host implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlAttribute(name="name")
	private String name;
	
	@XmlElement(name="user")
	private String user;
	
	@XmlElement(name="password")
	private String password;
	
	@XmlElement(name="enabled")
	private boolean enabled;
	
	@XmlElement(name="forhf")
	private boolean forhf;
	
	@XmlElement(name="forxml")
	private boolean forxml;
	
	@XmlElement(name="forprop")
	private boolean forprop;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isForhf() {
		return forhf;
	}

	public void setForhf(boolean forhf) {
		this.forhf = forhf;
	}

	public boolean isForxml() {
		return forxml;
	}

	public void setForxml(boolean forxml) {
		this.forxml = forxml;
	}

	public boolean isForprop() {
		return forprop;
	}

	public void setForprop(boolean forprop) {
		this.forprop = forprop;
	}
}
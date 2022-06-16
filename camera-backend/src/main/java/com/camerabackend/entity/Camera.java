package com.camerabackend.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Camera implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String cameraName;
	private String assignedTo;
	private int cameraModel;
	
	
	
	public Camera() {
		super();
	}
	public Camera(int id, String cameraName, String assignedTo, int cameraModel) {
		super();
		this.id = id;
		this.cameraName = cameraName;
		this.assignedTo = assignedTo;
		this.cameraModel = cameraModel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCameraName() {
		return cameraName;
	}
	public void setCameraName(String cameraName) {
		this.cameraName = cameraName;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public int getCameraModel() {
		return cameraModel;
	}
	public void setCameraModel(int cameraModel) {
		this.cameraModel = cameraModel;
	}
	@Override
	public String toString() {
		return "Camera [id=" + id + ", cameraName=" + cameraName + ", assignedTo=" + assignedTo + ", cameraModel="
				+ cameraModel + "]";
	}
	
}

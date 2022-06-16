package com.camerabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.camerabackend.entity.Camera;

@Repository
public interface CameraRepository extends JpaRepository<Camera, Integer>{
	public Camera findById(int id);
}

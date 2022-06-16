package com.camerabackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camerabackend.entity.Camera;
import com.camerabackend.repository.CameraRepository;

@Service
public class CameraService {
	
	@Autowired
	CameraRepository cameraRepository;
	

	public List<Camera> getAllCamera() {
		return cameraRepository.findAll();
	}

	//Get Camera by Id
	public Camera getCamera(int id) {
		Camera camera = null;
		camera = cameraRepository.findById(id);
		return camera;
	}
	
	
	//Add camera
	public Camera addCamera(Camera camera) {
		cameraRepository.save(camera);
		return camera;
	}

	//Update the camera.
	public Camera updateCamera(Camera camera,int id) {
		Camera cam = null;
		cam =  cameraRepository.getById(id);
		if(cam != null) {
			cam.setCameraName(camera.getCameraName());
			cam.setAssignedTo(camera.getAssignedTo());
			cam.setCameraModel(camera.getCameraModel());
		}
		return cameraRepository.save(cam);
	}

	//Delete camera
	public Camera deleteCamera(int id) {
		Camera cam = null;
		cam =  cameraRepository.getById(id);
		cameraRepository.delete(cam);
		return cam;
	}

}

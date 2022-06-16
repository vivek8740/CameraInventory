package com.camerabackend.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.camerabackend.entity.Camera;
import com.camerabackend.service.CameraService;

@RestController
public class CameraController {
	
	public final Logger log = LoggerFactory.getLogger(CameraController.class);

	@Autowired
	CameraService cameraService;

	@GetMapping(value = "/camera")
	public ResponseEntity<List<Camera>> getAllCameraDetails() {
		log.info("Fetching all camera details.");
		List<Camera> cList = cameraService.getAllCamera();
		if(cList.size() <= 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else
			return ResponseEntity.of(Optional.of(cList));
	}

	@GetMapping(value = "/camera/{id}")
	public ResponseEntity<Camera> getCameraById(@PathVariable("id") int id) {
		log.info("Fetching camera details by Id."+id);
		Camera camera = cameraService.getCamera(id);
		
		if(camera == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else
			return ResponseEntity.of(Optional.of(camera));
	}

	@PostMapping(value = "/camera")
	public ResponseEntity<Optional<Camera>> addCamera(@RequestBody Camera camera) {
		log.info("Adding Camera.");
		Camera cam = null;
		try {
			cam = cameraService.addCamera(camera);
			return ResponseEntity.ok(Optional.of(cam));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@PutMapping(value="/camera/{id}")
	public ResponseEntity<Camera> updateCameraDetail(@RequestBody Camera camera, @PathVariable int id) {
		log.info("Updating Camera.");
		Camera cam = null;
		try {
			cam = cameraService.updateCamera(camera,id);
			ResponseEntity.ok(cam);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@DeleteMapping(value="/camera/{id}")
	public ResponseEntity<Camera> updateCameraDetail(@PathVariable int id) {
		log.info("Deleting Camera.");
		try {
			cameraService.deleteCamera(id);
			ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}

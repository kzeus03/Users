package com.kzeus.Admin.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kzeus.Admin.Service.HotelsService;
import com.kzeus.Admin.entity.Hotels;

@RestController
@RequestMapping("/api")
public class HotelsRestController {

	// inject employee DAO directly (ill-advised manner)
	private HotelsService hotelsService;

	@Autowired // constructor injection
	public HotelsRestController(HotelsService theHotelsService) {
		hotelsService = theHotelsService;
	}

	@GetMapping("/hotels") // read all employees
	public List<Hotels> findAll() {
		return hotelsService.findAll();
	}

	// read single hotel
	@GetMapping("/hotels/{hotelsId}")
	public Hotels getHotel(@PathVariable int hotelsId) {
		Hotels hotel = hotelsService.findById(hotelsId);
		if(hotel==null) {
			throw new RuntimeException("Hotel not found");
		}
		return hotel;
	}
	
	
	
}

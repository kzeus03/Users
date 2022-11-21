package com.kzeus.Admin.Service;

import java.util.List;
import com.kzeus.Admin.entity.Hotels;

public interface HotelsService {

	public List<Hotels> findAll();

	public Hotels findById(int theId);

	

}

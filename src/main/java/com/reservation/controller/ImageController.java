package com.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.dao.ImageDao;
import com.reservation.model.Image;
import com.reservation.service.ImageService;
import com.reservation.service.impl.StorageService;


@CrossOrigin(origins = "*")
@RestController
public class ImageController {
	@Autowired
    private ImageDao imageDao;
	@Autowired
    private ImageService imageService;
	
	
	 @RequestMapping(value="api/Image/allImageByEtab/{id}", method = RequestMethod.GET)
	    public List<String> allImageByEtab(@PathVariable(value = "id") Long id){
	    	
	    	return imageDao.allImageByEtab(id);
	    }
	    
	 
	

}

package com.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.dao.ImageDao;
import com.reservation.model.Image;
import com.reservation.service.ImageService;

@Service(value = "imageService")

public class ImageServiceImpl  implements  ImageService{
	@Autowired
	private ImageDao imageDao;

	@Override
	public List<Image> allImageByEtab(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}

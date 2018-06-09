package com.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.dao.MenuDao;
import com.reservation.dao.PlatDao;
import com.reservation.dao.SectionDao;
import com.reservation.model.restaurant.Menu;
import com.reservation.model.restaurant.Plat;
import com.reservation.model.restaurant.Section;
import com.reservation.service.restaurant.PlatService;

@CrossOrigin(origins = "*")
@RestController
public class PlatController {
	
	@Autowired
    private PlatService platService;
	@Autowired
    private PlatDao platDao;
	@Autowired
    private MenuDao menuDao;
	@Autowired
    private SectionDao sectionDao;
   
	

	@RequestMapping(value="api/Plat", method = RequestMethod.POST)
    public Plat savePlat(
    		@RequestBody Plat plat){
    	return platDao.save(plat);
    }
	@RequestMapping(value="api/PlatSection/{id_section}", method = RequestMethod.POST)
    public Plat savePlatSection(
    		@PathVariable(value = "id_section") Long id_section,
    		@RequestBody Plat plat){
			Section s = sectionDao.findOne(id_section);
			plat.setSection(s);
    	return platDao.save(plat);
    }
	

}

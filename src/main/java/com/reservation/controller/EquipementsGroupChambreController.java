package com.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.dao.EquipementsGroupChambreDao;
import com.reservation.model.hotel.EquipementsGroupChambre;
import com.reservation.service.hotel.EquipementsGroupChambreService;

@CrossOrigin(origins = "*")
@RestController
public class EquipementsGroupChambreController {

	
	@Autowired
    private EquipementsGroupChambreService equipementsGroupChambreService;
	@Autowired
  private EquipementsGroupChambreDao equipementsCategorieHotelDao;
		
	
    @RequestMapping(value="api/EquipementsGroupChambre/all", method = RequestMethod.GET)
    public List<EquipementsGroupChambre> listEquipementsCategorieHotel(){
        return equipementsGroupChambreService.findAll();
    }
    
    @RequestMapping(value="api/EquipementsGroupChambre/save", method = RequestMethod.POST)
    public EquipementsGroupChambre saveEquipementsCategorieHotel(
    		@RequestBody EquipementsGroupChambre eq){
		return equipementsCategorieHotelDao.save(eq);
    }
	
}

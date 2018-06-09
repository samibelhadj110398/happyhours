package com.reservation.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.dao.GroupeChambreDao;
import com.reservation.dao.HotelDao;
import com.reservation.dao.PensionDao;
import com.reservation.model.Chambre_Pension;
import com.reservation.model.hotel.GroupeChambre;
import com.reservation.model.hotel.Hotel;
import com.reservation.model.hotel.Pension;
import com.reservation.service.hotel.GroupeChambreService;

@CrossOrigin(origins = "*")
@RestController
public class GroupeChambreController {

	@Autowired
    private GroupeChambreService groupeChambreService;
	@Autowired
    private HotelDao hotelDao;
	@Autowired
    private GroupeChambreDao groupeChambreDao;
	
	@Autowired
    private PensionDao pensionDao;
	
	@RequestMapping(value="api/groupeChambre/{id_hotel}", method = RequestMethod.POST)
    public GroupeChambre saveChambre(
    		@PathVariable(value = "id_hotel") Long id_hotel,
    		@RequestBody GroupeChambre chambre){
    	Hotel h =  hotelDao.findOne(id_hotel);
    	chambre.setHotel(h);
    	return groupeChambreDao.save(chambre);
    }
	


	

	

	
	   @RequestMapping(value="api/Etablissement/groupeChambre/{id_etab}/{total}", method = RequestMethod.POST)
	    public Long saveEtablissementHotelChambre(
	    		@PathVariable(value = "id_etab") Long id_etab,
	    		@PathVariable(value = "total") Long total,	    		
	    		@RequestBody GroupeChambre chambre){	
	    	Hotel hotel =  hotelDao.findOne(id_etab);
	    
			   GroupeChambre ch = new GroupeChambre();
	    		ch.setEquipementsGroupChambre(chambre.getEquipementsGroupChambre());
	    		ch.setSurface(chambre.getSurface());
	    		ch.setTypeChambre(chambre.getTypeChambre());	    
	    		
   		return null;
	    }
	   
	   @RequestMapping(value="api/groupeChambre/all", method = RequestMethod.GET)
	    public List<GroupeChambre> listChambre(){
	        return groupeChambreService.findAll();
	    }
	   @RequestMapping(value="api/groupeChambre/ByIdEtab/{id}", method = RequestMethod.GET)
	    public List<GroupeChambre> listChambreByIdEtab(@PathVariable(value = "id") Long id){
	        return groupeChambreDao.getListChambreByIdEtab(id);
	    }
}

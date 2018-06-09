package com.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.dao.DealDao;
import com.reservation.dao.EtablissementDao;
import com.reservation.model.Etablissement;
import com.reservation.model.restaurant.Deal;

@CrossOrigin(origins = "*")
@RestController
public class DealController {
	
	@Autowired
    private DealDao dealDao;
	@Autowired
    private EtablissementDao etablissementDao;
	
	
	@RequestMapping(value="api/Deal/{id_etab}", method = RequestMethod.POST)
    public Deal saveDeal(
    		@PathVariable(value = "id_etab") Long id_etab,
    		@RequestBody Deal deal){
		Etablissement e =  etablissementDao.findOne(id_etab);
		deal.setEtablissement(e);
    	return dealDao.save(deal);
    }

}

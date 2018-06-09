package com.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.dao.EtablissementDao;
import com.reservation.dao.ProxmiteDao;
import com.reservation.model.Etablissement;
import com.reservation.model.Proxmite;
import com.reservation.service.ProxmiteService;

@CrossOrigin(origins = "*")
@RestController
public class ProxmiteController {

	
	@Autowired
    private ProxmiteService proxmiteService;
	@Autowired
	private EtablissementDao etablissementDao;
	@Autowired
	private ProxmiteDao proxmiteDao;
	
	@RequestMapping(value="api/addProxmite/{id_etab}", method = RequestMethod.POST)
    public Proxmite saveProxmite(
    		@PathVariable(value = "id_etab") Long id_etab,
    		@RequestBody Proxmite proxmite){
			Etablissement s = etablissementDao.findOne(id_etab);
			proxmite.setEtablissement(s);
    	return proxmiteDao.save(proxmite);
    }
}

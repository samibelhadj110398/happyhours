package com.reservation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.dao.PensionDao;
import com.reservation.model.hotel.Pension;
import com.reservation.service.hotel.PensionService;

@Service(value = "pensionServiceImpl")

public class PensionServiceImpl  implements PensionService {

	
	
	@Autowired
	private PensionDao pensionDao;
	@Override
	public List<Pension> findAll() {
		List<Pension> list = new ArrayList<>();
		pensionDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
	
	
}

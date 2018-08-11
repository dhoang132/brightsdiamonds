package com.brightsdiamonds.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightsdiamonds.dao.StaticImageDao;
import com.brightsdiamonds.domain.StaticImage;

@Service
public class StaticImageService {
	
	@Autowired
	private StaticImageDao staticImageDao;
	
	public StaticImage getStaticImage(int id) {
		StaticImage staticImage = staticImageDao.getStaticImage(id);
		return staticImage;
	}

}

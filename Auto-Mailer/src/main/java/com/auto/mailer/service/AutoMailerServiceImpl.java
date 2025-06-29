package com.auto.mailer.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auto.mailer.bean.AutoMailerBean;
import com.auto.mailer.dao.AutoMailerDao;

@Service
public class AutoMailerServiceImpl implements AutoMailerService {

	@Autowired
	AutoMailerDao autoMailerDao;

	private static final Logger logger = LogManager.getLogger(AutoMailerServiceImpl.class);

	@Override
	public void insertDataInDB(AutoMailerBean autoMailerBean) {
		try {
			autoMailerDao.save(autoMailerBean);
		} catch (Exception e) {
			logger.error("Error Occurred");
		}
	}

}

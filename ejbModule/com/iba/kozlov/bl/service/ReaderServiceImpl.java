package com.iba.kozlov.bl.service;

import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;


import com.iba.kozlov.db.dao.ReaderDao;
import com.iba.kozlov.db.dto.ReaderDto;


@Stateless
public class ReaderServiceImpl implements ReaderService {
	private static final Logger LOGGER = Logger.getLogger(ReaderServiceImpl.class);
	private ReaderDao readDao=new ReaderDao();
	public List<ReaderDto> readReaders(){
		LOGGER.info("readReaders");
		return readDao.read();
	}
}

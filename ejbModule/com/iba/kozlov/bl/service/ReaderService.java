package com.iba.kozlov.bl.service;

import java.util.List;

import javax.ejb.Local;

import com.iba.kozlov.db.dto.ReaderDto;
@Local
public interface ReaderService {
	public List<ReaderDto> readReaders();
	
	public void createReader(ReaderDto readerDto);
}

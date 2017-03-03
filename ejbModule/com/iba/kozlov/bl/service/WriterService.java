package com.iba.kozlov.bl.service;

import java.util.List;

import javax.ejb.Local;

import com.iba.kozlov.db.dto.WriterDto;
@Local
public interface WriterService {
	public List<WriterDto> readWriters();
	public void createWriter(WriterDto writerDto);
	public void editWriter(WriterDto writerDto);
	public List<WriterDto> searchWriters(WriterDto writerDto);
	

}

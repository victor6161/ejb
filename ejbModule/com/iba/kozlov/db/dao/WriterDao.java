package com.iba.kozlov.db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.iba.kozlov.db.dto.WriterDto;

public class WriterDao {
	private static final Logger LOGGER = Logger.getLogger(WriterDao.class);

	public List<WriterDto> read(WriterSearchCriteria pCriteria) {
		LOGGER.info("method read all writer");
		List<WriterDto> arrayList = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = new CustomConnection().getConnection().createStatement();
			LOGGER.info(WriterQueryFacade.getQueryRead(pCriteria));
			rs = stmt.executeQuery(WriterQueryFacade.getQueryRead(pCriteria));

			while (rs.next()) {
				int id = rs.getInt(1);
				String writerName=rs.getString(2);
				String writerSurname = rs.getString(3);
				String country=rs.getString(4);

				LOGGER.info("id " + id);
				LOGGER.info("writer " + writerSurname);

				arrayList.add(new WriterDto(id,writerName, writerSurname,country));
			}
			return arrayList;
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException se1) {
			}
			try {
				rs.close();
			} catch (SQLException se1) {
			}

		}
		return arrayList;
	}

/*	public void update(BookDto bookDto) {

		LOGGER.info(" new author is " + bookDto.getWriter().getSurname() + " id " + bookDto.getWriter().getId());
		PreparedStatement prstmt = null;
		try {
			prstmt = new CustomConnection().getConnection().prepareStatement(WriterQueryFacade.getQueryUpdateSurname());
			prstmt.setString(1, bookDto.getWriter().getSurname());
			prstmt.setInt(2, bookDto.getWriter().getId());
			prstmt.executeUpdate();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {

			try {
				prstmt.close();
			} catch (SQLException se1) {
			}

		}
	}
	*/
	public void createWriter(WriterDto writerDto){
		LOGGER.info(writerDto.toString());
		PreparedStatement prstmt = null;
		try {
			LOGGER.info(WriterQueryFacade.getQueryCreate());
			prstmt = new CustomConnection().getConnection().prepareStatement(WriterQueryFacade.getQueryCreate());
			prstmt.setString(1, writerDto.getName());
			prstmt.setString(2, writerDto.getSurname());
			prstmt.setString(3, writerDto.getCountry());
			prstmt.executeUpdate();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {

			try {
				prstmt.close();
			} catch (SQLException se1) {
			}

		}
	}
	
	public void updateWriter(WriterDto writerDto) {
		
		LOGGER.info("update Writer");
		PreparedStatement prstmt = null;
		try {
			LOGGER.info(""+WriterQueryFacade.getQueryUpdate());
			prstmt = new CustomConnection().getConnection().prepareStatement(WriterQueryFacade.getQueryUpdate());
			prstmt.setString(1, writerDto.getName());
			prstmt.setString(2, writerDto.getSurname());
			prstmt.setString(3, writerDto.getCountry());
			prstmt.setInt(4, writerDto.getId());
			prstmt.executeUpdate();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {

				try {
					prstmt.close();
				} catch (SQLException se1) {
				}
			
		}
	}
	
}

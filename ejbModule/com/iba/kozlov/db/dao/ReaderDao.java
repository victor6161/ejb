package com.iba.kozlov.db.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.iba.kozlov.db.dto.ReaderDto;

public class ReaderDao {

	private static final Logger LOGGER = Logger.getLogger(BookDao.class);

	public List<ReaderDto> read() {
		LOGGER.info("method read all reader");
		List<ReaderDto> arrayList = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = new CustomConnection().getConnection().createStatement();

			rs = stmt.executeQuery(ReaderQueryFacade.getQueryReadReader());
			LOGGER.info(ReaderQueryFacade.getQueryReadReader());
			while (rs.next()) {
				int id = rs.getInt(1);
				String readerName = rs.getString(2);
				String readerSurname = rs.getString(3);
				String login = rs.getString(4);
				String password = rs.getString(5);
				String role = rs.getString(6);
				Date date = rs.getTimestamp(7);
				arrayList.add(new ReaderDto(id, readerName, readerSurname, login, password, role, date));
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

	public void createReader(ReaderDto readerDto) {
		LOGGER.info("create Reader");
		LOGGER.info(readerDto.toString());
		PreparedStatement prstmt = null;
		try {
			LOGGER.info(ReaderQueryFacade.getQueryCreate());
			prstmt = new CustomConnection().getConnection().prepareStatement(ReaderQueryFacade.getQueryCreate());
			prstmt.setString(1, readerDto.getLogin());
			prstmt.setString(2, readerDto.getPassword());
			prstmt.setString(3, readerDto.getName());
			prstmt.setString(4, readerDto.getSurname());
			prstmt.setInt(5, 1);// по умолчанию роль читатель ( обычный
								// пользователь )
			prstmt.setString(6, readerDto.getEmail());

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

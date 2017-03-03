package test.ejb;




import javax.ejb.Stateless;






@Stateless
public class LibrarySessionBean implements LibrarySessionBeanLocal {
   
	String test="ejb Test";
    
    public LibrarySessionBean(){
     
    }

	@Override
	public String getTest() {
		
		return test;
	}

	/*public List<BookDto> read(BookSearchCriteria pCriteria) {
	//	LOGGER.info("readDao");
		List<BookDto> arrayList=new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = new CustomConnection().getConnection().createStatement();
			try {
				//LOGGER.info(BookQueryFacade.getQueryBook(pCriteria));
				rs = stmt.executeQuery(BookQueryFacade.getQueryBook(pCriteria));
			} catch (CriteriaNullException e) {
				//LOGGER.fatal("CriteriaNullException" +e.getMessage());
			}
			while (rs.next()) {
				int id = rs.getInt(1);
				String bookname = rs.getString(2);
				int price=rs.getInt(3);
				String writerSurname = rs.getString(4);
				String readerSurname=rs.getString(5);
				int writerId=rs.getInt(6);
				String writerName=rs.getString(7);
				ReaderDto readerDto=new ReaderDto(readerSurname);
				WriterDto writerDto=new WriterDto(writerId,writerName,writerSurname);
				LOGGER.info("id "+id);
				LOGGER.info("bookname "+bookname);
				LOGGER.info("price "+price);
				LOGGER.info("writerSurname "+writerSurname);
				LOGGER.info("readerSurname "+readerSurname);
				arrayList.add(new BookDto(id,bookname,price,readerDto,writerDto));
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
	}*/
    
   
}

package test.ejb;





import javax.ejb.Local;




@Local
public interface LibrarySessionBeanLocal {
	public String getTest();
	/*public List<BookDto> read(BookSearchCriteria pCriteria);*/

}


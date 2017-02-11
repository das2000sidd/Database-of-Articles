package book;

import java.util.ArrayList;
import java.util.HashMap;

import anyPublication.Publication;

/**
 * @Invariant  Each Book object is also a type of Publication object
 * @Invariant  Each Book object has all the attributes of a Publication object 
 * @Invariant  
 
 * 
 * 
 * 
 */
public class Book extends Publication {
        private String publisherName;
        private String bookName;
        private String[] bookAuthors;
        private ArrayList<Book> publicationsCitedByThisBook;
        private ArrayList<Book> publicationsCitingThisBook;
        private int bookIdentifier;
        private int yearOfBookPublication;
        
        /**
         * @Raw
         * 
         * @param  yearOfBookPublication
         *         The year of publication for this Book
         *         this.getYearOfBookPublication()==
         * @param  bookAuthors
         *         The authors of this Book
         *         this.getBookAuthors()==
         * @param  bookName
         *         The name of this Book
         *         this.getBookName()==
         * @param  bookIdentifier
         *         The identifier of this Book
         *         this.getBookIdentifier()==  
         * @param  publisherName
         *         The name of publisher for this Book
         *         this.getPublisherName()==  
         * @param  publicationsCitedByThisBook
         *         The other Publications that this Book cites
         *         this.getPublicationsCitedByThisBook()==    
         * @param  publicationsCitingThisBook
         *         The other Publications that cite this Book
         *         this.getPublicationsCitingThisBook()==                
         * @effect The authors for this book is set to the given authors
         *         | setAuthorsOfPublication(bookAuthors)
         * @effect The title for this book is set to the given title
         *         | setTitleOfPublication(bookName) 
         * @effect The identifier for this book is set to given identifier
         *         | setIdentifierOfPublication(bookIdentifier)    
         * @effect The year of publication for this Book is set to the given year of publication
         *         | setYearOfPublication(yearOfBookPublication)
         * @effect The Publications set as citers of this Book are the new citers of this Book
         *         | setArticlesCitedByThisPublication(publicationsCitedByThisBook)  
         * @effect The Publications set as cited of this Book are the new Publications cited by this Book
         *         | setArticlesCitingThisPublication(publicationsCitingThisBook)                                    
         */
	public Book() {
		super.setPublisherOfPublication(this.getPublisherName());
		super.setTitleOfPublication(this.getBookName());
		super.setAuthorsOfPublication(this.getBookAuthors());
		super.setArticlesCitedByThisPublication(this.getPublicationsCitedByThisBook());
		super.setArticlesCitingThisPublication(this.getPublicationsCitingThisBook());
		super.setIdentifierOfPublication(this.getBookIdentifier());
		super.setYearOfPublication(this.getYearOfBookPublication());
	}
	/**
	 * @param     authorName
	 *            The name of an author for any paper
	 * @return    This method returns the title of a book given a name of an Author.
	 * @post      The name of an author 
	 *            | new.getPaperForAnAuthor(authorName)==   bookName
	 * 
	 
	 *
	 */
	@Override
	public String getPaperForAnAuthor(String authorName) {
		// TODO Auto-generated method stub
		for(int i=0; i < super.getAuthorsOfPublication().length;i++){
			if(super.getAuthorsOfPublication()[i]==authorName){
				return super.getTitleOfPublication();
			}
		}
		return super.getTitleOfPublication();
	}
	/**
	 * @Basic          The name of this book
	 * @Raw
	 * @immutable 
	 * @return         bookName
	 */
	public String getBookName() {
		return bookName;
	}
	
	/**
	 * Set the name of a book
	 * 
	 * @param  bookName
	 *         The string representing the name of the book which has been published.
	 *        
	 * @post   The set name for a book is the name of the book
	 *         
	 *         | new.getBookName() == bookName
	 
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	/**
	 * @Basic         The name of the publisher for this book
	 * @Raw
	 * @immutable
	 * @return       publisherName
	 */
	public String getPublisherName() {
		return publisherName;
	}
	/**
	 * Set the name of a publisher for a book
	 * 
	 * @param  publisherName
	 *         The string representing the name of the publisher for a book
	 *        
	 * @post   The set name for a book is the name of the book
	 *         
	 *         | new.getPublisherName() == publisherName
	 
	 */
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	/**
	 * @Basic         The authors of this book
	 * @Raw
	 * @immutable
	 * @return        bookAuthors
	 */
	public String[] getBookAuthors() {
		return bookAuthors;
	}
	/**
	 * Set the name of a publisher for a book
	 * 
	 * @param  bookAuthors
	 *         The string array  representing the authors of this book
	 *        
	 * @post   The set array of book authors is the author of this book
	 *         
	 *         | new.getBookAuthors() == bookAuthors
	 
	 */
	public void setBookAuthors(String[] bookAuthors) {
		this.bookAuthors = bookAuthors;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * @param     
	 *            
	 * @return    This method modifies the author name format for any book 
	 *            and returns an array of author names in new format.
	 * @post      The name of an author 
	 *            | new.settingAuthorNameNewFormat()==   String[] authorNameArrayNewFormat
	 * 
	 
	 *
	 */
	@Override
	public String[] settingAuthorNameNewFormat() {
		// TODO Auto-generated method stub
		String[] authorNameNewFormat=new String[super.getAuthorsOfPublication().length];
		for(int i=0; i < super.getAuthorsOfPublication().length;i++){
			String anyAuthor = super.getAuthorsOfPublication()[i];
            int indexOfComma = anyAuthor.indexOf(",");
			String lastNameGiven = anyAuthor.substring(0,indexOfComma);
			String firstNameGiven = anyAuthor.substring(indexOfComma+1,anyAuthor.length());
			lastNameGiven =lastNameGiven.trim();
			firstNameGiven = firstNameGiven.trim();
			String newFirstName = firstNameGiven.substring(0, 1).toUpperCase();
			String newLastName = lastNameGiven.substring(0, 1) + lastNameGiven.substring(1, lastNameGiven.length()).toLowerCase();
			String overallName = newFirstName + "." + " "+ newLastName;
			authorNameNewFormat[i] = overallName;
				
			}
			
		
		return authorNameNewFormat;
	}
	/**
	    * Obtain the article titles with a specific word
	    * @param aWordInTitle
	    *        The string representing any word in a conference paper
	    * @post  A conference paper that has a specific word in its title   
	    *       | new.getArticlesWithASpecificWord() == articleTitleToReturn
	    *   
	    */ 
	
	
	@Override
	public String getArticlesWithASpecificWord(String aWordInTitle) {
		
		String articleTitleToReturn="";
		for(int i =0; i < super.getTitleOfPublication().length();i++){
			if(super.getTitleOfPublication().contains(aWordInTitle)){
				articleTitleToReturn=super.getTitleOfPublication();
			}
		}
		return articleTitleToReturn;

	}
	
	
	/**
	 * @Basic       The publicationsCitedByThisBook
	 * @Raw
	 * @immutable
	 * @return        publicationsCitedByThisBook
	 */
	public ArrayList<Book> getPublicationsCitedByThisBook() {
		return publicationsCitedByThisBook;
	}
	/**
	 * @param   publicationsCitedByThisBook 
	 *           The list of publications cited by this book
	 *  @post    The set list of citations for a book are the publications cited by this single book   
	 *           |  new.getPublicationsCitedByThisConferencePaper() == publicationsCitedByThisBook
	 */
	
	public void setPublicationsCitedByThisBook(ArrayList<Book> publicationsCitedByThisBook) {
		this.publicationsCitedByThisBook = publicationsCitedByThisBook;
	}
	/**
	 * @Basic         The publicationsCitingThisBook
	 * @Raw        
	 * @immutable
	 * @return        publicationsCitingThisBook
	 */
	public ArrayList<Book> getPublicationsCitingThisBook() {
		return publicationsCitingThisBook;
	}
	/**
	 * @param   publicationsCitedByThisBook 
	 *           The list of publications cited by this book
	 *  @post    The set list of citations for a book are the publications cited by this single book   
	 *           |  new.getPublicationsCitedByThisConferencePaper() == publicationsCitedByThisBook
	 */
	public void setPublicationsCitingThisBook(ArrayList<Book> publicationsCitingThisBook) {
		this.publicationsCitingThisBook = publicationsCitingThisBook;
	}
	/**
	 * @Basic        Get the identifier of a book
	 * @Raw
	 * @immutable
	 * 
	 * @return       bookIdentifier
	 */
	public int getBookIdentifier() {
		return bookIdentifier;
	}
	/**
	 * @Raw
	 * @param bookIdentifier
	 * @pre The book identifier is unique to every publication of which a book is a type
	 *     
	 *@post The identifier of the article is equivalent to given article identifier
	 *       new.getArticleIdentifier()== articleIdentifier
	 */
	public void getBookIdentifier(int bookIdentifier) {
		this.bookIdentifier = bookIdentifier;
	}
	/**
	 * @return the yearOfBookPublication
	 */
	public int getYearOfBookPublication() {
		return yearOfBookPublication;
	}
	/**
	 * @param   yearOfBookPublication 
	 *           The year of publication of this book
	 *  @post    The set year of publication of this book is its new year of publication.   
	 *           |  new.getYearOfBookPublication() == yearOfBookPublication
	 */
	public void setYearOfBookPublication(int yearOfBookPublication) {
		this.yearOfBookPublication = yearOfBookPublication;
	}
	
	

}

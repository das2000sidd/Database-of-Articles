/**
 * 
 */
package anyPublication;
import java.text.StringCharacterIterator;
import java.time.Year;
//import com.google.java.contract;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.*;
import java.util.Calendar;

/**
 * @Invariant ({"identifierOfPublication > 0","titleOfPublication !=null"})
 * @Invariant ({"authorsOfPublication.length() > 0" && authorsOfPublication != null","yearOfPublication > 0"}
 * @Invariant ({"publisherOfPublication.length() > 0"})
 */
/**
 * @Invariant The identifier of each publication must be unique
 * @Invariant  Each publication must have a proper unique identifier
 * @Invariant Each publication must have a title 
 * @Invariant Each publication author array must have a length of at least one
 * @Invariant Each publication must have a year of publication greater than zero
 * @Invariant Each publication must have a publisher
 * 
 * 
 * 
 */
abstract public class Publication<T> implements Comparable<Publication> {
	private int identifierOfPublication;
	private String titleOfPublication;
	private String[] authorsOfPublication;
	private int yearOfPublication;
	private String publisherOfPublication;
	private ArrayList<Publication> articlesCitingThisPublication;
	private ArrayList<Publication> articlesCitedByThisPublication;


	/**
	 * @Raw
	 * @throws IllegalArgumentException
	 * @param  yearOfPublication
	 *         The year of publication for this publication
	 * @param  authorsOfPublication
	 *         The authors of a publication for this publication
	 * @param  titleOfPublication
	 *         The title of a publication for this publication
	 * @param  identifierOfPublication
	 *         The identifier of a publication for this publication               
	 * @effect The new year of publication is the set year of publication.
	 *         | setYearOfPublication(yearOfPublication)
	 * @effect The authors of a publication for this publications is set to the given authors
	 *         | setAuthorsOfPublication(authorsOfPublication)
	 * @effect The title of a publication for this publication is set to the given title
	 *         | setTitleOfPublication(titleOfPublication) 
	 * @effect The identifier of a publication for this publication is set to given identifier
	 *         | setIdentifierOfPublication(identifierOfPublication)                      
	 */


	public Publication() throws IllegalArgumentException{

		this.setYearOfPublication(this.getYearOfPublication());
		this.yearOfPublication=yearOfPublication;

		setAuthorsOfPublication(authorsOfPublication);
		setTitleOfPublication(titleOfPublication);
		setIdentifierOfPublication(identifierOfPublication);

	}
	/**
	 * @param     authorName
	 *             The name of an author for any paper
	 * @return    This method returns the title of a publication given a name of an Author.
	 * @post      The year of publication of this publication is equal to the given year of publication
	 *            | new.getPaperForAnAuthor(authorName)==   titleOfPublication
	 * 
	 * 
	 * 
	 *
	 */
	public abstract String  getPaperForAnAuthor(String paper);
	public abstract String[] settingAuthorNameNewFormat();
	public abstract String getArticlesWithASpecificWord(String anyString);
	/**
	 * @Basic
	 * @Raw

	 * @return   identifierOfPublication
	 */
	public int getIdentifierOfPublication() {
		return identifierOfPublication;
	}
	/**
	 * 
	 * @param identifierOfPublication
	 *        The integer representing the identifier of a publication
	 * @post  The set identifier of the publication is the new identifier of the publication
	 *        | new.getIdentifierOfPublication() == identifierOfPublication
	 *   
	 */ 
	public void setIdentifierOfPublication(int identifierOfPublication) {
		assert(identifierOfPublication > 0):"The identifier of a publication must be a positive number";
		this.identifierOfPublication = identifierOfPublication;
	}
	/**
	 * @Basic
	 * @Raw  
	 * @immutable       
	 * @pre      The year of publication must be valid with only numbers greater than equal to zero and less than current year allowed 
	 *           isYearOfPublicationPositive(yearOfPublication)
	 * 
	 * @return   titleOfPublication
	 */
	public String getTitleOfPublication() {
		return this.titleOfPublication;
	}
	/**
	 * 
	 * @param titleOfPublication
	 *        The string representing the title of any publication
	 * @post  The set name for a publication is the title of the publication     
	 *        | new.getTitleOfPublication() == titleOfPublication
	 *   
	 */
	public void setTitleOfPublication(String titleOfPublication) {

		this.titleOfPublication = titleOfPublication;
	}

	/**
	 * @Basic
	 * @Raw
	 * @immutable
	 * 
	 * @return     yearOfPublication
	 */
	public int getYearOfPublication() {
		return this.yearOfPublication;
	}
	/**
	 * @param     yearOfPublication
	 *            The year of publication for this article;
	 * @return    
	 * @post      The year of publication of this publication is equal to the given year of publication
	 *            | new.getYearOfPublication()==   yearOfPublication
	 * @throws    AssertionError
	 *            The given year of publication must be greater than zero and less than current year
	 *            if(yearOfPublication > 0 && yearOfPublication< Calendar.YEAR)
	 * 
	 * 
	 *
	 */

	public void setYearOfPublication(int yearOfPublication) {
		assert(yearOfPublication > 0 && yearOfPublication< Calendar.YEAR):"The year of publication must be greater than 0 and less than current year";
		if(yearOfPublication > 0 && yearOfPublication< Calendar.YEAR){
			
			this.yearOfPublication=yearOfPublication;
		}
	}




	/**
	 * 
	 * @param      authorsOfArticle
	 *             Check whether the authorsOfArticle is valid or not
	 * @pre        True if and only if the authorsOfArticle array has length at least one
	 *              if( authorsOfArticle.length() >= 1)
	 * @return      if(authorsOfArticle.length > 1) then
	 *              new.getAuthorsOfPublication()==authorsOfPublication
	 *                 
	 */	
	public boolean hasAtLeastOneAuthor(String[] authorsOfPublication){
		return (authorsOfPublication.length >= 1);
	}
	/**
	 * @Basic
	 * @Raw
	 * @immutable
	 * 
	 * @return    authorsOfPublication
	 */
	public String[] getAuthorsOfPublication() {
		return this.authorsOfPublication;
	}

	/**
	 * @Raw
	 * @param    authorsOfPublication
	 * @post     The authors of this publication
	 *           The authors of this publication is equal to the given authors of this publication
	 *           | new.getAuthorsOfPublication() == authorsOfPublication
	 /
	 * 
	 * @param authorsOfPublication
	 * @throws IllegalArgumentException
	 */
	public void setAuthorsOfPublication(String[] hasAtLeastOneAuthor) throws IllegalArgumentException   {
		assert hasAtLeastOneAuthor(hasAtLeastOneAuthor);



		this.authorsOfPublication=hasAtLeastOneAuthor;

	}




	/**
	 * @Basic
	 * @Raw
	 * @immutable
	 * 
	 * @return        publisherOfPublication
	 */
	public String getPublisherOfPublication() {
		return this.publisherOfPublication;
	}
	/**
	 * @Raw
	 * @param nameOfJournal
	 * @pre The name of journal must be a valid name with only letters, numbers
	 *      spaces and dots. 
	 *      validateNameOfJournal(publisherOfPublication)
	 *@post The name of the journal is equivalent to given journal name
	 *       new.getPublisherOfPublication()== publisherOfPublication
	 */
	public void setPublisherOfPublication(String publisherOfPublication) {
		assert validateNameOfJournal(publisherOfPublication);
		this.publisherOfPublication = publisherOfPublication;
	}




	/**
	 * Ensures name of journal is not empty
	 * @param      nameOfJournal
	 * @pre        The name of journal cannot be null and should have String arguements in it
	 *             | nameOfJournal != null 
	 *             
	 */
	public static boolean validateNameOfJournal(String nameOfJournal){
		boolean journalName = (nameOfJournal == null) && (nameOfJournal.equals(""));
		if(journalName==true){
			throw new IllegalArgumentException("Journal name cannot be empty");
		} else{
			StringCharacterIterator nameIterator = new StringCharacterIterator(nameOfJournal);
			char eachLetter = nameIterator.current();
			while(eachLetter !=StringCharacterIterator.DONE){
				boolean isValidChar = (Character.isLetter(eachLetter) || Character.isDigit(eachLetter)
						|| Character.isSpaceChar(eachLetter)|| eachLetter=='.');

				if(isValidChar!=true){
					String message = "Journal name can only take in alphabets, digits, spaces and dots";
					throw new IllegalArgumentException(message);
				} else {

				}
			}
		}
		return journalName;


	}



	/**
	 * Check whether the year of publication is a  positive number
	 * @param 	yearOfPublication
	 * @pre    The year of publication cannot be null
	 * 			| yearOfPublication != null
	 * @pre    The year of publication has to be a positive number
	 * 			| yearOfPublication > 0
	 * @return   Returns true if and only if the current year is exceeds
	 *          year of publication by 10
	 *          | result == (currentYear-this.getYearOfPublication() >= 10)
	 *         
	 */
	public boolean articlePublishedMoreThanTenYearsAgo(){
		boolean articlePublishedGreaterThanTenYearsAGo=false;


		if(Calendar.YEAR-this.getYearOfPublication() >= 10){
			articlePublishedGreaterThanTenYearsAGo=true;

		} else {
			articlePublishedGreaterThanTenYearsAGo=false;

		}
		return articlePublishedGreaterThanTenYearsAGo;
	} 

	/**
	 * Ensures article name is not null or empty String	
	 * @param articleTitle
	 * @throws IllegalArgumentException if article name is empty or String
	 * @pre    The article name cannot be null
	 *         | articleName != null
	 * @pre    The article name cannot be equal to empty quotes
	 *         | articleName !=""
	 *         
	 */
	public boolean validateNameOfArticle(String articleName){
		boolean isOnlyValidChar=true;
		try{

			if(articleName.length() >= 1){
				StringCharacterIterator iterator = new StringCharacterIterator(articleName);

				char character =  iterator.current();
				while (character != StringCharacterIterator.DONE ){
					isOnlyValidChar = (Character.isLetter(character)
							|| Character.isSpaceChar(character)
							|| character =='\'');
					if(isOnlyValidChar==true){

					} else {


					}
				}
			}
		}	catch(IllegalArgumentException e){


			String message = "Names can contain only letters, spaces, and apostrophes."; // got caught if I supplied "^^%^&&&" as name
			System.out.println(e.getMessage()+message);
		}

		return isOnlyValidChar;

	}

	/**
	 * @Basic
	 * @Raw
	 * @immutable
	 * 
	 * @return         articlesCitingThisPublication
	 */
	public ArrayList<Publication> getArticlesCitingThisPublication() {
		return articlesCitingThisPublication;
	}

	/**
	 * @Raw
	 * @param    articlesCitingThisPublication
	 * @pre      The articles citing this publication
	 *      
	 *      
	 *@post      The articles citing this publication are all articles referenced by articlesCitingThisPublication
	 *           new.getPublicationsCited()== publicationsCited
	 */
	public void setArticlesCitingThisPublication(ArrayList<Publication> articlesCitingThisPublication) {
		this.articlesCitingThisPublication = articlesCitingThisPublication;
	}
	/**
	 * @Basic
	 * @Raw
	 * @immutable
	 * 
	 * @return       articlesCitedByThisPublication
	 */
	public ArrayList<Publication> getArticlesCitedByThisPublication() {
		return articlesCitedByThisPublication;
	}

	/**
	 * @Raw
	 * @param     articlesCitedByThisPublication
	 * @pre       The articles cited by this publication
	 *      
	 *      
	 *@post       The articles cited this publication are all articles referenced by articlesCitedThisPublication
	 *            new.getArticlesCitedByThisPublication()== articlesCitedByThisPublication
	 */
	public void setArticlesCitedByThisPublication(ArrayList<Publication> articlesCitedByThisPublication) {
		this.articlesCitedByThisPublication = articlesCitedByThisPublication;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.identifierOfPublication;

	}
	/**

	 * @param     identifierOfPublication
	 * @pre       The identifier of any publication
	 *      
	 *      
	 *@post       Two publication objects are true if and only if they have the same identifier
	 *            if(this.identifierOfPublication==other.identifierOfPublication) return true
	 *            
	 */
	@Override
	public boolean equals(Object obj) {
		boolean flag = false;
		Publication anyPublication = (Publication) obj;
		if(anyPublication.identifierOfPublication==this.identifierOfPublication){
			flag=true;
		}
		return flag;
	}
	/**
	 * @Basic
	 * @Raw
	 * @immutable
	 * 
	 * @return         new.toString()==titleOfPublication
	 */
	public String toString(){
		return this.getTitleOfPublication();
	}








}

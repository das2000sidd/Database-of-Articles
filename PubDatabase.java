package testingDB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import anyPublication.Publication;
import article.Article;
import book.Book;
import conferencePaper.ConferencePaper;
/**
 * @Invariant  A database is a collection of publications.
 * @Invariant  Each publication must be a valid publication
 * @Invariant  Once a publication is removed from the database it does not cite any articles and it is removed
 *             from cited by list of all articles
 *   
 */
public class PubDatabase {
	Publication<?> anyPublication;
	private double citationWeightForBook=1.2;
	private double citationWeightForArticle=1.0;
	private double citationWeightForConferencePaper=0.7;

	private List<Publication> articlesOfDatabase = new ArrayList<Publication>();
	public HashMap<Integer,Integer> citations = new HashMap<>();


	public PubDatabase(){

	}
	/**
	 * 
	 * @param anyPublication
	 *        The reference variable to any publication object
	 * @pre   The object anyPublication is a true publication object         
	 * @post  The anyPublication object is now a part of the database.   
	 *        The size of the database increments by one  
	 *         
	 *   
	 */


	public List<Publication> addToDatabase(Publication<?> anyPublication) throws IllegalArgumentException{
		assert isPublicationObject(anyPublication);
		if(this.articlesOfDatabase.contains(anyPublication)){
			throw new IllegalArgumentException("The article already exists in the database");
		} else{
			this.articlesOfDatabase.add(anyPublication);
		}

		return this.articlesOfDatabase;

	}


	public boolean isPublicationObject(Publication<?> anyPublication){
		assert (anyPublication instanceof Publication):"This is not a true publication object";
		if(anyPublication==null){
			return false;
		} else{
			return true;
		}
	}
	/**
	 * 
	 * @param anyPublication
	 *        The reference variable to any publication object
	 * @pre   The object anyPublication is a true publication object and is part of the database      
	 * @post  The anyPublication object is not a part of the database any more.
	 *        It does not cite any publications and it is removed from the list of any publication where it is a cited
	 *        anyPublication.getArticlesCitedByThisPublication().remove(publicationToRemove);
	 *        It is not cited by any publication and its list of publications that cite this publication is removed as well.
	 *        anyPublication.getArticlesCitingThisPublication().remove(publicationToRemove);
	 *        The size of database is reduced by one 
	 *        | this.articlesOfDatabase.size() = this.articlesOfDatabase.size()-1
	 *   
	 */
	public void removingPublicationFromDataBase(Publication<?> publicationToRemove) throws IllegalArgumentException {
		assert isPublicationObject(publicationToRemove);
		if(this.articlesOfDatabase.contains(publicationToRemove)){
		Iterator<Publication> publicationIterator = this.articlesOfDatabase.iterator();
		while(publicationIterator.hasNext()){
			Publication anyPublication = publicationIterator.next();
			if(anyPublication.getArticlesCitedByThisPublication().contains(publicationToRemove)){
				anyPublication.getArticlesCitedByThisPublication().remove(publicationToRemove);
			} else if(anyPublication.getArticlesCitingThisPublication().contains(publicationToRemove)){
				anyPublication.getArticlesCitingThisPublication().remove(publicationToRemove);
			}
		}
		this.articlesOfDatabase.remove(publicationToRemove);
		} else{
			throw new IllegalArgumentException("This publication does not exist in the database");
		}
	}
	public boolean IsIdentifierOfPublicationValid(int aPublicationIdentifier){
		boolean isAValidIdentifier = false;
		for(Publication p: this.articlesOfDatabase){
			if(p.getIdentifierOfPublication()==aPublicationIdentifier){
				isAValidIdentifier= true;
			} else{
				isAValidIdentifier= false;
			}
		}
		return isAValidIdentifier;
	}
	/**
	 * 
	 * @param identifierOfCiter
	 *        The reference variable to a Publication object's identifier that is citing another Publication
	 * @param identifierOfCited
	 *         The reference variable to a Publication object's identifier that is being cited by another Publication       
	 * @pre   The arguments  identifierOfCiter and identifierOfCited are true identifiers of database Publication objects  
	 * @post  if (this.articlesOfDatabase.get(i).getIdentifierOfPublication()==identifierOfCiter) returns true
	 *        and
	 *        if(this.articlesOfDatabase.get(j).getIdentifierOfPublication()==identifierOfCited) returns true
	 *        The publication in the database at the index i cites the publication in the database at the index j
	 *        this.articlesOfDatabase.get(i).getArticlesCitedByThisPublication().add(thatisCited);
	 *        The publication in the database at the index j is cited by the publication in the database at the index i
	 *        this.articlesOfDatabase.get(j).getArticlesCitingThisPublication().add(thatisCiting);
	 *        
	 *        
	 *   
	 */

	public HashMap<Integer,Integer> addingReferenceUsingArticleIdentifier(int identifierOfCiter, int identifierOfCited){
         
		for(int i =0; i < this.articlesOfDatabase.size();i++){
			if(this.articlesOfDatabase.get(i).getIdentifierOfPublication()==identifierOfCiter){
				for(int j=0; j < this.articlesOfDatabase.size();j++){
					if(this.articlesOfDatabase.get(j).getIdentifierOfPublication()==identifierOfCited){
						this.citations.put(this.articlesOfDatabase.get(i).getIdentifierOfPublication(), this.articlesOfDatabase.get(j).getIdentifierOfPublication());
						Publication thatisCiting = this.articlesOfDatabase.get(i);
						Publication thatisCited = this.articlesOfDatabase.get(j);
						this.articlesOfDatabase.get(i).getArticlesCitedByThisPublication().add(thatisCited);
						this.articlesOfDatabase.get(j).getArticlesCitingThisPublication().add(thatisCiting);

					} 
				}
			} 
			

		}
		return this.citations;
	}
	public boolean isAValidPublicationOfDatabase(Publication anyPublication){
		return(this.articlesOfDatabase.contains(anyPublication));
	}

	/**
	 * 
	 * @param aPublicationBeingCited
	 *        The reference variable to any Publication object that is part of the database
	 *       
	 * @pre   The object aPublicationBeingCited is a true Publication object and is part of the database      
	 *    
	 *         
	 * @return  Returns list of Publication objects that directly cite a publication which is supplied as a method parameter.        
	 *          new.gettingPublicationsThatDirectlyCiteAPublication(aPublicationBeingCited)==  PublicationsThatDirectlyCiteAPublication
	 *   
	 */

	public Set<Publication> gettingPublicationsThatDirectlyCiteAPublication(Publication<?> aPublicationBeingCited) throws IllegalArgumentException{
		Set<Publication> allPublicationsThatDirectlyCiteAPublication = new HashSet<Publication>();
		if(this.isAValidPublicationOfDatabase(anyPublication)==true){
		throw new IllegalArgumentException("This is not a publication that exists in the database");
		} else{

		Iterator<Publication> dbPublicationIterator1 = this.articlesOfDatabase.listIterator();

		while(dbPublicationIterator1.hasNext()){
			Publication anyPub = dbPublicationIterator1.next();
			if(anyPub.equals(aPublicationBeingCited)){
				allPublicationsThatDirectlyCiteAPublication.addAll(anyPub.getArticlesCitingThisPublication());
			}

		}
		}
		return allPublicationsThatDirectlyCiteAPublication;
	}	
	/**
	 * 
	 * @param aPublicationBeingDirectlyCitedByASpecificPublication
	 *        The reference variable to any Publication object
	 *       
	 * @pre   The object aPublicationBeingCited is a true Publication object and is part of the database      
	 *    
	 *         
	 * @return  Returns list of Publication objects that directly cite a publication which is supplied as a method parameter.
	 *          new.gettingPublicationsThatDirectlyCiteAPublication(aPublicationBeingCited)== aPublicationBeingDirectlyCitedByASpecificPublication       
	 *          new.gettingInDirectCitationsOfAPublications(aPublicationBeingDirectlyCitedByASpecificPublication)== allPublicationsThatIndirectlyCiteAPublication
	 *   
	 */

	public Set<Publication> gettingIndirectCitationsOfAPublications(Publication<?> aPublicationBeingIndirectlyCited){
		Set<Publication> allPublicationsThatInDirectlyCiteAPublication = new HashSet<Publication>();
		Iterator<Publication> dbPublicationIterator1 = this.articlesOfDatabase.listIterator();
		while(dbPublicationIterator1.hasNext()){
			Publication anyPub = dbPublicationIterator1.next();
			if(anyPub.equals(aPublicationBeingIndirectlyCited)){
				List<Publication> getArticlesCitingAnyPub = anyPub.getArticlesCitingThisPublication();
				Iterator<Publication> getArticlesCitingAnyPubIterator = getArticlesCitingAnyPub.listIterator();
				while(getArticlesCitingAnyPubIterator.hasNext()){
					Publication eachArticleFromGetArticlesCitingAnyPubIterator = getArticlesCitingAnyPubIterator.next();
					List<Publication> gettingTheIndirectCitationList = eachArticleFromGetArticlesCitingAnyPubIterator.getArticlesCitingThisPublication();
					Iterator<Publication> gettingTheIndirectCitationListIterator = gettingTheIndirectCitationList.listIterator();
					while(gettingTheIndirectCitationListIterator.hasNext()){
						Publication indirectPub = gettingTheIndirectCitationListIterator.next();
						allPublicationsThatInDirectlyCiteAPublication.add(indirectPub);
						allPublicationsThatInDirectlyCiteAPublication.remove(aPublicationBeingIndirectlyCited);
					}

				}
			}
		}
		return allPublicationsThatInDirectlyCiteAPublication;
	}


	/**
	 * 
	 * @param aSpecificAuthor
	 *        The reference variable to any author of a database Publication
	 *       
	 * @pre   The object aPublicationBeingCited is a true Publication object and is part of the database      
	 *    
	 *         
	 * @return  Returns the citation of a specific author which is supplied as method argument.
	 *           new.computeCitationIndex(aSpecificAuthor)== citationIndex       
	 *          
	 *   
	 */

	public double computeCitationIndex(String aSpecificAuthor){
		double citationIndex=0;

		for(int i=0;i < this.articlesOfDatabase.size();i++){
			Publication<?> anyPublication = this.articlesOfDatabase.get(i);
			String[] authorsOfAnyPublication = anyPublication.getAuthorsOfPublication();
			for(String author : authorsOfAnyPublication){
				if (author.equals(aSpecificAuthor)){
					if(anyPublication instanceof Book){
						citationIndex=citationIndex+this.getCitationWeightForBook();
					} else if(anyPublication instanceof Article){
						citationIndex=citationIndex+this.getCitationWeightForArticle();
					} else if(anyPublication instanceof ConferencePaper){
						citationIndex = citationIndex + this.getCitationWeightForConferencePaper();
					}
				} 
			}
		}


		return citationIndex;
	}
	/**
	 * 
	 * @param authorName
	 *        The reference to any author of a database Publication
	 *       
	 *    
	 *    
	 *         
	 * @return  Returns a list of publications as ArrayList of type String for an author supplied as method argument.
	 *           new.getAllPublicationsForAnAuthor(authorName)== allPublicationsOfAuthor       
	 *          
	 *   
	 */

	public List<String> getAllPublicationsForAnAuthor(String authorName){
		List<String> allPublicationsOfAuthor = new ArrayList<String>();
		for(Publication p : this.articlesOfDatabase){

			String[] authorsOfAnyPublicationDesiredFormat = p.settingAuthorNameNewFormat();

			for(String author :authorsOfAnyPublicationDesiredFormat){

				if(author.equals(authorName)){
					allPublicationsOfAuthor.add(p.getTitleOfPublication());
				} else{
					//System.out.println("The author is not part of any publications of the database");
				}
			}
		}
		return allPublicationsOfAuthor;
	}
	/**
	 * 
	 * @param nameOfAuthorSupplied
	 *        The reference to any author of a database Publication supplied in format "initialOfFirstName. lastName"
	 *       
	 *    
	 *    
	 *         
	 * @return  Returns a list of publications for an author supplied as method argument as a List object of type String.
	 *           new.getAllPublicationsForAnAuthor(authorName)== allPublicationsOfAuthor       
	 *          
	 *   
	 */

	public ArrayList<String> getAllArticlesWithAuthorNameNewFormat(String nameOfAuthorSupplied){
		ArrayList<String> allArticlesOfAAuthorNewNameFormat = new ArrayList<String>();
		for(Publication<?> p : this.articlesOfDatabase){
			String[] authorNamesInDesiredFormat = p.settingAuthorNameNewFormat();

			for(String author :authorNamesInDesiredFormat){
				if(author.equals(nameOfAuthorSupplied)){
					allArticlesOfAAuthorNewNameFormat.add(p.getTitleOfPublication());
				}
			}
		}
		return allArticlesOfAAuthorNewNameFormat;
	}
	/**
	 * 
	 * @param anyWordInTitle
	 *        Any word in the titleOfPublication attribute of a Publication object
	 *       
	 *    
	 *    
	 *         
	 * @return  Returns the title of publications with a specific word in their title as a list object.
	 *           new.getAllPublicationsForAnAuthor(authorName)== allPublicationsOfAuthor       
	 *          
	 *   
	 */

	public ArrayList<String> getAllArticlesWithASpecificWordInTheirTitle(String anyWordInTitle){
		String titleWithWordOfInterest="";
		ArrayList<String> allArticlesWithASpecificWordInTitle = new ArrayList<String>();
		for(Publication<?> p : this.articlesOfDatabase){
			titleWithWordOfInterest = p.getArticlesWithASpecificWord(anyWordInTitle);
			if(titleWithWordOfInterest.length()!=0){

				allArticlesWithASpecificWordInTitle.add(titleWithWordOfInterest);
			}
		}
		return allArticlesWithASpecificWordInTitle;
	}



	/**
	 * @Basic
	 * @Raw  
	 * @immutable       
	 * 
	 * @return   articlesOfDatabase
	 */
	public List<Publication> getArticlesOfDatabase() {
		return articlesOfDatabase;
	}
	/**
	 * @Basic
	 * @Raw  
	 * @immutable       
	 * 
	 * @return   citationWeightForBook
	 */

	public double getCitationWeightForBook() {
		return citationWeightForBook;
	}
	/**
	 * 
	 * @param citationWeightForBook
	 *        The double value representing the citation weight of a book
	 * @post  The set citation weight of a book is the new citation weight of all Publication objects of type Book
	 *        | new.getCitationWeightForBook() == citationWeightForBook
	 *   
	 */

	public void setCitationWeightForBook(double citationWeightForBook) {
		this.citationWeightForBook = citationWeightForBook;
	}
	/**
	 * @Basic
	 * @Raw  
	 * @immutable       
	 * 
	 * @return   citationWeightForArticle
	 */
	public double getCitationWeightForArticle() {
		return citationWeightForArticle;
	}
	/**
	 * 
	 * @param citationWeightForArticle
	 *        The double value representing the citation weight of an article
	 * @post  The set citation weight of an article is the new citation weight of all Publication objects of type Article
	 *        | new.getCitationWeightForArticle() == citationWeightForArticle
	 *   
	 */
	public void setCitationWeightForArticle(double citationWeightForArticle) {
		this.citationWeightForArticle = citationWeightForArticle;
	}
	/**
	 * @Basic
	 * @Raw  
	 * @immutable       
	 * 
	 * @return   citationWeightForConferencePaper
	 */
	public double getCitationWeightForConferencePaper() {
		return citationWeightForConferencePaper;
	}
	/**
	 * 
	 * @param citationWeightForConferencePaper
	 *        The double value representing the citation weight of a conference paper
	 * @post  The set citation weight of a conference paper is the new citation weight of all Publication objects of type article
	 *        | new.getCitationWeightForConferencePaper() == citationWeightForConferencePaper
	 *   
	 */
	public void setCitationWeightForConferencePaper(double citationWeightForConferencePaper) {

		this.citationWeightForConferencePaper = citationWeightForConferencePaper;
	}

}

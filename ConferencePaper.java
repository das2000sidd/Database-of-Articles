package conferencePaper;

import java.util.ArrayList;
import java.util.HashMap;

import anyPublication.Publication;
/**
 * @Invariant  Each ConferencePaper object is also a type of Publication object
 * @Invariant  Each ConferencePaper object has all the attributes of a Publication object 
 * @Invariant  
 
 * 
 * 
 * 
 */
public class ConferencePaper extends Publication {
private String[] authorsOfAConferencePaper;
private String nameoOfConferenceForAPaper;
private String conferencePaperTitle;

private ArrayList<ConferencePaper> publicationsCitedByThisConferencePaper;
private ArrayList<ConferencePaper> publicationsCitingThisConferencePaper;

private int yearOfConference;
private int identifierOfConferencePaper;
/**
 * @Raw
 * 
 * @param  yearOfConference
 *         The year of publication for this ConferencePaper
 * @param  authorsOfAConferencePaper
 *         The authors of this ConferencePaper
 * @param  conferencePaperTitle
 *         The title of this ConferencePaper
 * @param  identifierOfConferencePaper
 *         The identifier of this ConferencePaper            
 * @effect The authors for this ConferencePaper is set to the given authors
 *         | setAuthorsOfPublication(authorsOfAConferencePaper)
 * @effect The title for this ConferencePaper is set to the given title
 *         | setTitleOfPublication(conferencePaperTitle) 
 * @effect The identifier for this ConferencePaper is set to given identifier
 *         | setIdentifierOfPublication(identifierOfConferencePaper)    
 * @effect The year of publication for this ConferencePaper is set to the given year of publication
 *         | setYearOfPublication(yearOfConference) 
 * @effect The Publications set as citers of this ConferencePaper are the new citers of this ConferencePaper
 *         | setArticlesCitedByThisPublication(publicationsCitedByThisConferencePaper)  
 * @effect The Publications set as cited of this ConferencePaper are the new Publications cited by this ConferencePaper
 *         | setArticlesCitingThisPublication(publicationsCitingThisConferencePaper) 
 *                                  
 */
	public ConferencePaper() throws IllegalArgumentException {
		super.setYearOfPublication(this.getYearOfConference());
		super.setAuthorsOfPublication(this.getAuthorsOfAConferencePaper());
		super.setTitleOfPublication(this.getConferencePaperTitle());
		super.setIdentifierOfPublication(this.getIdentifierOfConferencePaper());
		super.setPublisherOfPublication(this.getNameoOfConferenceForAPaper());
		super.setIdentifierOfPublication(this.getIdentifierOfConferencePaper());
		super.setArticlesCitedByThisPublication(this.getPublicationsCitedByThisConferencePaper());
		super.setArticlesCitingThisPublication(this.getPublicationsCitingThisConferencePaper());
	}
	/**
	 * @param     authorName
	 *            The name of an author for any conference paper
	 * @return    This method returns the title of a conference paper given a name of an Author.
	 * @post      The name of an author 
	 *            | new.getPaperForAnAuthor(authorName)==   conferencePaperTitle
	 * 
	 
	 *
	 */

	@Override
	public String getPaperForAnAuthor(String authorName) {
		
		for(int i=0; i < super.getAuthorsOfPublication().length;i++){
			if(super.getAuthorsOfPublication()[i]==authorName){
				return super.getTitleOfPublication();
			}
		}
		return super.getTitleOfPublication();
	}
	/**
	 * @param     
	 *            
	 * @return    This method modifies the author name format for any article 
	 *            and returns an array of author names in new format.
	 * @post      The name of an author 
	 *            | new.settingAuthorNameNewFormat()==   String[] authorsOfAConferencePaper
	 * 
	 
	 *
	 */
	@Override
	public String[] settingAuthorNameNewFormat() {
		
		String[] authorNameNewFormat=new String[super.getAuthorsOfPublication().length];
		for(int i=0; i < super.getAuthorsOfPublication().length;i++){
			String anyAuthor = super.getAuthorsOfPublication()[i];
				int indexOfComma = anyAuthor.indexOf(",");
				String lastNameGiven = anyAuthor.substring(0,indexOfComma);
				String firstNameGiven = anyAuthor.substring(indexOfComma+1,anyAuthor.length());
				lastNameGiven = lastNameGiven.trim();
				firstNameGiven = firstNameGiven.trim();
				String newFirstName = firstNameGiven.substring(0, 1).toUpperCase();
				String newLastName = lastNameGiven.substring(0, 1) + lastNameGiven.substring(1, lastNameGiven.length()).toLowerCase();
				String overallName = newFirstName + "." + " " +newLastName;
				authorNameNewFormat[i] = overallName;
				
			
			
		}
		return authorNameNewFormat;
	}

	/**
	 * @Basic           Returns the authors of this conference paper
	 * @Raw
	 * @immutable
	 * 
	 * @return
	 */
	public String[] getAuthorsOfAConferencePaper() {
		return authorsOfAConferencePaper;
	}
	/**
	 * Set the authors for a particular conference paper
	 * 
	 * @param  authorsOfAConferencePaper
	 *         The authors of a conference paper as an array
	 * @post   The authors of a specific article is equal to the given array of authors
	 *         
	 *         | new.getAuthorsOfAConferencePaper() == authorsOfAConferencePaper
	 
	 */


	public void setAuthorsOfAConferencePaper(String[] authorsOfAConferencePaper) {
		this.authorsOfAConferencePaper = authorsOfAConferencePaper;
	}


	/**
	 * @Basic            Returns the name of this conference paper
	 * @Raw
	 * @immutable
	 * 
	 * @return
	 */
	public String getNameoOfConferenceForAPaper() {
		return nameoOfConferenceForAPaper;
	}
	/**
	 * Set the authors for a particular conference paper
	 * 
	 * @param  nameoOfConferenceForAPaper
	 *         The string representing name of this conference where the conference was presented
	 *        
	 * @post   The set name for the conference of the paper is the name of the conference
	 *         
	 *         | new.getNameoOfConferenceForAPaper() == nameoOfConferenceForAPaper
	 
	 */


	public void setNameoOfConferenceForAPaper(String nameoOfConferenceForAPaper) {
		this.nameoOfConferenceForAPaper = nameoOfConferenceForAPaper;
	}

	/**
	 * @Basic     Returns the the title of the conference paper for this author
	 * @Raw
	 * @immutable
	 * 
	 * @return
	 */

	public String getConferencePaperTitle() {
		return conferencePaperTitle;
	}

   /**
    * 
    * @param conferencePaperTitle
    *        The string representing the name of a conference paper
    * @post  The set name for a conference paper title is the name of the conference paper title     
    *        | new.getConferencePaperTitle() == conferencePaperTitle
    *   
    */ 
    	
	public void setConferencePaperTitle(String conferencePaperTitle) {
		this.conferencePaperTitle = conferencePaperTitle;
	}

	



	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	    * Obtain the article titles with a specific word
	    * @param aWordInTitle
	    *        The string representing any word in a conference paper
	    * @post  A conference paper that has a specific word in its title   
	    *       | new.getArticlesWithASpecificWord() == conferencePaperTitleToReturn
	    *   
	    */ 

	@Override
	public String getArticlesWithASpecificWord(String aWordInTitle) {
		// TODO Auto-generated method stub
		String conferencePaperTitleToReturn="";
		for(int i =0; i < super.getTitleOfPublication().length();i++){
			if(super.getTitleOfPublication().contains(aWordInTitle)){
				conferencePaperTitleToReturn=super.getTitleOfPublication();
			}
		}
		return conferencePaperTitleToReturn;
	}


	

	/**
	 * @Basic            Returns the year of conference for this conference
	 * @Raw    
	 * @immutable
	 * 
	 * @return
	 */
	public int getYearOfConference() {
		return yearOfConference;
	}
	/**
	    * 
	    * @param yearOfConference
	    *        The integer representing the year this conference took place
	    * @post  The set year for this conference paper is the year of publication of the conference paper    
	    *        | new.getYearOfConference() == yearOfConference
	    *   
	    */ 
	
	public void setYearOfConference(int yearOfConference) {
		this.yearOfConference = yearOfConference;
	}
	/**
	 * @Basic         Returns the arrayList of publications cited by a conference paper
	 * @Raw
	 * @immutable
	 * 
	 * @return
	 */

	public ArrayList<ConferencePaper> getPublicationsCitedByThisConferencePaper() {
		return publicationsCitedByThisConferencePaper;
	}
	/**
	    * 
	    * @param publicationsCitedByThisConferencePaper
	    *        The list of publications cited by this conference paper
	    * @post  The set list of citations for a conference paper are the papers sited by this single conference paper 
	    *        | new.getPublicationsCitedByThisConferencePaper() == publicationsCitedByThisConferencePaper
	    *   
	    */ 

	public void setPublicationsCitedByThisConferencePaper(ArrayList<ConferencePaper> publicationsCitedByThisConferencePaper) {
		this.publicationsCitedByThisConferencePaper = publicationsCitedByThisConferencePaper;
	}
	/**
	 * @Basic          Returns an arrayList of publications citing a conference paper
	 * @Raw
	 * @immutable
	 * 
	 * @return
	 */

	public ArrayList<ConferencePaper> getPublicationsCitingThisConferencePaper() {
		return publicationsCitingThisConferencePaper;
	}

	/**
	 * @Basic          Returns an arrayList of publications citing a conference paper
	 * @Raw
	 * @immutable
	 * 
	 * @return
	 */
	public void setPublicationsCitingThisConferencePaper(ArrayList<ConferencePaper> publicationsCitingThisConferencePaper) {
		this.publicationsCitingThisConferencePaper = publicationsCitingThisConferencePaper;
	}
	/**
	 * @return the identifierOfConferencePaper
	 */
	public int getIdentifierOfConferencePaper() {
		return identifierOfConferencePaper;
	}
	/**
	 * @param identifierOfConferencePaper the identifierOfConferencePaper to set
	 */
	public void setIdentifierOfConferencePaper(int identifierOfConferencePaper) {
		this.identifierOfConferencePaper = identifierOfConferencePaper;
	}

}

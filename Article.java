/**
 * 
 */
package article;

import java.util.ArrayList;
import java.util.HashMap;

import anyPublication.Publication;

/**
 * @author user
 *
 */
/**
 * 
 * @author user
 *
 */
/**
 * @Invariant ({"identifierOfPublication > 0","titleOfPublication !=null"})
 * @Invariant ({"authorsOfPublication.length() > 0" && authorsOfPublication != null","yearOfPublication > 0"}
 * @Invariant ({"publisherOfPublication.length() > 0"})
 */
/**
 * @Invariant  Each Article object is also a type of Publication object
 * @Invariant  Each Article object has all the attributes of a Publication object and  separate attribute
 * @Invariant  Each Article object also has an issueNumberOfJournal attribute
 
 * 
 * 
 * 
 */
public class Article extends Publication {
      private String nameOfJournal;
      private int issueNumberOfJournal;
      private String[] authorOfArticle;
      private int yearOfArticlePublication;
      private String articleTitle;
      private String[] articlesCited;
      private ArrayList<Article> articlesCitedByThisArticle;
      private ArrayList<Article> articlesCitingThisArticle;
      private int articleIdentifier;
      /**
       * @Raw
       * @throws IllegalArgumentException
       * @param  yearOfArticlePublication
       *         The year of publication for this Article
       * @param  authorOfArticle
       *         The authors of a article for this Article
       * @param  articleTitle
       *         The title of a article for this Article
       * @param  articleIdentifier
       *         The identifier of a article for this Article        
       *                
       * @effect The new year of publication of this article is the set year of publication for this Article.
       *         | super.setYearOfPublication(this.getYearOfArticlePublication());
       * @effect The authors of a publication for this article is the set authors of publication for this Article.
       *         | setAuthorsOfPublication(authorsOfPublication)
       * @effect The title of a publication for this article is the set title of publication for this article.
       *         | setTitleOfPublication(titleOfPublication) 
       * @effect The identifier of a publication for this article is the set identifier of publication for this article.
       *         | setIdentifierOfPublication(identifierOfPublication) 
       * @effect The Publications set as citers of this Book are the new citers of this Book
       *         | setArticlesCitedByThisPublication(publicationsCitedByThisBook)  
       * @effect The Publications set as cited of this Book are the new Publications cited by this Book
       *         | setArticlesCitingThisPublication(publicationsCitingThisBook)                              
       */
	public Article() {
		super.setAuthorsOfPublication(this.getAuthorOfArticle());
		super.setTitleOfPublication(this.getArticleTitle());
		super.setPublisherOfPublication(this.getNameOfJournal());
		super.setYearOfPublication(this.getYearOfArticlePublication());
		super.setArticlesCitingThisPublication(this.getArticlesCitingThisArticle());
		super.setArticlesCitedByThisPublication(this.getArticlesCitedByThisArticle());
		super.setIdentifierOfPublication(this.getArticleIdentifier());
		
	}
	/**
	 * @param     authorName
	 *            The name of an author for any article
	 * @return    This method returns the title of an article given a name of an Author.
	 * @post      The name of an author 
	 *            | new.getPaperForAnAuthor(authorName)==   articleTitle
	 * 
	 
	 *
	 */
	@Override
	public String getPaperForAnAuthor(String authorName) {
		// TODO Auto-generated method stub
		for(int i =0;i < super.getAuthorsOfPublication().length;i++){
			if(super.getAuthorsOfPublication()[i]==authorName){
				return super.getTitleOfPublication();
			}
		}
		return super.getTitleOfPublication();
	}
	/**
	 * @Basic
	 * @Raw
	 * @immutable
	 * 
	 * @return
	 */
	public String[] getAuthorOfArticle() {
		return authorOfArticle;
	}
	/**
	 * @Raw
	 * @param    authorOfArticle
	 * @post     The authors of this article
	 *           The authors of this article is equal to the given authors of this article
	 *           If new instance of Publication
	 *           | new.getAuthorsOfPublication() == authorOfArticle
	 *           If new instance of Article
	 *           | new.getAuthorOfArticle() == authorOfArticle
	 */
	public void setAuthorOfArticle(String[] authorOfArticle) {
		this.authorOfArticle = authorOfArticle;
	}
	/**
	 * @Basic
	 * @Raw
	 * @immutable
	 * 
	 * @return
	 */
	public String getArticleTitle() {
		return articleTitle;
	}
	/**
	 * @Raw
	 * @param    articleTitle
	 * @post     The title of this article
	 *           The title of this article is equal to the given title of this article
	 *           If new reference variable of type Publication
	 *           | new.getTitleOfPublication() == articleTitle
	 *           If new reference variable of type Article
	 *           | new.getArticleTitle() == articleTitle
	 */
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	/**
	 * @Basic
	 * @Raw
	 * @immutable
	 * 
	 * @return
	 */

	public String getNameOfJournal() {
		return nameOfJournal;
	}
	/**
	 * @Raw
	 * @param   nameOfJournal
	 * @pre     The name of journal must be a valid name with only letters, numbers
	 *          spaces and dots. 
	 *          validateNameOfJournal(publisherOfPublication)
	 *@post     The name of the journal is equivalent to given journal name
	 *          If new reference variable of type Publication
	 *          | new.getPublisherOfPublication() == nameOfJournal
	 *          If new reference variable of type Article
	 *          new.getNameOfJournal()== nameOfJournal
	 */
	public void setNameOfJournal(String nameOfJournal) {
		this.nameOfJournal = nameOfJournal;
	}

	/**
	 * @param     
	 *            
	 * @return    This method modifies the author name format for any article 
	 *            and returns an array of author names in new format.
	 * @post      The name of an author 
	 *            | new.settingAuthorNameNewFormat()==   String[] authorNameArrayNewFormat
	 * 
	 
	 *
	 */

	@Override
	public String[] settingAuthorNameNewFormat() {
		// TODO Auto-generated method stub
		String[] authorNameNewFormat= new String[super.getAuthorsOfPublication().length];
		
			for (int i=0; i < super.getAuthorsOfPublication().length;i++){
				String anyAuthor = super.getAuthorsOfPublication()[i];
				int indexOfComma = anyAuthor.indexOf(",");
				String lastNameGiven = anyAuthor.substring(0,indexOfComma);
				String firstNameGiven = anyAuthor.substring(indexOfComma+1,anyAuthor.length());
				lastNameGiven = lastNameGiven.trim();
				firstNameGiven = firstNameGiven.trim();
				String newFirstName = firstNameGiven.substring(0, 1).toUpperCase();
				String newLastName = lastNameGiven.substring(0, 1) + lastNameGiven.substring(1, lastNameGiven.length()).toLowerCase();
				String overallName = newFirstName+"."+ " "+newLastName;
				authorNameNewFormat[i] = overallName;
				
				
			}
			
		
		return authorNameNewFormat;
	}
	/**
	 * @param     
	 *            
	 * @return    This method returns Publications that have a specific word in their title
	 *           
	 * @post      The name of an author 
	 *            | new.getArticlesWithASpecificWord()==   articleTitleToReturn
	 * 
	 
	 *
	 */
	@Override
	public String getArticlesWithASpecificWord(String aWordInTitle) {
		// TODO Auto-generated method stub
		String articleTitleToReturn="";
		for(int i =0; i < super.getTitleOfPublication().length();i++){
			if(super.getTitleOfPublication().contains(aWordInTitle)){
				articleTitleToReturn=super.getTitleOfPublication();
			}
		}
		return articleTitleToReturn;
	}

	

	

	
	/**
	 * Check whether the given contents is a valid contents for
	 * any oil tank under the given capacity.
	 *  
	 * @param  issueNumberOfJournal
	 * 		   The issueNumberOfJournal to check.
	 * @throws IllegalArgumentException if issueNumberOfJournal <= 0
	 * @return True if and only if the issue number is an integer greater than 0 and is the value returned
	 *       | return(issueNumberOfJournal >= 0)
	 *       
	 * 
	 */
	private static boolean validateIssueNumber(int issueNumberOfJournal){
		assert(issueNumberOfJournal >= 1):"Issue number of journal has to be greater than 0";
		if (issueNumberOfJournal >= 1){
			return true;
		} else {
			return false;
		}


	}
	/**
	 * @Basic        Get the identifier of an article
	 * @Raw
	 * @immutable
	 * 
	 * @return
	 */
	public int getArticleIdentifier() {
		return articleIdentifier;
	}
	/**
	 * @Raw
	 * @param articleIdentifier
	 * @pre The article identifier is unique to every publication of which an article is a type
	 *     
	 *@post The identifier of the article is equivalent to given article identifier
	 *       new.getArticleIdentifier()== articleIdentifier
	 */
	public void setArticleIdentifier(int articleIdentifier) {
		this.articleIdentifier = articleIdentifier;
	}
	/**
	 * @Basic        Get the issue number of a journal
	 * @Raw
	 * @immutable
	 * 
	 * @return
	 */
	public int getIssueNumberOfJournal() {
		return issueNumberOfJournal;
	}

	
	/**
	 * @Raw
	 * @param issueNumberOfJournal
	 * @pre The issue number of journal must be a valid name with only numbers
	 *     validateIssueNumber(issueNumberOfJournal)
	 *@post The name of the journal is equivalent to given journal name
	 *       new.getIssueNumberOfJournal()== issueNumberOfJournal
	 */
	public void setIssueNumberOfJournal(int issueNumberOfJournal) {
		assert validateIssueNumber(issueNumberOfJournal);
		this.issueNumberOfJournal = issueNumberOfJournal;
	}
	/**
	 * @Basic    
	 * @Raw
	 * @immutable
	 * 
	 * @return  Get the articles cited by this article
	 */
	public ArrayList<Article> getArticlesCitedByThisArticle() {
		return articlesCitedByThisArticle;
	}

	/**
	 * @Raw
	 * @param articlesCitedByThisArticle
	 * @pre The articles cited by this article must be other article objects.
	 *    
	 *@post The list of articles cited by this article is other article objects.
	 *       new.getArticlesCitedByThisArticle()== articlesCitedByThisArticle
	 */
	public void setArticlesCitedByThisArticle(ArrayList<Article> articlesCitedByThisArticle) {
		this.articlesCitedByThisArticle = articlesCitedByThisArticle;
	}

	/**
	 * @Basic
	 * @Raw
	 * @immutable
	 * @return        Get the articles citing this Article
	 */
	public ArrayList<Article> getArticlesCitingThisArticle() {
		return articlesCitingThisArticle;
	}
	/**
	 * @Raw
	 * @param articlesCitingThisArticle
	 * @pre The articles citing this article must be other article objects.
	 *    
	 *@post The list of articles cited by this article is other article objects.
	 *      new.getArticlesCitingThisArticle() = articlesCitingThisArticle
	 */
	public void setArticlesCitingThisArticle(ArrayList<Article> articlesCitingThisArticle) {
		this.articlesCitingThisArticle = articlesCitingThisArticle;
	}

	/**
	 * @Basic
	 * @Raw
	 * @immutable
	 * @return        Get the year of publication of this article
	 */
	public int getYearOfArticlePublication() {
		return yearOfArticlePublication;
	}

	/**
	 * @param   yearOfArticlePublication the yearOfArticlePublication to set
	 * @pre    The year of publication must be an integer less than current year and greater than zero
	 *    
	 *@post    The list of articles cited by this article is other article objects.
	 *         new.getYearOfArticlePublication() = yearOfArticlePublication
	 * 
	 */
	public void setYearOfArticlePublication(int yearOfArticlePublication) {
		this.yearOfArticlePublication = yearOfArticlePublication;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
	
	}

	
	
	




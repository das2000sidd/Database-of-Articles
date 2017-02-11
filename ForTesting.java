package forTesting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import conferencePaper.ConferencePaper;
import article.Article;
import book.Book;
import anyPublication.Publication;

import testingDB.PubDatabase;

public class ForTesting {

	public ForTesting() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Multiple different subclasses objects of Publication have been created
		 * They are from p1 till p10
		 * Each Publication object has been assigned an identifier, a title and an author String array
		 * 
		 */
		Publication p1 = new ConferencePaper();
		p1.setIdentifierOfPublication(1);
		p1.setTitleOfPublication("This is publication 1 of type ConferencePaper");
		
		String[] authors1 = {"Einstein, Albert" , "Franklin, Benjamin" , "Babbage, Charles"};
		
		p1.setAuthorsOfPublication(authors1);
        Publication p2 = new Article();
	    p2.setIdentifierOfPublication(2);
	    p2.setTitleOfPublication("This is publication 2 of type Article");
	    String[] authors2 = {"Tagore, Rabindranath" , "Churchill, Winston" , "Einstein, Albert"};
	    p2.setAuthorsOfPublication(authors2);
	    Publication p3 = new Book();
	    p3.setIdentifierOfPublication(3);
	    String[] authors3 = {"Gandhi, Mahatma" , "Franklin, Benjamin" , "Newton, Issac"};
	    p3.setTitleOfPublication("This is publication 3 of type Book");
	    p3.setAuthorsOfPublication(authors3);
	    String[] authors4 = {"Bose, Netaji" , "Einstein, Albert" , "Gallini, Galileo"};
	    Publication p4 = new Article();
	    p4.setIdentifierOfPublication(4);
	    p4.setTitleOfPublication("This is publication 4  of type Article");
	    p4.setAuthorsOfPublication(authors4);
		Publication p5 = new Article();
		p5.setIdentifierOfPublication(5);
		p5.setTitleOfPublication("This is publication 5 of type Article");
		String[] authors5={"Einstein, Albert" , "Washington, George"};
		p5.setAuthorsOfPublication(authors5);
		Publication p6 = new ConferencePaper();
		p6.setIdentifierOfPublication(6);
		p6.setTitleOfPublication("This is publication 6 of type ConferencePaper");
		String[] authors6={"Tagore, Rabindranath" , "Babbage, Charles"};
		p6.setAuthorsOfPublication(authors6);
		String[] authors7={"Churchill, Winston" , "Newton, Issac"};

		Publication p7 = new Article();
		p7.setIdentifierOfPublication(7);
		p7.setTitleOfPublication("This is publication 7 of type Article");
		p7.setAuthorsOfPublication(authors7);
		String[] authors8={"Gandhi, Mahatma" , "Franklin, Benjamin" , "Bose,Netaji"};

		Publication p8 = new Book();
		p8.setIdentifierOfPublication(8);
		p8.setTitleOfPublication("This is publication 8 of type Book");
		p8.setAuthorsOfPublication(authors8);
		String[] authors9={"Babbage, Charles" , "Gallini, Galileo"};

		Publication p9 = new Book();
		p9.setIdentifierOfPublication(9);
		p9.setTitleOfPublication("This is publication 9 of type Book");
        p9.setAuthorsOfPublication(authors9);
		String[] authors10={"Einstein, Albert" , "Gallini, Galileo" , "Churchill, Winston"};

		Publication p10 = new ConferencePaper();
		p10.setIdentifierOfPublication(10);
		p10.setTitleOfPublication("This is publication 10 of type ConferencePaper");
        p10.setAuthorsOfPublication(authors10);

        /**
         * Publication lists that will hold Publications
         * cited by each publication is being created
         */
		ArrayList<Publication> p1cites= new ArrayList<Publication>();
		ArrayList<Publication> p2cites= new ArrayList<Publication>();
		ArrayList<Publication> p3cites= new ArrayList<Publication>();
		ArrayList<Publication> p4cites= new ArrayList<Publication>();
		ArrayList<Publication> p5cites= new ArrayList<Publication>();
		ArrayList<Publication> p6cites= new ArrayList<Publication>();
		ArrayList<Publication> p7cites= new ArrayList<Publication>();
		ArrayList<Publication> p8cites= new ArrayList<Publication>();
		ArrayList<Publication> p9cites= new ArrayList<Publication>();
		ArrayList<Publication> p10cites= new ArrayList<Publication>();

       /**
        * Adding Publications objects that were created earlier to the cited by list
        * 
        */
		p1cites.add(p9);
		p1cites.add(p2);
		p1cites.add(p3);
		
		p2cites.add(p1);
		
		p3cites.add(p1);
		
		p4cites.add(p1);
		p5cites.add(p4);
		
		p5cites.add(p2);
		p6cites.add(p10);
		p6cites.add(p3);
		p7cites.add(p1);
		p7cites.add(p4);
		p7cites.add(p8);
		p8cites.add(p6);
		p8cites.add(p9);
		p8cites.add(p5);
		p8cites.add(p1);
		p9cites.add(p6);
		p9cites.add(p2);
		p10cites.add(p5);
		p10cites.add(p2);
		p10cites.add(p7);
		
		ArrayList<Publication> p1citedBy= new ArrayList<Publication>();
		ArrayList<Publication> p2citedBy= new ArrayList<Publication>();
		ArrayList<Publication> p3citedBy= new ArrayList<Publication>();
		ArrayList<Publication> p4citedBy= new ArrayList<Publication>();
		ArrayList<Publication> p5citedBy= new ArrayList<Publication>();
		ArrayList<Publication> p6citedBy= new ArrayList<Publication>();
		ArrayList<Publication> p7citedBy= new ArrayList<Publication>();
		ArrayList<Publication> p8citedBy= new ArrayList<Publication>();
		ArrayList<Publication> p9citedBy= new ArrayList<Publication>();
		ArrayList<Publication> p10citedBy= new ArrayList<Publication>();

		p1citedBy.add(p2);
		p1citedBy.add(p4);
		p1citedBy.add(p3);
		p1citedBy.add(p7);
		p1citedBy.add(p8);
		p2citedBy.add(p1);
		p2citedBy.add(p5);
		p2citedBy.add(p9);
		p2citedBy.add(p10);
		p3citedBy.add(p1);
		p3citedBy.add(p6);
		
		p4citedBy.add(p7);
		p4citedBy.add(p5);
		p5citedBy.add(p8);
		p5citedBy.add(p10);
		p6citedBy.add(p8);
		p6citedBy.add(p9);
		p7citedBy.add(p10);
		p8citedBy.add(p7);
		p9citedBy.add(p1);
		p9citedBy.add(p8);
		p10citedBy.add(p6);
		
		/**
		 * Each Publication objects's citer and citedBy list is being set.
		 * p1.setArticlesCitedByThisPublication()
		 * p1.setArticlesCitingThisPublication()
		 * 
		 */
		
		p1.setArticlesCitedByThisPublication(p1cites);
		p1.setArticlesCitingThisPublication(p1citedBy);
		p2.setArticlesCitingThisPublication(p2citedBy);
		p2.setArticlesCitedByThisPublication(p2cites);
		p3.setArticlesCitingThisPublication(p3citedBy);
		p3.setArticlesCitedByThisPublication(p3cites);
		p4.setArticlesCitedByThisPublication(p4cites);
		p4.setArticlesCitingThisPublication(p4citedBy);
		p5.setArticlesCitedByThisPublication(p5cites);
		p5.setArticlesCitingThisPublication(p5citedBy);
		p6.setArticlesCitedByThisPublication(p6cites);
		p6.setArticlesCitingThisPublication(p6citedBy);
		p7.setArticlesCitedByThisPublication(p7cites);
		p7.setArticlesCitingThisPublication(p7citedBy);
		p8.setArticlesCitedByThisPublication(p8cites);
		p8.setArticlesCitingThisPublication(p8citedBy);
		p9.setArticlesCitedByThisPublication(p9cites);
		p9.setArticlesCitingThisPublication(p9citedBy);
		p10.setArticlesCitingThisPublication(p10citedBy);
		p10.setArticlesCitedByThisPublication(p10cites);
		/**
		 * A database which is a object of type PubDatabase is being created
		 */
		PubDatabase newDB = new PubDatabase();
		/**
		 * Each of the publication objects created earlier is being added to the new database
		 * newDB.addToDatabase(Publication)
		 */
		newDB.addToDatabase(p4);
		newDB.addToDatabase(p3);
		newDB.addToDatabase(p2);
		newDB.addToDatabase(p1);
	  
		newDB.addToDatabase(p5);
		newDB.addToDatabase(p6);
		newDB.addToDatabase(p7);
		newDB.addToDatabase(p8);
		newDB.addToDatabase(p9);
		newDB.addToDatabase(p10);
		Map<Integer,Integer> references = new HashMap<Integer,Integer>();
		/**
		 * Adding Publication p4 as the publication that is citing p2
		 */
		references=newDB.addingReferenceUsingArticleIdentifier(p4.getIdentifierOfPublication(),p2.getIdentifierOfPublication());
		
		List<String> allPublicationsForAnAuthor = new ArrayList<String>();
		allPublicationsForAnAuthor = newDB.getAllPublicationsForAnAuthor("A. Einstein");
		System.out.println("The publications for A. Einstein are " + allPublicationsForAnAuthor);
		
		List<String> allPubWithWordConferencePaper = newDB.getAllArticlesWithASpecificWordInTheirTitle("ConferencePaper");
		System.out.println("The publications with the word \"ConferencePaper\" in their title are " + allPubWithWordConferencePaper);
		
		
		
		double citationIndex = newDB.computeCitationIndex("Einstein, Albert");
		System.out.println("The citation index of Einstein, Albert is " + citationIndex);
		System.out.println("Removing an article from the database and check if references work");
		/**
		 * Publication p2 still exists in the database and hence this will give the expected output
		 * p4 was added as a Publication that cites p2 using the addingReferenceUsingArticleIdentifier() method. 
		 * Hence the citations of p2 should return p4 along with other Publications that were set as citers of p2
		 */
		boolean checkingIfPubExists = newDB.isAValidPublicationOfDatabase(p2);
		System.out.println("The publication p2 existence status in database is " + checkingIfPubExists);
		System.out.println("Retrieving the direct citations of " + p2.toString() +" which are " +newDB.gettingPublicationsThatDirectlyCiteAPublication(p2));
		System.out.println("Retrieving the indirect and direct citations of " + p2.toString() +" which are " +newDB.gettingIndirectCitationsOfAPublications(p2));
		
		/**
		 * Attempting to get citations of publication p2 after it has been removed from the  database returns empty list objects
		 */
		newDB.removingPublicationFromDataBase(p2);
		boolean checkingIfPubExists1 = newDB.isAValidPublicationOfDatabase(p2);
		System.out.println("The publication p2 existence status in database is " + checkingIfPubExists1);
        System.out.println("Retrieving the direct citations of " + p2.toString() +" which are " +newDB.gettingPublicationsThatDirectlyCiteAPublication(p2));
		System.out.println("Retrieving the indirect citations of " + p2.toString() +" which are " +newDB.gettingIndirectCitationsOfAPublications(p2));
		/**
		 * Attempting to remove not existing publication throws illegal argument exception
		 */
		
		/**
		 *  Attempting to add references for publication identifiers that are not valid throws illegal argument exception. 
		 *  newDB.removingPublicationFromDataBase(p2)
		 *  newDB.addingReferenceUsingArticleIdentifier(p2.getIdentifierOfPublication(), p8.getIdentifierOfPublication()) throws illegal argument exception
		 */
        newDB.addingReferenceUsingArticleIdentifier(p2.getIdentifierOfPublication(), p8.getIdentifierOfPublication());
        
        /**
         * Publication p1 cites Publication p2. Once Publication p2 is removed, it should not be present in cites list of Publication p1.
         * Returns a list without title of Publication object p2.
         */
        System.out.println("Retrieving the direct citations of " + p1.toString() +" which are " +p1.getArticlesCitedByThisPublication());
		
	}

}

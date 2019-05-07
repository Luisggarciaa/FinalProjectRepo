import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 * ----------------------------------

//The following is brief description of the project.
The name of the project is "Movie Collection App"
This was a solo project, that was designed to help users maintain their movie collection.
The app gives the user the ability to create various new Lists.
The user can then organizes their movies into specific groups/lists based on their criteria.
If a user has already created a list they can view,add or remove any movie from said list.
If the user make any adjustment to their lists they can save the list either as a text or binary file.
The user can also view a print out  of what the list would look like if it was to be printed.

//How to use the app
To use the app the user first needs to load/open a list of your movies.
Another thing the user can do is create a new list.
 To perform the steps above you(the user) needs to click on the "File" menu option. 
 Then you can simply click on "New" or "Open" option.
 
 - To open an existing list click on "File"-->"Open" then use the on screen menu to find the file you want to open.
  you will be shown a table with all the movies in this collection.
 
 
 - If you decide to create a new list you will be  be prompted by the console to enter specific information about the 
 movie you want to add to the collection .
 This information includes:
 name of the movie
 movie rating 
 what type of   genre is a part of
 the name of the lead  director
 the movie release date 
 the movie run time in minutes
 the format in which the movie is owned Blu-ray, DVD or Digital  
An indicator that inform the user if they  have recently watched the the movie 
After adding a movie to the list you will be shown a table with  the movie you just added to this collection.	
								
 
 
 
 -Like I mentioned above the the user can also add remove or view the content of the current list 
 
 -To add a movie the user  can click in the "add movie" button.
 By clicking the button you will be prompted by the console to enter specific information about the 
 movie you want to add to the collection .
 This information includes the same a when you create a new list.
After adding a movie to the list you will be shown a table with  the movie you just added to this collection.	
								
								
 - To delete a movie you can click in the "delete movie" button.
 By clicking the button yoy will be prompted by the console to enter  the Movie ID associated with the  
 movie you want to delete from  the collection .
 
 After deleting a movie from the list you will be shown an updated table with the specific movie not on the list.


 -The user can also view a print out  of what the list would look like if it was to be printed.
To  do this the you can click on the "File" -->"Print" option .
This will then display a console output of the movies that are in your current List.


Once the user /you are done modifying your list you can save the data stored in said list.
To  do this the you can click on the "File" -->"Save" option .
At this point you can use the on screen menu to find the location where you want to store/save the file.
  

To Exit out of the program the user can click on the "Exit" button or you can click on the "File" -->"Exit" option .




These are the  classes used in the app along with a description of the role they have in the program.

The Movie class is the model class that contains  the specific data for each individual movie in the current list.

The MoviePrinter is a controller class the prints out the list of movies in the console.

The MovieReader is a controller class that allows the program to read in data from the chosen by the user .
 
The MovieWriter is a controller class that allows the program to write out data  to a file  chosen by the user .

The MovieAdder is a controller class that allows the program to add a new movie based on the data that the user has entered. 

The MovieDeleter is a controller class that allows the program to remove a new movie based on the data that the user has entered. 

The DrawingFrame is a view class that displays t various graphical elements that indicate the actions that the user can perform . 

The DrawingPanel is a view class that displays a JTable object.The JTable object  will display all the data from a List in an  spreadsheet table.   

The JTableCreator is a controller class that allows the program to create a JTable object  with the data  from the list that was chosen by the user. 


the types of serialization this program supports are text and binary.

This a list of enhancements that i would like to integrate into my program

--In its current state my program will open a new form window each time the user opens a new list or adds/deletes  a movie from a list.
 I would like to modify my program so that only one window is open at all times.
 
 -- In the current state of my program the user has to use the console to add or delete a movie from a list.
 I would like to make it so that a user  now  views a new form window when they want to add/delete a movie from the list.
 This new windows would allow the user to   approve or cancel if they want to add or delete a movie.
 
 inside the same form I would like to integrate a set of features to validate the data being entered by the user.
This would prevent the user from entering invalid or wrong data in each data field 

*----------------------------------
*/
class Movie implements Serializable{
	
	/**
	 * This class will be used to create objects of the type Movie 
	 * Each of the Movie objects will have the following variables  methods and functions
	 */
	
	
	private int movieID;			//numeric ID for each movie  
	
	private String movieName;	   	// name of each movie 
	
	private String rating;		  	// movie rating 
	
	private String genre;		 	// movie genre
	
	private String director;		//movie director 
	
	private String releaseDate;		//movie release date 
	
	private int runTime;			//movie run time in minutes
	
	private String format;			//the format in which the movie is owned 1=Blu-ray, 2=DVD or 3=Digital  
	
	private boolean watchStatus;		//indicate if the user has watched the the movie 
									//0 = they have not seen it. they have has not open the case/played the media file  
									//1= has seen it.They open the the case and inserted the disk into the media player/streamed the media file 
	
	
	//The methods and functions that will set and get the values for the private data member

	public int getMovieID() {
		return movieID;
	}//end of getMovieID
	

	public void setMovieID(int inputMovieID) {
		movieID = inputMovieID;
	}//end of setMovieID


	public String getMovieName() {
		return movieName;
	}//end of getMovieName


	public void setMovieName(String inputMovieName) {
		movieName = inputMovieName;
	}//end of setMovieName


	public String getRating() {
		return rating;
	}//end of getRating


	public void setRating(String inputRating) {
		rating = inputRating;
	}//end of setRating


	public String getGenre() {
		return genre;
	}//end of getGenre


	public void setGenre(String inputGenre) {
		genre = inputGenre;
	}//end of setGenre


	public String getDirector() {
		return director;
	}//end of getDirector


	public void setDirector(String inputDirector) {
		director = inputDirector;
	}//end of setDirector


	public String getReleaseDate() {
		return releaseDate;
	}//end of getReleaseDate


	public void setReleaseDate(String inputReleaseDate) {
		releaseDate = inputReleaseDate;
	}///end of setReleaseDate


	public int getRunTime() {
		return runTime;
	}//end of getRunTime


	public void setRunTime(int inputRunTime) {
		runTime = inputRunTime;
	}//end of setRunTime
	
	
	
	public String getFormat() {
		return format;
	}//end of getFormat


	public void setFormat(String inputFormat) {
		format = inputFormat;
	}//end of setFormat


	public boolean getWatchStatus() {
		return watchStatus;
	}//end of getWatchStatus


	public void setWatchStatus(boolean inputWatchStatus) {
		watchStatus = inputWatchStatus;
	}//end of setWatchStatus
	
	
	/**
	 * * This is  the default constructor for the Movie object
   	    * The  constructor takes in the following parameter that 
   	    * indicate the features of a Movie object
	 * @param inputMovieID
	 * @param inputMovieName
	 * @param inputRating
	 * @param inputGenre
	 * @param inputDirector
	 * @param inputReleaseDate
	 * @param inputRunTime
	 * @param inputFormat
	 * @param inputWatchStatus
	 *  The constructor also  calls all of the set methods to set the values for
   	 * each private data member
	 */
	
	public Movie ( int inputMovieID, String inputMovieName,String inputRating,String inputGenre, String inputDirector, String inputReleaseDate,int inputRunTime, String inputFormat , boolean inputWatchStatus) {
		
		setMovieID(inputMovieID);
		setMovieName(inputMovieName);
		setRating( inputRating);
		setGenre(inputGenre);
		setDirector(inputDirector);
		setReleaseDate(inputReleaseDate);
		setRunTime(inputRunTime);
		setFormat( inputFormat);
		setWatchStatus( inputWatchStatus);
			
	}//end of Movie constructor 
	
	
	/**
	 * The toString function will display information
	 *  about the Movie object in the console 
	 */
    public String toString() {
    	return String.format("Movie ID : %d   Movie Name : %s   Movie Rating : %s   Movie Genre : %s   Movie Director : %s   Movie Release Date : %s   Movie Runtime(Mins) : %d   Movie Format : %s   Has it been watched : %s" , 
    			movieID,movieName,rating,genre, director, releaseDate, runTime, format , watchStatus);
    }//end of toString 
	
    
}//end of the Movie class





class MoviePrinter{
	/**
	 * This class has only one role
	 * It will take in a parameter  which is an ArrayList of Movie objects 
	 * The class has the printMovies method that will  run  a for loop that calls the To string function for every Movie object in the ArrayList
	 This function will be used to display the information for each movie in the users' collection 
	 * @param inputMovies 
	 */
    public static void printMovies(ArrayList<Movie> inputMovies) {
   
    	
        	for (Movie m : inputMovies) {
        		System.out.println(m);
        	}///end of for loop
    		
    	
    	
    }//end of printMovies

}//end of MoviePrinter





class MovieReader{
	
	/** this class allows the program  read the Movie information from a
	 * text file. That text file is comma-separated and organized in this format
	 * movieID,movieName,rating,genre, director, releaseDate,runTime,format ,watchStatus;		
	 * The class has only one static function that will read the Movie info 
	 */
	
	/**
	 * The static function will take in a file name and store it in a String named fname 
	 * @param fname
	 * @return
	 * The function will return an ArrayList of Movies  that will have all the info for all the Movies in
	 *  the file used by fname
	 */
	
	public static ArrayList<Movie>ReadingMoviesFromTextFile(String fname){
		
		// the ArrayList to store all the Movies in a textFile
				ArrayList<Movie> inputMovies = new ArrayList<Movie>();
				
				//to perform the reading of a file we will need place the code in a try catch block
				try {
					
					//local variable to store the data for each Movie object that will be created 
					int inputMovieID,inputRunTime;
					String inputMovieName, inputRating, inputGenre,  inputDirector,  inputReleaseDate,  inputFormat = null;
					boolean inputWatchStatus = false;
				
					
					//local Movie object that will be used to store the
					//data for a new movie object 
					Movie newMovieFromFile;
					
					
					//the following variables will help to determine the value for the movie format and  watch status;
					int movieFormatNumber,movieWatchStatusNumber;
					
					
					//this line connects the content of the file in the variable fname
					//to a buffered reader 
					//the buffer reader will store all the the file data 
					BufferedReader br = new BufferedReader(new FileReader(fname));
			
					
					
					//this String variable will hold the data for each line of text in the file
					String currentLine=null;
					
					
					
					//the following is a while loop that will read the data from the file 
					 
					
					//the loop will run as long as the program can store a line of text in
					//the currentLine Variable 
					//this can be indicated by checking if the currentLine variable is equal to null
					
					
					while ((currentLine=br.readLine()) !=null) {
						
						//store the complete line of text in an Array of type String 
						//and split each part  the line everywhere a comma is detected
						
						 String[] data = currentLine.split(",");
						 
						 
						 //store each part pf the string into a  variable
						 
						 inputMovieID=Integer.parseInt(data[0]);
						 
						 inputMovieName=data[1];
						 
						 inputRating=data[2];
						 
						inputGenre=data[3];
						
						inputDirector=data[4];
						
						inputReleaseDate=data[5];
						
						inputRunTime=Integer.parseInt(data[6]);
						
						
						
						movieFormatNumber=Integer.parseInt(data[7]);
						
						//determine the value that will be assigned to inputFormat
						//the format in which the movie is owned 1=Blu-ray, 2=DVD or 3=Digital
						if (movieFormatNumber==1) {
							
							inputFormat="Blu-ray";
							
						}else if (movieFormatNumber==2) {
							
							inputFormat="DVD";
							
						}else if (movieFormatNumber==3) {
							
							inputFormat="Digital";
						}//end of if else if block
						
	
						
						
						movieWatchStatusNumber=Integer.parseInt(data[8]);
						
						//determine the value that will be assigned to inputWatchStatus
						//0 = they have not seen it. they have has not open the case/played the media file  
						//1= has seen it.They open the the case and inserted the disk into the media player/streamed the media file 

						if (movieWatchStatusNumber==0) {
							inputWatchStatus=false;
						
						}else if (movieWatchStatusNumber==1) {
							inputWatchStatus=true;
						
						} //end of if else if block
							
						
				    	 //this line of code prints out the data for each point objects before they are created and added to the ArrayList//this for testing purpose
						//System.out.println(inputMovieID+" " +inputMovieName+" " +inputRating+" " +inputGenre+" " +inputDirector+" " +inputReleaseDate+" " +inputRunTime+" " +inputFormat+" " +inputWatchStatus);
	
						
						 //create a new point object based on the data that was passed in
						newMovieFromFile=new Movie(inputMovieID, inputMovieName, inputRating, inputGenre, inputDirector, inputReleaseDate, inputRunTime, inputFormat, inputWatchStatus);
		
				    	 //add the new point object to the local ArrayList
						inputMovies.add(newMovieFromFile);
			
						
						
					}
					//when the program is don reading in the data  close the file 	
				    br.close();
						
				
					//return the array list of Movies from the file 
					return inputMovies;
					
				}catch(Exception ex) {
					
					//in case of not being able to read the file 
					//return nothing 
					return null;
				}//end of try catch block
		
		
	}//end of ReadingMoviesFromTextFile
	
}//end of MovieReader





class MovieWriter{
	/** this class allows the program  write the movie info to a
	// a text file. That text file is space-separated and organized in this format
	* movieID,movieName,rating,genre, director, releaseDate,runTime,format ,watchStatus;
	 * The class has only one static method that will write the Movie info 
	 * The static function will take in an ArrayList of Movies and the file location /name for where the file will be saved 
	 *  
	 *  
	 * @param outputMovies , fname
	 * @return true to indicate the file was written to correctly 
	 *  or false if we get an error
	 */
	
	public static boolean WriteMoviesToTextFile(ArrayList<Movie>outputMovies ,String fname){
		
		try {
			//creating a PrintWriter that will help send the data from the program to the final save location stored 
			//in the fname String
			PrintWriter pW= new PrintWriter(new BufferedWriter(new FileWriter(new File(fname))));
			
			//for loop that will write the data to the file ,and store the file  in the location value stored in fname
			
			for (Movie m: outputMovies) {
				pW.print(m.getMovieID()+",");
				pW.print(m.getMovieName()+",");
				pW.print(m.getRating()+",");
				pW.print(m.getGenre()+",");
				pW.print(m.getDirector()+",");
				pW.print(m.getReleaseDate()+",");
				pW.print(m.getRunTime()+",");
				
				
				//determine the value that will be written as the value for to Movie Format
				//the format in which the movie is owned 1=Blu-ray, 2=DVD or 3=Digital
				if (m.getFormat()=="Blu-ray"){
					pW.print(1+",");
					
				}else if (m.getFormat()=="DVD") {
					pW.print(2+",");
					
				}else if (m.getFormat()=="Digital") {
					pW.print(3+",");
			
				}//end of if else if block
				
				
				//determine the value that will be written as the value for WatchStatus
				//0 = they have not seen it. they have has not open the case/played the media file  
				//1= has seen it.They open the the case and inserted the disk into the media player/streamed the media file 

				if (m.getWatchStatus()==false) {
					pW.print(0);
				}else if (m.getWatchStatus()==true) {
					pW.print(1);
				}//end of if else if block
				
				//create a new line 
				pW.println();
				
			}//end of for loop
			

			//close the PrintWriter
			pW.close();
			
			return true;
		}catch(Exception ex) {
			
			return false; 
		}//end of try catch block
		
		
	}//end of WiteMoviesToTextFile

}//end of MovieWritter






class MovieAdder{ 
/**
 * **
	 * This class has only one role
	 * It will take in a parameter  which is an ArrayList of Movie objects 
	 * The class has the AddMovie method.
	 * This method  will  collect the information that the user types into the command line
	 * and with that a new movie object will be created 
	 * The method will return an updated  array list with the newe movie added 
	 * @param inputMovies 
	 */
 

	public static  ArrayList<Movie>AddMovie(ArrayList<Movie>inputMovies){
	
		//local variable to store the data for each Movie object that will be created 
		int inputMovieID,inputRunTime, inputFormatNumber,inputWatchedNumber;
		
		String inputMovieName, inputRating, inputGenre,  inputDirector,  inputReleaseDate,  inputFormat = null;
		
		boolean inputWatchStatus = false;
	
		
		//local Movie object that will be used to store the
		//data for a new movie object 
		Movie newMovieFromUser;
		
		
		///local Scanner variable to take read in the user input
		Scanner sc= new Scanner (System.in);
		
		
		
		
		// prompts that ask the user to enter data 
		
		System.out.println("Add a Movie:");
		System.out.println("Please do not add commas in any of the fields.");
		System.out.println("Please enter:");
		System.out.println();
		
		
		
		
		System.out.print("Name:");
		inputMovieName=sc.nextLine();
		
	
		
		System.out.print("Rating:");
		inputRating=sc.nextLine();
		
	
		

		
		System.out.print("Genre:");
		inputGenre=sc.nextLine();
	

		
		System.out.print("Director:");
		inputDirector=sc.nextLine();
	
		
		
		
		System.out.print("Release Date MM/DD/YYYY:");
		inputReleaseDate=sc.nextLine();
		
		
		
		
		System.out.print("Runtime(In Minutes):");
		inputRunTime=sc.nextInt();
	
		
		
		System.out.println("In what format do you own the movie?");
		System.out.print( "1=Blu-ray, 2=DVD or 3=Digital:");
		inputFormatNumber=sc.nextInt();	
	
		
		
		System.out.println("Have you recently watched the movie?");
		System.out.print("1=Yes/ 0=No:");
		inputWatchedNumber=sc.nextInt();
		
		
		
		if (inputFormatNumber==1) {
			
			inputFormat="Blu-ray";
			
		}else if (inputFormatNumber==2){
			
			inputFormat="DVD";
			
		}else if (inputFormatNumber==3) {
			
			inputFormat="Digital";
			
		}//end of if else if block
		
		
		
		if (inputWatchedNumber==0) {
			inputWatchStatus=false;
		
			
		}else if (inputWatchedNumber==1) {
			inputWatchStatus=true;
		}////end of if else if block
			
		
		//setting the MovieID for the movie that will be added
		inputMovieID=inputMovies.size()+1;
		
		//this line is for testing purposes
		//System.out.println(inputMovieID+ inputMovieName+ inputRating+ inputGenre+ inputDirector+ inputReleaseDate+ inputRunTime+ inputFormat+ inputWatchStatus);
		
		
		//creating a new Movie object
		newMovieFromUser=new Movie(inputMovieID, inputMovieName, inputRating, inputGenre, inputDirector, inputReleaseDate, inputRunTime, inputFormat, inputWatchStatus);
		
		
		//adding the new movie to the ArrayList
		inputMovies.add(newMovieFromUser);

		
	//returning the updated movieArraylist
	return inputMovies;
	
	}//end of AddMovie


}///end of MovieAdder


class MovieDeleter{
	/**
	 * **
		 * This class has only one role
		 * It will take in a parameter  which is an ArrayList of Movie objects 
		 * The class has the DeleteMovie method.
		 * This method  will  collect the information that the user types into the command line
		 * and with that a specific MovieID a movie in the arrayList will be deleted 
		 * The method will return an updated array list with the movie deleted
		 * @param inputMovies 
		 */
	
	
	public static ArrayList<Movie>DeleteMovie(ArrayList<Movie>inputMovies){
		
		//local variable to store the MovieID for the movie that will be deleted 
		//	//local varable to store the max number of movies in the movie collection 
		int inputMovieID,maxNumsOfMovies;
		
	//local variable to store the name of the movie to be deleted 
		String nameOfTheDeletedMovie;
		///local Scanner variable to take read in the user input
		Scanner sc= new Scanner (System.in);
		
		
		
		
		//check if the array list is empty / has no elements 
		if (inputMovies.isEmpty() && inputMovies.size()==0) {
			
			//if the arrayList is empty the user gets a message
			JOptionPane.showMessageDialog(null,"The movie collection is empty");
			
		}else{
			
			//get the max number of movies 
		maxNumsOfMovies=inputMovies.size();
		
		// prompts that ask the user to enter data 
		
				System.out.println("Delete a Movie:");
				
				System.out.print("Please enter the corresponding Movie ID :");
				
				inputMovieID=sc.nextInt();
				
				
				//determine if the user input is valid 
				//if it is not display a message
				//repeat the process if the user keesps entering an invalid Movie ID
				
				
			
				
				do {
					if (inputMovieID <1 || inputMovieID > maxNumsOfMovies) {
						
						JOptionPane.showMessageDialog(null,"Please select a valid movie ID 1 -" +maxNumsOfMovies);
						
						
						System.out.print("Please enter the corresponding Movie ID :");
						
						inputMovieID=sc.nextInt();
						
					}//end of if else if block
					
					
					
				}while(inputMovieID <1 || inputMovieID > maxNumsOfMovies);
					
				
				
				
				
				
				
				//now we will delete the selected Movie
				
				nameOfTheDeletedMovie=inputMovies.get(inputMovieID-1).getMovieName();
				
				JOptionPane.showMessageDialog(null,"Deleting "+nameOfTheDeletedMovie);
				
				inputMovies.remove(inputMovieID-1);
				
				JOptionPane.showMessageDialog(null,"done Deleting "+nameOfTheDeletedMovie);
				
				
		}//end of the if block to check if the array list is empty / has no elements 
		
		
		//returning the updated movieArraylist
		return inputMovies;
		
		
		
	}//end of DeleteMovie
	
	
}//end ofMovieDeleter






 class DrawingFrame extends JFrame  {
/**
* The DrawingFrame class will be responsible for setting up all the user interface  features
 *The DrawingFrame objects will have the following variables  methods and functions
 */
	
	// The points ArrayList will hold all of the movies 
	private ArrayList<Movie> inputMovies =null;

	//This is the JPanel object that will display the Movie info
	 //create the drawingpanel class
	private DrawingPanel panDrawing;

	
	 
	/**
	 * The setupUI method will setup all the features need to display a user window 
	 */
	public void setupUI(){
		
		//the default action when the user window is closed
		setDefaultCloseOperation(EXIT_ON_CLOSE);
			
				
		//set the starting point and the size of the user window 
		setBounds(100,100,240,150);		
		

		//obtaining a content pane for the heavyweight   container
		Container c = getContentPane();
		
		
		//setting the  layout for the heavyweight  container
		c.setLayout(new BorderLayout());
		
		
		//creating a new JPanel 
		//this Jpanel will hold buttons that allow user to perform a action
		JPanel panSouthButtons = new JPanel();
			
	
		
		
		
		//creating a new JButton 
		JButton btnExit = new JButton("Exit");
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				 // The user window will be closed 
    	   			System.exit(0);
			}//end of actionPerformed
			
		});//end of addActionListener
		
		
		  //Adding the JButton btnExit  to the JPanel panSouth 
		panSouthButtons.add(btnExit);
		
		
		
		
		
		//creating a new JPanel 
		//this Jpanel will hold buttons that allow user to perform a action
		JPanel panEastButtons =new JPanel( );
		
		
		//this button will allow the user to add a new movie to the ArrayList
		JButton btnAddmovie = new JButton("Add movie");
		
		btnAddmovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//this if statement block check to see if the inputMovies arrayList is pointing to nothing /is empty because no file has been added to the arraylist
    			if (inputMovies==null) {
    	    		
    	    		JOptionPane.showMessageDialog(null,"No file has been opened");

    	    	}else {
    	    		
    	    		/**
        	    	 * The MovieAdder object will take in the inputMovies ArrayList as an argument 
        	    	 * To then add a new movie
        	    	 */
        	    		inputMovies=MovieAdder.AddMovie(inputMovies);
        				//this should update the Movies on screen when a file is opened 
					       //call the method to pass the new Movies to the panDrawing
					    	panDrawing =new DrawingPanel(inputMovies);
							panDrawing.setVisible(true);
					    
    	    	}//end of if else block
        	    		
    	    		
			
			}//end of actionPerformed
			
		});//end of addActionListener
		
		
		
	
		
		//this button will allow the user to delete a  movie from the ArrayList

		JButton btnDeletemovie = new JButton("Delete movie");
		
		btnDeletemovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				//this if statement block check to see if the inputMovies arrayList is pointing to nothing /is empty because no file has been added to the arraylist
    			if (inputMovies==null) {
    	    		
    	    		JOptionPane.showMessageDialog(null,"No file has been opened");
    	    		
    	    	}else {
    	    	
    	    		inputMovies=MovieDeleter.DeleteMovie(inputMovies);
    				//this should update the Movies on screen when a file is opened 
				       //call the method to pass the new Movies to the panDrawing
				    	panDrawing =new DrawingPanel(inputMovies);
				    	panDrawing.setVisible(true);
				    

    	    		
    	    	}//end of if else block
        	    		
				
			}//end of actionPerformed
			
		});//end of addActionListener
		
		
		panEastButtons.add(btnAddmovie);
		panEastButtons.add(btnDeletemovie);
		
		
		
		// Adding the JPanel panSouthButtons to the c heavyweight container 
		c.add(panSouthButtons,BorderLayout.SOUTH);
		
		// Adding the JPanel panEastButtons to the c heavyweight container 
		c.add(panEastButtons,BorderLayout.EAST);
				
		
		
		// Calling the setupMenu method that adds the menu bar to the  top of the user window 
		setupMenu();
		
		
	}//end of setupUI

	
	
	
	
	private void setupMenu() {
	
		/**
		 * The setupMenu Method will add a menu bar to the 
		 * Northern region of the user window
		 */
		
		/**
		 * Adding a JMenuBar object named mbar
		 */
		JMenuBar mbar = new JMenuBar();
		
		
		/**
		 * Adding a JMenu object named mnuFile
		 */
    	JMenu mnuFile = new JMenu("File");
    	
    	
    	/**
    	 * Adding a JMenuItem object named miNew
    	 */
    	JMenuItem miNew= new JMenuItem("New");
miNew.addActionListener(new ActionListener() {
        	
    		public void actionPerformed(ActionEvent e) {
    		//the user windows will pronpt the user to a movie to the collection by calling the MovieAdder Class
    			
    			/**
    	    	 * The MovieAdder object will take in the inputMovies ArrayList as an argument 
    	    	 * To then add a new movie
    	    	 */
    			//new ArrayList 
    				inputMovies =new ArrayList<Movie>();
    					
    				//set the data for  ArrayList to the data enter by the user
    	    		inputMovies=MovieAdder.AddMovie(inputMovies);
    				//this should update the Movies on screen when a file is opened 
				       //call the method to pass the new Movies to the panDrawing
				    	panDrawing =new DrawingPanel(inputMovies);
						panDrawing.setVisible(true);
				    
    			
    		
    		
    	
    	 
    
    		}//end of actionPerformed

			
    	});//end of addActionListener
    
    
 	
 	
    	
    
    	/**
    	 * Adding a JMenuItem object named miOpen
    	 */
    	JMenuItem miOpen= new JMenuItem("Open");
 	miOpen.addActionListener(new ActionListener() {
        	
    		@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
    			/**
    			 * The user window will bring up a window  to select a file to open 
    			 */
    			
    	   		// the name of the file
    			String fname;
    			
    			//the file extension for the selected file
    			String fextension;
    			
    			//the full file path 
    			String fullPath ;
    			//the file object that will link the file to our program 
    			File FileObject = null;
    			
    			
    			//the file chooser that will show the user the window
    			JFileChooser jfc = new JFileChooser();
    			
    			//check if the user click the ok button on the file chooser window/ a file was chosen 
    			if (jfc.showOpenDialog(DrawingFrame.this) == JFileChooser.APPROVE_OPTION) {
    				
    				// store the name of the file in the File object variable
    				FileObject = jfc.getSelectedFile();	
    				
    				//get the name of the file that will be opened
        			fname=FileObject.getName();
        				
        			
        			//get the extension
        			fextension=fname;
        			fextension=fextension.substring(fextension.lastIndexOf("."), fextension.length());
        			
        			
        			//get the full path for the file that is going to be opened 
        			fullPath=FileObject.getAbsolutePath();
        			
        			
        			//Open the selected File

       
	    			//check to see what type of file was opened 
        			
	
								if (fextension.contains(".txt")) {
									
									
									//show a  pop up window that show what file will be opened
									JOptionPane.showMessageDialog(null,"opening " + FileObject.getName());
									
									//determine what needs to be done when opening the file 
									//if the arrayList is set to null (pointing to no data ) do nothing.... 
									//if the rrayList is not set null (has data that it's pointing to) clear the data ....
									// this help clear up  the array when new data is added to it
									
									if (inputMovies==null) {
										//JOptionPane.showMessageDialog(null,"the array list IS pointing to null " );
										
									}else if  (inputMovies!=null) {
 		
 									//JOptionPane.showMessageDialog(null,"the array list is NOT pointing to null " );
 									inputMovies.clear();
 									}//end of if else if block
									
								
						 			//set the Movies arraylist to the arraylist created by the Movie reader
									inputMovies=MovieReader.ReadingMoviesFromTextFile(fullPath);
									
									
									
									//show a  pop up window that show that the file opened
									JOptionPane.showMessageDialog(null,"done opening  " + FileObject.getName());
									
									
									//this should update the Movies on screen when a file is opened 
							       //call the method to pass the new Movies to the panDrawing
									
									panDrawing =new DrawingPanel(inputMovies);
									panDrawing.setVisible(true);
							    	
										
								
								}else if (fextension.contains(".bin")) {
									
									///need to find a way to solve the  show the updated screen
									
											//show a  pop up window that show what file will be opened
											JOptionPane.showMessageDialog(null,"opening " + FileObject.getName());
											
											try {
												
											
												
												//create a new object input stream
												ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fullPath));
												
												
												//determine what needs to be done when opening the file 
												//if the arrayList is set to null (pointing to no data ) do nothing.... 
												//if the rrayList is not set null (has data that it's pointing to) clear the data ....
												// this help clear up  the array when new data is added to it
												
												if (inputMovies==null) {
													//JOptionPane.showMessageDialog(null,"the array list IS pointing to null " );
													
												}else if  (inputMovies!=null) {
			 		
			 									//JOptionPane.showMessageDialog(null,"the array list is NOT pointing to null " );
			 									inputMovies.clear();
			 									}//end of if else if block
												
												
												//assign the movies from the file to the arraylist  
												inputMovies = (ArrayList<Movie>)ois.readObject();
												
												//close the object input stream
												ois.close();
												
												//show a  pop up window that show that the file opened
												JOptionPane.showMessageDialog(null,"done opening  " + FileObject.getName());
												
												//this should update the Movies on screen when a file is opened 
											    //call the method to pass the new Movies to the panDrawing
												
												
										//create a new JFrame 
											    	panDrawing =new DrawingPanel(inputMovies);
											    	panDrawing.setVisible(true);
											    	
												
												
												
												
									    	}catch(Exception ex) {
												//show a  pop up window that show that the file was not able to be opened

									    	JOptionPane.showMessageDialog(null,"error while opening " + FileObject.getName());
												
											}//end of try catch block
								
								}else {
									//show a  pop up window that show what file will be opened
							  		JOptionPane.showMessageDialog(null,"can not open " + FileObject.getName());
								}
					
								
				}//end of file chooser if 
    			
    		
    		
    	
    	 
    
    		}//end of actionPerformed

			
    	});//end of addActionListener
    
    
 	
 	
 	
    	/**
    	 * Adding a JMenuItem object named miSave
    	 */
    	JMenuItem miSave= new JMenuItem("Save");
    	
    	miSave.addActionListener(new ActionListener() {
        	
    		public void actionPerformed(ActionEvent e) {
    			
    			//this if statement block check to see if the inputMovies arrayList is pointing to nothing /is empty because no file has been added to the arraylist
    			if (inputMovies==null) {
    	    		
    	    		JOptionPane.showMessageDialog(null,"No file has been opened");
    	    		
    	    	}else {
    	    		
    	    		//if the arraytlist is pointing to a set of data 
    	    		
    	    	
    	   		// the name of the file
    			String fname;
    			//the file object that will link the file to our program 
    			File inputFileObject=null;
    			
    			//the file extension for the selected file
    			String fextension;
    			
    			//the file object that will link the file to our program 
    			String fullPath;
    			
    			//the file chooser that will show the user the window
				JFileChooser jfc = new JFileChooser();
				
				
				
    			
    			//check if the user click the ok button on the file chooser window/ a file was chosen 
				if(jfc.showSaveDialog(DrawingFrame.this)==JFileChooser.APPROVE_OPTION) {
					
					// store the name of the file in the File object variable
					inputFileObject=jfc.getSelectedFile();
					
				
					//get the name of the file that will be written
        			fname=inputFileObject.getName();
        				
        			
        			//get the extension
        			fextension=fname;
        			fextension=fextension.substring(fextension.lastIndexOf("."), fextension.length());
        			
        			
        			//get the full path for the file that is going to be written 
        			fullPath=inputFileObject.getAbsolutePath();
        			
        			
        			//save the selected File

 			       
        			//check to see what type of file was selected to be saved 
        			
    							if (fextension.contains(".txt")) {
    							
	    								//show a  pop up window that show what file will be saved
										JOptionPane.showMessageDialog(null,"saving " + inputFileObject.getName());
										
	    								//write the content of the points arraylist to the full path location 
										MovieWriter.WriteMoviesToTextFile(inputMovies, fullPath );
	    								
	    								
	    								//show a  pop up window that show what file will be saved
										JOptionPane.showMessageDialog(null," done saving " + inputFileObject.getName());
										
	    								
    							}else if (fextension.contains(".bin")) {
    								
    										//show a  pop up window that show what file will be saved
    										JOptionPane.showMessageDialog(null,"saving " + inputFileObject.getName());
    										

    								    	try {
    								    		

												//create a new object output stream
    								    		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fullPath));
    											
												//Write the data from the points arraylist to the object output stream
    								    		oos.writeObject(inputMovies);
    								    		
												//close the object output stream
    								    		oos.close();
    											
    											//show a  pop up window that show what file will be saved
        										JOptionPane.showMessageDialog(null," done saving " + inputFileObject.getName());
    											
        										
    								    	}catch(Exception ex) {
    								    		
    								    		//show a  pop up window that show what file will be saved
        										JOptionPane.showMessageDialog(null,"error while saving " + inputFileObject.getName());
    											
    										}//end of try catch block
    								    	
    								 		
    							}else {
    								//show a  pop up window that show what file will be opened
    						  		JOptionPane.showMessageDialog(null,"can not save " + inputFileObject.getName());
    							}//end of if else if else block
    						
        			
        			
        			
				}//end of file chooser if 
				
    	    }//end of if else block
				
    	}//end of actionPerformed
    		
    	});//end of addActionListener
    	
    	
    	


    	/**
    	 * Adding a JMenuItem object named miPrint
    	 */
    	JMenuItem miPrint= new JMenuItem("Print");
    	miPrint.addActionListener(new ActionListener() {
        	
    		public void actionPerformed(ActionEvent e) {
 		
    			
    			//this if statement block check to see if the inputMovies arrayList is pointing to nothing /is empty because no file has been added to the arraylist
    			if (inputMovies==null) {
    	    		
    	    		JOptionPane.showMessageDialog(null,"No file has been opened");
    	    		
    	    	}else {
    	    		
    	    		/**
        	    	 * The MoviePrinter object will take in the inputMovies ArrayList as an argument 
        	    	 * To then display the information for each Movie object
        	    	 */
        	    	MoviePrinter.printMovies(inputMovies);
        	    		
    	    		
    	    	}//end of if else block
    			
    		
    		}//end of actionPerformed
    		
    	});//end of addActionListener
    	
    	
    	
    	
    	
    	/**
    	 * Adding a JMenuItem object named miExit
    	 */
    	JMenuItem miExit= new JMenuItem("Exit");
    	miExit.addActionListener(new ActionListener() {
        	
    		public void actionPerformed(ActionEvent e) {
    			/**
    			 * The user window will be closed 
    			 */
    	   			System.exit(0);
    	   			
    		}//end of actionPerformed
    		
    	});//end of addActionListener
		

    	
    	
    	
       	/**
    	 * Adding the JMenuItems miOpen,miSave, miPrint,miExit
    	 * 
    	 * to the mnuFile JMenu mnuFile
    	 */
    	mnuFile.add(miNew);
    	mnuFile.add(miOpen);
		mnuFile.add(miSave);
		mnuFile.add(miPrint);
		mnuFile.add(miExit);
		
		
	   	/**
		 * Adding the JMenu mnuFile  to the mBar JMenuBar 
		 */
	   	mbar.add(mnuFile);
	 
	   	
	   	/**
	   	 * Setting the JMenuBar 
	   	 * to the mbar object
	   	 */
	   	setJMenuBar(mbar);
	   	
		
	}//end of setupMenu


	
	
	
	/**
	 *  This is the DrawingFrame constructor
	 *  It will call the setupUI method  
	 *  set the window as a focusable object
	 *  and set the focus to the current window
	 */
	public DrawingFrame() {
		setupUI();
		setFocusable(true);
		requestFocusInWindow();
		
	}//end of DrawingFrame constructor
	
	 
 }//end of DrawingFrame

 

 
 
 class DrawingPanel extends JFrame{
	 
	 /**
	  * This variable will locally store the ArrayList content that was passed in
	  */
	 private ArrayList<Movie> displayedMovies=null;
	 
	
	 
	 
	public void setupTable(){
		
				//set the starting point and the size of the user window 
				setBounds(500,100,1500,500);	
				 
		
				//obtaining a content pane for the heavyweight   container
				Container c = getContentPane();
				
				
				//setting the  layout for the heavyweight  container
				c.setLayout(new BorderLayout());
				
				
				//creating a new JPanel 
				 JPanel panel = new JPanel();
			        
			        panel.setLayout(new BorderLayout());
				
			        
			         //create a JScolPanel object that will hold inside it a table filled with data 
			        JScrollPane tableContainer = JTableCreator.tableContainer(displayedMovies);

			     //add the SrollPanel to the the J Panel light weight  container
			        panel.add(tableContainer, BorderLayout.CENTER);
			        
				     //add the Jpanel to the the J frame heavy weight  container
			        
			        c.add(panel);
			
	 }//end of setupTable
	 
	 
	 
	 
	 
	 
		
	
	public DrawingPanel(ArrayList<Movie> moviesFromFiles) {
		
		/**
		 * this method will  set the content of the arraylist inside of  drawingPanel
		 * It is called when a new file is Open 
		 * Also if a entry on the table is added or deleted 
		 */
		displayedMovies =moviesFromFiles;
		
		//these lines are for testing
		//System.out.println("The arraylist has been updated");
		//System.out.println("The Array has "+displayedMovies.size());

		
		//call the method to setup the Jtable
		 setupTable();
	
		
	 }//end of DrawingPanel constructor
	 
 }//end of DrawingPanel
 
  
 
 
 

 class JTableCreator{
	 /**
	  * this class will  have one role .
	  * It will create a table that displays the data passed in by the ArrayList
	  * In the end it will return a JScrollPanel that has a JTable Object 
	  * @param inputMovies
	  * @return
	  */
	 
	 public static JScrollPane tableContainer(ArrayList<Movie> inputMovies) {
		 
		// these are local variables that will  store single pieces of data for one ArrayList entry
		 int inputMovieID;
		 String inputMovieName;
		 String inputRating;
		 String inputGenre;
		 String inputDirector;
		 String inputReleaseDate;
		 int inputRunTime;
		 String inputFormat;
		boolean inputWatchStatus;
		 
	
		//this DefaultTableModel object is used to store data in a vector/2D array format that it can be used by a JTable 
		DefaultTableModel tableModel = new DefaultTableModel();
		
		//Here we will create a JTable object 
		//The JTable object has a DefaultTableModel object as an argument that will pass in a set of data
		JTable table= new JTable(tableModel); 
	
		

	//Here we will assign the values for the columns in the JTable 
		tableModel.addColumn("Movie ID");
		tableModel.addColumn("Movie Name");
		tableModel.addColumn("Rating");
		tableModel.addColumn("Genre");
		tableModel.addColumn("Director");
		tableModel.addColumn("Release Date");
		tableModel.addColumn("Run Time");
		tableModel.addColumn("Movie Format");
		tableModel.addColumn("Watch Status");
	
		
		
		//This for loop will extract data from the inputMovies ArrayList 
		//The data will be assigned to local variables
		//so that the data can be used late 
	
	for (int i=0;i<inputMovies.size();i++ ) {
		
		inputMovieID=inputMovies.get(i).getMovieID();
		
		inputMovieName=inputMovies.get(i).getMovieName();
		
		inputRating=inputMovies.get(i).getRating();
		
		inputGenre=inputMovies.get(i).getGenre();
		
		inputDirector=inputMovies.get(i).getDirector();
		
		inputReleaseDate=inputMovies.get(i).getReleaseDate();
		
		
		inputRunTime=inputMovies.get(i).getRunTime();
		
		inputFormat=inputMovies.get(i).getFormat();
		
		inputWatchStatus=inputMovies.get(i).getWatchStatus();
		
		
		//here we create a generic object that will  store all the single pieces of data for one ArrayList entry
		Object[]data= { inputMovieID, inputMovieName,inputRating , inputGenre , inputDirector , inputReleaseDate, inputRunTime, inputFormat, inputWatchStatus};
	
		//here we will add the generic object to the tableModel that will be used by the JTable 
		tableModel.addRow(data);
	
		
	}//end for loop
	
	// here we create a JScrol panel that will make it so that the JTable can be scrolled through if it is larger then the screen .
	//the  JScrol panel will take in the JTable object as a argument 
	
     JScrollPane tableContainer = new JScrollPane(table);

     //set the table so it uses all of the vertical   space of the frame its in.
     table.setFillsViewportHeight(true);
     
     
     
     // this methods return  the  JScrol panel object so it can be used in another part of the program
	return tableContainer;
	 
		 
	 }//end of  tableContainer
	 
	 
	 
 }//end of JtableCreator






public class GarciaMovieCollectionApp {

	public static void main(String[] args) {
		
		/**
		 * -------------------------------------------
		 * This is the function that will start the program 
		 * The program will create the following object/ variable:
		 * 
		 *- A DrawingFrame object
		 *The DrawingFrame object will display a user window
		 *that allows a user to load a file that has a movie collection
		 * -------------------------------------------
		 */
		
		
    	/**
    	 * The Program will then create a new DrawingFrame object
    	 */
    	 DrawingFrame frm = new DrawingFrame();
    	 
    	 
    	 /**  
    	 * The program will then set the visibility of the DrawingFrame object
    	 */
    	frm.setVisible(true);

	
	}//end of main class

}//end of GarciaMovieCollectionApp











/**
 * TODO 
 * INTIGRATE MENU 
 * 
 * NEW- CREATE NEW EMTY FILE
 * 
 * 
 * OPEN -OPEN CURRENT FILE -- can open txt & bin files 
 * SAVE-  can save txt & bin files
 * PRINT-CMD PRINTOUT--can print out to cmd
 * 
 * 
 * 
 * 

 * DRAWING PANEL CLASS TO SHOW A JTABLR EXCEL SPREADSHEET OF ALL THE DATA
 * 
 * ACTIONS  BUTTONS THAT (ON WEST BORDER  ON TOP OF EACH OTHER )

 * ADD NEW ENTRY ON LIST - can add a new entry 
 *
 * DELETE ENTRY ON LIST 
 */

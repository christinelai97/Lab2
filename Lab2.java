//Christine Lai
//This program reads data from a csv file and prints data onto an outful file

import java.util.Scanner;
import java.io.*;

public class Lab2 {
  public static void main(String [] args) throws IOException {
    
    int rows = 200; //initialize rows to 200 = (max number of songs in csv list)
    int cols = 2; //column 2 of csv list contains name of artists
    int numCount; //will be used to count the number of times artist's song appears
    
    String[][] myList = new String[rows][cols]; //create new 2D array
    
    //loop allows methods to run for each position in 2D array
    for (int i = 0; i < rows; i++) { 
      for (int j = 0; j < cols; j++) {
        myList[i][j] = "";
        
        numCount = readData(myList);
        
        sortAlpha(myList, numCount);
        printData(myList, numCount);
      }
    }
  }
    
    //method reads and allocates data from csv file into 2D array
    public static int readData(String[][] array) throws IOException {

      Scanner sc = new Scanner(new File("regional-global-daily-latest.csv"));
      
      String str; //will hold string value taken from csv file
      int i = 0;

      
      //skips first 3 lines from the csv file
      str = sc.nextLine();
      str = sc.nextLine();
      str = sc.nextLine();
      
      //scans next lines of data
      while(sc.hasNextLine()) {
        str = sc.nextLine();
        String artistName;
        
        //array will temporarily hold split string in order to locate artist name
        String[] temp = str.split(","); 
        artistName = temp[temp.length-3]; // name is located on first position of array
        
        // compare method will compare current artist to other artists listed
        if(compare(array, i + 1, artistName) != -1) {
          int row = compare(array, i + 1, artistName);
          int col = Integer.parseInt(array[row][1]) + 1;
          array[row][1] = Integer.toString(col);
        }
        
        //if returns -1, artist name will be added into array
        else { 
          array[i][0] = artistName;
          array[i][1] = "1"; //String 1 allocated for newly added artists
          i++;
        }
      }
      
      sc.close();
      return i; //returns i as total number of songs counted
    }
    
    //method checks if artist name is already in array
    public static int compare(String[][] array, int num, String name){
      
      for(int i = 0; i<num; i++) {
        if(array[i][0].equals(name)) 
          return i; //returns i if current artist's name searched has a match in array
      }
      
      return -1; //returns -1 if artist name is not yet listed
    }
  
    public static sortAlpha(String[][] array, int num) {
      for(int i =0; i<n-1; i++) {
        for (int j=i+1; j<n; j++) {
          if (array[i][0].compareToIgnoreCase(array[j][0]) > 0) {
            String temp = array[i][0];
            array[i][0] = array[j][0];
            array[j][0] = temp;
          }
        }
      }
    }
    
    //method prints data onto an output file 
    public static void printData(String[][] arr, int numCount) throws IOException {
      
      PrintWriter outputText = new PrintWriter("Artists-WeekOf08302020.txt");
      outputText.println("Regional Global Daily Top 200\n\n");
      
      //loop prints out each data stored in 2D array
      for(int i = 0; i < numCount; i++) {
      outputText.println(arr[i][0] + " has " + arr[i][1] + " song appearance/s in chart\n");
      } 
      
      outputText.close();
      
    }
}
    
    
      
      
      
      
      
      

// ***************************************************************
// Name: Jose Alberto Rodriguez
// Date: 11/16/2018
//
// CS 225, Section 02
// ***************************************************************

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CommonIssues {
	private File ComIss;
	private static String Make;
	private static String MakeCI;
	
	  public static void main(String[] args) {
		  	CommonIssues CI = new CommonIssues();
		  	
		    Scanner input = new Scanner(System.in);
		    System.out.println("Input the make of your Vehicle: (use Toyota)" );
		    CI.Make = input.next();
		    String CI_ext = "_CI.txt";
		    MakeCI = Make + CI_ext;
		    CI.createFileErr();
		    CI.displayIssues();
		    CI.runIssues();
		    
		  }
	  
	private void createFileErr() {
		ComIss = new File(MakeCI);
	}
	  
	public void displayIssues() {
		  try {
				// make file reader
				FileReader fileReader = new FileReader(ComIss);
				// buffer the file reader
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				// make the string line
				String line;
				int Index = 0;
				while ( (line = bufferedReader.readLine() )!= null ) {
					String[] splitLine = line.split(",");
					
						String Num=splitLine[0];
						String Issu=splitLine[1];
						System.out.println("" + Num + ". " + Issu);
					
					Index++;
				}
				bufferedReader.close();	
			}catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	
	  public void runIssues() {
		  Scanner input = new Scanner(System.in);
		    System.out.println("Input the Common Issue Number: " );
		    String Code = input.next();
		  
		  try {
				// make file reader
				FileReader fileReader = new FileReader(ComIss);
				// buffer the file reader
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				// make the string line
				String line;
				int Index = 0;
				while ( (line = bufferedReader.readLine() )!= null ) {
					String[] splitLine = line.split(",");
					
					if (splitLine[0].equalsIgnoreCase(Code)) {
						String FixMessage=splitLine[2];
						System.out.println("" + FixMessage);
					}
					
					Index++;
				}
				bufferedReader.close();	
			}catch (Exception e) {
				e.printStackTrace();
			}
		  
	  }
	
}
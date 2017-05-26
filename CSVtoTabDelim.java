//Kana Kihara
//CSV to Tab Delimeter

import java.util.*;
import java.io.*;

public class CSVtoTabDelim{
	public static void main (String[] args){
		List<String> differentSchools = new ArrayList<String>(); // Create school array. Each array element represents a school which contains a text file 
		String filename = "SampleData.csv";

		/* Open CSV file */
		File fp = new File(filename);

		try{
			Scanner input = new Scanner(fp);
			String category = input.next(); //STUDENT_ID,STUDENT_NAME,SCHOOL

			/* Read from file */
			while (input.hasNext()){			
				String beforeSpace = input.next(); 
				String afterSpace = input.next();

				Scanner s = new Scanner(beforeSpace).useDelimiter(",");
				int id = s.nextInt();
				String fname = s.next();
			
				Scanner t = new Scanner(afterSpace).useDelimiter(",");
				String lname = t.next();
				String school = t.next();

				/* Add this student information to "tab delimited file" by creating a student object with all this info */
				Student newStudent = new Student(id, fname, lname, school);
				differentSchools.add(newStudent.getSchool());	//add school to arraylist
				compareSchools(differentSchools, newStudent);

				/* Close file(s) */
				s.close();
				t.close();
			}
			input.close();
		}catch (FileNotFoundException e){
            e.printStackTrace();
        }
	}

	public static void compareSchools(List<String> schoolArray, Student oneStudent){
		String schoolName = oneStudent.getSchool();
		String textfile = schoolName + ".txt";
		int i = 0; //for loop variable
		boolean neverSameFileName = true; //changed to false if School's file has been created before

		/* Loop through all students, if schools are the same, (APPEND) add Student to that school */
		for (i = 0; i < schoolArray.size() - 1; i++){
			if (schoolName.equals(schoolArray.get(i))){
				neverSameFileName = false;
				try{
					File file = new File(textfile);
					FileWriter fw = new FileWriter(file, true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter writer = new PrintWriter(bw);
					//writer.printf("%d\t%s %s\n", id, fName, lName);
					writer.printf("%s", oneStudent.toString());
					writer.close();
				}
				catch (IOException e){
					System.out.println (e.toString());
        			System.out.println("Could not find file " + textfile);
				}
				break;
			}
		} //close for loop

		/* Create (NEW) School file and add Student to that school */
		if (neverSameFileName){
			try{
				PrintWriter writer = new PrintWriter(textfile, "UTF-8");
				writer.printf("%s", oneStudent.toString());
				writer.close();
			}
			catch (IOException e){
				System.out.println (e.toString());
        		System.out.println("Could not find file " + textfile);
			}
		}
	}
}

























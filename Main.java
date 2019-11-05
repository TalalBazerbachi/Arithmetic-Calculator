import java.io.*;
	

	public class Main {

	    public static void main(String[] args) {

	        String fileName = "ArithmeticExpressions.txt";
	        String line = null;

	        try {
	            FileReader fileReader = new FileReader(fileName);

	            // Always wrap FileReader in BufferedReader.
	            BufferedReader bufferedReader = new BufferedReader(fileReader);
	            while((line = bufferedReader.readLine()) != null) {

	                    ACalculator calculator = new ACalculator();
	                    double result = ACalculator.evaluate(line);
	                    try {
	                    BufferedWriter writer = new BufferedWriter(new FileWriter("Arithmetic_Output.txt", true));
	                    writer.append(line + " = " + result + "\n");

	                    writer.close();
	                     }
	                     catch(IOException e) {
	                          System.out.println("Error writing to file");
	                      }

	            }

	            // Always close files.
	            bufferedReader.close();
	        }
	        catch(FileNotFoundException ex) {
	            System.out.println(
	                    "Unable to open file '" +
	                            fileName + "'");
	        }
	        catch(IOException ex) {
	            System.out.println(
	                    "Error reading file '"
	                            + fileName + "'");
	            // Or we could just do this:
	            // ex.printStackTrace();
	        }



	    }

	}


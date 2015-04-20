import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class WriteFile {
	
	public String filepath;
	
	public WriteFile(String filepath){
		this.filepath = filepath;
	}
	
	public void write(String writetxt){
		
		 File file = new File(filepath);
		 FileWriter fw = null;
		 BufferedWriter writer = null;
		 try {
			fw = new FileWriter(file);
			 writer = new BufferedWriter(fw);
			 writer.write(writetxt);
			 writer.newLine();
	         writer.flush();
			 writer.close();
	         fw.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamCorruptedException;
import java.util.HashMap;
import java.util.Map;


public class ReadFile {
	public String filepath;
	
	public ReadFile(String filepath) {
		this.filepath = filepath;
	}
	
	public Map<String, Object> getFileDetails(){
		Map<String, Object> map = new HashMap();
		File file=new File(filepath);
		String encoding = "UTF-8";
        try {
			if(file.isFile() && file.exists()){
			    InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);
			    BufferedReader bufferedReader = new BufferedReader(read);
			    String lineTxt = null;
			    String str = new String();
			    Grid[][] pic = null;
			    int scale = 0;
			    int line_number = 1;
			    while((lineTxt = bufferedReader.readLine()) != null){
			        if(line_number==1){
			        	map.put("algorithm", lineTxt);
			        }
			        if(line_number==2){
			        	map.put("iterations", Integer.parseInt(lineTxt));
			        }
			        if(line_number==3){
			        	map.put("scale", Integer.parseInt(lineTxt));
			        	scale = Integer.parseInt(lineTxt);
			        	pic = new Grid[scale][scale];
			        }
			        if(line_number>3){
			        	str = lineTxt; 
			        	for(int i = 0;i<scale;i++){
			        		String type = str.substring(i, i+1);
			        		Grid g = new Grid();
			        		g.setX_position(line_number - 3);
			        		g.setY_position(i);
			        		if(type.equals("X")){
			        			g.setType(-1);
			        		}
			        		if(type.equals("R")){
			        			g.setType(1);
			        		}
			        		if(type.equals("S")){
			        			g.setType(0);
			        		}
			        		if(type.equals("G")){
			        			g.setType(2);
			        		}
			        		pic[line_number - 3][i] = g;
			        	}
			        }
			    	line_number++;
			    }
			    read.close();
			    map.put("Grid[][]", pic);
			}
			else{
				System.out.println("file not found!!!!");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return map;
	}

}

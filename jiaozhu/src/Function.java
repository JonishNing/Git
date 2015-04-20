import java.util.Map;


public class Function {
	
	public void func(){
		
		String filepath = "D://input.txt";
		ReadFile r = new ReadFile(filepath);
		Map<String, Object> map = r.getFileDetails();
		String algorithm = (String)map.get("algorithm");
		int iterations = (Integer)map.get("iterations");
		int scale = (Integer)map.get("scale");
		Grid[][] pic = (Grid[][])map.get("Grid[][]");
		jiye j = new jiye();
		j.getPath(algorithm, iterations, scale, pic);
		String filepath0 = "D:// ";
		WriteFile w = new WriteFile(filepath0);
		w.write(filepath0);

	}

}

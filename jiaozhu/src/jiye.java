
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;



public class jiye {
	public static final int S= 1;
	public static final int G = -1;	
	public static final int R = 1;
	public static final int X = -1;
	
	public static int cost = 0;
	
	public static Grid startGrid = new Grid();
	public static Grid goalGrid = new Grid();
	public static Grid currentGrid = new Grid();
	public static Grid nextGrid = new Grid();
	//directions
	public static final int[][] dir = {{-1,0},{0-1},{0,1},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
	

	public void getPath(String algorithm , int iterations , int scale , Grid[][] pic){
		
		if(algorithm.equals("D")){
			BFS(0,pic);
			
		}
		
//		if(algorithm.equals("B")){
//			BFS(0,pic);
//			
//		}
//		
//		if(algorithm.equals("U")){
//			UCS(0,pic);
//		}
//		
//		if(algorithm.equals("A")){
//			AStar(0,pic);
//		}
	}
	
	private void BFS(int iterations,Grid[][] pic){
		
		Queue<Grid> q = new LinkedList<Grid>();
		startGrid = getStart(pic);
		goalGrid = getGoal(pic);
		q.offer(startGrid);
		int current_x = startGrid.getX_position();
		int current_y =startGrid.getY_position();
		startGrid.setReached(true); 
		while(!currentGrid.equals(goalGrid)&&q.isEmpty()!=true){
			currentGrid = q.poll();
			for(int i = 0;i<8;i++){
				current_x = currentGrid.getX_position()+dir[i][0];
				current_y = currentGrid.getY_position()+dir[i][1];
				if(current_x<0||current_y<0)
					continue;
				if(pic[current_x][current_y].isReached()==true)
					continue;
				if(pic[current_x][current_y].getType()==X)
					continue;
				pic[current_x][current_y].setPre_x_position(currentGrid.getX_position());
				pic[current_x][current_y].setPre_y_position(currentGrid.getY_position());
				pic[current_x][current_y].setReached(true);
				q.offer(pic[current_x][current_y]);							
			}						
		}
		Stack<Grid> s = new Stack<Grid>();
		while(!currentGrid.equals(startGrid)){
			s.push(goalGrid);
			current_x = currentGrid.getPre_x_position();
			current_y = currentGrid.getPre_y_position();
			currentGrid = pic[current_x][current_y];
		}
		s.push(startGrid);
		String writetxt = "S";
		System.out.print("S");
		while(!nextGrid.equals(goalGrid)){
			System.out.print("-");
			writetxt += "-";
			currentGrid = s.pop();
			nextGrid = s.peek();
			int x_difference = nextGrid.getX_position() - currentGrid.getX_position();
			int y_difference = nextGrid.getY_position() - currentGrid.getY_position();
			String Direction = getDirection(x_difference, y_difference);
			System.out.print(Direction);
			writetxt += Direction;
		}
		System.out.print("-G");
		System.out.print(" "+cost);
		System.out.println();
		writetxt += "-G "+cost;
		
				
		
	
		
	}
	
//	private void DFS(int iterations,ArrayList[][] pic){
//		
//	}
//	
//	private void UCS(int iterations,ArrayList[][] pic){
//		
//	}
//	
//	private void AStar(int iterations,ArrayList[][] pic){
//		
//	}
	
	private Grid getStart(Grid[][] pic){
		for(int i = 0 ;i<pic.length;i++){
			for(int j = 0;j<pic[i].length;j++){
				if(pic[i][j].getType()==S){
					startGrid = pic[i][j];
					break;
				}
			}
		}
		return startGrid;
	}
	private Grid getGoal(Grid[][] pic){
		for(int i = 0;i<pic.length;i++){
			for(int j = 0;j<pic[i].length;j++){
				if(pic[i][j].getType()==G){
					goalGrid = pic[i][j];
					break;
				}
			}
		}
		return goalGrid;
	}
	private String getDirection(int x_difference ,int y_difference){
		String message = new String();
		if(x_difference==-1){
			message = message + "L";
			++cost;
		}
		if(x_difference==1){
			message = message + "R";
			++cost;
		}
		if(y_difference==-1){
			message = message + "U";
			++cost;
		}
		if(y_difference==1){
			message = message + "D";
			++cost;
		}
		return message;
	}
	

}

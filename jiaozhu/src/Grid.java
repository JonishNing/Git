import org.omg.PortableServer.POA;


public class Grid {
	
	private int x_position;
	private int y_position;
	private int type;// 1.R -1,X 0,S 2,G
	private boolean reached = false;
	private int kind;// 1.S -1,G
	private int pre_x_position = -1;
	private int pre_y_position = -1;
	public int getX_position() {
		return x_position;
	}
	public void setX_position(int x_position) {
		this.x_position = x_position;
	}
	public int getY_position() {
		return y_position;
	}
	public void setY_position(int y_position) {
		this.y_position = y_position;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public boolean isReached() {
		return reached;
	}
	public void setReached(boolean is_reached) {
		this.reached = is_reached;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	public int getPre_x_position() {
		return pre_x_position;
	}
	public void setPre_x_position(int pre_x_position) {
		this.pre_x_position = pre_x_position;
	}
	public int getPre_y_position() {
		return pre_y_position;
	}
	public void setPre_y_position(int pre_y_position) {
		this.pre_y_position = pre_y_position;
	}
	public void Rmove(){
		this.x_position = this.x_position + 1;
	}
	
	public void Lmove(){
		this.x_position = this.x_position - 1;
	}
	
	public void Umove(){
		this.y_position =this.y_position - 1;
	}
	public void Dmove(){
		this.y_position = this.y_position + 1;
	}
	public void LUmove(){
		this.x_position = this.x_position - 1;
		this.y_position = this.y_position - 1;
	}
	public void RUmove(){
		this.x_position = this.x_position + 1;
		this.y_position = this.y_position - 1;
	}
	public void LDmove(){
		this.x_position = this.x_position - 1;
		this.y_position = this.y_position + 1;
	}
	public void RDmove(){
		this.x_position = this.x_position + 1;
		this.y_position = this.y_position + 1;
	}
	

}

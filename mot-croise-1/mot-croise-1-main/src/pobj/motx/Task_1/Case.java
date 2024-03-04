package pobj.motx.tme1;



public class Case {
	private int x,y;
	private char val;
   
	public Case(int lig, int col, char c) {
		this.x=lig;
		this.y=col;
		this.val=c;
	}
	
	public int getLig()
	{
		return x;
	}
	
	public int getCol()
	{
		return y;
	}
	
	public char getChar()
	{
		return val;
	}
	
	
	public void setChar(char c) {
		this.val=c;
	}
	
	public boolean isVide() {
		
		return val==' ';
	}
	
	public boolean isPleine(){
		
		return val=='*';
	}
	
	
	
	
	
}

/*
COLORED MAP*/
public class Map {
	
	private char [][] map;
	
	// Map's Constructor.
	public Map(char[][] map) {
		String colors="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWYZ";
		this.map=new char[map.length][map.length];
		for(int i=0; i<map.length;i++){
			for(int j=0; j<map.length;j++){
				String color=map[i][j]+"";
				if(colors.contains(color)){
					this.map[i][j]=map[i][j];
				}
				else this.map[i][j]='z';	
			}
		}
		
	}
	
	// Restart a new map by double array.
	public char[][] getMap() {
		char [][] getMap = new char[this.map.length][this.map.length];
		for(int i=0;i<getMap.length;i++){
			for(int j=0;j<getMap.length; j++){
				getMap[i][j]=this.map[i][j];
			}
		}
		return getMap;
	}
	
	//Equals method that checks if is the same map.
	public boolean equals(Map map) {
		char[][] other = map.getMap();
		if(this.map.length!=other.length){
			return false;
		}
		for(int i=0;i<this.map.length;i++){
			for(int j=0;j<this.map.length; j++){
				if(this.map[i][j]!= other[i][j])
					return false;
				
			}
		}
		return true;
	}
	
	// Counts the number of colors in the map by double array.
	public int numOfColors() {
		if(this.map==null || this.map.length==0)
			return 0;
		return this.countColors(0,this.map.length-1,0,this.map.length-1);
	}
		
		//help function gets from I to I and from J to J for counting colors.
	private int countColors(int fromI,int toI,int fromJ,int toJ){
		boolean [] colors= new boolean[26];
		String colorString="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWYZ";
		for(int i=fromI;i<=toI;i++){
			for(int j=fromJ;j<=toJ;j++){
				int index=colorString.indexOf(this.map[i][j])%26;
				colors[index]=true;
			}
		}
		int count=0;
		for(int i=0;i<colors.length;i++){
			if (colors[i]==true) count++;
		}
		return count;
		
	}
		
	// counts the number of points in the same color like the certain one we got.
	public int numOfColors(Point p) {
		
		if(p.getX()<0 || p.getX()>this.map.length-1 || p.getY()<0 || p.getY()>this.map.length-1)
			return 0;
		if(p.getX()>0 && p.getX()<this.map.length-1 && p.getY()>0 && p.getY()<this.map.length-1 )
			return this.countColors(p.getX()-1,p.getX()+ 1, p.getY()-1, p.getY()+1);
		if(p.getX()==0 && p.getY()>0 && p.getY()<this.map.length-1 )
			return this.countColors(p.getX(), p.getX()+1, p.getY()-1,p.getY()+ 1);
		if(p.getX()==this.map.length-1 && p.getY()>0 && p.getY()<this.map.length-1 )
			return this.countColors(p.getX()-1, p.getX(), p.getY()-1,p.getY()+ 1);
		if(p.getX()>0 && p.getX()<this.map.length-1 && p.getY()==0)
			return this.countColors(p.getX()-1, p.getX()+1, p.getY(), p.getY()+1);
		if(p.getX()>0 && p.getX()<this.map.length-1 && p.getY()==this.map.length-1 )
			return this.countColors(p.getX()-1,p.getX()+ 1, p.getY()-1, p.getY());
		if(p.getX()==0 && p.getY()==0)
			return this.countColors(p.getX(), p.getX()+1, p.getY(),p.getY()+ 1);
		if(p.getX()==0 &&  p.getY()==this.map.length-1 )
			return this.countColors(p.getX(), p.getX()+1, p.getY()-1, p.getY());
		if(p.getX()==this.map.length-1 && p.getY()==0)
			return this.countColors(p.getX()-1, p.getX(), p.getY(), p.getY()+1);
		if(p.getX()==this.map.length-1 &&p.getY()==this.map.length-1 )
			return this.countColors(p.getX()-1, p.getX(), p.getY()-1, p.getY());
		return 0;
	}
	
	//checks if the point (x,y) is in the bounds of from I to I from J to J
	private boolean checkNeighbor(int fromI,int toI,int fromJ,int toJ,Point p1,Point p2){
		
		for(int i=p1.getX()+fromI;i<=p1.getX()+toI;i++){
			for(int j=p1.getY()+fromJ;j<=p1.getY()+toJ;j++){
				if(i==p2.getX()&&j==p2.getY())
					return true;
			}
		}
		return false;
		
	}
	
	// Check if the points is in the same for color, for each case.
	public boolean legalNeighbor(Point p1, Point p2) {
		if(p1.getX()<0 || p1.getX()>this.map.length-1 || p1.getY()<0 || p1.getY()>this.map.length-1) 
			return false;
		if(p2.getX()<0 || p2.getX()>this.map.length-1 || p2.getY()<0 || p2.getY()>this.map.length-1)
			return false;
		if(p1.getX()==p2.getX() && p1.getY()==p2.getY())
			return false;
		if(this.map[p1.getX()][p1.getY()]!=this.map[p2.getX()][p2.getY()])
			return false;
		if(p1.getX()>0 && p1.getX()<this.map.length-1 && p1.getY()>0 && p1.getY()<this.map.length-1 )
			return this.checkNeighbor(-1, 1, -1, 1, p1,p2);
		if(p1.getX()==0 && p1.getY()>0 && p1.getY()<this.map.length-1 )
			return this.checkNeighbor(0, 1, -1, 1,p1,p2);
		if(p1.getX()==this.map.length-1 && p1.getY()>0 && p1.getY()<this.map.length-1 )
			return this.checkNeighbor(-1, 0, -1, 1,p1,p2);
		if(p1.getX()>0 && p1.getX()<this.map.length-1 && p1.getY()==0)
			return this.checkNeighbor(-1, 1, 0, 1,p1,p2);
		if(p1.getX()>0 && p1.getX()<this.map.length-1 && p1.getY()==this.map.length-1 )
			return this.checkNeighbor(-1, 1, -1, 0,p1,p2);
		if(p1.getX()==0 && p1.getY()==0)
			return this.checkNeighbor(0, 1, 0, 1,p1,p2);
		if(p1.getX()==0 &&  p1.getY()==this.map.length-1 )
			return this.checkNeighbor(0, 1, -1, 0,p1,p2);
		if(p1.getX()==this.map.length-1 && p1.getY()==0)
			return this.checkNeighbor(-1, 0, 0, 1,p1,p2);
		if(p1.getX()==this.map.length-1 &&p1.getY()==this.map.length-1 )
			return this.checkNeighbor(-1, 0, -1, 0,p1,p2);
		return false;
	}
	
	// Recursively checks the neighbor and his neighbor etc, and paint them in a certain color .
	public void fill(Point p,char color) {
		boolean[][] helpMemo= new boolean[this.map.length][this.map.length];
		this.fill(p,color,helpMemo);
	}
	
	private void fill(Point p, char color, boolean[][]helpMemo){
		if(p.getX()>=0 && p.getX()<=this.map.length-1 && p.getY()>=0 && p.getY()<=this.map.length-1) {
			if(helpMemo[p.getX()][p.getY()]==false){
				helpMemo[p.getX()][p.getY()]=true;
				for(int i=-1; i<=1;i++){
					for(int j=-1; j<=1; j++){
						Point p2 = new Point(p.getX()+i,p.getY()+j);
						if(this.legalNeighbor(p, p2))
							fill(p2,color,helpMemo);
					}
				}
				this.map[p.getX()][p.getY()]=color;
			}
		}
	}
}

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;


class OutputScreen extends Canvas{
	
	JFrame f;
	int flag=-1,point1,point2;
	int num;
	int graph[][]=new int[10][10];
	int parent[]=new int[10];
	public int coor[][]= new int[10][2];
	
	public void paint(Graphics g) {
		setBackground(Color.BLACK);  
		setForeground(Color.GREEN);
    	for(int i=0;i<num;i++) {
    		g.fillOval(coor[i][0],coor[i][1],25, 25);
    		g.drawString("["+(i+1)+"]", coor[i][0]-8, coor[i][1]-8);
    	}
  
    		for(int i=1;i<num;i++) {
    				point1=i;
    				point2=parent[i];
    				g.drawLine(coor[point1][0]+12, coor[point1][1]+12,coor[point2][0]+12, coor[point2][1]+12);
    				g.drawString(graph[i][parent[i]]+"", (((coor[point1][0]+coor[point2][0])/2)-5), (((coor[point1][1]+coor[point2][1])/2)-5));
    			}
		
	}
	
	public OutputScreen(int g[][],int p[],int n,int c[][]) {
		num=n;
		graph=g;
		parent=p;
		coor=c;
		
		f=new JFrame("Minimum Spanning Tree");
	 	f.add(this);  
	    f.setSize(400,400);  
	    f.setVisible(true); 
	    
	    
	   
	}
	
	
}
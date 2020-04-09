import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class PointDisplay extends Canvas {
	JFrame f;
	int flag=-1,mcount=0,point1,point2;
	int num;
	int graph[][]=new int[10][10];
	public int coor[][]= new int[10][2];
	
	public PointDisplay(int n) {
		num=n;
		
		
		f=new JFrame("Point Mapper");
	 	f.add(this);  
	    f.setSize(400,400);  
	    f.setVisible(true); 
	    
	    
	    
	}
	
	public void paint(Graphics g) {
		setBackground(Color.BLACK);    
        
        if (flag!=-1) {
        	setForeground(Color.RED);
        	for(int i=0;i<mcount;i++) {
        		g.fillOval(coor[i][0],coor[i][1],25, 25);
        		g.drawString("["+(i+1)+"]", coor[i][0]-8, coor[i][1]-8);
        		
        		/*
        		if(i==4)
        			g.drawLine(coor[1][0]+12, coor[1][1]+12, coor[2][0]+12, coor[2][1]+12);
        		*/
		    }
        
        	if(mcount==num)
        		for(int i=0;i<num;i++)
        		for(int j=0;j<num;j++) {
        				if(graph[i][j]!=0) {
        				point1=i;
        				point2=j;
        				g.drawLine(coor[point1][0]+12, coor[point1][1]+12,coor[point2][0]+12, coor[point2][1]+12);
        				g.drawString(graph[i][j]+"", (((coor[point1][0]+coor[point2][0])/2)-5), (((coor[point1][1]+coor[point2][1])/2)-5));
        				}
        			}
        }

	}
	
	public void plotPoint() {
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
			if(mcount<num) {
				flag=1;
				coor[mcount][0]=e.getX();
			    coor[mcount][1]=e.getY();
			    mcount++;
			    repaint();
			}
			else 
				return;
			}
		});
	}
	
	public void plotLine(int g[][]) {
		flag=0;
		graph=g;
		repaint();
	}
	
}

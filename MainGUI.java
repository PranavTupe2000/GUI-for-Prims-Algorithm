import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MainGUI extends JFrame {
	int num,flag=0,point1,point2;
	int graph[][]=new int[10][10];
	PointDisplay p1;
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2;
	JButton b1,b2,b3;
	
	
	public MainGUI() {
		
		l1= new  JLabel("Enter the total number Points");
		l2= new  JLabel("|                                           Select First Point                                            |");
		l3= new  JLabel("|                                           Select Second Point                                           |");
		l4= new  JLabel("|                                           Enter Weight                                           |");
		l5= new  JLabel("|                                                                                      |");
		l6= new  JLabel("|                                                                                      |");
		b1= new JButton("Ok");
		b2= new JButton("Add/Update Edge");
		b3= new JButton("Compute MST");
		t1= new JTextField(12);
		t2= new JTextField(12);
		t1.setText("Maximum 10");
		
		JRadioButton[] br1=new JRadioButton[10];
		JRadioButton[] br2= new JRadioButton[10];
		ButtonGroup bgrp1= new ButtonGroup();
		ButtonGroup bgrp2= new ButtonGroup();
		
		
		
		for(int i=0;i<10;i++) {
		br1[i]= new JRadioButton((i+1)+"");
		br2[i]=new JRadioButton((i+1)+"");
		bgrp1.add(br1[i]);
		bgrp2.add(br2[i]);
			for(int j=0;j<10;j++)
					graph[i][j]=0;
		}
		
		add(l1);
		add(t1);
		add(b1);
		
		b1.addActionListener(ae -> {
			if(flag==0) {
					
				num=Integer.parseInt(t1.getText());
				
				p1=new PointDisplay(num);
				p1.plotPoint();
				flag=1;
				
				add(l2);
				for(int i=0;i<num;i++)
					add(br1[i]);
				add(l3);
				for(int i=0;i<num;i++)
					add(br2[i]);
				add(l4);
				add(t2);
				add(b2);
				add(l5);
				add(l6);
				add(b3);
				setVisible(true);
			}
		});
		
		b2.addActionListener(ae ->{
			for(int i=0;i<num;i++) {
				if(br1[i].isSelected()) {
						point1=i;
						break;
				}
			}
			for(int i=0;i<num;i++) {
				if(br2[i].isSelected()) {
						point2=i;
						break;
				}
			}
			if(point1!=point2) {
				graph[point1][point2]=Integer.parseInt(t2.getText());
				graph[point2][point1]=Integer.parseInt(t2.getText());
			}
			System.out.println(point1+","+point2+","+graph[point1][point2]);
			p1.plotLine(graph);

		});
		
		b3.addActionListener(ae ->{
				MainAlgorithm ma= new MainAlgorithm(graph, num, p1.coor);
				ma.primMST();
		});
		
		setTitle("Prim's Algorithm");
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(250, 400);
		setDefaultCloseOperation(3);
			
			
	}
	
}

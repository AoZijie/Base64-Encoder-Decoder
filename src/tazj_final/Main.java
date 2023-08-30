package tazj_final;

import javax.swing.JFrame;
import java.awt.Rectangle;

public class Main
{
	public static void main(String[] args)
	{
		JFrame frame = new GUI();
	    Rectangle bounds = frame.getBounds();
	    frame.setLocation(530 + bounds.x, 150 + bounds.y); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口大小并禁止调整
		frame.setSize(300, 360);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}
}

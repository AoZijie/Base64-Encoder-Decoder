package tazj_final;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GUI extends JFrame
{	
	//按钮
	JButton encode = new JButton(new ImageIcon("Encode.png"));
	JLabel entip = new JLabel("    加密文件    ");
	JButton decode = new JButton(new ImageIcon("Decode.png"));
	JLabel detip = new JLabel("    解密文件    ");
	JLabel tip = new JLabel("                                                                                  ");
	JLabel tip2 = new JLabel("              提示：不建议加密大于100M的文件                ");
	
	
	
	public GUI()
	{
		super("Base64工具");
		JPanel root = new JPanel();				
		this.setContentPane(root);
		
		encode.setFocusable(false);
		encode.setBorderPainted(false);
		decode.setFocusable(false);
		decode.setBorderPainted(false);
		
		root.add(encode);
		root.add(entip);
		root.add(decode);
		root.add(detip);
		root.add(tip);
		root.add(tip2);
		root.add(new JLabel("加密若无窗口提示则说明文件超过限制"));
		root.add(new JLabel("解密若无窗口提示则说明文件并未加密"));

		encode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new Encoder().main(null);
			}

		});
		
		decode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new Decoder().main(null);
			}
		});
	}
}
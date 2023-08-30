package tazj_final;

import java.awt.Container;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fileopen {
		private String fp;
		private String name;
		JFileChooser chooser = new JFileChooser();
		int ret = chooser.showOpenDialog(chooser);
		{
			if (ret == JFileChooser.APPROVE_OPTION)
			{
				File file = chooser.getSelectedFile();
				//定义内存地址
				fp = file.getAbsolutePath();
			}
			else {
				//弹出警告
				JFrame frame = new GUI();
				JDialog d = new JDialog( frame, "警告" , false);
				Container c = d.getContentPane();
				JLabel error = new JLabel("请选择文件！");
				error.setIcon(new ImageIcon("Error.png"));
				d.setSize(300,150);
				d.setVisible(true);
				d.setResizable(false);
				d.setLocationRelativeTo(null);
				c.setLayout(new FlowLayout(FlowLayout.CENTER));
				c.add(new JLabel("                                                                           "));
				c.add(error);
			}
		}
		//返回文件路径
		public String  getfilepath() {
			return fp;
		}
		//返回文件名称
		public String  getname() {
			return name;
		}
}

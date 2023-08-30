package tazj_final;

import java.awt.Container;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Filesave {
		private String fileSavePath;
		private String newFileName;
		JFileChooser chooser = new JFileChooser();
		// 弹出对话框
		int ret = chooser.showSaveDialog(chooser);
		{
			if (ret == JFileChooser.APPROVE_OPTION)
			{
				// 结果为：用户要保存的文件的路径
				File file = chooser.getSelectedFile();
				//定义内存地址
				fileSavePath = file.getAbsolutePath();
				newFileName = chooser.getSelectedFile().getName();
			
			}
			else {
			
			//
			JFrame frame = new GUI();
			JDialog d = new JDialog( frame, "警告" , false);
			Container c = d.getContentPane();
			JLabel error = new JLabel("请填写文件名称并选择保存路径！");
			error.setIcon(new ImageIcon("Error.png"));
			d.setSize(300,150);
			d.setVisible(true);
			d.setResizable(false);
			d.setLocationRelativeTo(null);
			c.setLayout(new FlowLayout(FlowLayout.CENTER));
			c.add(new JLabel("                                                                           "));
			c.add(error);
			//
			
			}
		}
		public String  get_SavePath() {
			return fileSavePath;
		}
		public String  getNFN() {
			return newFileName;
		}
}

package tazj_final;

import java.awt.Container;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Encoder
{
	private String res;
	//根据传入文件进行加密并生成Base64
	public void main(String[] args) 
	{
		Fileopen fp = new Fileopen();
		Base64.Encoder en = Base64.getMimeEncoder();
		byte [] ImgContainer = null;
		FileInputStream fIP = null;
		try {
			//传入文件路径并加密
			fIP = new FileInputStream(fp.getfilepath());
			ImgContainer =new byte [fIP.available()];
			fIP.read(ImgContainer);
			System.out.println(ImgContainer);
			String Base64ImgData = en.encodeToString(ImgContainer);
			fIP.close();
			res = Base64ImgData;
			
			//调用文件保存功能
			Filesave fs= new Filesave();
			String nfp =fs.get_SavePath();
			System.out.println(nfp);

			//创建新文件
			File file = new File(nfp);
			try {
				file.createNewFile();
			}catch (IOException e) {
				e.printStackTrace();
				}
			
			//写入文件
			try {
				FileWriter fw = new FileWriter(file);
				fw.write(res);
				fw.flush();
				fw.close();
				System.out.println("done");
			}catch(IOException e){
				e.printStackTrace();
				}
			
			//第一个try结尾
			}catch (IOException e) {
			e.printStackTrace();
			
		}
		
		//完成后弹出提示窗口
		JFrame frame = new GUI();
		JDialog d = new JDialog( frame, "完成" , false);
		Container c = d.getContentPane();
		JLabel icontext = new JLabel(" 已完成加密      ");
		icontext.setIcon(new ImageIcon("Encoded.png"));
		d.setSize(300,150);
		d.setVisible(true);
		d.setResizable(false);
		d.setLocationRelativeTo(null);
		c.setLayout(new FlowLayout(FlowLayout.CENTER));
		c.add(new JLabel("                                                                           "));
		c.add(icontext);

	}
}
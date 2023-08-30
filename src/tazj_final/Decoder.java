package tazj_final;

import java.awt.Container;
import java.awt.FlowLayout;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Decoder {

	public void main(String[] args) 
	{
		//调用打开方法并初始化
		Fileopen fp = new Fileopen();
		Base64.Decoder de = Base64.getMimeDecoder();
		byte [] OrgData = null;
		byte [] Container = null;
		FileInputStream fIP = null;
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		try {
			//给fIP传递文件路径
			fIP = new FileInputStream(fp.getfilepath());
			
			//给OrgData传递文件字节内容
			OrgData =new byte [fIP.available()];
			fIP.read(OrgData);
			
			//关闭传输
			fIP.close();
			Container = de.decode(OrgData);
			
			//选择保存目录及名称
			Filesave fs= new Filesave();		
			System.out.println(fs.get_SavePath());
			try {
				//接收文件保存路径
				File file = new File(fs.get_SavePath());
				fos= new FileOutputStream(file);
				bos = new BufferedOutputStream(fos);
				bos.write(Container);
			}catch (IOException e) {
				e.getStackTrace();
				}finally {
					if (bos != null) {
						try {
							bos.close();
						}catch (IOException e) {
							e.getStackTrace();
						}
					}
				}
			//第一个try结尾
			}catch (IOException e) {
				e.printStackTrace();
				}
		
		//完成后弹出提示窗口
		JFrame frame = new GUI();
		JDialog d = new JDialog( frame, "完成" , false);
		Container c = d.getContentPane();
		JLabel icontext = new JLabel(" 解密已完成      ");
		icontext.setIcon(new ImageIcon("Decoded.png"));
		d.setSize(300,150);
		d.setVisible(true);
		d.setResizable(false);
		d.setLocationRelativeTo(null);
		c.setLayout(new FlowLayout(FlowLayout.CENTER));
		c.add(new JLabel("                                                                           "));
		c.add(icontext);
		
	}
}
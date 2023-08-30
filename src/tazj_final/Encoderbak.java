package tazj_final;

import java.awt.Container;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Encoderbak
{
	private String res;
	//根据传入文件进行加密并生成Base64
	public String Base64Encode() 
	{
		Fileopen fp = new Fileopen();
		Base64.Encoder en = Base64.getMimeEncoder();
		byte [] ImgContainer = null;
		FileInputStream fIP = null;
		try {
			fIP = new FileInputStream(fp.getfilepath());
			ImgContainer =new byte [fIP.available()];
			fIP.read(ImgContainer);
			System.out.println(ImgContainer);
			String Base64ImgData = en.encodeToString(ImgContainer);
			fIP.close();
			res = Base64ImgData;
			
			//选择保存目录及名称
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
			return Base64ImgData;
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
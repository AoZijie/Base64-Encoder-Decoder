package tazj_final;

import java.awt.Container;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CreatFile {
		//获取新文件名称
//		String new_file_name = getNFN();
		String new_file_name = String.format("abc") + ".txt";
		public String creat_txt()
		{	
			Filesave fs= new Filesave();
			fs.get_SavePath();
//			String CurrentPath;
//			CurrentPath = get_SavePath();
//			fileName = getname();
//			System.out.println(CurrentPath);
			//创建文件
			System.out.println(new_file_name);
			File file = new File(new_file_name);
			try {
				file.createNewFile();
				}catch (IOException e) {
					e.printStackTrace();
				}
			//写文件
			try {
				FileWriter fw = new FileWriter(file);
				fw.write("nmsl");
				fw.flush();
				fw.close();
//				System.out.println("done");		//在控制台显示信息
				}catch(IOException e){
					e.printStackTrace();
					}
			return null;
		}
}



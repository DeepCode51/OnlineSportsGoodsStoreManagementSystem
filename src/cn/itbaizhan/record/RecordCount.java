package cn.itbaizhan.record;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class RecordCount {
	// ʹ��Properties
	private static Properties pp = new Properties();

	public static void writeCount(String path, String count) {

		pp.setProperty("count", count); // ���ü�ֵ��
		try {
			pp.store(new FileOutputStream(path), ""); // д���ļ�
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String readCount(String path) {

		String count = "0";
		File f = new File(path);
		if (!f.exists()) {
			writeCount(path, "0");
		}
		try {
			pp.load(new FileInputStream(path));
			count = pp.getProperty("count");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

}

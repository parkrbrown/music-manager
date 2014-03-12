package ProgramControl;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class test {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		JFrame RF = new JFrame();
//		int test = JOptionPane.showConfirmDialog(RF, "Test");
//		System.out.println(test);
		File test = new File(".");
		System.out.println(test.getAbsolutePath());
	}

}

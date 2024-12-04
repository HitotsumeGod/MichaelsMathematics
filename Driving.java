import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Driving {

	public static void main(String[] args) {
	
		Arithmetic a = new Arithmetic();
		a.createScreen();
	
	}

}
class Arithmetic {

	public static JFrame f;
	public static JPanel displays;
	public static JPanel maths;
	public static JTextField t;
	public static JLabel ans;
	private Font SERIF = new Font("Serif", Font.PLAIN, 20);
	
	public void createScreen() {
		
		Arithmetic a = new Arithmetic();
		f = new JFrame();
		displays = new JPanel();
		maths = new JPanel();
		JLabel l = new JLabel("Aristocles' Arithmetic");
		ans = new JLabel("Answer = ");
		t = new JTextField("                                                                                                                          ");
		t.addActionListener(new Solver());
		ans.setFont(a.SERIF);
		l.setFont(a.SERIF);
		displays.setLayout(new BoxLayout(displays, BoxLayout.Y_AXIS));
		maths.setLayout(new BoxLayout(maths, BoxLayout.X_AXIS));
		displays.add(l);
		displays.add(t);
		maths.add(ans);
		f.add(displays);
		f.add(maths);
		f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	
	}

}
class Solver implements ActionListener {

	public void actionPerformed(ActionEvent e) {
	
		Arithmetic a = new Arithmetic();
		Solver so = new Solver();
		String sus = a.t.getText().replaceAll("\\s", "");
		int leng = sus.length();
		int fAns = 0;
		if (sus.indexOf('+') > -1) {
			
			fAns = so.converter(so.cycler(sus.indexOf('+'), sus)) + so.converter(so.cycler(sus.indexOf('+'), sus, leng));
			a.ans.setText("Answer = " + fAns);
			a.f.setVisible(true);
		
		} else if (sus.indexOf('-') > -1) {
		
			fAns = so.converter(so.cycler(sus.indexOf('-'), sus)) - so.converter(so.cycler(sus.indexOf('-'), sus, leng));
			a.ans.setText("Answer = " + fAns);
			a.f.setVisible(true);
		
		} else if (sus.indexOf('*') > -1) {
		
			fAns = so.converter(so.cycler(sus.indexOf('*'), sus)) * so.converter(so.cycler(sus.indexOf('*'), sus, leng));
			a.ans.setText("Answer = " + fAns);
			a.f.setVisible(true);
		
		} else if (sus.indexOf('/') > -1) {
		
			fAns = so.converter(so.cycler(sus.indexOf('/'), sus)) / so.converter(so.cycler(sus.indexOf('/'), sus, leng));
			a.ans.setText("Answer = " + fAns);
			a.f.setVisible(true);
		
		} 
		
		
	
	}
	
	private StringBuilder cycler(int max, String s) {
	
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < max; i++) {
		
			 char c = s.charAt(i);
			 sb.append(c);
		
		}
		return sb;
	
	}
	
	private StringBuilder cycler(int max, String s, int leng) {
	
		StringBuilder sb = new StringBuilder();
		for (int i = max + 1; i < leng; i++) {
		
			 char c = s.charAt(i);
			 sb.append(c);
		
		}
		return sb;
	
	}
	
	private int converter(StringBuilder sb) {
		
		String sr = sb.toString();
		int bank = Integer.parseInt(sr);
		return bank;
	
	}

}

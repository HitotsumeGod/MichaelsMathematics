import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.io.File;

public class MikeMath {

	public static void main(String[] args) {
	
		Arithmetic a = new Arithmetic();
		a.helpScreen();
		a.createScreen();
	
	}

}
class Arithmetic {

	public static JFrame f;
	public static JPanel title;
	public static JPanel maths; 
	public static JPanel answer;
	public static JTextField t;
	public static JLabel ans;
	private Font SERIF = new Font("Serif", Font.PLAIN, 20);
	private File file = new File("miker.jpg");
	
	public void createScreen() {
		
		Arithmetic a = new Arithmetic();
		f = new JFrame();
		title = new JPanel();
		maths = new JPanel();
		answer = new JPanel();
		JLabel l = new JLabel("Michael's Mathematics");
		JLabel mike = new JLabel(new ImageIcon(file.getAbsolutePath()));
		ans = new JLabel("Answer = ");
		t = new JTextField("                                                                                                                          ");
		t.addActionListener(new Solver());
		ans.setFont(a.SERIF);
		l.setFont(a.SERIF);
		title.setLayout(new BoxLayout(title, BoxLayout.Y_AXIS));
		maths.setLayout(new BoxLayout(maths, BoxLayout.Y_AXIS));
		answer.setLayout(new BoxLayout(answer, BoxLayout.Y_AXIS));
		title.setPreferredSize(new Dimension(420, 280));
		maths.setPreferredSize(new Dimension(30, 30));
		answer.setPreferredSize(new Dimension(210, 100));
		title.add(l);
		title.add(mike);
		maths.add(t);
		answer.add(ans);
		f.add(title);
		f.add(maths);
		f.add(answer);
		f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}
	
	public void helpScreen() {
		
		JFrame f = new JFrame();
		JPanel p = new JPanel();
		JPanel pi = new JPanel();
		JLabel l = new JLabel("This calculator supports only two variables at the moment. Available operations include: addition - subtraction - multiplication - division.");
		JLabel end = new JLabel("Developed by Peterbot, with the assistance of dearly departed Ronald Reagan. Copyright 2024.");
		l.setFont(SERIF);
		end.setFont(SERIF);
		p.setLayout(new FlowLayout());
		pi.setLayout(new FlowLayout());
		f.setLayout(new BorderLayout());
		p.add(l);
		pi.add(end);
		f.add(p, BorderLayout.CENTER);
		f.add(pi, BorderLayout.PAGE_END);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.pack();
		f.setVisible(true);
		
	}

}
class Solver implements ActionListener {

	@SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent e) {
	
		Arithmetic a = new Arithmetic();
		Solver so = new Solver();
		String sus = a.t.getText().replaceAll("\\s", "");
		int leng = sus.length();
		double fAns = 0;
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
		
		} else {
			
			a.ans.setText("Invalid operator/syntax. Please try again.");
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
	
	private double converter(StringBuilder sb) {
		
		String sr = sb.toString();
		double bank = Double.parseDouble(sr);
		return bank;
	
	}

}

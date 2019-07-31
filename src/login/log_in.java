package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import login.admin_Question;
import login.sign_up;
public class log_in{
	public static String user;
	public static String password;
	static JFrame fr = new JFrame("Log in");
	Container cta = fr.getContentPane();
	static JButton btn1 = new JButton("Log in");
	static JButton btn2 = new JButton("Sign up");
	static JLabel lb = new JLabel("DBMS");
	static JLabel lb1 = new JLabel("Username: ");
	static JLabel lb2 = new JLabel("Password: ");
	static JTextField tf1 = new JTextField(10);
	static JPasswordField tf2 = new JPasswordField(10);
	public static void main(String[] args) throws Exception {
		log_in li = new log_in();
	}
	public log_in() throws Exception {
		String drive = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433;databaseName = QuestionBank";
		Class.forName(drive);
		Connection c =  DriverManager.getConnection(url,"sa","hsm12138");
		fr.setSize(500, 500);
		fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				user = tf1.getText();
				password = new String(tf2.getPassword());
				try {
					Statement st = c.createStatement();
					String sql = "select *from QuestionBankUser where userName = '"+user+"'";
					PreparedStatement ps = c.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					if(rs.next()) {
						String passwd = rs.getString(2);
						if(passwd.equals(password)) {
							if(user.equals("root")) {
								tf1.setText(null);
								tf2.setText(null);
								fr.setVisible(false);
								new admin_Question();
							}else {
								tf1.setText(null);
								tf2.setText(null);
								fr.setVisible(false);
								new Stu_learnPrac();
							}
						}else {
							new Frames();
						}
					}else{
						new Frames();
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fr.setVisible(false);
				try {
					new sign_up();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		fr.setLocation(600, 300);
		cta.setLayout(null);
		lb.setFont(new Font("宋体",Font.PLAIN,48));
		lb1.setFont(new Font("黑体",Font.PLAIN,32));
		lb2.setFont(new Font("黑体",Font.PLAIN,32));
		tf1.setFont(new Font("黑体",Font.PLAIN,32));
		tf2.setFont(new Font("黑体",Font.PLAIN,32));
		tf2.setEchoChar('*');
		lb.setBounds(180, 0, 100, 50);
		btn1.setBounds(50, 300, 100, 50);
		btn2.setBounds(350, 300, 100, 50);
		tf1.setBounds(180, 100, 249, 50);
		lb1.setBounds(0, 100, 200, 50);
		lb2.setBounds(0, 200, 200, 50);
		tf2.setBounds(180, 200, 249, 50);
		cta.add(lb);cta.add(lb1); cta.add(tf1);
		cta.add(lb2);cta.add(tf2);cta.add(btn2);
		cta.add(btn1);
		cta.setBackground(Color.lightGray);
//		fr.pack();
		fr.setVisible(true);
	}
	
}
class Frames {
	public Frames() {
		JFrame jf = new JFrame("提示");
		jf.setVisible(true);
		jf.setSize(600, 200);
		jf.setLocation(600, 350);
		JLabel jb = new JLabel("用户名或密码错误");
		Container ctn = jf.getContentPane();
		jb.setHorizontalAlignment(SwingConstants.CENTER);
		jb.setFont(new Font("宋体",Font.PLAIN,40));
		JButton jbt = new JButton("确定");
		jbt.setFont(new Font("宋体",Font.PLAIN,30));
		ctn.setLayout(null);
		jbt.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
			}         
		});
		jb.setBounds(100, 0, 400, 50);
		jbt.setBounds(250, 80, 100, 50);
		ctn.add(jb);ctn.add(jbt);
	}

	
}
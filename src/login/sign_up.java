package login;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import login.log_in;
public class sign_up  {
	public sign_up() throws Exception {
		String drive = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433;databaseName = QuestionBank";
		Class.forName(drive);
		Connection c =  DriverManager.getConnection(url,"sa","hsm12138");
		JFrame fr = new JFrame("Sign Up");
		Container cta = fr.getContentPane();
		JButton btn1 = new JButton("submit");
		JButton btn2 = new JButton("Cancel");
		JLabel lb = new JLabel("User Sign Up");
		JLabel lb1 = new JLabel("Username: ");
		JLabel lb2 = new JLabel("Password: ");
		JLabel lb3 = new JLabel("Confirm:");
		JTextField tf1 = new JTextField(10);
		JPasswordField tf2 = new JPasswordField(10);
		JPasswordField tf3 = new JPasswordField(10);
		fr.setSize(500, 500);
		fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(new String(tf3.getPassword()).equals(new String(tf2.getPassword()))) {
					try {
						String sql = "select *from QuestionBankUser where userName = '"+tf1.getText()+"'";
						PreparedStatement ps = c.prepareStatement(sql);
						ResultSet rs = ps.executeQuery();
						if(rs.next()) {
							new error_sign();
						}else {
							String sql1 = "insert into QuestionBankUser values('"+tf1.getText()+"',"+"'"+new String(tf2.getPassword())+"',0,0)";
							ps = c.prepareStatement(sql1);
							ps.executeUpdate();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					new error_sign1();
				}
			}
			
		});
		btn2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					fr.setVisible(false);
					new log_in();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		fr.setLocation(600, 300);
		cta.setLayout(null);
		lb.setFont(new Font("宋体",Font.PLAIN,48));
		lb1.setFont(new Font("黑体",Font.PLAIN,32));
		lb2.setFont(new Font("黑体",Font.PLAIN,32));
		lb3.setFont(new Font("黑体",Font.PLAIN,32));
		tf1.setFont(new Font("黑体",Font.PLAIN,32));
		tf2.setFont(new Font("黑体",Font.PLAIN,32));
		tf3.setFont(new Font("黑体",Font.PLAIN,32));
		tf2.setEchoChar('*');
		tf3.setEchoChar('*');
		lb.setBounds(80, 0, 300, 50);
		btn1.setBounds(50, 400, 100, 40);
		btn2.setBounds(350, 400, 100, 40);
		tf1.setBounds(180, 100, 249, 40);
		lb1.setBounds(0, 100, 200, 50);
		lb2.setBounds(0, 200, 200, 50);
		lb3.setBounds(0, 300, 200, 50);
		tf2.setBounds(180, 200, 249, 40);
		tf3.setBounds(180, 300, 249, 40);
		cta.add(lb);cta.add(lb1); cta.add(tf1);
		cta.add(lb2);cta.add(tf2);cta.add(btn2);
		cta.add(btn1);cta.add(lb3);cta.add(tf3);
		cta.setBackground(Color.lightGray);
//		fr.pack();
		fr.setVisible(true);
	}
}
class error_sign{
	public error_sign() {
		JFrame jf = new JFrame("提示");
		jf.setVisible(true);
		jf.setSize(600, 200);
		jf.setLocation(600, 350);
		JLabel jb = new JLabel("用户名已被注册");
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
class error_sign1{
	public error_sign1() {
		JFrame jf = new JFrame("提示");
		jf.setVisible(true);
		jf.setSize(600, 200);
		jf.setLocation(600, 350);
		JLabel jb = new JLabel("两次的密码不一致");
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
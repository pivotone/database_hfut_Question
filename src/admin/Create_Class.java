package login;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Create_Class {
	public Create_Class() throws Exception {
		String drive = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433;databaseName = QuestionBank";
		Class.forName(drive);
		Connection c =  DriverManager.getConnection(url,"sa","hsm12138");
		JFrame jf = new JFrame("题库管理系统(管理员版)");
		jf.setVisible(true);
		jf.setLayout(null);
		Container cta = jf.getContentPane();
		jf.setSize(1000, 1000);
		jf.setLocation(350, 50);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JButton jbt1 = new JButton("录入试题");
		JButton jbt2 = new JButton("退出登录");
		JButton jbt3 = new JButton("删除试题");
		JButton jbt4 = new JButton("更改试题");
		JButton jbt5 = new JButton("查看试题");
		JButton jbt6 = new JButton("创建课程及章节&创建题目类型");
		JLabel jb1 = new JLabel("课程编号:");
		JLabel jb2 = new JLabel("课程章节:");
		JLabel jb3 = new JLabel("课程名称:");
		JLabel jb4 = new JLabel("题目类型");
		JTextField jtf1 = new JTextField(10);
		JTextField jtf2 = new JTextField(10);
		JTextField jtf3 = new JTextField(10);
		JTextField jtf4 = new JTextField(10);
		JButton jbt = new JButton("创建");
		JButton jtb2 = new JButton("创建");
		jtb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					String sqlq = "select type from QUestionBankType where type = '"+String.valueOf(jtf4.getText())+"'";
					PreparedStatement ps = c.prepareStatement(sqlq);
					ResultSet rs = ps.executeQuery();
					if(!rs.next()) {
						String spl = "insert into QuestionBankType(type) values('"+String.valueOf(jtf4.getText())+"')";
						ps = c.prepareStatement(spl);
						ps.executeUpdate();
						ps.close();
					}else {
						new Error_Create();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		jbt1.setFont(new Font("宋体",Font.PLAIN,18));
		jbt1.setBounds(10, 180, 160, 50);//"录入试题"
		jbt2.setFont(new Font("宋体",Font.PLAIN,18));
		jbt2.setBounds(10, 10, 160, 50);//"退出登陆"
		jbt3.setFont(new Font("宋体",Font.PLAIN,18));
		jbt3.setBounds(10, 250, 160, 50);//
		jbt4.setFont(new Font("宋体",Font.PLAIN,18));
		jbt4.setBounds(10, 320, 160, 50);//
		jbt5.setFont(new Font("宋体",Font.PLAIN,18));
		jbt5.setBounds(10, 390, 160, 50);//
		jbt6.setFont(new Font("宋体",Font.PLAIN,14));
		jbt6.setBounds(10, 460, 160, 50);//
		
		jb1.setFont(new Font("宋体",Font.PLAIN,30));
		jb1.setBounds(200, 100, 160, 50);//
		jb2.setFont(new Font("宋体",Font.PLAIN,30));
		jb2.setBounds(200, 250, 160, 50);//
		jb3.setFont(new Font("宋体",Font.PLAIN,30));
		jb3.setBounds(200, 400, 160, 50);//
		jb4.setFont(new Font("宋体",Font.PLAIN,30));
		jb4.setBounds(200, 600, 160, 50);//
		jbt.setFont(new Font("宋体",Font.PLAIN,30));
		jbt.setBounds(500, 500, 160, 50);//
		jtb2.setFont(new Font("宋体",Font.PLAIN,30));
		jtb2.setBounds(500, 680, 160, 50);//
		jtf1.setFont(new Font("宋体",Font.PLAIN,30));
		jtf1.setBounds(370, 75, 500, 100);//
		jtf2.setFont(new Font("宋体",Font.PLAIN,30));
		jtf2.setBounds(370, 225, 500, 100);//
		jtf3.setFont(new Font("宋体",Font.PLAIN,30));
		jtf3.setBounds(370, 375, 500, 100);//
		jtf4.setFont(new Font("宋体",Font.PLAIN,30));
		jtf4.setBounds(370, 600, 500, 50);//
		cta.setBackground(Color.gray);
		cta.add(jbt1);cta.add(jbt2);cta.add(jbt3);cta.add(jbt5);cta.add(jbt4);cta.add(jbt6);
		cta.add(jb1);cta.add(jb2);cta.add(jb3);cta.add(jbt);cta.add(jb4);cta.add(jtf4);
		cta.add(jtf1);cta.add(jtf2);cta.add(jtf3);cta.add(jtb2);
		jbt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					PreparedStatement ps;
					String sql_Q = "select *from Class where classno = '"+jtf1.getText()+"' and classdept = '"+jtf2.getText()+"'";
					ps = c.prepareStatement(sql_Q);
					ResultSet rs1 = ps.executeQuery();
					if(!rs1.next()) {
						String sql = "insert into Class values('"+jtf1.getText()+"','"+jtf2.getText()+"','"+jtf3.getText()+"',0)";
						ps = c.prepareStatement(sql);
						ps.executeUpdate();
						jtf1.setText(null);
						jtf2.setText(null);
						jtf3.setText(null);
					}else {
						jtf1.setText(null);
						jtf2.setText(null);
						jtf3.setText(null);
						new Error_Create();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		jbt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jf.setVisible(false);
				try {
					new admin_Question();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		jbt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jf.setVisible(false);
				try {
					new log_in();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		jbt3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jf.setVisible(false);
				try {
					new Delete_Question();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		jbt4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jf.setVisible(false);
				try {
					new Update_Question();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		jbt5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jf.setVisible(false);
				try {
					new ViewofQuestion();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		jbt6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jf.setVisible(false);
				try {
					new Create_Class();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		JButton jbt7 = new JButton("备份&恢复");
		jbt7.setFont(new Font("宋体",Font.PLAIN,14));
		jbt7.setBounds(10, 530, 160, 50);//
		cta.add(jbt7);
		jbt7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jf.setVisible(false);
				try {
					new safety_safety();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
class Error_Create{
	public Error_Create() {
		JFrame jf = new JFrame("提示");
		jf.setVisible(true);
		jf.setSize(600, 200);
		jf.setLocation(600, 350);
		JLabel jb = new JLabel("已存在!");
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
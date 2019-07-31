package login;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import login.log_in;
import javax.swing.*;
public class admin_Question {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public admin_Question() throws Exception {
		String drive = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433;databaseName = QuestionBank";
		Class.forName(drive);
		Connection c =  DriverManager.getConnection(url,"sa","hsm12138");
		JFrame jf = new JFrame("题库管理系统(录入选择题)(管理员版)");
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
		JButton jbt7 = new JButton("备份&恢复");
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
		JButton btn5 = new JButton("提交题目");
		JLabel jb1 = new JLabel("题目：");
		JLabel jb6 = new JLabel("答案：");
		JLabel jb7 = new JLabel("题目所属课程：");
		JLabel jb8 = new JLabel("题目所属章节：");
		JTextArea jta_Q = new JTextArea(200,50);
		JTextArea jta_A = new JTextArea(200,50);
		JComboBox jcb1 = new JComboBox();
		String sq1 = "select distinct classname from Class";
		PreparedStatement ps = c.prepareStatement(sq1);
		ResultSet rs = ps.executeQuery();
		Vector vec = new Vector();
		for(int i=0;rs.next();++i) {
			vec.add(rs.getString(1));
		}
		String[] select = new String[vec.size()];
		for(int i=0;i<vec.size();++i) {
			select[i] = (String) vec.get(i);
		}
		jcb1.setModel(new DefaultComboBoxModel(select));
		int len = vec.size();
		vec.clear();
		JComboBox jcb2 = new JComboBox();
		jcb1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				String CLASS = String.valueOf(jcb1.getSelectedItem());
				String sq2 = "select distinct classdept from Class where classname = '"+CLASS+"'";
				try {
					PreparedStatement ps = c.prepareStatement(sq2);
					ResultSet rs = ps.executeQuery();
					
					jcb2.removeAllItems();
					while(rs.next()) {
						jcb2.addItem(rs.getString(1));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		JComboBox jcb3 = new JComboBox();
		sq1 = "select type from QuestionBankType";
		ps = c.prepareStatement(sq1);
		rs = ps.executeQuery();
		for(int i=0;rs.next();++i) {
			vec.add(rs.getString(1));
		}
		String[] select3 = new String[vec.size()];
		for(int i=0;i<vec.size();++i) {
			select3[i] = (String) vec.get(i);
		}
		jcb3.setModel(new DefaultComboBoxModel(select3));
		vec.clear();
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
		jbt7.setFont(new Font("宋体",Font.PLAIN,14));
		jbt7.setBounds(10, 530, 160, 50);//
		btn5.setFont(new Font("宋体",Font.PLAIN,18));
		btn5.setBounds(430, 550, 160, 50);//
		jta_Q.setFont(new Font("宋体",Font.PLAIN,18));
		jta_Q.setBounds(200, 200, 750,130);//
		jta_A.setFont(new Font("宋体",Font.PLAIN,18));
		jta_A.setBounds(200, 445, 750,100);//
		jb1.setFont(new Font("宋体",Font.PLAIN,30));
		jb1.setBounds(200, 150, 100, 50);//
		jb6.setFont(new Font("宋体",Font.PLAIN,30));
		jb6.setBounds(200, 400, 100, 50);//
		
		
		
		cta.add(jbt1);cta.add(jbt2);cta.add(jbt3);cta.add(jbt5);cta.add(jbt4);cta.add(jbt6);cta.add(btn5);
		cta.add(jta_Q);cta.add(jta_A);cta.add(jb1);cta.add(jb6);
		cta.add(jbt7);
		cta.setBackground(Color.gray);
		
		jcb1.setFont(new Font("宋体",Font.PLAIN,30));
		jcb1.setBounds(300, 130, 160, 30);//
		cta.add(jcb1);
		jcb2.setFont(new Font("宋体",Font.PLAIN,30));
		jcb2.setBounds(460, 130, 160, 30);//
		cta.add(jcb2);
		jcb3.setFont(new Font("宋体",Font.PLAIN,30));
		jcb3.setBounds(630, 130, 160, 30);//
		cta.add(jcb3);
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
		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(jta_Q.getText() != null&&jta_A.getText()!=null) {
					try {
						String Questiondecr = jta_Q.getText();
						String slq = "select QuestionNo from QuestionBankQuestion where Questiondecr ='"+Questiondecr+"'";
						PreparedStatement ps1 = c.prepareStatement(slq);
						ResultSet rs1 = ps1.executeQuery();
						if(rs1.next()) {
							new errorss();
						}else {
							String sql = "insert into QuestionBankQuestion(Questiondecr,QuestionAns,QuestionTye) values('"+jta_Q.getText()+"','"+jta_A.getText()+"','"+String.valueOf(jcb3.getSelectedItem())+"')";
							ps1 = c.prepareStatement(sql);
							ps1.executeUpdate();
							ps1.close();
							String sql2 = "select QuestionNo from QuestionBankQuestion where Questiondecr ='"+Questiondecr+"'";
							ps1 = c.prepareStatement(sql2);
							rs1 = ps1.executeQuery();
							int No=0;
							while(rs1.next()) {
								No = rs1.getInt(1);
							}
							ps1.close();
							sql2 = "select classno from Class where classname = '"+jcb1.getSelectedItem().toString()+"' and classdept = '"+jcb2.getSelectedItem().toString()+"'";
							ps1 = c.prepareStatement(sql2);
							rs1 = ps1.executeQuery();
							String classno = "";
							while(rs1.next()) {
								classno = rs1.getString(1);
							}
							String sql1 = "insert into QuestionBankQue values("+No+",'"+classno+"','"+jcb2.getSelectedItem().toString()+"')";
							ps1.close();
							ps1 = c.prepareStatement(sql1);
							ps1.executeUpdate();
							ps1.close();
						}
						
						jta_Q.setText(null);
						jta_A.setText(null);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					new error_Question();
				}
			}
			
		});
	}
}

class error_Question {
	public error_Question() {
		JFrame jf = new JFrame("提示");
		jf.setVisible(true);
		jf.setSize(600, 200);
		jf.setLocation(600, 350);
		JLabel jb = new JLabel("请不要空值!");
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
class errorss{
	public errorss() {
		JFrame jf = new JFrame("提示");
		jf.setVisible(true);
		jf.setSize(600, 200);
		jf.setLocation(600, 350);
		JLabel jb = new JLabel("已有该题目!");
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
	}
}
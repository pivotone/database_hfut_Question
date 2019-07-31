package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;
import java.awt.*;

public class ViewofQuestion {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static int number;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ViewofQuestion() throws Exception {
		String drive = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433;databaseName = QuestionBank";
		Class.forName(drive);
		Connection c =  DriverManager.getConnection(url,"sa","hsm12138");
		JFrame jf = new JFrame("题库管理系统(管理员版)");
		jf.setSize(1000, 1000);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setLocation(350, 0);
		jf.setLayout(null);
		Container cta = jf.getContentPane();
		JTextArea jta = new JTextArea(400,200);
		JTextArea jta1 = new JTextArea(400,200);
		JTextField jtf2 = new JTextField(10);
		JLabel jb = new JLabel("课程&章节：");
		JLabel jb1 = new JLabel("课程&题型：");
		JLabel jb2 = new JLabel("课程：");
		JLabel jb3 = new JLabel("题型:");
		JButton jbt1 = new JButton("录入试题");
		JButton jbt2 = new JButton("退出登录");
		JButton jbt3 = new JButton("删除试题");
		JButton jbt4 = new JButton("更改试题");
		JButton jbt5 = new JButton("查看试题");
		JButton jbt6 = new JButton("创建课程及章节&创建题目类型");
		JButton btn1 = new JButton("查询1");
		JButton btn2 = new JButton("查询2");
		JButton btn3 = new JButton("查询3");
		JButton btn4 = new JButton("查询4");
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
		jb.setFont(new Font("宋体",Font.PLAIN,30));
		jb.setBounds(200, 180, 200, 50);//
		jb1.setFont(new Font("宋体",Font.PLAIN,30));
		jb1.setBounds(200, 280, 200, 50);//
		jb2.setFont(new Font("宋体",Font.PLAIN,30));
		jb2.setBounds(200, 380, 160, 50);//
		jb3.setFont(new Font("宋体",Font.PLAIN,30));
		jb3.setBounds(200, 480, 160, 50);//
		btn1.setFont(new Font("宋体",Font.PLAIN,30));
		btn1.setBounds(800, 180, 160, 50);//
		btn2.setFont(new Font("宋体",Font.PLAIN,30));
		btn2.setBounds(800, 280, 160, 50);//
		btn3.setFont(new Font("宋体",Font.PLAIN,30));
		btn3.setBounds(800, 380, 160, 50);//
		btn4.setFont(new Font("宋体",Font.PLAIN,30));
		btn4.setBounds(800, 480, 160, 50);//
		cta.setBackground(Color.gray);
		cta.add(jbt1);cta.add(jbt2);cta.add(jbt3);cta.add(jbt5);cta.add(jbt4);cta.add(jbt6);
		cta.add(jb);cta.add(jb1);cta.add(jb2);cta.add(jb3);
		cta.add(btn1);cta.add(btn2);cta.add(btn3);cta.add(btn4);
		JComboBox jcb1 = new JComboBox();
		jcb1.setFont(new Font("宋体",Font.PLAIN,30));
		jcb1.setBounds(400, 180, 160, 50);//
		cta.add(jcb1);
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
		ps.close();
		int len = vec.size();
		vec.clear();
		
		JComboBox jcb2 = new JComboBox();
		jcb2.setFont(new Font("宋体",Font.PLAIN,30));
		jcb2.setBounds(600, 180, 160, 50);//
		cta.add(jcb2);
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
		ps.close();
		vec.clear();
		
		JComboBox jcb3 = new JComboBox();
		jcb3.setFont(new Font("宋体",Font.PLAIN,30));
		jcb3.setBounds(400, 380, 350, 50);//
		cta.add(jcb3);
		String sq3 = "select distinct classname from Class";
		ps = c.prepareStatement(sq3);
		rs = ps.executeQuery();
		for(int i=0;rs.next();++i) {
			vec.add(rs.getString(1));
		}
		String[] select2 = new String[vec.size()];
		for(int i=0;i<vec.size();++i) {
			select2[i] = (String) vec.get(i);
		}
		jcb3.setModel(new DefaultComboBoxModel(select2));
		ps.close();
		vec.clear();
		
		JComboBox jcb4 = new JComboBox();
		jcb4.setFont(new Font("宋体",Font.PLAIN,30));
		jcb4.setBounds(400, 480, 350, 50);//
		cta.add(jcb4);
		String sq4 = "select distinct QuestionTye from QuestionBankQuestion";
		ps = c.prepareStatement(sq4);
		rs = ps.executeQuery();
		for(int i=0;rs.next();++i) {
			vec.add(rs.getString(1));
		}
		String[] select3 = new String[vec.size()];
		for(int i=0;i<vec.size();++i) {
			select3[i] = (String) vec.get(i);
		}
		jcb4.setModel(new DefaultComboBoxModel(select3));
		ps.close();
		vec.clear();
		
		
		
		JComboBox jcb5 = new JComboBox();
		jcb5.setFont(new Font("宋体",Font.PLAIN,30));
		jcb5.setBounds(400, 280, 160, 50);//
		cta.add(jcb5);
		String sq5 = "select distinct classname from Class";
		ps = c.prepareStatement(sq5);
		rs = ps.executeQuery();
		for(int i=0;rs.next();++i) {
			vec.add(rs.getString(1));
		}
		String[] select5 = new String[vec.size()];
		for(int i=0;i<vec.size();++i) {
			select5[i] = (String) vec.get(i);
		}
		jcb5.setModel(new DefaultComboBoxModel(select5));
		ps.close();
		vec.clear();
		

		JComboBox jcb6 = new JComboBox();
		jcb6.setFont(new Font("宋体",Font.PLAIN,30));
		jcb6.setBounds(600, 280, 160, 50);//
		cta.add(jcb6);
		String sq6 = "select distinct QuestionTye from QuestionBankQuestion";
		ps = c.prepareStatement(sq6);
		rs = ps.executeQuery();
		for(int i=0;rs.next();++i) {
			vec.add(rs.getString(1));
		}
		String[] select6 = new String[vec.size()];
		for(int i=0;i<vec.size();++i) {
			select6[i] = (String) vec.get(i);
		}
		jcb6.setModel(new DefaultComboBoxModel(select6));
		ps.close();
		vec.clear();
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
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String sql = jcb1.getSelectedItem().toString();
					String sql2 = jcb2.getSelectedItem().toString();
					CallableStatement cstt = c.prepareCall("{? = call dbo.NumQuestion(?,?)}");
					cstt.registerOutParameter(1, java.sql.Types.INTEGER);
					cstt.setString(2,sql);
					cstt.setString(3, sql2);
					cstt.execute();
					number = cstt.getInt(1);
					new Number();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String sql = jcb5.getSelectedItem().toString();
					String sql1 = jcb6.getSelectedItem().toString();
					CallableStatement cstt = c.prepareCall("{? = call dbo.NumType(?,?)}");
					cstt.registerOutParameter(1, java.sql.Types.INTEGER);
					cstt.setString(2,sql);
					cstt.setString(3, sql1);
					cstt.execute();
					number = cstt.getInt(1);
					new Number();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String sql = jcb3.getSelectedItem().toString();
					CallableStatement cstt = c.prepareCall("{? = call dbo.Numoffall(?)}");
					cstt.registerOutParameter(1, java.sql.Types.INTEGER);
					cstt.setString(2,sql);
					cstt.execute();
					number = cstt.getInt(1);
					new Number(); 
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String sql = jcb4.getSelectedItem().toString();
					CallableStatement cstt = c.prepareCall("{? = call dbo.NumofallType(?)}");
					cstt.registerOutParameter(1, java.sql.Types.INTEGER);
					cstt.setString(2,sql);
					cstt.execute();
					number = cstt.getInt(1);
					new Number();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
	}
}
class Number{
	public Number() {
		JFrame jf = new JFrame("提示");
		jf.setVisible(true);
		jf.setSize(600, 200);
		jf.setLocation(600, 350);
		JLabel jb = new JLabel("题目数量为："+ViewofQuestion.number);
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
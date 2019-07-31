package login;

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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.awt.*;

public class Delete_Question {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Delete_Question() throws Exception {
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
		JLabel jb1 = new JLabel("删除题目:");
		JLabel jb2 = new JLabel("删除课程章节");
		JButton jbt1 = new JButton("录入试题");
		JButton jbt2 = new JButton("退出登录");
		JButton jbt3 = new JButton("删除试题");
		JButton jbt4 = new JButton("更改试题");
		JButton jbt5 = new JButton("查看试题");
		JButton jbt6 = new JButton("创建课程及章节&创建题目类型");
		JButton btn1 = new JButton("执行");
		JButton btn2 = new JButton("执行");
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
		JComboBox jcb4 = new JComboBox();
		sq1 = "select distinct classname from Class";
		ps = c.prepareStatement(sq1);
		rs = ps.executeQuery();
		vec = new Vector();
		for(int i=0;rs.next();++i) {
			vec.add(rs.getString(1));
		}
		String[] select3 = new String[vec.size()];
		for(int i=0;i<vec.size();++i) {
			select3[i] = (String) vec.get(i);
		}
		jcb4.setModel(new DefaultComboBoxModel(select3));
		len = vec.size();
		vec.clear();
		JComboBox jcb5 = new JComboBox();
		jcb4.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				String CLASS = String.valueOf(jcb4.getSelectedItem());
				String sq2 = "select distinct classdept from Class where classname = '"+CLASS+"'";
				try {
					PreparedStatement ps = c.prepareStatement(sq2);
					ResultSet rs = ps.executeQuery();
					
					jcb5.removeAllItems();
					while(rs.next()) {
						jcb5.addItem(rs.getString(1));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		JComboBox jcb3 = new JComboBox();
		jcb5.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				String CLASS = String.valueOf(jcb4.getSelectedItem());
				String Dept = String.valueOf(jcb5.getSelectedItem());
				String sq2 = "select Questiondecr from QuestionBankQuestion where QuestionNo in (select QuestionNo from QuestionBankQue where QuestionClass = (select classno from Class where classdept = '"+Dept+"' and classname = '"+CLASS+"') and QuestionDept = '"+Dept+"')";
				try {
					PreparedStatement ps = c.prepareStatement(sq2);
					ResultSet rs = ps.executeQuery();
					
					jcb3.removeAllItems();
					while(rs.next()) {
						jcb3.addItem(rs.getString(1));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
		jb1.setBounds(200, 200, 160, 50);//
		jb2.setFont(new Font("宋体",Font.PLAIN,30));
		jb2.setBounds(200, 450, 210, 50);//
		jcb1.setFont(new Font("宋体",Font.PLAIN,30));
		jcb1.setBounds(410, 450, 160, 50);//
		btn1.setFont(new Font("宋体",Font.PLAIN,30));
		btn1.setBounds(500, 340, 160, 50);//
		btn2.setFont(new Font("宋体",Font.PLAIN,30));
		btn2.setBounds(500, 530, 160, 50);//
		cta.setBackground(Color.gray);
		cta.add(jbt1);cta.add(jbt2);cta.add(jbt3);cta.add(jbt5);cta.add(jbt4);cta.add(jbt6);
		cta.add(jb1);cta.add(jb2);cta.add(jcb1);
		cta.add(btn1);cta.add(btn2);
		jcb2.setFont(new Font("宋体",Font.PLAIN,30));
		jcb2.setBounds(620, 450, 160, 50);//
		cta.add(jcb2);
		jcb4.setFont(new Font("宋体",Font.PLAIN,30));
		jcb4.setBounds(300, 270, 160, 30);//
		cta.add(jcb4);
		jcb5.setFont(new Font("宋体",Font.PLAIN,30));
		jcb5.setBounds(500, 270, 160, 30);//
		cta.add(jcb5);
		jcb3.setFont(new Font("宋体",Font.PLAIN,30));
		jcb3.setBounds(700, 270, 160, 30);//
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
					String sqlss = "select QuestionNo from QuestionBankQuestion where Questiondecr = '"+String.valueOf(jcb3.getSelectedItem())+"'";
					PreparedStatement ps1 = c.prepareStatement(sqlss);
					ResultSet rs1 = ps1.executeQuery();
					if(rs1.next()) {
						int No = rs1.getInt(1);
						String sqls1 = "delete from QuestionBankQue where QuestionNo = "+No+"";
						ps1 = c.prepareStatement(sqls1);
						ps1.executeUpdate();
						ps1.close();
						sqls1 = "delete from QuestionBankQuestion where Questiondecr = '"+String.valueOf(jcb3.getSelectedItem())+"'";
						ps1 = c.prepareStatement(sqls1);
						ps1.executeUpdate();
						
					}else {
						new error();
					}
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
					String sqls2 = "select classno from Class where classname = '"+jcb1.getSelectedItem().toString()+"' and classdept = '"+jcb2.getSelectedItem().toString()+"'";
					PreparedStatement ps2;
					ps2 = c.prepareStatement(sqls2);
					ResultSet rs = ps2.executeQuery();
					String No = "";
					if(rs.next()) {
						No = rs.getString(1);
					}
					String sqls3 = "delete from QuestionBankQue where QuestionClass = '"+No+"' and QuestionDept = '"+jcb2.getSelectedItem().toString()+"'";
					ps2 = c.prepareStatement(sqls3);
					ps2.executeUpdate();
					sqls3 = "delete from Class where classno = '"+No+"' and classdept = '"+jcb2.getSelectedItem().toString()+"'";
					ps2 = c.prepareStatement(sqls3);
					ps2.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
	}
}
class error {
	public error() {
		JFrame jf = new JFrame("提示");
		jf.setVisible(true);
		jf.setSize(600, 200);
		jf.setLocation(600, 350);
		JLabel jb = new JLabel("删除错误");
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
class success {
	public success() {
		JFrame jf = new JFrame("提示");
		jf.setVisible(true);
		jf.setSize(600, 200);
		jf.setLocation(600, 350);
		JLabel jb = new JLabel("删除成功");
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
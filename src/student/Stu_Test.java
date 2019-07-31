package login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.*;
public class Stu_Test {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Stu_Test() throws Exception {
		String drive = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433;databaseName = QuestionBank";
		Class.forName(drive);
		Connection c =  DriverManager.getConnection(url,"sa","hsm12138");
		JFrame jf = new JFrame(" ‘Ã‚≤‚ ‘(—ß…˙”√)");
		Container cta = jf.getContentPane();
		jf.setSize(1000, 1000);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setLocation(350, 0);
		jf.setLayout(null);
		JComboBox jcb1 = new JComboBox();
		jcb1.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.PLAIN,20));
		jcb1.setBounds(400, 30, 400, 30);
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
		JButton jbt1 = new JButton("ÕÀ≥ˆ");
		JButton jbt2 = new JButton(" ‘Ã‚¡∑œ∞");
		JButton jbt3 = new JButton(" ‘Ã‚≤‚ ‘");
		JButton btn1 = new JButton("…˙≥… ‘Ã‚");
		JButton btn2 = new JButton("ªÒµ√¥∞∏");
		jbt1.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.PLAIN,20));
		jbt1.setBounds(10, 0, 200, 100);
		jbt2.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.PLAIN,20));
		jbt2.setBounds(10, 300, 200, 100);
		jbt3.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.PLAIN,20));
		jbt3.setBounds(10, 600, 200, 100);
		btn1.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.PLAIN,20));
		btn1.setBounds(300, 800, 200, 100);
		btn2.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.PLAIN,20));
		btn2.setBounds(600, 800, 200, 100);
		cta.add(jbt1);cta.add(jbt2);cta.add(jbt3);cta.add(btn1);cta.add(btn2);
		JTextArea jta = new JTextArea();
		JScrollPane jsp=new JScrollPane(jta);
		jsp.setBounds(300, 100, 600, 300);
		JTextArea jta1 = new JTextArea();
		JScrollPane jsp1=new JScrollPane(jta1);
		jsp1.setBounds(300, 500, 600, 200);
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					cta.add(jsp);
					cta.remove(jsp1);
					jta.setText(null);
					jta1.setText(null);
					cta.repaint();
					CallableStatement cstt = c.prepareCall("{call dbo.selectTest(?)}");
					String sqlsql = jcb1.getSelectedItem().toString();
					cstt.setString(1, sqlsql);
					cstt.execute();
					String sql1 = "select classno from Class where classname = '"+jcb1.getSelectedItem().toString()+"'";
					PreparedStatement ps1 = c.prepareStatement(sql1);
					ResultSet rs1 = ps1.executeQuery();
					String No = "";
					if(rs1.next()) {
						No = rs1.getString(1);
					}
					String sqls = "select Questiondecr,QuestionAns from QuestionBankQuestion,QuestionBankQue where QuestionBankQuestion.QuestionNo = QuestionBankQue.QuestionNo and QuestionTye = '—°‘ÒÃ‚' and QuestionClass = '"+No+"'";
					ps1 = c.prepareStatement(sqls);
					rs1 = ps1.executeQuery();
					int i = 1;
					for(int j=0;j<10&&rs1.next();) {
						int x = (int)(Math.random()*2);
						if(x==1) {
							jta.setText(jta.getText()+i+"."+"\t");
							jta.setText(jta.getText()+rs1.getString(1)+"\n");
							jta1.setText(jta1.getText()+i+"."+"\t");
							jta1.setText(jta1.getText()+rs1.getString(2)+"\n");
							++i;
							++j;
						}
					}
					String sqls1 = "select Questiondecr,QuestionAns from  QuestionBankQuestion,QuestionBankQue where QuestionBankQuestion.QuestionNo = QuestionBankQue.QuestionNo and QuestionTye = 'ÃÓø’Ã‚' and QuestionClass = '"+No+"'";
					ps1 = c.prepareStatement(sqls1);
					rs1 = ps1.executeQuery();
					for(int j=0;j<10&&rs1.next();) {
						int x = (int)(Math.random()*2);
						if(x==1) {
							jta.setText(jta.getText()+i+"."+"\t");
							jta.setText(jta.getText()+rs1.getString(1)+"\n");
							jta1.setText(jta1.getText()+i+"."+"\t");
							jta1.setText(jta1.getText()+rs1.getString(2)+"\n");
							++i;
							++j;
						}
					}
					String sqls2 = "select Questiondecr,QuestionAns from  QuestionBankQuestion,QuestionBankQue where QuestionBankQuestion.QuestionNo = QuestionBankQue.QuestionNo and QuestionTye = '≈–∂œÃ‚' and QuestionClass = '"+No+"'";
					ps1 = c.prepareStatement(sqls2);
					rs1 = ps1.executeQuery();
					for(int j=0;j<10&&rs1.next();) {
						int x = (int)(Math.random()*2);
						if(x==1) {
							jta.setText(jta.getText()+i+"."+"\t");
							jta.setText(jta.getText()+rs1.getString(1)+"\n");
							jta1.setText(jta1.getText()+i+"."+"\t");
							jta1.setText(jta1.getText()+rs1.getString(2)+"\n");
							++i;
							++j;
						}
					}
					String sqls3 = "select Questiondecr,QuestionAns from QuestionBankQuestion,QuestionBankQue where QuestionBankQuestion.QuestionNo = QuestionBankQue.QuestionNo and QuestionTye = '◊€∫œÃ‚' and QuestionClass = '"+No+"'";
					ps1 = c.prepareStatement(sqls3);
					rs1 = ps1.executeQuery();
					for(int j=0;j<5&&rs1.next();) {
						int x = (int)(Math.random()*2);
						if(x==1) {
							jta.setText(jta.getText()+i+"."+"\t");
							jta.setText(jta.getText()+rs1.getString(1)+"\n");
							jta1.setText(jta1.getText()+i+"."+"\t");
							jta1.setText(jta1.getText()+rs1.getString(2)+"\n");
							++i;
							++j;
						}
					}
					//String sqlss = "update QuestionBankUser set TimesTest = TimesTest + 1 where userName = '"+log_in.user+"'";
					
					String sqlss = "insert into QuestionTest(userName,Class) values('"+log_in.user+"','"+sqlsql+"')";
					ps1 = c.prepareStatement(sqlss);
					ps1.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cta.add(jsp1);
				cta.repaint();
			}
			
		});
		jbt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jf.setVisible(false);
				try {
					new log_in();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		jbt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jf.setVisible(false);
				try {
					new Stu_learnPrac();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		jbt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				jf.setVisible(false);
				try {
					new Stu_Test();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
	}
}

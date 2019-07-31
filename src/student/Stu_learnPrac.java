package login;

import login.log_in;
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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import java.awt.*
;public class Stu_learnPrac {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Stu_learnPrac() throws Exception {
		String drive = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433;databaseName = QuestionBank";
		Class.forName(drive);
		Connection c =  DriverManager.getConnection(url,"sa","hsm12138");
		JFrame jf = new JFrame(" ‘Ã‚ø‚œµÕ≥(—ß…˙”√)");
		jf.setSize(1000, 1000);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setLocation(350, 0);
		jf.setLayout(null);
		Container cta = jf.getContentPane();
		JButton jbt1 = new JButton("ÕÀ≥ˆ");
		JButton jbt2 = new JButton(" ‘Ã‚¡∑œ∞");
		JButton jbt3 = new JButton(" ‘Ã‚≤‚ ‘");
		JButton btn1 = new JButton("ªÒµ√—µ¡∑œ∞Ã‚");
		JButton btn2 = new JButton("ªÒ»°œ∞Ã‚¥∞∏");
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
		//cta.add(jta);cta.add(jta1);
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
		jcb1.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.PLAIN,20));
		jcb1.setBounds(400, 30, 130, 30);
		cta.add(jcb1);
		int len = vec.size();
		vec.clear();
		JComboBox jcb2 = new JComboBox();
		jcb2.setFont(new Font("Œ¢»Ì—≈∫⁄",Font.PLAIN,20));
		jcb2.setBounds(700, 30, 130, 30);
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
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PreparedStatement ps1;
				try {
					cta.add(jsp);
					cta.remove(jsp1);
					jta.setText(null);
					jta1.setText(null);
					cta.repaint();
					CallableStatement cstt = c.prepareCall("{call dbo.selectPrac(?,?)}");
					String sqlsql1 = jcb1.getSelectedItem().toString();
					String sqlsql2 = jcb2.getSelectedItem().toString();
					cstt.setString(1, sqlsql1);
					cstt.setString(2, sqlsql2);
					cstt.execute();
					String sql1 = "select classno from Class where classname = '"+jcb1.getSelectedItem().toString()+"' and classdept = '"+jcb2.getSelectedItem().toString()+"'";
					ps1 = c.prepareStatement(sql1);
					ResultSet rs1 = ps1.executeQuery();
					String No = "";
					if(rs1.next()) {
						No = rs1.getString(1);
					}
					String sql = "select QuestionBankQuestion.QuestionNo,Questiondecr,QuestionTye from QuestionBankQuestion where QuestionBankQuestion.QuestionNo in (select QuestionBankQue.QuestionNo from QuestionBankQue where QuestionClass ='"+No+"' and QuestionDept = '"+jcb2.getSelectedItem().toString()+"')";
					ps1 = c.prepareStatement(sql);
					rs1 = ps1.executeQuery();
					while(rs1.next()) {
						String Tye = rs1.getString(3);
						String decr = rs1.getString(2);
						jta.setText(jta.getText()+rs1.getInt(1)+".\t");
						jta.setText(jta.getText()+Tye);
						jta.setText(jta.getText()+decr+"\n");
					}
					String sql3 = "insert into QuestionPrac(selectNo,Class,Dept) values('"+log_in.user+"','"+sqlsql1+"','"+sqlsql2+"')";
					ps1 = c.prepareStatement(sql3);
					ps1.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					cta.add(jsp1);
					cta.repaint();
					String sql1 = "select classno from Class where classname = '"+jcb1.getSelectedItem().toString()+"' and classdept = '"+jcb2.getSelectedItem().toString()+"'";
					PreparedStatement ps2 = c.prepareStatement(sql1);
					ResultSet rs2 = ps2.executeQuery();
					String No = "";
					if(rs2.next()) {
						No = rs2.getString(1);
					}
					String sql2 = "select QuestionBankQuestion.QuestionNo,QuestionAns from QuestionBankQuestion where QuestionBankQuestion.QuestionNo in (select QuestionBankQue.QuestionNo from QuestionBankQue where QuestionClass ='"+No+"' and QuestionDept = '"+jcb2.getSelectedItem().toString()+"')";
					ps2 = c.prepareStatement(sql2);
					rs2 = ps2.executeQuery();
					while(rs2.next()) {
						jta1.setText(jta1.getText()+String.valueOf(rs2.getInt(1))+".\t");
						jta1.setText(jta1.getText()+rs2.getString(2)+"\n");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
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

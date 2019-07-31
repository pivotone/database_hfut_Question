package login;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class safety_safety {
	static File file;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public safety_safety() throws Exception {
		String drive = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://localhost:1433;databaseName = QuestionBank";
		Class.forName(drive);
		Connection c =  DriverManager.getConnection(url,"sa","hsm12138");
		JFrame jf = new JFrame("������ϵͳ(����Ա��)");
		jf.setSize(1000, 1000);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setLocation(350, 0);
		jf.setLayout(null);
		Container cta = jf.getContentPane();
		JButton jbt1 = new JButton("¼������");
		JButton jbt2 = new JButton("�˳���¼");
		JButton jbt3 = new JButton("ɾ������");
		JButton jbt4 = new JButton("��������");
		JButton jbt5 = new JButton("�鿴����");
		JButton jbt6 = new JButton("�����γ̼��½�&������Ŀ����");
		JButton jtb7 = new JButton("����&�ָ�");
		JButton btn1 = new JButton("����");
		JButton btn2 = new JButton("�ָ�");
		JButton btn3 = new JButton("ѡ�񱸷�·��");
		JButton btn4 = new JButton("ѡ��ָ��ļ�");
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser jfc  =new JFileChooser("ѡ�񱸷�·��");
				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
				jfc.showDialog(new JLabel(), "ѡ��");
				file = jfc.getSelectedFile();
				System.out.println(file.getAbsolutePath());
			}
		});
		btn4.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser jfc  =new JFileChooser("ѡ�񱸷�·��");
				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );  
				jfc.showDialog(new JLabel(), "ѡ��");
				file = jfc.getSelectedFile();
				System.out.println(file.getAbsolutePath());
			}
		});
		btn4.setFont(new Font("����",Font.PLAIN,18));
		btn4.setBounds(350, 500, 160, 50);//"¼������"
	    btn3.setFont(new Font("����",Font.PLAIN,18));
		btn3.setBounds(350, 250, 160, 50);//"¼������"
		jbt1.setFont(new Font("����",Font.PLAIN,18));
		jbt1.setBounds(10, 180, 160, 50);//"¼������"
		jbt2.setFont(new Font("����",Font.PLAIN,18));
		jbt2.setBounds(10, 10, 160, 50);//"�˳���½"
		jbt3.setFont(new Font("����",Font.PLAIN,18));
		jbt3.setBounds(10, 250, 160, 50);//
		jbt4.setFont(new Font("����",Font.PLAIN,18));
		jbt4.setBounds(10, 320, 160, 50);//
		jbt5.setFont(new Font("����",Font.PLAIN,18));
		jbt5.setBounds(10, 390, 160, 50);//
		jbt6.setFont(new Font("����",Font.PLAIN,14));
		jbt6.setBounds(10, 460, 160, 50);//
		jtb7.setFont(new Font("����",Font.PLAIN,14));
		jtb7.setBounds(10, 530, 160, 50);//
		btn1.setFont(new Font("����",Font.PLAIN,18));
		btn1.setBounds(550, 250, 160, 50);//"¼������"
		btn2.setFont(new Font("����",Font.PLAIN,18));
		btn2.setBounds(550, 500, 160, 50);//"¼������"
		cta.setBackground(Color.gray);
		cta.add(jbt1);cta.add(jbt2);cta.add(jbt3);cta.add(jbt5);cta.add(jbt4);cta.add(jbt6);cta.add(jtb7);
		cta.add(btn1);cta.add(btn2);cta.add(btn3);cta.add(btn4);
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
		jtb7.addActionListener(new ActionListener() {
			
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
					String sql = "backup database QuestionBank to disk = '"+file.getAbsolutePath()+"\\QuestionBank.bak' with format";
					PreparedStatement ps = c.prepareStatement(sql);
					ps.execute();
					new success1();
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
					String sql1 = "restore database QuestionBank from disk = '"+file.getAbsolutePath()+"' with replace,recovery";
					CallableStatement cstmt = c.prepareCall("{? = call dbo.reducdb(?)}"); 
					cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
					cstmt.setString(2,sql1);
					cstmt.execute();
					if(cstmt.getInt(1)==1) {
						new success2();
					}else {
						new errors();
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					new errors();
				}
			}
		});
	}
}
class success2 {
	public success2() {
		JFrame jf = new JFrame("��ʾ");
		jf.setVisible(true);
		jf.setSize(600, 200);
		jf.setLocation(600, 350);
		JLabel jb = new JLabel("�ָ��ɹ�");
		Container ctn = jf.getContentPane();
		jb.setHorizontalAlignment(SwingConstants.CENTER);
		jb.setFont(new Font("����",Font.PLAIN,40));
		JButton jbt = new JButton("ȷ��");
		jbt.setFont(new Font("����",Font.PLAIN,30));
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
class success1 {
	public success1() {
		JFrame jf = new JFrame("��ʾ");
		jf.setVisible(true);
		jf.setSize(600, 200);
		jf.setLocation(600, 350);
		JLabel jb = new JLabel("���ݳɹ�");
		Container ctn = jf.getContentPane();
		jb.setHorizontalAlignment(SwingConstants.CENTER);
		jb.setFont(new Font("����",Font.PLAIN,40));
		JButton jbt = new JButton("ȷ��");
		jbt.setFont(new Font("����",Font.PLAIN,30));
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
class errors{
	public errors() {
		JFrame jf = new JFrame("��ʾ");
		jf.setVisible(true);
		jf.setSize(600, 200);
		jf.setLocation(600, 350);
		JLabel jb = new JLabel("�ָ�ʧ��");
		Container ctn = jf.getContentPane();
		jb.setHorizontalAlignment(SwingConstants.CENTER);
		jb.setFont(new Font("����",Font.PLAIN,40));
		JButton jbt = new JButton("ȷ��");
		jbt.setFont(new Font("����",Font.PLAIN,30));
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
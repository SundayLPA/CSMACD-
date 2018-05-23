import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class CSMACDControl extends javax.swing.JDialog implements
		ActionListener {
	private JPanel jPanel1;

	public static JLabel jLabelB;

	private JLabel jLabelATranTime;
	public static JButton jButtonCControl;
	public static JButton jButtonBControl;
	public static JButton jButtonAControl;

	public static JTextField jTextFieldCBackTime;

	public static JTextField jTextFieldCBackCount;

	public static JTextField jTextFieldCTranTime;

	private JLabel jLabelCBackTime;

	public static JTextField jTextFieldABackTime;

	private JLabel jLabelCBackCount;

	private JLabel jLabelCTranTime;

	public static JTextField jTextFieldBTranTime;

	public static JTextField jTextFieldBBackCount;

	public static JTextField jTextFieldBBackTime;

	private JLabel jLabelBTranTime;

	private JLabel jLabelBBackCount;

	private JLabel jLabelBBackTime;

	public static JTextField jTextFieldABackCount;

	private JLabel jLabelABackTime;

	private JLabel jLabelABackCount;

	public static JTextField jTextFieldATranTime;

	public static JLabel jLabelC;

	public static JLabel jLabelA;

	public static JButton jButtonC;

	public static JButton jButtonB;

	public static JProgressBar jProgressBar;

	public static JButton jButtonA;

	/**
	 * Auto-generated main method to display this JDialog
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				CSMACDControl inst = new CSMACDControl(frame);
				inst.setVisible(true);

			}
		});

		Bus.busStartTime = new Double((System.nanoTime()) / Math.pow(10, 9))
				.doubleValue();

	}

	public CSMACDControl(JFrame frame) {
		super(frame);
		initGUI();
	}

	private void initGUI() {
		try {
			{
				this.setResizable(false);
				this.setTitle("\u6a21\u62dfCSMA/CD");
				{
					jPanel1 = new JPanel();
					getContentPane().add(jPanel1, BorderLayout.CENTER);
					jPanel1.setLayout(null);
					{
						jButtonA = new JButton();
						jPanel1.add(jButtonA);
						jButtonA.setBounds(207, 85, 80, 63);
						jButtonA.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource("dead.jpg")));
						
					}
					{
						jProgressBar = new JProgressBar();
						jPanel1.add(jProgressBar);
						jProgressBar.setStringPainted(true);
						jProgressBar.setBounds(90, 207, 461, 36);
					}
					{
						jButtonB = new JButton();
						jPanel1.add(jButtonB);
						jButtonB.setBounds(66, 304, 80, 63);
						jButtonB.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource("dead.jpg")));
						
					}
					{
						jButtonC = new JButton();
						jPanel1.add(jButtonC);
						jButtonC.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource("dead.jpg")));
						jButtonC.setBounds(495, 302, 80, 63);
						
					}
					{
						jLabelA = new JLabel();
						jPanel1.add(jLabelA);
						jLabelA.setBounds(232, 148, 31, 59);
						jLabelA.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource("Link.jpg")));
						jLabelA.setVisible(false);
					}
					{
						jLabelB = new JLabel();
						jPanel1.add(jLabelB);
						jLabelB.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource("Link.jpg")));
						jLabelB.setBounds(91, 245, 31, 59);
						jLabelB.setVisible(false);
					}
					{
						jLabelC = new JLabel();
						jPanel1.add(jLabelC);
						jLabelC.setIcon(new ImageIcon(getClass()
								.getClassLoader().getResource("Link.jpg")));
						jLabelC.setBounds(518, 243, 31, 59);
						jLabelC.setVisible(false);
					}
					{
						jLabelATranTime = new JLabel();
						jPanel1.add(jLabelATranTime);
						jLabelATranTime
								.setText("\u4f20\u8f93\u65f6\u95f4\uff1a");
						jLabelATranTime.setBounds(306, 58, 74, 15);
						jLabelATranTime.setFont(new java.awt.Font("仿宋_GB2312",
								0, 14));
					}
					{
						jTextFieldATranTime = new JTextField();
						jPanel1.add(jTextFieldATranTime);
						jTextFieldATranTime.setBounds(387, 55, 49, 22);
					}
					{
						jLabelABackCount = new JLabel();
						jPanel1.add(jLabelABackCount);
						jLabelABackCount
								.setText("\u56de\u9000\u6b21\u6570\uff1a");
						jLabelABackCount.setBounds(304, 93, 77, 15);
						jLabelABackCount.setFont(new java.awt.Font("仿宋_GB2312",
								0, 14));
					}
					{
						jLabelABackTime = new JLabel();
						jPanel1.add(jLabelABackTime);
						jLabelABackTime
								.setText("\u56de\u9000\u65f6\u95f4\uff1a");
						jLabelABackTime.setBounds(304, 125, 77, 15);
						jLabelABackTime.setFont(new java.awt.Font("仿宋_GB2312",
								0, 14));
					}
					{
						jTextFieldABackCount = new JTextField();
						jPanel1.add(jTextFieldABackCount);
						jTextFieldABackCount.setBounds(387, 90, 49, 22);
						jTextFieldABackCount.setEditable(false);
					}
					{
						jTextFieldABackTime = new JTextField();
						jPanel1.add(jTextFieldABackTime);
						jTextFieldABackTime.setEditable(false);
						jTextFieldABackTime.setBounds(387, 122, 49, 22);
					}
					{
						jLabelBBackTime = new JLabel();
						jPanel1.add(jLabelBBackTime);
						jLabelBBackTime
								.setText("\u56de\u9000\u65f6\u95f4\uff1a");
						jLabelBBackTime.setFont(new java.awt.Font("仿宋_GB2312",
								0, 14));
						jLabelBBackTime.setBounds(157, 375, 74, 15);
					}
					{
						jLabelBBackCount = new JLabel();
						jPanel1.add(jLabelBBackCount);
						jLabelBBackCount
								.setText("\u56de\u9000\u6b21\u6570\uff1a");
						jLabelBBackCount.setFont(new java.awt.Font("仿宋_GB2312",
								0, 14));
						jLabelBBackCount.setBounds(157, 341, 77, 15);
					}
					{
						jLabelBTranTime = new JLabel();
						jPanel1.add(jLabelBTranTime);
						jLabelBTranTime
								.setText("\u4f20\u8f93\u65f6\u95f4\uff1a");
						jLabelBTranTime.setFont(new java.awt.Font("仿宋_GB2312",
								0, 14));
						jLabelBTranTime.setBounds(157, 307, 77, 15);
					}
					{
						jTextFieldBBackTime = new JTextField();
						jPanel1.add(jTextFieldBBackTime);
						jTextFieldBBackTime.setEditable(false);
						jTextFieldBBackTime.setBounds(231, 372, 49, 22);
					}
					{
						jTextFieldBBackCount = new JTextField();
						jPanel1.add(jTextFieldBBackCount);
						jTextFieldBBackCount.setEditable(false);
						jTextFieldBBackCount.setBounds(232, 337, 49, 22);
					}
					{
						jTextFieldBTranTime = new JTextField();
						jPanel1.add(jTextFieldBTranTime);
						jTextFieldBTranTime.setBounds(232, 304, 49, 22);
					}
					{
						jLabelCTranTime = new JLabel();
						jPanel1.add(jLabelCTranTime);
						jLabelCTranTime
								.setText("\u4f20\u8f93\u65f6\u95f4\uff1a");
						jLabelCTranTime.setFont(new java.awt.Font("仿宋_GB2312",
								0, 14));
						jLabelCTranTime.setBounds(359, 307, 77, 15);
					}
					{
						jLabelCBackCount = new JLabel();
						jPanel1.add(jLabelCBackCount);
						jLabelCBackCount
								.setText("\u56de\u9000\u6b21\u6570\uff1a");
						jLabelCBackCount.setFont(new java.awt.Font("仿宋_GB2312",
								0, 14));
						jLabelCBackCount.setBounds(359, 341, 77, 15);
					}
					{
						jLabelCBackTime = new JLabel();
						jPanel1.add(jLabelCBackTime);
						jLabelCBackTime
								.setText("\u56de\u9000\u65f6\u95f4\uff1a");
						jLabelCBackTime.setFont(new java.awt.Font("仿宋_GB2312",
								0, 14));
						jLabelCBackTime.setBounds(359, 375, 74, 15);
					}
					{
						jTextFieldCTranTime = new JTextField();
						jPanel1.add(jTextFieldCTranTime);
						jTextFieldCTranTime.setBounds(434, 304, 49, 22);
					}
					{
						jTextFieldCBackCount = new JTextField();
						jPanel1.add(jTextFieldCBackCount);
						jTextFieldCBackCount.setEditable(false);
						jTextFieldCBackCount.setBounds(434, 337, 49, 22);
					}
					{
						jTextFieldCBackTime = new JTextField();
						jPanel1.add(jTextFieldCBackTime);
						jTextFieldCBackTime.setEditable(false);
						jTextFieldCBackTime.setBounds(433, 372, 49, 22);
					}
					{
						jButtonAControl = new JButton();
						jPanel1.add(jButtonAControl);
						jButtonAControl.setText("\u4e3b\u673aA");
						jButtonAControl.setBounds(207, 45, 80, 32);
						jButtonAControl.setFont(new java.awt.Font("仿宋_GB2312",0,14));
						jButtonAControl.addActionListener(this);
					}
					{
						jButtonBControl = new JButton();
						jPanel1.add(jButtonBControl);
						jButtonBControl.setText("\u4e3b\u673aB");
						jButtonBControl.setBounds(66, 375, 80, 30);
						jButtonBControl.setSize(80, 32);
						jButtonBControl.setFont(new java.awt.Font("仿宋_GB2312",0,14));
						jButtonBControl.addActionListener(this);
					}
					{
						jButtonCControl = new JButton();
						jPanel1.add(jButtonCControl);
						jButtonCControl.setText("\u4e3b\u673aC");
						jButtonCControl.setBounds(495, 375, 80, 30);
						jButtonCControl.setSize(80, 32);
						jButtonCControl.setFont(new java.awt.Font("仿宋_GB2312",0,14));
						jButtonCControl.addActionListener(this);
					}
				}
			}
			this.setSize(650, 482);
			WindowCenter.Center(this);

			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					dispose();
					System.exit(0);
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==jButtonAControl)
		{   
			if (jTextFieldATranTime.getText().equals("")||new Integer(jTextFieldATranTime.getText().trim()).intValue()==0) {
				JOptionPane.showMessageDialog(this, "传输时间输入有错!", "传输时间",
						JOptionPane.WARNING_MESSAGE);
				}
			else	
			{   
				int i=new Integer(jTextFieldATranTime.getText()).intValue();
				jButtonA.setIcon(new ImageIcon(getClass()
						.getClassLoader().getResource("unworking.jpg")));
				jButtonAControl.setEnabled(false);
				
				Bus bus=new Bus();            
			    Competitor a=new Competitor(i,"A",bus);	
			    a.start();
		
			}
			}
		if(e.getSource()==jButtonBControl)
			
		{
		if (jTextFieldBTranTime.getText().equals("")||new Integer(jTextFieldBTranTime.getText().trim()).intValue()==0) {
			JOptionPane.showMessageDialog(this, "传输时间输入有错!", "传输时间",
					JOptionPane.WARNING_MESSAGE);
			}
		else	
		{   int j=new Integer(jTextFieldBTranTime.getText()).intValue();
		jButtonB.setIcon(new ImageIcon(getClass()
				.getClassLoader().getResource("unworking.jpg")));
		jButtonBControl.setEnabled(false);
			Bus bus=new Bus();            
		    Competitor a=new Competitor(j,"B",bus);	
		    a.start();
	
		}
			
		}
		
		if(e.getSource()==jButtonCControl)
		{
		if (jTextFieldCTranTime.getText().equals("")||new Integer(jTextFieldCTranTime.getText().trim()).intValue()==0) {
			JOptionPane.showMessageDialog(this, "传输时间输入有错!", "传输时间",
					JOptionPane.WARNING_MESSAGE);
			}
		else	
		{   int k=new Integer(jTextFieldCTranTime.getText()).intValue();
		   jButtonC.setIcon(new ImageIcon(getClass()
				.getClassLoader().getResource("unworking.jpg")));
		   jButtonCControl.setEnabled(false);
			Bus bus=new Bus();            
		    Competitor a=new Competitor(k,"C",bus);	
		    a.start();
	
		}
			
		}
		
	}
     
}

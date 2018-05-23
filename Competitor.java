import java.math.BigDecimal;
import java.util.Random;

import javax.swing.ImageIcon;

public class Competitor extends Thread {
	Bus bus;
	int waitDelay; // 竞争者的等待时延（后退时间）,单位为s
	int backCount = 0; // (回退次数)发生冲突的次数
	int delay; // 传输时间，单位为s

	public Competitor(int t, String s, Bus bus) {
		super(s);
		this.bus = bus;
		this.delay = t;
	}

	public void run() {
		while (this.backCount < 16 && Bus.busState != 0) {
			if (Bus.busState != 0) {
				this.backCount++;

				
				// 改变界面中的回退次数显示
				if (this.getName().equals("A")) 
				{
					CSMACDControl.jTextFieldABackCount.setText(this.backCount+"");
				}
			    else if(this.getName().equals("B"))
			    {   CSMACDControl.jTextFieldBBackCount.setText(this.backCount+"");
			    }
			    else
			    {   CSMACDControl.jTextFieldCBackCount.setText(this.backCount+"");
			    }
				
				
			}

			int n;// n用于计算后退时间
			Random ran = new Random();
			if (this.backCount <= 10)
				n = this.backCount;
			else
				n = 10;
			this.waitDelay = 2 * ran.nextInt((int) Math.pow(2, n)); // 基本退避时间（争用期）2t=2

			
			//改变界面中的回退时间显示
			if (this.getName().equals("A")) 
			{
				CSMACDControl.jTextFieldABackTime.setText(this.waitDelay+"");
			}
		    else if(this.getName().equals("B"))
		    {   CSMACDControl.jTextFieldBBackTime.setText(this.waitDelay+"");
		    }
		    else
		    {   CSMACDControl.jTextFieldCBackTime.setText(this.waitDelay+"");
		    }
			
			

			if (this.waitDelay == 0 && this.backCount != 0)
				continue;

			
			//非坚持CSMA/CD：若信道闲，则发送数据；若忙，则随机等待一段时间（即回退时间），重新监听（注意：等待过程中不监听）
			
			
			//由于竞争者进程是动态建立（不是初始化时候将所有竞争者进程建立起来）的，所以可能会出现这样的情况：主机A的退避时间比主机B的退避时间长，
             //但是主机A却比B先发送，因为主机A和主机B的退避时间起点不相同
			
			try {
				this.sleep(this.waitDelay * 1000);
			     } catch (InterruptedException e) {
					CSMACDControl.jProgressBar.setString("信道竞争异常！");
				 }
		   /* if (Bus.busState != 0) {
				continue;
			} else
			{   
				break;
			}*/
		}

		synchronized (bus) {
			Bus.busState = 1;
          			
			CSMACDControl.jProgressBar.setString("主机" + this.getName() + "占用信道");
			
			if (this.getName().equals("A")) 
			{
			  CSMACDControl.jLabelA.setVisible(true);
			  CSMACDControl.jButtonA.setIcon(new ImageIcon(getClass()
						.getClassLoader().getResource("sending.jpg")));
			}
		    else if(this.getName().equals("B"))
		    { CSMACDControl.jLabelB.setVisible(true);
		      CSMACDControl.jButtonB.setIcon(new ImageIcon(getClass()
					.getClassLoader().getResource("sending.jpg")));
		    }
		    else
		    { CSMACDControl.jLabelC.setVisible(true);
		      CSMACDControl.jButtonC.setIcon(new ImageIcon(getClass()
					.getClassLoader().getResource("sending.jpg")));
		    }
			
			CSMACDControl.jProgressBar.setMaximum(this.delay);
            
			try {
				for (int i = 0; i <= this.delay; i++) {
					this.sleep((Bus.busIFS + 1000));

					// 在此添加进度条的值
					// 添加闪电图标
					// NewJFrameCSMACDControl.setVisible(false);
						int j = CSMACDControl.jProgressBar.getValue();
						j++;
						CSMACDControl.jProgressBar.setValue(j);
					
				}
				CSMACDControl.jProgressBar.setValue(0);
				// 隐藏闪电图标

				Bus.usedTime += this.delay;
				Bus.busState = 0;			
				
				if (this.getName().equals("A")) 
				{
					CSMACDControl.jLabelA.setVisible(false);
					CSMACDControl.jButtonAControl.setEnabled(true);
					CSMACDControl.jTextFieldATranTime.setText("");
					CSMACDControl.jTextFieldABackCount.setText("");
					CSMACDControl.jTextFieldABackTime.setText("");
					CSMACDControl.jButtonA.setIcon(new ImageIcon(getClass()
							.getClassLoader().getResource("unworking.jpg")));
					
				}
			    else if(this.getName().equals("B"))
			    { 	CSMACDControl.jLabelB.setVisible(false);
			    CSMACDControl.jButtonBControl.setEnabled(true);
			    CSMACDControl.jTextFieldBTranTime.setText("");
				CSMACDControl.jTextFieldBBackCount.setText("");
				CSMACDControl.jTextFieldBBackTime.setText("");
				CSMACDControl.jButtonB.setIcon(new ImageIcon(getClass()
						.getClassLoader().getResource("unworking.jpg")));
			    }
			    else
			    {  CSMACDControl.jLabelC.setVisible(false);
			       CSMACDControl.jButtonCControl.setEnabled(true);
			       CSMACDControl.jTextFieldCTranTime.setText("");
				   CSMACDControl.jTextFieldCBackCount.setText("");
				   CSMACDControl.jTextFieldCBackTime.setText("");
				   CSMACDControl.jButtonC.setIcon(new ImageIcon(getClass()
						.getClassLoader().getResource("unworking.jpg")));
			    }
				
				
			} catch (InterruptedException e) {
				CSMACDControl.jProgressBar.setString("信道竞争异常！");
			} finally {
				Bus.busState = 0;

			}

		}

		if (this.backCount >= 16) {
			CSMACDControl.jProgressBar.setString("当前主机"+this.getName()+"不能使用信道！");
			this.backCount = 0;
		}

		// 将利用率用百分号表示出来
		int r = (new BigDecimal(Bus.getRate() * 1000).setScale(0,
				BigDecimal.ROUND_HALF_UP)).intValue();
		CSMACDControl.jProgressBar.setString("主机" + this.getName() + "释放信道,信道的利用率是：" + r / 10 + "." + r % 10 + "%");
		

	}
}

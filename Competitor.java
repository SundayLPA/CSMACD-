import java.math.BigDecimal;
import java.util.Random;

import javax.swing.ImageIcon;

public class Competitor extends Thread {
	Bus bus;
	int waitDelay; // �����ߵĵȴ�ʱ�ӣ�����ʱ�䣩,��λΪs
	int backCount = 0; // (���˴���)������ͻ�Ĵ���
	int delay; // ����ʱ�䣬��λΪs

	public Competitor(int t, String s, Bus bus) {
		super(s);
		this.bus = bus;
		this.delay = t;
	}

	public void run() {
		while (this.backCount < 16 && Bus.busState != 0) {
			if (Bus.busState != 0) {
				this.backCount++;

				
				// �ı�����еĻ��˴�����ʾ
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

			int n;// n���ڼ������ʱ��
			Random ran = new Random();
			if (this.backCount <= 10)
				n = this.backCount;
			else
				n = 10;
			this.waitDelay = 2 * ran.nextInt((int) Math.pow(2, n)); // �����˱�ʱ�䣨�����ڣ�2t=2

			
			//�ı�����еĻ���ʱ����ʾ
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

			
			//�Ǽ��CSMA/CD�����ŵ��У��������ݣ���æ��������ȴ�һ��ʱ�䣨������ʱ�䣩�����¼�����ע�⣺�ȴ������в�������
			
			
			//���ھ����߽����Ƕ�̬���������ǳ�ʼ��ʱ�����о����߽��̽����������ģ����Կ��ܻ�������������������A���˱�ʱ�������B���˱�ʱ�䳤��
             //��������Aȴ��B�ȷ��ͣ���Ϊ����A������B���˱�ʱ����㲻��ͬ
			
			try {
				this.sleep(this.waitDelay * 1000);
			     } catch (InterruptedException e) {
					CSMACDControl.jProgressBar.setString("�ŵ������쳣��");
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
          			
			CSMACDControl.jProgressBar.setString("����" + this.getName() + "ռ���ŵ�");
			
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

					// �ڴ���ӽ�������ֵ
					// �������ͼ��
					// NewJFrameCSMACDControl.setVisible(false);
						int j = CSMACDControl.jProgressBar.getValue();
						j++;
						CSMACDControl.jProgressBar.setValue(j);
					
				}
				CSMACDControl.jProgressBar.setValue(0);
				// ��������ͼ��

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
				CSMACDControl.jProgressBar.setString("�ŵ������쳣��");
			} finally {
				Bus.busState = 0;

			}

		}

		if (this.backCount >= 16) {
			CSMACDControl.jProgressBar.setString("��ǰ����"+this.getName()+"����ʹ���ŵ���");
			this.backCount = 0;
		}

		// ���������ðٷֺű�ʾ����
		int r = (new BigDecimal(Bus.getRate() * 1000).setScale(0,
				BigDecimal.ROUND_HALF_UP)).intValue();
		CSMACDControl.jProgressBar.setString("����" + this.getName() + "�ͷ��ŵ�,�ŵ����������ǣ�" + r / 10 + "." + r % 10 + "%");
		

	}
}

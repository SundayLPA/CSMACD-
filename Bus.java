
public class Bus {
	static int busIFS=100;       //�ŵ�֡�����������ߵȴ�ʱ��=�ŵ�֡����+����ʱ�䣩����λΪms
	                              //Ϊ�˼�㣬ֻ���������֡����
	static int busState=0;       //�ŵ�״̬��0Ϊ�ŵ����У�1Ϊ�ŵ�æ
	static double utilRate;      //�ŵ�������
	static double totalTime=0;  //��ʱ�䣬��λΪs.  totalTime=busNowTime-busTotalTime
	static double usedTime=0;   //�ŵ����ڷ�æ����ռ�õ�ʱ�䣩,��λΪs
  	static double busStartTime;  //��λΪs
    static	double busNowTime;    //��λΪs 

	
    public static double getRate()  //����ŵ�������
    {   getTotalTime();
    	return usedTime/totalTime;
    }
    
    public static void getTotalTime()
	 {   
	      Bus.busNowTime=new Double((System.nanoTime())/Math.pow(10, 9)).doubleValue();
	      Bus.totalTime=Bus.busNowTime-Bus.busStartTime;
	 }
}

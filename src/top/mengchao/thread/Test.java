package top.mengchao.thread;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Function;

public class Test {
	private ArrayList<String> listThirty = new ArrayList<String>();
	private ArrayList<String> listFive = new ArrayList<String>();
	private ArrayList<String> listThird = new ArrayList<String>();
	private HashMap<String,Thread> thm = new HashMap<String,Thread>();
	public static void main(String arg[]) {

	}
	
	public void reciveTask(String url) {
		
	}
	
	class Mytask extends TimerTask{
		private long delay = 30000;//30s
		private Timer timer = new Timer();
		private int count = 0;
		private String url = "";//ͨ�����캯�����ݲ���
		public Mytask (String url) {
			this.url = url;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("ִ������");
			boolean flag = true;
			if(flag) {//30s��һ��ִ�еĽ���ɹ�
				
				return;
			}else {
				if(count==30) {
					//����30�������Ȼû�гɹ����˳�ϵͳ������¼��־
					return;
				}
				if(delay==3000) {
					setTask(this,delay);
				}else if(delay==5000) {
					this.delay = 3000;
					setTask(this,delay);
				}else {
					this.delay = 5000;
					setTask(this,delay);
				}
				count++;
			}
		}
		public void setTask(Mytask mytask,long delay) {
			//Timer timer = new Timer();
			timer.cancel();
			timer.schedule(mytask, delay);
		}
	}
	
	
	
	
	
}

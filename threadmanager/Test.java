/**
 * Created by kevin on 2015/4/27.
 */
public class Test {

	ThreadPoolManager tpm = ThreadPoolManager.newInstance();

	public void sendMsg(String msg){
		tpm.addLogMsg(msg + "记录一条日志 ");
	}
	
	public void sendMsg2(String msg){
		tpm.addLogMsg(msg + "记录一条日志==2 ");
	}

	public static void main(String[] args){
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++){
					new Test().sendMsg(Integer.toString(i));
				}
			}
		}).start();
		
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++){
					new Test().sendMsg2(Integer.toString(i));
				}
			}
		}).start();
		
	}

}

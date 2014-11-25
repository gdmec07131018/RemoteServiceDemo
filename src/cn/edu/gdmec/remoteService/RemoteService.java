package cn.edu.gdmec.remoteService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import cn.edu.gdmec.remoteService.IMathService.Stub;


public class RemoteService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return mBinder;
	}
	IMathService.Stub mBinder = new Stub() {
		
		@Override
		public long Add(long a, long b) throws RemoteException {
			return a+b;
		}

		@Override
		public AllResult CompuerAny(long a, long b) throws RemoteException {
			long addResult = a +b;
			long subResult = a-b;
			long mulResult =a*b;
			double divResult = a/b;
			AllResult allResult = new AllResult(addResult,subResult,mulResult,divResult);
			return allResult;	
		}
	};
}

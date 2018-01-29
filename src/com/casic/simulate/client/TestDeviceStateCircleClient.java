package com.casic.simulate.client;

import java.util.Date;
import java.util.Random;

import com.casic.iot.client.DeviceStateClient;
import com.casic.iot.model.request.DeviceStateRequest;
import com.casicloud.mail.SendMail;

public class TestDeviceStateCircleClient {
	
	final static String url = "http://106.74.152.104:80/api/1.1/iot/device_state_acquire";
	final static String accesskey = "";
	final static DeviceStateClient client = new DeviceStateClient(url, accesskey);
	
	public static void main(String[] args) throws Exception{
		//设备id数组        740117_system账号下的设备
		String[] yxdeviceArr = new String[]{
				"10000049224865","10000049224894","10000049224923"
		};
		String[] djdeviceArr = new String[]{
				"10000050640315","10000050640317"
		};
		String[] gzdeviceArr = new String[]{
				"10000049224952","10000049224981"
		};
		
		
		while (true) {

			Long currentTime = new Date().getTime(); 
			DeviceStateRequest dsReq = new DeviceStateRequest();
			int yxcount = 0;
			int gzcount = 0;
			currentTime = new Date().getTime();
			dsReq.setIot("");
			//device01--运行--device02
			for(;yxcount<3;yxcount++){
				dsReq.addData(yxdeviceArr[yxcount], "1000", currentTime);
			}
			for(;gzcount<2;gzcount++){
				dsReq.addData(gzdeviceArr[gzcount], "3000", currentTime);
			}
			try{
				client.execute(dsReq);
			}catch(Exception e){
				e.printStackTrace();
				String message = "上传设备运行状态程序抛异常。异常原因为"+e.getMessage();
				SendMail.deliverMail(message);
				break;
			}
			

			try {
				Thread thread = Thread.currentThread();
				thread.sleep(60000);// 暂停1min后程序继续执行
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}

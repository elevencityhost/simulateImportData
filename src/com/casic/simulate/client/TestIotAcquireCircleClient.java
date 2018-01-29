package com.casic.simulate.client;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.casic.iot.client.IotAcquireClient;
import com.casic.iot.model.request.IotAcquireRequest;
import com.casicloud.mail.SendMail;

public class TestIotAcquireCircleClient {
	
	final static String url = "http://106.74.152.104:80/api/1.1/iot/data_acquire";
	//final static String url2 = "http://iotapi.casicloud.com/api/1.1/iot/device_state_acquire";
	final static String accesskey = "";			
	final static IotAcquireClient client = new IotAcquireClient(url, accesskey);
	//final static DeviceStateClient client2 = new DeviceStateClient(url2, accesskey);
	//static int  cnt1=0;

	public static void main(String[] args) throws Exception{
		int count = 1;
		while (true) {
			count=count+1;
	
			List<Map<String,Object>> list = getList();
			Float string = null;
			Float string1 = null;
			Float string2 =null;
			Float string3 =null;
			Float string4 =null;
			Integer string5 =null;
			{
				int g = new Random().nextInt(10);
				string = (Float) list.get(g).get("power");
				string1 = (Float) list.get(g).get("windSpeed");
				string2 = (Float) list.get(g).get("nac_direct");
				string3 = (Float) list.get(g).get("re_power");
				IotAcquireRequest req = new IotAcquireRequest();
				req.setIot("");
				
				//设备ID（需修改内容，与系统中设备ID对应）
				req.setEquipment("10000049224865");
				//req.addData("feed", ""+(float) (Math.random()*(75-50+1)+50), new Date().getTime());
				req.addData("power", ""+string, new Date().getTime())
				.addData("windSpeed", ""+string1, new Date().getTime())
				.addData("nac_direct", ""+string2, new Date().getTime())
				.addData("energy", ""+(100f+count), new Date().getTime())
				.addData("re_power", ""+string3, new Date().getTime())
				.addData("fault", ""+0, new Date().getTime());
				try{
					client.execute(req);
				}catch(Exception e){
					e.printStackTrace();
					String message = "上传采集点数据程序抛异常。异常原因为"+e.getMessage();
					SendMail.deliverMail(message);
					break;
				}
				
			}
			try {
				Thread thread = Thread.currentThread();
				thread.sleep(5 * 1000);// 暂停10s后程序继续执行
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return "TestIotAcquireCircleClient []";
	}
	

	public static List<Map<String,Object>> getList(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		list.add(getMap(124.313f,79.1997f,167.967f,-10f));
		list.add(getMap(149.724f,164.026f,228.783f,-20f));
		list.add(getMap(164.842f,16.754f,98.408f,-40f));
		list.add(getMap(10f,90.0117f,180.009f,-58f));
		list.add(getMap(107.079f,39.8615f,115.575f,-90f));
		list.add(getMap(124.391f,51.3095f,166.687f,-80f));
		list.add(getMap(143.3704f,114.969f,182.145f,-78f));
		list.add(getMap(115.6121f,56.4786f,166.162f,-50f));
		list.add(getMap(168.99f,173.814f,234.271f,-68f));
		list.add(getMap(140.9717f,71.7974f,159.721f,-67f));
		return list;
	}
	public static Map<String,Object> getMap(Float power,Float windSpeed,Float nac_direct,Float re_power){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("power", power);
		map.put("windSpeed", windSpeed);
		map.put("nac_direct", nac_direct);
		map.put("re_power", re_power);
		return map;
	}
}


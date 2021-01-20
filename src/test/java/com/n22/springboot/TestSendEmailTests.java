package com.n22.springboot;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.client.utils.HttpClientUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.n22.springboot.utils.HttpClientCoreUtil;



@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSendEmailTests {

	@Autowired
	private JavaMailSender jms;
	
	@Value("${spring.mail.username}")
	private String from;
	
	@Test
	public void test() throws Exception {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		while (true) {
			
			Date min = format.parse("2021-01-22 07:59:55");
			Date max = format.parse("2021-01-22 08:05:00");
			if(new Date().before(max) && new Date().after(min)) {
				

				String url = "https://m.hsyuntai.com/med/hp/hospitals/100582/registration/doctorDetails225?branchId=&docId=51645497&filtrate=N&outpatientId=1330916&schListType=true&type=0";
				int timeOut = 10000;
				String httpsGet = HttpClientCoreUtil.httpsGet(url, timeOut);
				
				JSONArray jsonArray = JSONObject.parseArray(httpsGet);
				
				
				for (Object object : jsonArray) {
					JSONObject jsonObject = JSONObject.parseObject(object.toString());
					if(jsonObject.getString("api_name") !=null && "/r/100582/60060/112".equals(jsonObject.getString("api_name"))) {
						JSONArray data = jsonObject.getJSONArray("data");
						if(data!=null && data.size()>0) {
							JSONObject object2 = (JSONObject) data.get(0);
							if(object2.getInteger("state")>0) {
								SimpleMailMessage message = new SimpleMailMessage();
								message.setFrom(from);
								message.setTo("guoshijievip@126.com"); //接收地址
								message.setSubject(object2.getInteger("state").toString()); // 标题
								message.setText(object2.getString("stateShown"));
								jms.send(message);
								System.out.println("有号了，快抢啊！");
								return;
							}else {
								System.out.println(object2.getInteger("state").toString()+"==="+object2.getString("stateShown"));
							}
						}
					}
				}
			}
			
			if(!new Date().before(max)) {
				System.out.println("超过时间范围内，结束程序...");
				return;
			}
		}
	}
}

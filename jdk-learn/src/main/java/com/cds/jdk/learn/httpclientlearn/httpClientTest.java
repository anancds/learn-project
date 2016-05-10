package com.cds.jdk.learn.httpclientlearn;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class httpClientTest {

    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test1() {
        CloseableHttpClient client = HttpClients.createDefault();

        URI uri = null;

        try {
            uri = new URIBuilder()
                    .setScheme("http")
                    .setHost("www.baidu.com")
//                    .setPath("/WebServices/MobileCodeWS.asmx/getDatabaseInfo")
                    .setParameter("", "")//这里可以设置多个参数
                    .setParameter("", "")
                    .setParameter("", "")
                    .setParameter("", "")
                    .build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        HttpGet get = new HttpGet(uri);

        try {
            CloseableHttpResponse response = client.execute(get);

            if (response.getStatusLine().getStatusCode() == 2000) {
                System.out.println(EntityUtils.toString(response.getEntity()));
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void test2(){

        CloseableHttpClient client = HttpClients.createDefault();

        HttpPost httppost = new HttpPost("www.baidu.com");

        //构建请求参数
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        list.add(new BasicNameValuePair("mobileCode", "110"));
        list.add(new BasicNameValuePair("userID", ""));

        //构建url加密实体，并以utf-8方式进行加密；
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, Consts.UTF_8);
        httppost.setEntity(entity);

        try {
            CloseableHttpResponse response = client.execute(httppost);

            if(response.getStatusLine().getStatusCode()==200){

                //org.apache.http.util.EntityUtils类可以快速处理服务器返回实体对象
                System.out.println(EntityUtils.toString(response.getEntity()));

            }
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

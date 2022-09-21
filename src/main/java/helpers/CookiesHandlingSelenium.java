package helpers;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CookiesHandlingSelenium {
    String url = "https://www.google.co.in/";
    String applicationurl = "";

    /*public void handleCookie() throws IOException, ExecutionException, InterruptedException {
        CookieStore cstore = new BasicCookieStore();
        //Create local Http Context
        HttpClientContext localContext = HttpClientContext.create();
        //Bind Custom Cookiestore to local context
        localContext.setCookieStore(cstore);
        HttpGet hget = new HttpGet(url);
        System.out.println("Executing request "+hget.getRequestLine());
        HttpClient httpclient = new HttpClient();
        Future<HttpResponse> future = (Future<HttpResponse>) httpclient.execute(hget, localContext,null);
        HttpResponse response = future.get();
        System.out.println("Response is "+response.getStatusLine());
        List<Cookie> cookieList = cstore.getCookies();
        for(int i=0;i<cookieList.size();i++){
            System.out.println("Local Cookies are "+cookieList.get(i));
        }
        //Below can be created in different class
        //First create a HttpPost object, create namevaluepair to store credentials in them, bind them with request
        HttpPost httpPost = new HttpPost(applicationurl);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("uname","Username"));
        params.add(new BasicNameValuePair("pwd","Password"));
        httpPost.setEntity(new UrlEncodedFormEntity(params));
        Future<HttpResponse> future = (Future<HttpResponse>) httpclient.execute(httpPost, localContext,null);
        HttpResponse response = future.get();
        cookieList = cstore.getCookies();
        //Now we have all cookies , add those to Selenium webdriver
        System.setProperty("webdriver.chrome.driver","drivers/chromdriver");
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.navigate().to(applicationurl);
        org.openqa.selenium.Cookie c;
        for(int i=0;i<cookieList.size();i++){
            System.out.println("Local Cookies are "+cookieList.get(i));
            c= new org.openqa.selenium.Cookie(cookieList.get(i).getName(),cookieList.get(i).getValue());
            chromeDriver.manage().addCookie(c);
            chromeDriver.navigate().to(applicationurl);
            //Now user will be logged in application without dealing with login page
        }
    }*/
    public static void main(String[] args){

    }
}

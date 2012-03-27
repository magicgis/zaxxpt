package com.xunruan.framekork.lang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/** *//**
 * 
 * @descripte use java.net.HttpURLConnection to request resource form web.
 * @author wenz 
 * @date 2011-12-27
 * @version 1.0
 */
public class TransactionCenter {
	private static final Log log = LogFactory.getLog(TransactionCenter.class);
    private URL url;
    private HttpURLConnection urlconn;

    String inencoding;
    String outencoding;
    
    /***
     * 
     * @param inencoding  input的编码格式(读出)
     * @param outencoding  output的编码格式 (输入)
     */
    public TransactionCenter(String inencoding, String outencoding) {
        this.inencoding = inencoding;
        this.outencoding = outencoding;
    }
    
    /***
     * 
     * @param params  
     * @param postUrl  url  如  http://www.baidu.com/s? bs=java+%B5%F7%D3%C3url&f=8&rsv_bp=1&wd=HttpURLConnection&n=2&inputT=1219
     * @return
     */
    public String connect(Object params, String postUrl) {
        BufferedReader br = null;
        String response = "", brLine = "";
        try {
            //params=URLEncoder.encode(params,"GB2312"); //use URLEncoder.encode for encode the params

            url = new URL(postUrl);
            urlconn = (HttpURLConnection) url.openConnection();
//          urlconn.setRequestProperty("user-agent","mozilla/4.7 [en] (win98; i)");    //set request header 
//          urlconn.setRequestProperty("X-Forwarded-For", "127.0.0.1");
            // 设定传送的内容类型是可序列化的java对象   12  
            // (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException)  
            urlconn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.10) Gecko/20100914 Firefox/3.6.10 ");
            urlconn.setRequestProperty("Content-type", "application/x-java-serialized-object"); 
            urlconn.setConnectTimeout(30000);
            urlconn.setReadTimeout(30000);
            urlconn.setRequestMethod("POST");     // request method, default GET
            // Post 请求不能使用缓存   
            urlconn.setUseCaches(false);  
            // 设置是否向urlconn输出，因为这个是post请求，参数要放在    
            // http正文内，因此需要设为true, 默认情况下是false;  
            urlconn.setDoOutput(true);   
            // 设置是否从urlconn读入，默认情况下是true;
            urlconn.setDoInput(true);    
            OutputStream outputStream = urlconn.getOutputStream();
            ObjectOutputStream out=new ObjectOutputStream(outputStream);
//            out.write(params==null?"".getBytes(outencoding):params.getBytes(outencoding));
            out.writeObject(params==null?"":params);
            out.flush();
            out.close();    // output stream close,That's means need not to post data to this outputstream
            InputStream inputStream= urlconn.getInputStream();
            br = new BufferedReader(new InputStreamReader(inputStream, inencoding));
            while((brLine = br.readLine())!=null)
                response =(new StringBuilder(String.valueOf(response))).append(brLine).toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(br != null) {
                    br.close();
                }
            } catch (IOException e) {
            	log.error("input stream close fail", e);
            }
            urlconn.disconnect();
        }
        return response;
    }
    
    
    
}

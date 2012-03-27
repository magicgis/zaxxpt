package com.xunruan.framekork.web.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import com.xunruan.framekork.lang.Application;
import com.xunruan.framekork.util.PropertiesUtils;


/***
 * 
 * @author wenz
 * @version 1.0
 * 2012-01-11 14:20
 *
 */
public class DownloadAction extends BaseAction {
	
	private static final Log log = LogFactory.getLog(DownloadAction.class);
	private static final char[] DEFAULT_CHAR={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private static final String DEFAULT_FILE_NAME="default.txt";
	private static final String DEFAULT_FILE_PATH="download/default.txt";
	private InputStream inputStream; 
	private String downLoadFileName;
	private String path;
	
    /***
     * 产生0~9的随机数，放在一个字符串里 
     * @author wenz
     * @param  生成数字长度
     * @return 随机数字字符串
     */
    public String createRandomInt(int length) { 
        String str = ""; 
        for (int i = 0; i < length; i++) { 
            str += Integer.toString((new Double(Math.random() * 10)).intValue()); 
        } 
        return str; 
    }
    
    /***
     * 产生0~9 a~z A~Z 的字符，放在一个字符串里 
     * @author wenz
     * @param  生成字符长度
     * @return 随机字符串
     */
    public String createRandomString(int length){
    	 String str = ""; 
    	 Random random = new Random();
         for (int i = 0; i < length; i++) { 
        	String c=String.valueOf(DEFAULT_CHAR[random.nextInt(DEFAULT_CHAR.length)]);
        	if(random.nextInt(2)==1)
        		c=c.toUpperCase();
        	str+=c;
         } 
         return str; 
    }
    
    
    /***
     * 随机产生一个颜色 
     * @return  Color对象
     */
    public Color createsRandomColor() { 
        int r = (new Double(Math.random() * 256)).intValue(); 
        int g = (new Double(Math.random() * 256)).intValue(); 
        int b = (new Double(Math.random() * 256)).intValue(); 
        return new Color(r, g, b); 
    } 
    
    
    /***
     * 生成一个内存图片，将字符串写在图片上 
     * @param str 要产生图片的字符串
     * @return  
     */
    public BufferedImage createImage(String str) { 
        int width = 60; 
        int height = 22; 
        // 生成随机类
        Random random = new Random();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
        // 获取图形上下文 
        Graphics g = image.getGraphics(); 
        // 设定背景色 
        g.setColor(Color.WHITE); 
        g.fillRect(0, 0, width, height); 
        //画边框 
        g.setColor(Color.black); 
        g.drawRect(0, 0, width - 1, height - 1); 
        // 将认证码显示到图象中 
        g.setFont(new Font("Atlantic Inline", Font.PLAIN, 18)); 
        //使用随机颜色 
        // 随机产生干扰线，使图象中的认证码不易被其它程序探测到
        g.setColor(this.createsRandomColor());
        for (int i = 0; i < 15; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
        // 取随机产生的认证码
        for (int i = 0; i < str.length(); i++) {
            // 将认证码显示到图象中
            g.setColor(this.createsRandomColor());
            g.drawString(Character.toString(str.charAt(i)), i*4+8*(i+1), 17);
        }
        // 图象生效 
        g.dispose(); 
        return image; 
    } 
    
    
    
    /***
     * 将图片的以字节形式写到InputStream里
     * @return
     * @throws Exception
     */
    public ByteArrayInputStream createInputStream() throws Exception { 
        //获取随机字符串 
        String str=this.createRandomString(4); 
        BufferedImage image = this.createImage(str); 
        //将产生的字符串写入session，供校验时使用 
        this.getSession().setAttribute("validateCode", str); 
        ByteArrayOutputStream output = new ByteArrayOutputStream(); 
        ImageOutputStream imageOut = ImageIO.createImageOutputStream(output); 
        ImageIO.write(image, "JPEG", imageOut); 
        imageOut.close(); 
        ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray()); 
        output.close(); 
        return input; 
    } 

    /***
     * 生成验证码
     * @return
     */
    public String image(){
    	try {
			this.setInputStream(createInputStream());
		} catch (Exception e) {
			log.error("", e);
			e.printStackTrace();
		}
    	return "image";
    }
    
    /***
     * 生成下载文件
     * @return
     */
	public String execute(){
		try {
			File file=null;
			if(null!=path){
				file=new File(path);
			}
			if(null==file||(null!=file&&!file.isFile()))
				file=new File(Application.get().getWebRoot()+""+DEFAULT_FILE_PATH);
			this.setInputStream(new FileInputStream(file));
		} catch (Exception e) {
			log.error("",e);
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}


	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}


	/***
	 * 提供转换编码后的供下载用的文件名 
	 */
	public String downLoadFileName() { 
		try { 
			if(downLoadFileName==null||"".equals(downLoadFileName)){
				File file=null;
				if(null!=path){
					file=new File(path);
					if(file.isFile())
						downLoadFileName=path.substring((path.lastIndexOf("\\")>0?path.lastIndexOf("\\"):path.lastIndexOf("/"))+1);
				}
				if(null==file||(null!=file&&!file.isFile()))
					downLoadFileName=DEFAULT_FILE_NAME;
			}
//			downLoadFileName = new String(downLoadFileName.getBytes("GBK"), "ISO-8859-1"); 
			downLoadFileName = URLEncoder.encode(downLoadFileName, "UTF-8"); 
		} catch (Exception e) { 
			e.printStackTrace(); 
		} 
		return downLoadFileName;
	}


	public String getDownLoadFileName() {
		return downLoadFileName();
	}


	public void setDownLoadFileName(String downLoadFileName) {
		this.downLoadFileName = downLoadFileName;
	}



	public void setPath(String path) {
		this.path = path;
	}
	
	
	public static void main(String[] args) {
////		String path="E:\\beijin\\apket\\log.log";
////		System.out.println(path.substring((path.lastIndexOf("\\")>0?path.lastIndexOf("\\"):path.lastIndexOf("/"))+1));
//		Random random = new Random();
//		for (int i = 0; i < 100; i++) {
//			System.out.println(random.nextInt(2));
//		}
////		String a="32fdfdsf";
////		System.out.println(a.toLowerCase());
////		System.out.println(a.toUpperCase());
		
		try {
			URL  url=new URL(PropertiesUtils.getVal("news.rss.url"));
			SyndFeedInput input=new SyndFeedInput();
			SyndFeed build = input.build(new XmlReader(url));
			System.out.println(build.getEntries());
		} catch (Exception e) {
			// TODO: handle exception
			log.error("", e);
		}
	}

	
	
}

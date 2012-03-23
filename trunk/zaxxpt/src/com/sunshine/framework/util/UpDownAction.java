package com.sunshine.framework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UpDownAction extends ActionSupport {
	
	private static final long serialVersionUID = -8590927808639585342L;

	// 提交方式
	private String method;

	// 上传接受依赖注入的属性
	private String filePath;
	
	// 文件流
	private File upload;


	
	// 上传文件备注
	private String uploadFileRemark;
	
	// 上传人
	private String uploadFileUserid;
	
	// 上传人
	private String uploadFileUsername;
	
	// 上传时间
	private String uploadFileDate = BeanUtils.getFormatDateTimeStr();
	
	// 上传文件类型
	private String uploadContentType;

	// 上传后物理文件
	private String uploadFile;
	
	// 上传后逻辑文件名
	private String uploadFileName;
	
	// 上传后逻辑文件扩展名
	private String uploadFileNameExt;
	
	// 上传后逻辑文件大小
	private String uploadFileNameSize;

	
	
	
	// 下载文件
	private String urlfilename;
	
	// 下载文件描述
	private String filename;
	
	
	
	/** 下载方法 **/
	public String getUrlfilename() {
		return urlfilename;
	}

	public void setUrlfilename(String urlfilename) {
		this.urlfilename = urlfilename;
	}

	public String getFilename() {
		
		/*try {
			filename = new String(filename.getBytes("iso-8859-1"), "gb2312");
		} catch (Exception e) { 
			e.printStackTrace(); 
		}*/
		
		BeanUtils.toUtf8String(filename);
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public InputStream getInputStream() throws Exception {
		InputStream is = null;
		if (BeanUtils.isNotEmpty(getUrlfilename())) {
			String downFile = filePath+"/"+getUrlfilename();
			is = ServletActionContext.getServletContext().getResourceAsStream(downFile);
		}
		return is;
	}
	
	/** 上传方法 **/
	public void setFilePath(String value) {
		this.filePath = value;
	}
	
	public String getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	private String getFilePath() throws Exception {
		return ServletActionContext.getRequest().getRealPath(filePath);
	}
	
	public void setUpload(File upload) {
		this.upload = upload;
	}

	public File getUpload() {
		return (this.upload);
	}
	
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return (this.uploadContentType);
	}

	public String getUploadFileName() {
		return (this.uploadFileName);
	}
	
	public String getUploadFileNameExt() {
		return uploadFileNameExt;
	}

	public void setUploadFileNameExt(String uploadFileNameExt) {
		this.uploadFileNameExt = uploadFileNameExt;
	}

	public String getUploadFileNameSize() {
		return uploadFileNameSize;
	}

	public void setUploadFileNameSize(String uploadFileNameSize) {
		this.uploadFileNameSize = uploadFileNameSize;
	}
	
	// 以服务器的文件保存地址和原文件名建立上传文件输出流
	public String execute() {
		try {
			if (getMethod() !=  null) {
				if (getMethod().equals("upload")) {
					
					setUploadFile(BeanUtils.replaceStr(this.getUploadFileName(), ".", ","));
					String[] f = getUploadFile().split(",");
					
					// 设置逻辑文件名
					String o = "";
					for (int i = 0; i < f.length -1; i ++)
						o += f[i];
					setUploadFileName(o);
					
					// 设置逻辑文件扩展名
					setUploadFileNameExt(f[f.length-1]);
					
					// 设备物理名
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
					Date d = new Date();
					setUploadFile(simpleDateFormat.format(d)+"."+f[f.length-1]);
					
					FileOutputStream fos = new FileOutputStream(getFilePath() + "/" + getUploadFile());
					FileInputStream fis = new FileInputStream(getUpload());
					byte[] buffer = new byte[1024];
					int len = 0;
					while ((len = fis.read(buffer)) > 0) 
						fos.write(buffer, 0, len);
					
					setUploadFileNameSize(BeanUtils.getRound(((double)getUpload().length()/1024/1024), 2, BigDecimal.ROUND_CEILING)+" MB");
		
					setMethod("success");
				} else if (getMethod().equals("download")) {
					return "download";
				}
			}
		} catch(Exception e) {
			SysLogger.error("UpDownAction.class Error!", e);
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String getUploadFileDate() {
		return uploadFileDate;
	}

	public void setUploadFileDate(String uploadFileDate) {
		this.uploadFileDate = uploadFileDate;
	}

	public String getUploadFileRemark() {
		return uploadFileRemark;
	}

	public void setUploadFileRemark(String uploadFileRemark) {
		this.uploadFileRemark = uploadFileRemark;
	}

	public String getUploadFileUserid() {
		return uploadFileUserid;
	}

	public void setUploadFileUserid(String uploadFileUserid) {
		this.uploadFileUserid = uploadFileUserid;
	}

	public String getUploadFileUsername() {
		return uploadFileUsername;
	}

	public void setUploadFileUsername(String uploadFileUsername) {
		this.uploadFileUsername = uploadFileUsername;
	}

}

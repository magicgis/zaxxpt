package com.xunruan.site.web.basic;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

import com.opensymphony.xwork2.config.Configuration;
import com.opensymphony.xwork2.config.impl.DefaultConfiguration;
import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import com.xunruan.framekork.dao.IBaseDao;
import com.xunruan.framekork.dao.sql.SQLProperties;
import com.xunruan.framekork.dao.sql.SQLTitle;
import com.xunruan.framekork.dao.sql.TablePropertiest;
import com.xunruan.framekork.lang.Application;
import com.xunruan.framekork.lang.PageInfo;
import com.xunruan.framekork.util.PropertiesUtils;
import com.xunruan.framekork.util.StringUtil;
import com.xunruan.framekork.web.action.BaseAction;
import com.xunruan.site.domain.Produce;
import com.xunruan.site.domain.RealInfo;

/***
 * 2012-02-08
 * @author wenz
 * @version 1.0
 */
public class IndexPageAction extends BaseAction{

	private static final Log log = LogFactory.getLog(IndexPageAction.class);
	@Resource
	private IBaseDao<RealInfo> realInfoDao;
	@Resource
	private IBaseDao<Produce>  produceDao;
	private PageInfo<RealInfo> pageCompany;  //公司动态
	private PageInfo<Produce> pageProduct;  //产品介绍
	private List<SyndEntry> syndList;
	
	
	public String execute(){
		
		pageCompany=new PageInfo<RealInfo>();
		pageCompany.setRowsOfPage(6);
		this.setPageCompany(this.getCompany( pageCompany));
		pageProduct=new PageInfo<Produce>();
		pageProduct.setRowsOfPage(6);
		this.setPageProduct(this.getProduct(pageProduct));
		List<SyndEntry> rssList=getRSS();
		if(null!=rssList&&rssList.size()>6){
			this.setSyndList(getRssImageAndAouth(rssList.subList(0, 6)));
		}
		return SUCCESS;
	}

	
	/***
	 * 获取产品介绍信息
	 * @param pageCompany  分页信息
	 * @param map   动态参数
	 * @return
	 */
	public PageInfo<RealInfo>  getCompany(PageInfo<RealInfo> pageCompanys){
//		TablePropertiest table=new TablePropertiest();
//		table.setAlias(SQLTitle.DOMAIN1);
//		table.setClasss(RealInfo.class);
//		SQLProperties type=new SQLProperties();
//		type.setTable(table);
//		type.setColumn("type");
//		type.setStartLink(SQLTitle.AND);
//		type.setOperation(SQLTitle.EQ);
//		type.setKey(":type");
		Map<String,Object> map =new HashMap<String, Object>();
		map.put("type", 1);map.put("sts", 1);
		String hql=" from com.xunruan.site.domain.RealInfo as model where model.type=:type and model.sts=:sts order by model.createTime desc";
		pageCompanys=realInfoDao.findByHql(pageCompanys, hql,map);
		return pageCompanys;
	}
	
	
	/***
	 * 获取产品介绍信息
	 * @param hql 查询语句
	 * @param pageCompany  分页信息
	 * @param map   动态参数
	 * @return
	 */
	public PageInfo<Produce>  getProduct(PageInfo<Produce> pageProducts){
		Map<String,Object> map =new HashMap<String, Object>();
		map.put("sts", 1);
		String hql=" from com.xunruan.site.domain.Produce as model where  model.sts=:sts order by model.createTime desc";
		pageProducts=produceDao.findByHql(pageProducts, hql,map);
		return pageProducts;
	}
	
	/***
	 * 获取RSS信息
	 * @return 返回RSS信息
	 */
	private List<SyndEntry> getRSS(){
		List<SyndEntry> list=null;
		try {
			URL  url=new URL(PropertiesUtils.getVal("news.rss.url"));
			SyndFeedInput input=new SyndFeedInput();
			SyndFeed build = input.build(new XmlReader(url));
			if(null==build){
				int count=Integer.valueOf(PropertiesUtils.getVal("news.rss.count"));
				for (int i = 0; i < count; i++) {
					list=build.getEntries();
					if(null!=list)
						break;
				}
			}else{
				list=build.getEntries();
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.error("", e);
		}
		return list;
	}
	
	private List<SyndEntry>   getRssImageAndAouth(List<SyndEntry> sourceSyndList){
		for (int i = 0; i < sourceSyndList.size(); i++) {
			sourceSyndList.get(i).setUri(StringUtil.getHtmlImgPath(sourceSyndList.get(i).getDescription().getValue()));
			sourceSyndList.get(i).setAuthor(sourceSyndList.get(i).getTitle().substring(sourceSyndList.get(i).getTitle().indexOf("-")+1));
			sourceSyndList.get(i).setTitle(sourceSyndList.get(i).getTitle().substring(0, sourceSyndList.get(i).getTitle().indexOf("-")));
		}
		return sourceSyndList;
	}
	public IBaseDao<RealInfo> getRealInfoDao() {
		return realInfoDao;
	}

	public void setRealInfoDao(IBaseDao<RealInfo> realInfoDao) {
		this.realInfoDao = realInfoDao;
	}

	public PageInfo<RealInfo> getPageCompany() {
		return pageCompany;
	}

	public void setPageCompany(PageInfo<RealInfo> pageCompany) {
		this.pageCompany = pageCompany;
	}


	public PageInfo<Produce> getPageProduct() {
		return pageProduct;
	}

	public void setPageProduct(PageInfo<Produce> pageProduct) {
		this.pageProduct = pageProduct;
	}

	public List<SyndEntry> getSyndList() {
		return syndList;
	}

	public void setSyndList(List<SyndEntry> syndList) {
		this.syndList = syndList;
	}
	
	
	
}

package com.system.log.service;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.sunshine.framework.context.ConfigConstant;
import com.sunshine.framework.entity.DataException;
import com.sunshine.framework.service.BaseService;
import com.sunshine.framework.util.SysLogger;
import com.system.log.entity.LogEntity;

public class LogService extends BaseService {
	/**
	 * 记录操作日志
	 * @param menuid
	 * @param itemnoid
	 * @param type
	 * @param userid
	 * @param ip
	 * @throws DataException
	 */
	public void save(String menuid, String itemnoid, String type, String userid, String ip) {
		if (ConfigConstant.databaseLogs) {
			try {
				LogEntity log=new LogEntity();
				log.setMenuid(menuid);
				log.setUserid(userid);
				log.setIp(ip);
				log.setItemnoid(itemnoid);
				log.setType(type);
				SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String datetime=dateFormat.format(new Date());
				log.setDatetime(datetime);
				this.insert(log);
			} catch(Exception e) {
				SysLogger.error("记录操作日志失败!",e);
			}			
		}
	}
	
}

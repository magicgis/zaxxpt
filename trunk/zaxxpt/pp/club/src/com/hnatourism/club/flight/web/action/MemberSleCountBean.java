package com.hnatourism.club.flight.web.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hnatourism.club.common.Constants;
import com.hnatourism.framework.spring.SpringBeanUtil;
import com.hnatourism.framework.utils.BeanUtils;
import com.hnatourism.framework.core.daosupport.JdbcDaoSupport;
import com.hnatourism.framework.core.daosupport.jdbc.support.JdbcDAOSupport;
public class MemberSleCountBean {
	
//	private JdbcDAOSupport jdbcDAOSupport;
//	
//	public JdbcDAOSupport getJdbcDAOSupport() {
//		return jdbcDAOSupport;
//	}
//
//	public void setJdbcDAOSupport(JdbcDAOSupport jdbcDAOSupport) {
//		this.jdbcDAOSupport = jdbcDAOSupport;
//	}

	public String findMemberSleCount(String memberId){
		try {
			List values = null;
			JdbcDAOSupport jdbcDAOSupport =(JdbcDAOSupport)BeanUtils.getBeanObj("jdbcDAOSupport");
			
			String sql = "select count(*) count from booking_flight" + Constants.LINK_NAME; 
			if (!StringUtils.isEmpty(memberId)) {
				sql = sql + " b join(select id from order_flight"+ Constants.LINK_NAME + " o where o.member_id = ?) a";
				sql = sql + " on b.order_id = a.id where b.origin = 'SZ' and b.pnr_cancle_sts = '0'";
				values = new ArrayList();
				values.add(memberId);
			} else {
				values = null;
			}
			List<Map> list = jdbcDAOSupport.findMaps(sql, values);
			return String.valueOf((BigDecimal)list.get(0).get("count"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
}

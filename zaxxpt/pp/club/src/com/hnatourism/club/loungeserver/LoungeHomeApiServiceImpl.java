package com.hnatourism.club.loungeserver;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.hnatourism.club.flight.web.vo.FlightAirport;
import com.hnatourism.club.golf.api.ParameterHandler;
import com.hnatourism.club.lounge.prod.dao.IFlightAirlineComDao;
import com.hnatourism.club.lounge.prod.dao.IFlightAirportDao;
import com.hnatourism.club.lounge.prod.dao.ILoungeInfoDao;
import com.hnatourism.club.lounge.prod.dao.ILoungePriceDao;
import com.hnatourism.club.lounge.prod.dao.ILoungeRoomDao;
import com.hnatourism.club.lounge.prod.domain.LoungeInfo;
import com.hnatourism.club.lounge.prod.domain.LoungePrice;
import com.hnatourism.club.lounge.prod.domain.LoungeRoom;
import com.hnatourism.club.lounge.prod.vo.FilghtAirportVo;
import com.hnatourism.club.lounge.prod.vo.LoungeInfoVo;
import com.hnatourism.club.lounge.prod.vo.LoungePriceVo;
import com.hnatourism.club.lounge.prod.vo.LoungeRoomVo;

public class LoungeHomeApiServiceImpl extends LoungeApiService implements
IloungeHomeApiService {

	private ILoungeInfoDao loungeInfoDao;
	private ILoungeRoomDao loungeRoomDao;
	private ILoungePriceDao loungePriceDao;
	private IFlightAirportDao flightAirportDao;
	private IFlightAirlineComDao flightAirlineComDao;
	
	
	@Override
	public void endHandler() {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * 2011-08-15 v1.1.0 (高杰) :
	 */
	public void execute()
	{
		List<LoungeRoomVo> result=new ArrayList<LoungeRoomVo>();
		
		List<LoungeRoom> roomlist_temp=loungeRoomDao.findByComm();
		Iterator<LoungeRoom> roomlist_i=roomlist_temp.iterator();
		while(roomlist_i.hasNext())
		{
			LoungeRoomVo room=new LoungeRoomVo();
			BeanUtils.copyProperties(roomlist_i.next(), room);
			
			//休息室
			LoungeInfo lounge_temp=loungeInfoDao.findById(room.getLoungeId());
			LoungeInfoVo lounge=null;
			if(lounge_temp!=null)
			{	
				lounge=new LoungeInfoVo();
				BeanUtils.copyProperties(lounge_temp, lounge);
			}
			
			//价格
			LoungePrice price_comditio=new LoungePrice();
			price_comditio.setRoomId(room.getId());
			
			LoungePriceVo min_price=new LoungePriceVo();
			List<LoungePrice> pricemin=loungePriceDao.findByRoomMin(price_comditio);
			if(pricemin!=null&&pricemin.size()>0)
			{
				BeanUtils.copyProperties(loungePriceDao.findByRoomMin(price_comditio).get(0), min_price);
			}
			
			//机场
			//机场
			if(lounge!=null){
				FilghtAirportVo airport=new FilghtAirportVo();
				List<FlightAirport> airportlist=(List<FlightAirport>)flightAirportDao.findByCode(lounge.getAirportCode());
				if(airportlist!=null&&airportlist.size()>0)
				{
					BeanUtils.copyProperties(airportlist.get(0), airport);
				}
				lounge.setAirport(airport);
			}
			room.setLoungePriceVo(min_price);
			room.setLounge(lounge);
			//确保数据完整性
			if(room.getLounge()!=null&&room.getLounge().getAirport()!=null){
				result.add(room);
			}
		}
		
		super.returnObj=result;
	}

	@Override
	public void init(Object permeters, Type type) {
		// TODO Auto-generated method stub
		super.permeters=permeters;
		super.type=type;
	}

	@Override
	public void parameterHandler() throws Exception {
		// TODO Auto-generated method stub
		//对象初始化
		LoungeInfoVo loungeInfoVo=new LoungeInfoVo();
		LoungeInfo  loungeInfo=new LoungeInfo();
		//参数转换
		//if(super.permeters==null || "".equals(String.valueOf(super.permeters))){
			//loungeInfo=null;
		//}else{
			if(super.type==String.class){
				loungeInfoVo=(LoungeInfoVo) ParameterHandler.urlPremeter2Object(String.valueOf(super.permeters),LoungeInfoVo.class);
			}else{
				loungeInfoVo=(LoungeInfoVo)super.permeters;
			}
		//}
		BeanUtils.copyProperties(loungeInfoVo, loungeInfo);
		super.permeters=loungeInfo;
	}

	@Override
	public Object getResult() {
		// TODO Auto-generated method stub
		return super.returnObj;
	}

	public ILoungeInfoDao getLoungeInfoDao() {
		return loungeInfoDao;
	}

	public void setLoungeInfoDao(ILoungeInfoDao loungeInfoDao) {
		this.loungeInfoDao = loungeInfoDao;
	}

	public ILoungeRoomDao getLoungeRoomDao() {
		return loungeRoomDao;
	}

	public void setLoungeRoomDao(ILoungeRoomDao loungeRoomDao) {
		this.loungeRoomDao = loungeRoomDao;
	}

	public ILoungePriceDao getLoungePriceDao() {
		return loungePriceDao;
	}

	public void setLoungePriceDao(ILoungePriceDao loungePriceDao) {
		this.loungePriceDao = loungePriceDao;
	}

	public IFlightAirportDao getFlightAirportDao() {
		return flightAirportDao;
	}

	public void setFlightAirportDao(IFlightAirportDao flightAirportDao) {
		this.flightAirportDao = flightAirportDao;
	}

	public IFlightAirlineComDao getFlightAirlineComDao() {
		return flightAirlineComDao;
	}

	public void setFlightAirlineComDao(IFlightAirlineComDao flightAirlineComDao) {
		this.flightAirlineComDao = flightAirlineComDao;
	}

	
}

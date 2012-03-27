package com.hnatourism.club.hotel.prod.web.newapivo;

/**
 * 项目名称:海航旅业B2C系统系统
 * 
 * 功能描述:新版酒店接口酒店详情json返回数据结构
 * {
    "result": {
        "resultCode": "",
        "message": "" ,
} ,
"resultBean":{
"maptype":"G",
    "citycode": "100000001634",
    "cityname": "北京",
    "idate": "2010-12-28",
"odate": "2010-12-29",
    "hotel": {
            "code": "0000129957",
            "name": "北京国际航空俱乐部",
"addr": "北京市朝阳区机场辅路200号",
"phone":"010-64598822",
“signin”:””,//签到人数
“hdesc”:” 北京国际航空俱乐部，客房设计清新高雅，内部设施齐全。另外，酒店还拥有设备良好的娱乐中心、游泳馆和网球场等辅助设施。酒店清新幽雅的绿化环境、风格迥异的居住场所和先进安全的设施设备为您的到来提供了多样化的选择，无论您是久居还是小憩都会得到如家般的享受！”
“sellpoint”:” 酒店距首都机场8公里，距新国展6公里，交通方便”
“traffic”:” 位于机场辅路中段南侧，交通极为便利。
- 距离北京西站34公里，乘坐出租车约40-50分钟；- 距离天安门广场25公里，乘坐出租车约35分钟；
- 距离北京站23公里，乘坐出租车约30分钟；- 距离首都国际机场9公里，乘坐出租车约15分钟；
- 距离新国展6公里，乘坐出租车约13分钟。”
" origin": "HBE",
"longitude ":"116.506205",
"latitude ":" 40.007595",
            "ecoarea": "010101",
            "govarea": "0003",
    			"star": "4",
            "price": "1234",
“pics”:[
{	
“name”:” 外围”,
“path”:” http://localhost:8080/B2C/com/hnatourism/hbe/houseinfo/service/impl/0000139453_酒店大楼.jpg”,
“size”:”min”
},
{
“name”:”大楼”
“path”:” \com\hnatourism\hbe\houseinfo\service\impl\0000139453_酒店大楼.jpg”,
“size”:”max”
},
]

“details”:{
” hotelEquip”:” 商务中心、停车场、送餐服务、洗衣服务、叫醒服务、礼宾司服务、旅游服务、擦鞋服务、外币兑换、医疗支持、儿童看护、前台贵重物品保险柜、大巴或轿车租赁服务、接机服务、美容美发”,
”roomEquip ”:” 中央空调、免费卫生间清洁备品、小冰箱、房内保险柜、残障人房间”
,
”dinner ”:” 酒吧：24酒吧服务，提供咖啡，饮料，啤酒，洋酒等。
室内餐厅：提供中西式自助早餐（6：30－10：00）及24小时简餐。”
,
” entertainment”:” 棋牌麻将、篮球、网球、台球、羽毛球、运动场、健身、游泳池、钓鱼、滑冰、洗浴桑拿中心”
,
”conference”:” 酒店设有可容纳25人、45人、60人、150人、218人不等的会议室”
,
]
        }}
}
 * 
 * 历史版本: 2011-11-14 v1.0.0 (lixun) 创建
 * 
 */
public class HotelDetailsResultVo extends HotelResultVo{
	
	private HotelDetailInfoVo resultBean;


	public HotelDetailInfoVo getResultBean() {
		return resultBean;
	}

	public void setResultBean(HotelDetailInfoVo resultBean) {
		this.resultBean = resultBean;
	}
	
	
}

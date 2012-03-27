<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/include/tags-lib.jsp"%>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
<script type="text/javascript" src="${ctx}/js/jquery/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="${ctx}/js/map/mapTools.js"></script>
<style type="text/css"> 
  html { height: 100% }
  body { height: 100%; margin: 0px; padding: 0px }
  #map_canvas {height: 100%;width: 100%}
</style>
<title>v3</title>
<% 
String address=request.getParameter("address");
String latitude=request.getParameter("latitude"); 
String longitude=request.getParameter("longitude"); 
String hotelName=request.getParameter("hotelName"); 
%>
<script type="text/javascript">
var address,latitude,longitude,hotelName;

  function initMap() {
   	address='<%=address%>';
	latitude='<%=latitude%>';
	longitude='<%=longitude%>';
	hotelName='<%=hotelName%>';
    var myLatlng = new google.maps.LatLng(latitude, longitude);
    //var myLatlng = new google.maps.LatLng(39.905667, 116.409198);
    createMap(12,myLatlng);
    var contentString = "<div>"+address+"</div>";
    //var contentString1 = "<div>bbbb</div>";
    addMarker(myLatlng,addInfowindow(contentString)); 
   // addMarker(myLatlng1,addInfowindow(contentString1)); 
  }
  $(document).ready(function(){ 
        //loadScript();
    });
</script>
</head>
<div id="map_canvas"></div>

<!--http://code.google.com/intl/zh-CN/apis/maps/documentation/javascript/basics.html-->
	 
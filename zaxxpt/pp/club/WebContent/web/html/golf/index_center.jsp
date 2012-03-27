<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <div class="jc_left">
                <div class="jdtj_img1">
                <ul>
                	<s:iterator value="golflist_image" var="golfInfoVo" status="status">
                	<s:if test="#status.index<4">
                        <li>
                        	<span>
                        		<img src="<s:property value="serverPath"/>/<s:property value="#golfInfoVo.golfimage.path" escape="false"/>" />
                        	</span>
                        	<a href="view.jsp?id=<s:property value="#golfInfoVo.id"/>" target="blank">
                        		<s:property escape="false" value="#golfInfoVo.name"/>
                        	</a>
                        </li>
                    </s:if>
                    </s:iterator>
                </ul>
            </div>
                <ul class="float_li">
                <li><img src="${ctx}/web/images/bj_left.jpg" /></li>
                <li class="jc_tagbj">
                
                    <div class="tag_right">
                        <ul>
                        	<s:iterator value="citylist" status="status">
                        		<s:if test="#status.index<9">
	                        		<s:if test="#status.index==0">
	                        			<li class="jc_tag1 last">
	                        		</s:if>
	                        		<s:else>
	                                	<li class="jc_tag1">
	                        		</s:else>
	                        		<s:if test="#status.index==3">
	                        			<a href="javascript:void(0);" class="jc_ta1" id="navjd<s:property value="citylist.size-#status.index"/>">
	                        		</s:if>
	                        		<s:else>
	                        			<a href="javascript:void(0);" class="jc_ta2" id="navjd<s:property value="citylist.size-#status.index"/>">
	                        		</s:else>
	                        		<s:property escape="false" value="pcName"/></a></li>
                        		</s:if>
                            </s:iterator>
                            <li class="jc_img"><img src="${ctx}/web/images/title6.jpg" /></li>
                        </ul>
                    </div>
                </li>
                <li><img src="${ctx}/web/images/bj_right.jpg" /></li>
            </ul>
                <div class="clear"></div>
                <div class="tag_right_boz">
                <s:iterator value="citylist" status="status" var="city">
                	<s:if test="#status.last">
                		<div class="golf_recommend" id="searjd<s:property value="#status.index+1"/>" style="display:block;">
                	</s:if>
                	<s:else>
                		<div class="golf_recommend" id="searjd<s:property value="#status.index+1"/>" style="display:none;">
                	</s:else>
                	<s:iterator value="#city.golflist_result" var="golf" status="gs">
                		<s:if test="#gs.index==0">
                			<ul>
                			<s:iterator value="#golf" var="onegolf" status="item">
                				<li>
									<a href="view.jsp?id=<s:property value="#onegolf.id"/>" target="blank">
										<span class="name"><s:property escape="false" value="#onegolf.name"/></span>
										<span>最低价:¥
											<s:if test='#onegolf.golfsitelist.size>0'>
												<s:if test="#onegolf.golfsitelist[0].type==1">
													<s:property value="#onegolf.minPrice.price"/>/球
												</s:if>
												<s:else>
													<s:if test="#onegolf.minPrice.price<#onegolf.minHPrice.price">
														<s:property value="#onegolf.minPrice.price"/>
													</s:if>
													<s:else>
														<s:property value="#onegolf.minHPrice.price"/>
													</s:else>/人
												</s:else>
											</s:if>
										</span>
									</a>
								</li>
                			</s:iterator>
                			</ul>
	                	</s:if>
	                	<s:else>
	                		<ul class="noBG">
                			<s:iterator value="#golf" var="onegolf" status="item">
                				<li>
									<a href="view.jsp?id=<s:property value="#onegolf.id"/>" target="blank">
										<span class="name"><s:property escape="false" value="#onegolf.name"/></span>
										<span>最低价:¥
											<s:if test='#onegolf.golfsitelist.size>1'>
												<s:if test="#onegolf.minPrice.price<#onegolf.minHPrice.price">
													<s:property value="#onegolf.minPrice.price"/>
												</s:if>
												<s:else>
													<s:property value="#onegolf.minHPrice.price"/>
												</s:else>/人
											</s:if>
											<s:else>
												<s:property value="#onegolf.minPrice.price"/>/球
											</s:else>
										</span>
									</a>
								</li>
                			</s:iterator>
                			</ul>
	                	</s:else>
                	</s:iterator>
                	</div>
                </s:iterator>
                
            </div>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>详情</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/bootstrap.min.css"/>
	<style type="text/css">
	        body{	color: #000;
				    background: #D2D8DE;
				    font-family: Verdana,Arial,Helvetica,sans-serif;
				    font-size: 14px;
				    min-height: 101%;}
			.article_list{background: #FFFFFF;margin-bottom: 10px;}
			.bottom_element{margin-bottom: 5px;}
			header {
			        height: 70px;
				    background: none repeat scroll 0% 0% rgba(213, 100, 100, 1);
				    clear: both;
			}
			.navigator{
				    background-color: black;
				    overflow: hidden;
				    clear: both;
			}
			section{margin-top: 10px;}
			.day {
				min-height: 10px;
				_height: 10px;
				background: #fff;
			    border-radius: 7px;
			    box-shadow: 1px 1px 2px #A7A8AD;
			    color: #666666;
			    margin: 0 5px 20px 0;
			    padding:5px 20px 10px;
			}
			.center_ele{margin-bottom: 30px;}
			.footer{ border-top-width:1px;
					 border-top-style:solid;
					 border-top-color:#000;
					 height:50px;   
					 line-height:50px;   
					 overflow:hidden;
					 text-align:center;   
				}
	</style>
</head>
<body>
	<!-- å¤´é¨  -->
	<header class="container-fluid">
 		<div class="row">
		  	<div class="col-md-10">
		  		<div class="">
					
		  		</div>
		  	</div>
		  	<div class="col-md-2">
		 
		  	</div>
		</div>  	
	</header>

	<div class="container-fluid">
 		<div class="row">
		  	<div class="col-md-12 navigator">
		  		<ul class="nav nav-pills">
				  <li role="presentation" class="active"><a href="#">Home</a></li>
				  <li role="presentation"><a href="#">Profile</a></li>
				  <li role="presentation"><a href="#">Messages</a></li>
				</ul>
		  	</div>
		</div>
	</div>


	<section class="container-fluid">
	  <div class="row center_ele">
	  	<div class="col-md-10">
	  	</div>
	  	<div class="col-md-2">
 		<!-- 	<div class="input-group">
				<input type="text" class="form-control" placeholder="ä½èãæ é¢ãåå®¹">
				<span class="input-group-btn">
					<button class="btn btn-default" type="button">æç´¢</button>
				</span>
			</div>/input-group -->
	  	</div>
	  </div>
      <div class="row">
		  <div class="col-md-2">
		  		<div>
					<div class="btn-group btn-group-justified bottom_element" >
				      <a href="#" class="btn btn-default" role="button">Left</a>
				    </div>
				    <div class="btn-group btn-group-justified bottom_element" >
				      <a href="#" class="btn btn-default" role="button">Left</a>
				    </div>
				    <div class="btn-group btn-group-justified bottom_element" >
				      <a href="#" class="btn btn-default" role="button">Left</a>
				    </div>
				    <div class="btn-group btn-group-justified bottom_element" >
				      <a href="#" class="btn btn-default" role="button">Left</a>
				    </div>
				    <div class="btn-group btn-group-justified bottom_element" >
				      <a href="#" class="btn btn-default" role="button">Left</a>
				    </div>
				    <div class="btn-group btn-group-justified bottom_element" >
				      <a href="#" class="btn btn-default" role="button">Left</a>
				    </div>
			    </div>
		  </div>
		  <div class="col-md-10">
  		  		<div class="day">
					 <div>
						<h3>${deta.name}</h3>
						<div><label>作者:${deta.dischargeStandard}</label><label>发布时间:${data.updateTime}</label><label>阅读:${data.seatNumber}</label></div>
					</div>
					<div>  ${deta.shortName}
					
					
					
					
					   </div>
		  		</div>
		  </div>
		</div>
	</section>
	<div class="container-fluid">
		<div class="row">
			 <div class="col-md-12 footer">
				<div class="">
					Copyright ©2018 小禾点点
				</div>
			 </div>	
		</div>
	</div>
 <script type="text/javascript" src="<%=basePath %>js/jquery-3.2.1.min.js"></script>
 <script type="text/javascript"  src="<%=basePath %>js/bootstrap.min.js"></script>
</body>
</html>
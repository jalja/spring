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
	<meta HTTP-EQUIV="pragma" CONTENT="no-cache">      
	<meta HTTP-EQUIV="Cache-Control" CONTENT="no-store, must-revalidate">      
	<meta HTTP-EQUIV="expires" CONTENT="Wed, 26 Feb 1997 08:21:57 GMT">      
	<meta HTTP-EQUIV="expires" CONTENT="0">
	<title>首页</title>
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
	<!-- 头部  -->
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
 			<div class="input-group">
				<input type="text" class="form-control" name="search" placeholder="作者、标题、内容">
				<span class="input-group-btn">
					<button class="btn btn-default" type="button" id="search_fn">搜索</button>
				</span>
			</div><!-- /input-group -->
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
			<div class="container-fluid" id="article_list">
		       
			</div>
			<!-- 分页 -->
			<div class="container-fluid">
				<div class="row">
				  <div class="col-md-12 ">
						<ul id="pageLimit"></ul>
				  </div>
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
 <script type="text/javascript" src="<%=basePath %>js/bootstrap-paginator.js"></script>
	<script type="text/javascript">
	$(function(){
		var currentPage=1;
		var totalPages=0;
		var pageSize=10;
		var search_data=$("input[name='search']").val();
		paginator_fn();
		function paginator_fn(){
			search(search_data);
		    $('#pageLimit').bootstrapPaginator({
			    currentPage: currentPage,//当前的请求页面。
			    totalPages: totalPages,//一共多少页。
			    size:"normal",//应该是页眉的大小。
			    bootstrapMajorVersion: 3,//bootstrap的版本要求。
			    alignment:"right",
			    numberOfPages:pageSize,//一页列出多少数据。
			    itemTexts: function (type, page, current) {//如下的代码是将页眉显示的中文显示我们自定义的中文。
			        switch (type) {
				        case "first": return "首页";
				        case "prev": return "上一页";
				        case "next": return "下一页";
				        case "last": return "末页";
				        case "page": return page;
			        }
			    },
			    onPageClicked: function (event, originalEvent, type, page) {
			    	currentPage=page;
			    	search(search_data);
			    }
			});
		}
		$("#search_fn").click(function(){
			search_data=$("input[name='search']").val();
			alert(search_data);
	    	paginator_fn();
		});
   		function search(value){
   			var search=$("input[name='search']").val();
   			var url="<%=basePath %>getSearch";
   			$.ajax({ 
   				url: url, 
   				data: {"search":value,"pageSize":pageSize,"pageNum":currentPage}, 
   			    async:false, 
   				success: function(result){
   					console.info(result);
   					currentPage=result.pageNum;
   					totalPages=result.totalPages;
   					search_tbody(result.datas);
   				}
   			});
   		}
   		function search_tbody(result){
   			var html="";
   			if(result.length<=0){
   				$("#article_list").empty().append(html);
   				return;
   			}
   			$.each(result,function(index,value){
   				html+=" <div class='row article_list day'> <div class='col-md-12'> ";
   				html+="<div><h5>"+value.name+"</h5></div>";
   				html+="<div>"+value.shortName+"</div>";
   				html+="<div><label>作者:"+value.gearType+"</label><label>发布时间:"+value.updateTime+"</label><button onclick='read_fn("+value.id+")'>阅读</button></div>";
   				html+="</div></div>"
   			});
   			$("#article_list").empty().append(html);
   		}
	});
	function read_fn(id){
		this.location.href="<%=basePath %>getDetails?id="+id;
	}
	</script>
</body>
</html>


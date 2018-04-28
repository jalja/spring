





<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="styleSheet"  href="<%=basePath %>css/bootstrap.min.css" />
</head>
<body>
   <div class="container">
    <h1>elasticsearch-demo</h1>
    <div class="row">
        <div class="col-md-12" style="background-color: #dedef8; box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
			   <div class="form-group">
			    	<label for="exampleInputEmail1">Email address</label>
			    	<input type="text" class="form-control" id="" name="search">
			    	<p></p>
			    	<button type="button" class="btn btn-primary">查询</button>
			  </div>
        </div>
        <div class="col-md-12" >
        	<table class="table table-hover">
        			<thead>
						<tr>
						  <td class="info">index</td>
						  <td class="info">name</td>
						  <td class="info">gearType</td>
						  <td class="info">price</td>
						  <td class="info">shortName</td>
						  <td class="info">updateTime</td>
						</tr>
					</thead>
					<!-- On cells (`td` or `th`) -->
					<tbody id="search_tbody">
						
					</tbody>
			</table>
        </div>
    </div>
</div>
   
   <script type="text/javascript" src="<%=basePath %>js/jquery-3.2.1.min.js"></script>
   <script type="text/javascript">
   	$(function(){
   		$("button[type='button']").click(function(){
   			var search=$("input[name='search']").val();
   			var url="<%=basePath %>getSearch";
   			$.ajax({ 
   				url: url, 
   				data: {"search":search}, 
   				success: function(result){
   					search_tbody(result);
   				}
   			});
   			
   		  	$("input[name='search']").css("background-color","#D6D6FF");
   		});
   		function search_tbody(result){
   			var html="";
   			if(result.length<=0){
   				$("#search_tbody").empty().append(html);
   				return;
   			}
   			$.each(result,function(index,value){
   				html+="<tr>";
   				html+="<td class='info'>"+index+"</td>";
   				html+="<td class='info'>"+value.name+"</td>";
   				html+="<td class='info'>"+value.gearType+"</td>";
   				html+="<td class='info'>"+value.price+"</td>";
   				html+="<td class='info'>"+value.shortName+"</td>";
   				html+="<td class='info'>"+value.updateTime+"</td>";
   				html+="</tr>"
   			});
   			$("#search_tbody").empty().append(html);
   		}
   	});
   </script>
</body>
</html>
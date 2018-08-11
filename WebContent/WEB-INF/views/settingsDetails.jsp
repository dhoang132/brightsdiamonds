<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List organizations</title>
<style>
table {
	border-collapse: collapse;
}

table th, td {
	padding: 5px;
	margin: 10px;
	font-size: 20px;
	border: 1px solid black
}
</style>
</head>
<body>
	<h2 align="center" style="color: #DF0101">Diamond details</h2>
	<hr />
		<div align="center">
		<h3 style="color: #DF0101">Diamond details: ${diamond.certificateId}</h3><br/>
		<h3 style="color: #DF0101">Diamond details: ${diamond.stockItem}</h3><br/>
		<c:set value = "${pageContext.request.contextPath}" var = "contextPath">
						</c:set>
						<a href="${contextPath}/addCart?id=${diamond.id}"style="margin-top: 0px; width: 150px; float: right; margin-right: 31px;"> add to cart</a>
		</div>
		
</body>
</html>
-->


<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Brights Diamonds Home Page</title>
		<style type="text/css">
			html, #page { padding:0; margin:0;}
			body { margin:0; padding:0; width:100%; color:#959595; font:normal 16px/1.0em Sans-Serif;} 
			h1, h2, h3, h4, h5, h6 {color:darkgreen;}
			#page { background:#fff;}
			#header, #footer, #top-nav, #content, #content #contentbar, #content #sidebar { margin:0; padding:0;}
						
			/* Logo */
			#logo { padding:0; width:auto; float:left;}
			#logo h1 a, h1 a:hover { color:darkgreen; text-decoration:none;}
			#logo h1 span { color:#BCCE98;}

			/* Header */
			#header { background:#fff; }
			#header-inner { margin:0 auto; padding:0; width:970px;}
			
			/* Feature */
			.feature { background:green;padding:18px;}
			.feature-inner { margin:auto;width:970px; }
			.feature-inner h1 {color:#DAE9BC;font-size:32px;}
			
			/* Menu */
			#top-nav { margin:0 auto; padding:0px 0 0; height:37px; float:right;}
			#top-nav ul { list-style:none; padding:0; height:37px; float:left;}
			#top-nav ul li { margin:0; padding:0 0 0 8px; float:left;}
			#top-nav ul li a { display:block; margin:0; padding:8px 20px; color:green; text-decoration:none;}
			#top-nav ul li.active a, #top-nav ul li a:hover { color:#BCCE98;}
			
			/* Content */
			#content-inner { margin:0 auto; padding:10px 0; width:970px;background:#fff;}
			#content #contentbar { margin:0; padding:0; float:right; width:760px;}
			#content #contentbar .article { margin:0 0 24px; padding:0 20px 0 15px; }
			#content #sidebar { padding:0; float:left; width:200px;}
			#content #sidebar .widget { margin:0 0 12px; padding:8px 8px 8px 13px;line-height:1.4em;}
			#content #sidebar .widget h3 a { text-decoration:none;}
			#content #sidebar .widget ul { margin:0; padding:0; list-style:none; color:#959595;}
			#content #sidebar .widget ul li { margin:0;}
			#content #sidebar .widget ul li { padding:4px 0; width:185px;}
			#content #sidebar .widget ul li a { color:green; text-decoration:none; margin-left:-16px; padding:4px 8px 4px 16px;}
			#content #sidebar .widget ul li a:hover { color:#BCCE98; font-weight:bold; text-decoration:none;}
			
			.tab0  { position:absolute;left:25px;  }
			.tab1  { position:absolute;right:50px;  }
			.tab2  { position:absolute;left:75px;  }
			.tab3  { position:absolute;right:100px; }
			.tab4  { position:absolute;left:125px; }
			.tab5  { position:absolute;left:150px; }
			.tab6  { position:absolute;left:175px; }
			.tab7  { position:absolute;left:200px; }
			.tab8  { position:absolute;left:225px; }
			.tab9  { position:absolute;left:250px; }
			.tab10 { position:absolute;left:275px; }
			
			/* Footerblurb */
			#footerblurb { background:#DAE9BC;color:green;}
			#footerblurb-inner { margin:0 auto; width:922px; padding:24px;}
			#footerblurb .column { margin:0; text-align:justify; float:left;width:250px;padding:0 24px;}
			
			/* Footer */
			#footer { background:#fff;}
			#footer-inner { margin:auto; text-align:center; padding:12px; width:922px;}
			#footer a {color:green;text-decoration:none;}
			
			/* Clear both sides to assist with div alignment  */
			.clr { clear:both; padding:0; margin:0; width:100%; font-size:0px; line-height:0px;}
		</style>
		<script type="text/javascript">
			/* =============================
			This script generates sample text for the body content. 
			You can remove this script and any reference to it. 
			 ============================= */
			var bodyText=["The smaller your reality, the more convinced you are that you know everything.", "If the facts don't fit the theory, change the facts.", "The past has no power over the present moment.", "This, too, will pass.", "</p><p>You will not be punished for your anger, you will be punished by your anger.", "Peace comes from within. Do not seek it without.", "<h2>Heading</h2><p>The most important moment of your life is now. The most important person in your life is the one you are with now, and the most important activity in your life is the one you are involved with now."]
			function generateText(sentenceCount){
				for (var i=0; i<sentenceCount; i++)
				document.write(bodyText[Math.floor(Math.random()*7)]+" ")
			}
		</script>
	</head>
	<body>
		<div id="page">
			<header id="header">
			<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
				<div id="header-inner">	
					<div id="logo">
						<h1><img  src="data:image/jpeg;base64,${logo}" width="120" height="60" /></span></h1>
					</div>
					<div id="top-nav">
						<ul>
						<li><a href="${contextPath}/about">About</a></li>
						<li><a href="#">Contact</a></li>
						<c:choose>
							<c:when test= "${not empty user}">
								<li><a href= "${contextPath}/userDetails">${user.email}</a></li>
							</c:when>
							<c:otherwise><li><a href= "${contextPath}/login">Login</a></li></c:otherwise>
							</c:choose>
						<li><a href= "${contextPath}/logout">Logout</a></li>
						<li><a href="${contextPath}/viewCart">Cart</a></li>
						</ul>
					</div>
					<div class="clr"></div>
				</div>
			</header>
			<div class="feature">
				<div class="feature-inner">
				<h1>Welcome to BrightsDiamonds</h1>
				</div>
			</div>
		
	
			<div id="content">
				<div id="content-inner">
				
					<main id="contentbar">
						<div class="article">
									<div align="center">
										<h3>${engagementSetting.name}</h3><hr/>
										<c:set value = "${pageContext.request.contextPath}" var = "contextPath">
										</c:set>
										<table border="0" width= 400px>
										<tr>
										
										<td>
										<table border="0" width= 400px>
											<tr>
												<td>
											 		<img  src="data:image/jpeg;base64,${settingImage}" width="250" height="250"/>
											 	</td>
											 </tr>
											 <tr>
											 	<td>
											 		<img  src="data:image/jpeg;base64,${settingImage2}" width="250" height="250"/>
											 	</td>
											 </tr>
										</table>
										</td>
										
										
										<td>
										<table border="0" width=400px>
										<c:choose>
										<c:when test= "${engagementSetting.isInStock == true}">
											<form:form method = "POST" action = "${contextPath}/addSettingCart?id=${engagementSetting.id}" modelAttribute="settingRingCust">
												<tr>
													<td><form:label path="size">Ring Size *</form:label></td>
													<td>
														<form:select path = "size">
														<form:option value = "6.0"> 6.0</form:option>
														<form:option value = "6.5"> 6.5</form:option>
														<form:option selected = "selected" value = "7.0"> 7.0</form:option>
														<form:option value = "7.5"> 7.5</form:option>
														<form:option value = "8.0"> 8.0</form:option>
														</form:select>
													</td>
												</tr>
												<tr>
												<td></td>
												<td>$${engagementSetting.unitPrice}</td>
												</tr>
												</tr>
												<tr>
												<td></td>
												<td>(setting price)</td>
												</tr>
												
												
												<tr>
													<td>
													</td>
													<td>
													<input type ="submit" value ="Add Setting to Cart"/>
													</td>
												</tr>
											</form:form>

												</c:when>
												<c:otherwise>
												<tr>
													<td>
														No Longer Available
													</td>
												</tr>
												</c:otherwise>
												</c:choose>

											<tr align="left">
											<th><b>Summary</b></th>
											</tr>
											<tr>
											<td>Stock Number</td><td>${engagementSetting.stockItem}</td>
											</tr>
											<tr>
											<td>Available Metal</td><td>${engagementSetting.metal}</td>
											</tr>
											<tr>
											<td>Width</td><td>${engagementSetting.width}</td>
											</tr>
										</table>
										</td>
										</tr>
										</table>
									</div>
						</div>
					</main>
					
					<nav id="sidebar">
						<div class="widget">
							<h3></h3>
							<ul>
							<li><a href="${contextPath}/listDiamonds">Lab Grown Diamonds</a></li>
							<li><a href="${contextPath}/listSettings">Engagement Rings</a></li>
							<li><a href="${contextPath}/education">Education</a></li>
							</ul>
						</div>
					</nav>
					
					<div class="clr"></div>
				</div>
			</div>
		
			
			<footer id="footer">
				<div id="footer-inner">
					<p>&copy; Copyright <a href="${contextPath}/">Home</a> &#124; <a href="${contextPath}/about">Terms of Use</a></p>
					<div class="clr"></div>
				</div>
			</footer>
		</div>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Brights Diamonds home page</title>
</head>
<body>
	<h2 align="left" style="color: #add8e6">
			<a href="${contextPath}/listDiamonds" style="font-size: 30px">View our Diamonds</a><tr/>
	</h2>
	<hr />
	<h1 align="center">Brights Diamonds</h1>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<div style="text-align: center">
		<a href="${contextPath}/listDiamonds" style="font-size: 30px">Click
			here to get a list of our diamonds.</a><br/>
			
		<a href= "${contextPath}/newUser" style = "font-size: 30px">New User</a><br/>
		<a href= "${contextPath}/login" style = "font-size: 30px">Login</a><br/>	
		<a href= "${contextPath}/paypalCheckOut" style = "font-size: 30px">Paypal</a><br/>	
	</div>	
</body>
</html> -->


<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Brights Diamonds Home Page</title>
		<style type="text/css">
			html, #page { padding:0; margin:0;}
			body { margin:0; padding:0; width:100%; color:#959595; font:normal 16px/2.0em Sans-Serif;} 
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
			<c:set var="contextPath" value=""/>
				<div id="header-inner">	
					<div id="logo">
						<h1><a href="${contextPath}/"><img itemprop ="image" src="data:image/jpeg;base64,${logo}" alt="Brightsdiamonds logo" width="180" height="90" /></a></span></h1>
					</div>
					<div id="top-nav">
						<ul>
						<li><a href="${contextPath}/about">About</a></li>
						<li><a href="${contextPath}/contact">Contact</a></li>
						
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
							<h3>About BrightsDiamonds</h3>
							
							BrightsDiamonds is committed to bringing you the highest quality lab-grown diamonds at affordable prices to suit your every need.
							Our family has been in the diamond business for several decades. We are honored to partner with you in creating meaningful memories through our exceptional products.
							If you chose us we are confident that you will be pleased with each and every purchase. We are available to support you each step of the way. We offer 24/7 phone and email service support
							in addition to our 30-day money back guarantee. If for any reason you have an issue with your order, please give us a call. We will always do our best to accommodate you!
							<br/>
							<h3>
							Terms & Conditions
							
							</h3>
							
							By using brightsdiamonds.com website or calling brightsdiamonds.com, or when you purchase an products
							you are agreeing to comply with and be bound by our terms and conitions. Please review the following
							terms carefully. If you do not agree to these terms, you should not use this website. The term 
							Brights-diamonds.com, "we", "our", or "us" refers to Danphie LLC and the owner of the Website. The term
							"you" refers to the viewer or user of our website.
							
							<br/>
							<h3>
							Pricing
							</h3>
							
							We do not negotiate prices as we believe our prices are the best prices available. Our prices are in 
							US dollars. We do reserve the right to cancel any order, if we cancel an order after checkout we will refund
							the fee listed on the check out receipt in the same manner as payment was made.
							
							<br/>
							<h3>
							Photography
							</h3>
							Items maybe appear larger or smaller than actually size on the photos. It is your responsibility
							to review the listed size and weight of each stone when before purchasing.
							
							<br/>
							<h3>
							Refund and Return Policy
							</h3>
							BrightsDiamonds refund, return and exchange policy is limited to thirty (30) days from the date of purchase.
							You must notify BrightsDiamonds Customer Service Department via telephone at 4045182618 within 
							thirty (30) days from the date of purchase and follow the instructions provided to you 
							at that time.  Shipping and handling charges are non-refundable.  You are responsible for return shipping and handling costs.  
							BrightsDiamond may reject any returned or exchanged item that does not reasonably conform to these terms.  If the case of a request for an exchange,
							BrightsDiamond expressly reserves the right, in its sole and absolute discretion, to find an acceptable replacement or 
							refund your money should an acceptable replacement be unavailable. Any return of a diamond made without the original diamond grading report will be subject to a $250 
							replacement fee. A 10% restocking fee will be charged should the order be returned for any reason.
							
							<br/>
							
							<h3>Ring Resizing</h3>
							
							Any ring purchased from BrightsDiamonds can be sent back within 60 days from the date of purchase 
							for a free resizing. The customer is responsible for any shipping charges to ship the item to us for resizing.
							
							<br/>
							<h3>
							
							Export Compliance
							</h3>
							Each product that BrightsDiamonds sells is subject to all United States export laws.  Therefore, 
							no products may be exported or re-exported into, or to a national or resident of, Cuba, Iran, 
							North Korea, Syria or any country to which the United States has embargoed goods. Additionally, 
							no products may be exported or re-exported to anyone on the United States Treasury Department’s 
							list of specially designated nationals or the United States Commerce Department’s Table of Denial 
							Orders.
							<br/>
							<h3>
							
							User Generated Content
							</h3>
							BrightsDiamonds may provide you with the ability to submit user generated content to the Website, 
							which may include but is not limited to product reviews.  Except as otherwise licensed herein, you own 
							all rights in and to your User Generated Content.  User Generated Content may be hosted, shared, and/or 
							published as part of the Website’s associated services.  User Generated Content posted to public areas of 
							the Website, including as product reviews, will be publicly visible to all visitors of the Website.  
							You expressly acknowledge, however, that BrightsDiamonds does not guarantee any confidentiality with respect 
							to any submissions of your User Generated Content.
							<br/>

							By submitting User Generated Content to the Website, you grant BrightsDiamonds a non-exclusive, 
							irrevocable, royalty free, worldwide, and perpetual license to use your User Generated Content 
							for the customary and intended purposes of the Website and any purpose related thereto, including, 
							without limitation, to reproduce, prepare derivative works, distribute copies, perform, sell, display, research, 
							and use any of the User Generated Content. These purposes may include, but are not limited to, 
							providing you or third parties with the Website or its associated services, 
							improving the Website or its associated services, and archiving or making backups of the Website. 
							You agree to waive all moral rights in and to your User Generated Content across the world, whether 
							you have or have not asserted moral rights in or to your User Generated Content. By submitting User 
							Generated Content to the Website, you further agree to waive all rights of publicity or privacy with 
							respect to the User Generated Content submitted.
							
							<br/>

							You warrant that any User Generated Content that you submit to the Website will not violate the 
							rights of third parties, including, but not limited to, trademark rights, copyright rights, and 
							rights of publicity and privacy, or violate any applicable law, statute, ordinance, treaty, or 
							regulation, whether local, state, provincial, national, or international.
							<br/>

							You agree that you are solely responsible for any User Content that you submit to the Site.  
							BrightsDiamond acts solely as a repository of data, and therefore makes no guarantees as to the 
							validity, accuracy, relevance, usefulness, or legal status of any User Generated Content.  
							BrightsDiamonds does not guarantee the confidentiality of any User Generated Content you share 
							through the Website with any third party.

							<br/>
							BrightsDiamonds reserves the right to remove User Generated Content without prior notice and may, 
							at its sole discretion, remove User Generated Content that it determines, at its sole discretion, 
							violates the terms of this Agreement.  BrightsDiamonds also reserves the right to terminate a user’s 
							access to the Website for any reason, including, but not limited to, for repeatedly infringing on 
							the intellectual property or other rights of third parties or otherwise violating the terms of this 
							Agreement, or for no reason, and without prior notice.
							<br/>
							
							<br/>
							<h3>
							Limitation of Liability
							</h3>
							BrightsDiamonds SPECIFICALLY DISCLAIMS ANY LIABILITY OR RESPONSIBILITY FOR ORDERS OR BUY BACK SALES 
							PLACED VIA THE BrightsDiamonds ONLINE ORDER ENTRY SYSTEM, FOR ANY LOSSES OR DIRECT, INDIRECT, CONSEQUENTIAL, 
							INCIDENTAL, OR PUNITIVE DAMAGES THAT YOU MAY INCUR AS A RESULT OF THE USE OF THE BrightsDiamond ONLINE ORDER ENTRY SYSTEM, 
							THE WEBSITE, AND/OR RELATED PRODUCTS/SERVICES. BrightsDiamonds SHALL NOT BE RESPONSIBLE FOR ERRORS, NEGLIGENCE, OR 
							INABILITY TO EXECUTE ORDERS. FURTHER, BrightsDiamonds SHALL NOT BE RESPONSIBLE FOR ANY DELAYS IN THE TRANSMISSION, 
							DELIVERY, OR EXECUTION OF YOUR ORDERS DUE TO BREAKDOWN OR FAILURE OF TRANSMISSION OR COMMUNICATION FACILITIES, 
							OR FOR ANY OTHER CAUSES BEYOND BrightsDiamond’S REASONABLE CONTROL. BrightsDiamonds SPECIFICALLY DISCLAIMS ANY 
							LIABILITY FOR THE INTERRUPTION, CANCELLATION, OR OTHER TERMINATION OF THE BrightsDiamonds ONLINE ORDER ENTRY SYSTEM.
							<br/>
							THE WEBSITE MAY CONTAIN TECHNICAL INACCURACIES OR TYPOGRAPHICAL ERRORS OR OMISSIONS. BrightsDiamonds IS NOT RESPONSIBLE FOR 
							ANY SUCH TYPOGRAPHICAL, TECHNICAL, OR PRICING ERRORS LISTED ON THE WEBSITE.
							<br/>
							SOME JURISDICTIONS DO NOT ALLOW THE EXCLUSION OR LIMITATION OF DAMAGES. IF YOUR JURISDICTION DOES NOT ALLOW THE EXCLUSION OR 
							LIMITATION OF DAMAGES, YOU SHOULD SEEK LEGAL COUNSEL TO UNDERSTAND YOUR LEGAL RIGHTS UNDER THE LAW.
							<br/>
							<h3>
							Indemnity and Release
							</h3>
							You agree to defend, indemnify and hold BrightsDiamonds and its parents, subsidiaries, affiliates, 
							officers, directors, agents, employees, licensors, members, shareholders, co-branders or other 
							partners, employees, and advertising partners harmless from any and all claims and expenses, 
							liabilities, losses, actions, damages, claims or demands, including reasonable attorneys’ fees,  
							made by any third-party directly or indirectly relating to or arising out of (a) 
							content you provide to the Website or otherwise transmit or obtain through the products and/or 
							services, (b) your use, purchase, and/or sale of the products and/or services, (c) your connection 
							to the products and/or services, (d) your violation of this Agreement, (e) your violation 
							of any rights of another, (f) your breach of any representation or warranty made by you to 
							BrightsDiamonds, or (g) your failure to perform your obligations here under.  If you are obligated to
							 provide indemnification pursuant to this provision, BrightsDiamonds may, in its sole and absolute 
							 discretion, control the disposition of any claim at your sole cost and expense. 
							  Without limitation of the foregoing, you may not settle, compromise or in any other manner 
							  dispose of any claim without BrightsDiamonds’s consent.
							
							<br/>
							You are hereby agreeing to release the BrightsDiamonds and its parents, subsidiaries, affiliates, 
							officers, directors, agents, employees, licensors, members, shareholders, co-branders or other 
							partners, employees, and advertising partners from any and all claims, demands, debts, obligations, 
							damages (actual or consequential), costs, and expenses of any kind or nature whatsoever, whether 
							known, suspected or unsuspected, disclosed or undisclosed, that you may have against them arising
							 out of or in any way related to, without limitation, such disputes and/or to the Website and 
							 related products and services.
							<br/>
							<h3>
							No Waiver
							</h3>
							Upon your failure to comply with your duties and obligations to BrightsDiamonds, the latter reserves all rights and remedies available at law or in equity.  No delay or failure on the part of BrightsDiamonds in exercising any right or any remedy shall operate or be construed as a waiver of that right or that remedy.  In addition, no partial exercise by BrightsDiamonds of any right or any remedy shall preclude the further exercise of that right or that remedy or the exercise of any other right or any other remedy.  In the event that you fail to comply with this Agreement, you expressly authorize and grant to BrightsDiamonds the right to charge your credit card for any and all market losses incurred by BrightsDiamonds, including, without limitation, administrative fees for accepting your orders to either buy from or sell to BrightsDiamonds as a result of price and market fluctuations for which you did not fulfill.
							
							<br/>
							<h3>
							No assignment
							</h3>
							You may not assign this Agreement, including your related rights and/or obligations, without express prior written consent of BrightsDiamonds.  Such consent may be granted or withheld by BrightsDiamonds at its sole and absolute discretion.  This Agreement shall be binding upon and inure to the benefit any/all permitted assignees and successors of you and BrightsDiamonds.

							<br/>
							<h3>
							Force Majeure
							</h3>
							You acknowledge and understand that if BrightsDiamonds and/or the Website are unable to provide the products and/or services as a result of a force majeure event, BrightsDiamonds and/or the Website will not be in breach of any of its obligations towards you under this Agreement.  A force majeure event means any event beyond the control of BrightsDiamonds and/or the Website.  BrightsDiamonds SHALL NOT HAVE ANY LIABILITY TO YOU WHETHER IN CONTRACT, WARRANTY, TORT (INCLUDING NEGLIGENCE), OR ANY OTHER FORM OF LIABILITY FOR FAILING TO PERFORM ITS OBLIGATIONS UNDER THIS AGREEMENT TO THE EXTENT THAT SUCH FAILURE IS AS A RESULT OF A FORCE MAJEURE EVENT.

							<br/>
							<h3>
							Warranties, Representations, and Restrictions of Website Use
							</h3>
							You warrant and agree that you have the right and legal capacity to enter into this Agreement and to adhere to its terms and conditions.  You warrant that you are a human individual that is eighteen (18) years of age or older.  If you are under eighteen (18) years of age but at least thirteen (13) years of ag, you must present this Agreement to your legal guardian for review.  Any minors under the age of thirteen (13) are prohibited from utilizing the Website and/or related services.

							You warrant and represent that any and all information that you provide to BrightsDiamonds and the Website is accurate and valid.  You agree to comply in good faith with the terms and conditions of this Agreement.

							You will not use the Website in any way that violates the rights of third parties, and you agree to comply with any and all applicable local, state, national, provincial, and international laws, treaties, and regulations.  Given the global nature of the Internet, you agree to comply with all laws and rules where you reside and here you use the Website.  You may not use any third-party intellectual property without the express written permission of the applicable third-party, except as permitted by law.  The Website will retain ownership of its intellectual property rights and you may not obtain any rights therein by virtue of this Agreement or otherwise, except as expressly set forth in this Agreement.  You will have no right to use, copy, display, perform, create derivative works from, distribute, have distributed, transmit or sublicense from materials or content available on the Website, except as expressly set forth in this Agreement.   You may not attempt to reverse engineer any of the technology used to provide the products and/or services.

							In your use of the Website and the products and/or services, you may not: (i) infringe any patent, trademark, trade secret, copyright, right of publicity or other right of any party; (ii) defame, abuse, harass, stalk any individual, or disrupt or interfere with the security or use of the products and/or services, the Website or any websites linked to the Website; (iii) interfere with or damage the Website or products and/or services, including, without limitation, through the use of viruses, cancel bots, Trojan horses, harmful code, flood pings, denial of service attacks, packet or IP spoofing, forged routing or electronic mail address information or similar methods or technology; (iv) attempt to use another user’s account, impersonate another person or entity, misrepresent your affiliation with a person or entity, including (without limitation) the Website or create or use a false identity; (v) attempt to obtain unauthorized access to the Website or portions of the Website that are restricted from general access; (vi) engage, directly or indirectly, in transmission of “spam,” chain letters, junk mail or any other type of unsolicited solicitation; (vii) collect, manually or through an automatic process, information about other users without their express consent or other information relating to the Website or the products and/or services; (viii) use any meta tags or any other “hidden text” utilizing the BrightsDiamonds name, trademarks, or product names; (ix) advertise, offer to sell, or sell any goods or services, except as expressly permitted by the Website; (x) engage in any activity that interferes with any third party’s ability to use or enjoy the Website or products and/or services; or (xi) assist any third party in engaging in any activity prohibited by this Agreement.

							<br/>
							<h3>
							Resolution of Disputes and Governing Law; Waiver of Jury and Arbitration Agreement
							</h3>
							To the extent permitted by applicable law, you hereby expressly waive your right to a trial by jury in any proceeding or litigation brought against BrightsDiamonds with respect to this Agreement and/or the Website.  All disputes arising out of or relating to these Terms & Conditions (including formation, performance or alleged breach) or your use of the Website will be exclusively resolved under confidential binding arbitration held in Dallas, TX in accordance with the Rules of the American Arbitration Association.  You hereby consent to personal jurisdiction for the purpose of resolving such disagreements and such disputes and waive all objections to the jurisdiction.  The arbitrator’s award will be binding and may be entered as a judgment in any court of competent jurisdiction. To the fullest extent permitted by applicable law, no arbitration under this Agreement will be joined to an arbitration involving any other party subject to this Agreement, whether through class arbitration proceedings or otherwise.  Notwithstanding the foregoing, BrightsDiamonds will have the right to seek injunctive or other equitable relief in state or federal court located in Dallas, TX to enforce these Terms & Conditions or prevent an infringement of a third party’s rights.  In the event equitable relief is sought, you hereby irrevocably submit to the personal jurisdiction of such court and waive all objections to the jurisdiction.  This Agreement shall be governed by, and interpreted in accordance with, the laws of the State of Texas, without regard to conflict of laws principles.

							BY ENTERING INTO THIS AGREEMENT, YOU HEREBY IRREVOCABLY WAIVE ANY RIGHT YOU MAY HAVE TO JOIN CLAIMS WITH THOSE OF OTHERS IN THE FORM OF A CLASS ACTION OR SIMILAR PROCEDURAL DEVICE.   ANY CLAIMS ARISING OUT OF, RELATING TO, OR CONNECTED WITH THIS AGREEMENT MUST BE ASSERTED INDIVIDUALLY.

							You acknowledge and agree that, regardless of any statute or law to the contrary, any claim or cause of action you may have arising out of, relating to, or connected with your use of the Website, must be filed within one calendar year after such claim or cause of action arises, or forever be barred.  In the event that BrightsDiamonds takes any action against you, arising out of and/or to enforce your obligations under this Agreement, you expressly agree to pay all of the associated costs and the expenses incurred by BrightsDiamonds, including, without limitation, reasonable attorneys’ fees, in connection with such action.  You expressly agree to execute and deliver any/all documents and take such other actions as may be reasonably requested by BrightsDiamonds to carry out this Agreement.

							<br/>
							<h3>
							Severability
							</h3>
							If any provision of this Agreement is found by a court of competent jurisdiction to be invalid, the parties nevertheless agree that the court should endeavor to give effect to the parties’ intentions as reflected in the provision, and the other provisions of this Agreement remain in full force and effect.

							<br/>
							<h3>
							Entire Agreement
							</h3>
							This Agreement constitutes the entire agreement between you and BrightsDiamonds and governs your use of the Website, superseding any prior agreements.

							<br/>
							<h3>
							Integration
							</h3>
							BrightsDiamonds hereby incorporates its Privacy Policy and its Copyright Policy into this Agreement. This Agreement and its incorporated Privacy Policy and Copyright Policy constitutes the entire agreement between the parties with respect to the use of the Website and its associated services and products. You acknowledge and agree that any additional provisions that may appear in any communication from you will not bind BrightsDiamonds.

							<br/>
							<h3>
							Statute of Limitations
							</h3>
							YOU AGREE THAT REGARDLESS OF ANY STATUTE OR LAW TO THE CONTRARY, ANY CLAIM OR CAUSE OF ACTION ARISING OUT OF RELATED TO THE AGREEMENT MUST BE FILED WITHIN ONE (1) YEAR AFTER SUCH CLAIM OR CAUSE OF ACTION AROSE OR BE FOREVER BARRED.

							<br/>
							<h3>
							Child Online Privacy Protection Act
							</h3>
							The Website is not directed to persons under the age of eighteen (18) and BrightsDiamonds will not knowingly collect personally identifiable information from children under the age of eighteen (18). If BrightsDiamonds inadvertently collects such personally identifiable information, BrightsDiamonds will delete the personally identifiable information in accordance with its security protocols.

							<br/>
							<h3>
							Reservation of Rights
							</h3>
							All rights not expressly granted herein are reserved to BrightsDiamonds.

							<br/>
							<h3>
							
							Privacy
							</h3>
							Use of this Website is subject to the terms of our Privacy Policy, which is hereby incorporated into and made part of this Agreement. Please carefully review our Privacy Policy.  By using this Website, you agree to be bound by the terms of our Privacy Policy.  We reserve the right, and you authorize us, to use information regarding your use of this Website, account registration, and any other personal information provided by you in accordance with our Privacy Policy.

							<br/>
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
		
<!--			<div id="footerblurb">
				<div id="footerblurb-inner">
				
					<div class="column">
						<h2><span>Heading</span></h2>
						<p><script>generateText(2)</script></p>
					</div>	
					<div class="column">
						<h2><span>Heading</span></h2>
						<p><script>generateText(2)</script></p>
					</div>
					<div class="column">
						<h2><span>Heading</span></h2>
						<p><script>generateText(2)</script></p>
					</div>	
					
					<div class="clr"></div>
				</div>
			</div>   -->
			<footer id="footer">
				<div id="footer-inner">
					<p>&copy; Copyright <a href="${contextPath}/">Home</a> &#124; <a href="${contextPath}/about">Terms of Use</a></p>
					<div class="clr"></div>
				</div>
			</footer>
		</div>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table width="95%" border="0" cellspacing="0" cellpadding="1"
		align="center" bgcolor="#006699"
		style="font-family: verdana, arial, helvetica; font-size: small;">
		<tr>
			<td>
				<table width="100%" border="0" cellspacing="0" cellpadding="5"
					align="center" bgcolor="#FFFFFF"
					style="font-family: verdana, arial, helvetica; font-size: small;">
					<tr valign="top">
						<td>
							<table width="100%"
								style="font-family: verdana, arial, helvetica; font-size: small;">
								<tr>
									<td></td>
									<td width="98%">
										<div style="padding-left: 1em;">
											<span style="font-size: large;">Brightsdiamonds.com</span><br />
										</div>
									</td>
									<td nowrap="nowrap">Brightsdiamonds.com<br />3045 Gordy Parkway Suite 108, Georgia 30066<br />404-518-2618
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr valign="top">
						<td>
							<table cellpadding="4" cellspacing="0" border="0" width="100%"
								style="font-family: verdana, arial, helvetica; font-size: small;">
								<tr>
									<td colspan="2" bgcolor="#006699"
										style="color: white; padding: 5px;"><b>Purchasing
											Information:</b></td>
								</tr>
								<tr>
									<td nowrap="nowrap"><b>E-mail Address:</b></td>
									<td> ${paypalInformation.email}
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<table width="100%" cellspacing="0" cellpadding="0"
											style="font-family: verdana, arial, helvetica; font-size: small;">
											<tr>
												<td valign="top" width="50%"><b>Billing Address:</b><br />
													${paypalInformation.userShippingAddress}</td>
												<td valign="top" width="50%"><b>Shipping Address:</b><br />
													${paypalInformation.userShippingAddress}
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td nowrap="nowrap"><b>Order Grand Total:</b></td>
									
									<td width="98%"><b><fmt:formatNumber value = "${paypalInformation.cartTotal}" type = "currency"/></b></td>
								</tr>
								<tr>
									<td nowrap="nowrap"><b>Payment Method:</b></td>
									<td width="98%">PayPal</td>
								</tr>
								<tr>
									<td colspan="2" bgcolor="#006699"
										style="color: white; padding: 5px;"><b>Order Summary:</b>
									</td>
								</tr>
								<tr>
									<td colspan="2" bgcolor="#EEEEEE"><font color="#CC6600"><b>Shipping
												Details:</b></font></td>
								</tr>
								<tr>
									<td colspan="2">
										<table border="0" cellpadding="1" cellspacing="0" width="100%"
											style="font-family: verdana, arial, helvetica; font-size: small;">
											<tr>
												<td nowrap="nowrap"><b>Order #:</b></td>
												<td width="98%">
													${paypalInformation.cartId}
												</td>
											</tr>
											<tr>
												<td nowrap="nowrap"><b>Order Date: </b></td>
												<td width="98%">${paypalInformation.date}</td>
											</tr>
											<tr>
												<td nowrap="nowrap"><b>Shipping Method:</b></td>
												<td width="98%">Next Day Express Shipping</td>
											</tr>
											<tr>
												<td nowrap="nowrap">Products Subtotal:&nbsp;</td>
												
												<td width="98%"><fmt:formatNumber value = "${(paypalInformation.cartTotal-30)}" type = "currency"/></td>
											</tr>
											<tr>
												<td nowrap="nowrap">Next Day Express Shipping:</td>
												<td>$30.00</td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td>------</td>
											</tr>
											<tr>
												<td nowrap="nowrap"><b>Total for this Order:&nbsp;</b>
												</td>
												
												<td><b><fmt:formatNumber value = "${paypalInformation.cartTotal}" type = "currency"/></b></td>
											</tr>
											<tr>
												<td colspan="2"><br />
												<br />
												<b>Products on order:&nbsp;</b>
													<table width="100%"
														style="font-family: verdana, arial, helvetica; font-size: small;">
														<tr>
															<td width="98%"><b>${paypalInformation.cartProducts}
															</b></td>
														</tr>
													</table></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
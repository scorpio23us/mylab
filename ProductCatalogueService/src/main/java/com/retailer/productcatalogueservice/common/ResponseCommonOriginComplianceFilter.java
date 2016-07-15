package com.retailer.productcatalogueservice.common;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

public class ResponseCommonOriginComplianceFilter implements ContainerResponseFilter{

	@Override
	public ContainerResponse filter(ContainerRequest req,ContainerResponse contResp) {
		ResponseBuilder resp = Response.fromResponse(contResp.getResponse());
		resp.header("Access-Control-Allow-Origin", "*")
		.header("Access-Control-Allow-Headers","authorization")
		.header("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
		.header("Cache-Control","no-cache");
		contResp.setResponse(resp.build());

		if(req.getMethod().equalsIgnoreCase("OPTIONS")) {
			contResp.setStatus(HttpServletResponse.SC_OK);
		}
		return contResp;

	}
	
}
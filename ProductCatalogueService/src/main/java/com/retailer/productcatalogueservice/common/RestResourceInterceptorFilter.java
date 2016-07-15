package com.retailer.productcatalogueservice.common;

import java.util.Collections;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import com.sun.jersey.api.model.AbstractMethod;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import com.sun.jersey.spi.container.ResourceFilter;
import com.sun.jersey.spi.container.ResourceFilterFactory;

public class RestResourceInterceptorFilter implements ResourceFilterFactory {

	private static int TOKEN_STALENESS_FACTOR_IN_MINUTES = 60;

	@Context
	private HttpServletRequest httpServletRequest;
	@Context
	private ServletConfig config;
	@Context
	private UriInfo uriInfo;
	
	@Override
	public List<ResourceFilter> create(AbstractMethod arg0) {
		return Collections.<ResourceFilter> singletonList(new RESTRequestFilter());
	}

	private class RESTRequestFilter implements ResourceFilter, ContainerRequestFilter {
		@Override
		public ContainerRequest filter(ContainerRequest req) {
			try {
				TOKEN_STALENESS_FACTOR_IN_MINUTES = Integer.parseInt(config.getInitParameter("StalenessFactorInMinutes"));
			} catch (Exception e) {
				// ignore
			}
			String reqUri = req.getRequestUri().toString();
			String method = httpServletRequest.getMethod();
			boolean isRequestAuthorizedForToken = false;
			boolean escapeRequestAuthorization = false;

			if(reqUri.contains("/restful/")) {
				//Do something..and move ahead....if context a mismatch, then fail it
				//may be set header token
			}
			return req;
	    }

		@Override
		public ContainerRequestFilter getRequestFilter() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ContainerResponseFilter getResponseFilter() {
			// TODO Auto-generated method stub
			return null;
		}
	}
}

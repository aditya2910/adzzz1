package com.sb.service.logging;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.jboss.logging.MDC;
import org.springframework.stereotype.Component;

@Component
public class SampleAppFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// do nothing.
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		MDC.put("mdc_Key_1", "value_mdc_1");

		filterChain.doFilter(servletRequest, servletResponse);
		MDC.remove("mdc_Key_1");
	}

	@Override
	public void destroy() {
		// do nothing.
	}
}

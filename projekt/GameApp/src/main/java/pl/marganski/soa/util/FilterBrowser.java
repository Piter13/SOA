package pl.marganski.soa.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "FilterBrowser", urlPatterns = {"/*"})
public class FilterBrowser implements Filter {
	
	public void destroy() {}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String userAgent = ((HttpServletRequest) request).getHeader("User-Agent");

        if (userAgent.contains("Chrome")){
            chain.doFilter(request, response);
            return;
        }

        ((HttpServletResponse) response).getWriter().write("Access denied");
	}
	
	public void init(FilterConfig fConfig) throws ServletException {}

}

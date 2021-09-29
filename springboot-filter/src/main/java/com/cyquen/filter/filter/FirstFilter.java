package com.cyquen.filter.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author zheng
 */
@Order(1)
@WebFilter(filterName = "firstFilter", urlPatterns = "/*")
public class FirstFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("first filter 1");
        filterChain.doFilter(request, response);
        System.out.println("first filter 2");
    }
}

package com.kaisikk.java.springdatabase.filter;

import jakarta.servlet.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/cookie")
public class LogginFilter implements Filter {

    @Override
    public void doFilter(jakarta.servlet.ServletRequest servletRequest, jakarta.servlet.ServletResponse servletResponse, jakarta.servlet.FilterChain filterChain) throws IOException, jakarta.servlet.ServletException {
        HttpServletRequest hsr = (HttpServletRequest) servletRequest;

        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        Cookie[] cookies = hsr.getCookies();
        boolean checker = false;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("kaisik")) checker = true;
        }


        if (checker) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            httpServletResponse.sendRedirect("image");
        }
    }


}

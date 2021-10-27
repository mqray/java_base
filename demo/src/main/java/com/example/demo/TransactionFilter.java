package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Intellij IDEA.
 * User: mqray
 * Date: 2021/10/27
 */
public class TransactionFilter implements Filter {

    @Autowired
    private HttpServletReqUtil reqUtil;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        final MyHttpServletRequestWrapper wrappedRequest = new MyHttpServletRequestWrapper(
                (HttpServletRequest) request);
        System.out.println("Inside Servlet Filter");
        System.out.println("User IP address: " + reqUtil.getRemoteAddress(wrappedRequest));
        System.out.println("Request Params: " + reqUtil.getRequestParams(wrappedRequest));
        System.out.println("Request Payload: " + reqUtil.getPayLoad(wrappedRequest));
        System.out.println("Exiting Servlet Filter");
        chain.doFilter(wrappedRequest, response);
    }
}

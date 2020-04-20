package com.abhi.microservices.netflixzuulapigatewayserver.log;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/** @author a0r00rf */
@Component
public class ZuulLoggingFilter extends ZuulFilter {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() throws ZuulException {

    HttpServletRequest httpServletRequest = RequestContext.getCurrentContext().getRequest();
    logger.info(
        "request -> {} request Uri -> {}", httpServletRequest, httpServletRequest.getRequestURI());
    return null;
  }
}

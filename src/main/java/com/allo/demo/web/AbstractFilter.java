//package com.xiaomi.bigdata.mqs.mqsdataview.web;
//import com.alibaba.fastjson.JSON;
//import org.apache.commons.collections4.CollectionUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.IOException;
//import java.util.Set;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//public abstract class AbstractFilter implements Filter {
//    private static final Logger logger = LoggerFactory.getLogger(AbstractFilter.class);
//    private String loginUrl = "/mqsas/login/redirect.do";
//    protected Filter filter;
//
//    protected Set<String> excludePath;
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        String path = ((HttpServletRequest) request).getServletPath();
//        String requestURL = ((HttpServletRequest) request).getRequestURL().toString();
//        logger.info("doFilter path:{}", path);
//        ((HttpServletRequest) request).getHeader("backdoor");
//        if ("sys".equals((((HttpServletRequest) request).getHeader("backdoor")))) {
//            chain.doFilter(request,response);
//        } /*else if (path.endsWith("gif") || path.endsWith("jpg") || path.endsWith("png") || path.endsWith("js")
//                || path.endsWith("css") || path.endsWith("woff") || path.endsWith("eot") || path.endsWith("svg")
//                || path.endsWith("ico") || path.endsWith("jpeg") || path.endsWith("otf") || path.endsWith("webp")
//                || path.endsWith("ttf") ||(!path.equalsIgnoreCase("/mqsas/relocation/index.html") && path.endsWith("html"))) {
////            logger.info("static file exclude, path:{}", path);
//            //静态页面不拦截
//            chain.doFilter(request, response);
//        }*/ else if (CollectionUtils.isNotEmpty(excludePath) && excludePath.contains(path)) {
//            logger.debug("AbstractFilter exclude, path:{}", path);
//            chain.doFilter(request, response);
//        } else {
////            final HttpSession session = ((HttpServletRequest) request).getSession(false);
////            final Assertion assertion = session != null ? (Assertion) session.getAttribute(CONST_CAS_ASSERTION) : null;
////            logger.debug("AbstractFilter, requestURL = {}, assertion = {}", requestURL, JSON.toJSONString(assertion));
////            if (requestURL.contains(loginUrl) || assertion != null) {
////                filter.doFilter(request, response, chain);
////                return;
////            } else {
////                ((HttpServletResponse)response).setStatus(401);
////                return;
////            }
//        }
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}
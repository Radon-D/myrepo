package com.myapp.config;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class MyServletInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic myservlet = servletContext.addServlet("myservlet", MyServlet.class);
        myservlet.addMapping("/cusotm/**");

        FilterRegistration.Dynamic myfilter = servletContext.addFilter("myfilter", MyFilter.class);
        myfilter.addMappingForUrlPatterns(null, false, "/custom/**");
    }

}

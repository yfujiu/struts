package org.superbiz.struts;

import com.opensymphony.module.sitemesh.filter.PageFilter;
import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean siteMeshFilter() {

        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new SiteMeshFilter());
        bean.addUrlPatterns("/*");
        bean.setOrder(1);
        return bean;
         //Output - FilterRegistrationBean
        //type SiteMeshFilter  order 1  urlpattern=/*
        // type PrepareAndExecuteFilter   order 2 urlpattern-/, /addUserForm.action, --------
        //bean.addUrlPatterns("/*");
        //return bean;
    }

    @Bean
    public FilterRegistrationBean prepareAndExecuteFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new StrutsPrepareAndExecuteFilter());
        bean.addUrlPatterns("/", "/addUserForm.action", "/addUser.action", "/findUserForm.action", "/findUser.action", "/listAllUsers.action");
        bean.setOrder(2);
        return bean;
    }

/*
    @Bean
    public FilterRegistrationBean filterDispatch() {
        return buildFilterRegistration(2, new StrutsPrepareAndExecuteFilter(),
                asList("/", "/addUserForm.action", "/addUser.action",
                        "/findUserForm.action", "/findUser.action",
                        "/listAllUsers.action"));
    }

    @Bean
    public FilterRegistrationBean sitemeshPageFilter() {
        return buildFilterRegistration(1, new SiteMeshFilter(),
                singletonList("/*"));
    }

    private FilterRegistrationBean buildFilterRegistration(int order, Filter filter, List<String> urlPatterns) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);
        registration.setUrlPatterns(urlPatterns);
        registration.setOrder(order);
        return registration;
    }

 */
}

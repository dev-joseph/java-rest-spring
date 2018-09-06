/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springone.security;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.util.Assert;

/**
 * BeanPostProcessor implementation used to customize the
 * parameter name of RememberMeServices bean registered
 * by the Spring Security Namespace configuration.
 *
 * @author nirmal
 */
public class RememberMeParameterBeanPostProcessor implements BeanPostProcessor, InitializingBean {

    private String rememberMeParameter;

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.hasText(rememberMeParameter, "Remember Me Parameter must be set to a non empty value.");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof AbstractRememberMeServices) {
            ((AbstractRememberMeServices) bean).setParameter(rememberMeParameter);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public String getRememberMeParameter() {
        return rememberMeParameter;
    }

    /**
     * Sets the parameter name to be used for RememberMeServices
     *
     * @param rememberMeParameter parameter name to be used
     */
    public void setRememberMeParameter(String rememberMeParameter) {
        this.rememberMeParameter = rememberMeParameter;
    }
}

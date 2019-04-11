package com.config;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
//过滤器

/**
 * @WebFilter相当于：
 *   <filter>
 *       <filter-name>myFilter</filter-name>
 *       <filter-class></filter-class>
 *       <init-param>
 *           <param-name>exclusions</param-name>
 *           <param-value>*.js</param-value>
 *       </init-param>
 *   </filter>
 */
@WebFilter(filterName = "statFilter",urlPatterns = "/*",initParams ={@WebInitParam(name = "exclusions",value ="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*" )})//忽略资源
public class DruidStatFilter extends WebStatFilter {}

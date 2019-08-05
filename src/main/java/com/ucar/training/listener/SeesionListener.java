package com.ucar.training.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class SeesionListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public SeesionListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        Integer count = null;
        int sessionCount = (int) se.getSession().getServletContext().getAttribute("sessionCount");
        System.out.println("session创建成功！！");
        if (se.getSession().getServletContext().getAttribute("sessionCount") == null) {
            count = 0;
        } else {
            count = sessionCount;
        }
        count++;
        System.out.println("当前session数：" + count + "");
        se.getSession().getServletContext().setAttribute("sessionCount", count);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        Integer count = null;
        System.out.println("session销毁成功！！");
        int sessionCount = (int) se.getSession().getServletContext().getAttribute("sessionCount");
        if (se.getSession().getServletContext().getAttribute("sessionCount") == null) {
            count = 0;
        } else {
            count = sessionCount;
        }
        count--;
        System.out.println("当前session数：" + count.toString());
        se.getSession().getServletContext().setAttribute("sessionCount", count);
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
        System.out.println("id为" + sbe.getSession().getId() + "的session新建了属性：key为" + sbe.getName() + "valut为" + sbe.getValue());
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
        System.out.println("id为" + sbe.getSession().getId() + "的session删除了属性：key为" + sbe.getName() + "valut为" + sbe.getValue());
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */

    }
}

package com.ma;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.tools.ant.taskdefs.Sleep;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[]args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.setAllowUseOriginalMessage(false);
        try {
            camelContext.addRoutes(new FtpRouteBuilder());
            camelContext.start();
            Thread.sleep(200000);
        }catch (Exception e){
            System.out.printf("ex: "+e.getMessage());
        }
        finally {
            camelContext.stop();
        }
    }
}

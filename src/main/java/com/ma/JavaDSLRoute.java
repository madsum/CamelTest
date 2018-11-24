package com.ma;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class JavaDSLRoute {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();

        try {

            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() throws Exception {
                    from("direct:JavaDSLRouteStart").

                            //To filter routing message to the external file
                                    split(xpath("//order[@product='electronics']/items")).
                            to("file:src/main/resources/orderxmlroute/");
                }
            });
            context.start();
            ProducerTemplate template = context.createProducerTemplate();
            InputStream orderxml = new FileInputStream("src/main/resources/order.xml");
            template.sendBody("direct:JavaDSLRouteStart", orderxml);
        } finally {
            context.stop();
        }
    }
}

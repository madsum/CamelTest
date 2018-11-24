package com.ma;

import org.apache.camel.builder.RouteBuilder;

        public class FtpRouteBuilder extends RouteBuilder {
            @Override
            public void configure() throws Exception {
                try{
                    from("file:c:/temp/input/")
                            .streamCaching()
                            .to("sftp://sftpuser@192.168.10.54:/sftpuser/?password=dev&passiveMode=true");
                }catch (Exception ex){
                    System.out.printf("ex: "+ex.getMessage());
                }
            }
        }
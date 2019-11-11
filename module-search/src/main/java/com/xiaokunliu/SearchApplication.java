package com.xiaokunliu;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 *
 */
@SpringBootApplication
public class SearchApplication {
    public static void main( String[] args ) {
        new SpringApplicationBuilder().bannerMode(Banner.Mode.OFF).run(args);
    }
}

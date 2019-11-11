package com.xiaokunliu.study.springinaction.assembly.profile;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.logging.Logger;

/**
 * Created by keithl on 2017/10/20.
 */
@Configuration
@Profile("dev")
public class DevelopmentProfileConfig {

    // 用于开发环境的配置

    //    @Bean(destroyMethod = "shutdown")
    public DataSource dataSource(){
        return new EmbeddedDatabase() {
            @Override
            public void shutdown() {

            }

            @Override
            public Connection getConnection() {
                return null;
            }

            @Override
            public Connection getConnection(String username, String password) {
                return null;
            }

            @Override
            public <T> T unwrap(Class<T> iface) {
                return null;
            }

            @Override
            public boolean isWrapperFor(Class<?> iface) {
                return false;
            }

            @Override
            public PrintWriter getLogWriter() {
                return null;
            }

            @Override
            public void setLogWriter(PrintWriter out) {

            }

            @Override
            public int getLoginTimeout() {
                return 0;
            }

            @Override
            public void setLoginTimeout(int seconds) {

            }

            @Override
            public Logger getParentLogger() {
                return null;
            }
        };
    }
}

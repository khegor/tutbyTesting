package com.roxoft.tutby.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Esenin on 13.11.2017.
 */
public class SessionFactory {


    public static Logger LOGGER = Logger.getLogger(SessionFactory.class);

    public static SqlSession getSession() {
        SqlSessionFactory sqlSessionFactory = null;

        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis.config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return sqlSessionFactory.openSession();
    }
}

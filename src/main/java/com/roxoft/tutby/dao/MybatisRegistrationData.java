package com.roxoft.tutby.dao;

import com.roxoft.tutby.models.RegistrationData;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by Esenin on 13.11.2017.
 */
public class MybatisRegistrationData implements IRegDao {

    final static String namespace = "testMapper";


    @Override
    public List<RegistrationData> getAllRegistartionData() {
        SqlSession sqlSession = SessionFactory.getSession();
        List<RegistrationData> dataList;
        try {
            dataList = sqlSession.selectList(namespace + ".getAllRegistartionData");
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
        return dataList;

    }
}

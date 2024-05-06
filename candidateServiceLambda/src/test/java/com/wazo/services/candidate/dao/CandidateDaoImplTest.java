package com.wazo.services.candidate.dao;

import com.wazo.services.candidate.ConfigurationServiceClient.impl.ConfigurationRestClientImpl;
import com.wazo.services.candidate.clients.DynamoDb;
import com.wazo.services.candidate.dao.entity.CandidateEntity;
import com.wazo.services.candidate.dao.impl.CandidateDaoImpl;
import com.wazo.services.candidate.handler.CandidateLambdaMainHandler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RunWith(MockitoJUnitRunner.class)
public class CandidateDaoImplTest {

    @Mock
    private CandidateDao candidateDao;

    @InjectMocks
    private CandidateDaoImpl candidateDaoImpl;

    @Before
    public void setUp() {
        // You can initialize any setup required for your tests here
    }
    private static final Logger log = LoggerFactory.getLogger(CandidateLambdaMainHandler.class);

    // TEST a private method with Reflection to check its accessibility
    @Test
    public void testConvertToCandidateResponse() throws NoSuchMethodException, IllegalArgumentException, SecurityException {
        Method m = CandidateDaoImpl.class.getDeclaredMethod("convertToCandidateResponse", CandidateEntity.class);
        m.setAccessible(true);
        CandidateEntity candidate = new CandidateEntity();
        try {
            m.invoke(candidateDaoImpl, candidate);
        } catch (InvocationTargetException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }
}

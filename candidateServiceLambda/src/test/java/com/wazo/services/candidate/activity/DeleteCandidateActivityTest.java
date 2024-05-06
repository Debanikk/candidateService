package com.wazo.services.candidate.activity;


import com.wazo.services.candidate.dao.CandidateDao;
import com.wazo.services.candidate.model.response.ApiResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.wazo.services.candidate.utils.Constants.DELETE_SUCCESS;
import static com.wazo.services.candidate.utils.Constants.ERROR_MESSAGE;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DeleteCandidateActivityTest {

    @Mock
    private CandidateDao candidateDao;

    @InjectMocks
    private DeleteCandidateActivity deleteCandidateActivity;

    @Before
    public void setUp() {
        // You can initialize any setup required for your tests here
    }

    @Test
    public void testDeleteCandidateSuccess() {
        // Mock input parameters
        String orgId = "org123";
        String candidateId = "candidate123";

        // Mock the behavior of the candidateDao
        doNothing().when(candidateDao).deleteCandidateEntity(orgId, candidateId);

        // Call the method under test
        ApiResponse response = deleteCandidateActivity.run(orgId, candidateId);

        // Verify the behavior
        assertEquals(203, response.getStatus());
        assertEquals(DELETE_SUCCESS, response.getMessage());

        // Verify that candidateDao.deleteCandidateEntity was called with the correct arguments
        verify(candidateDao, times(1)).deleteCandidateEntity(orgId, candidateId);
    }

    @Test
    public void testDeleteCandidateMissingIds() {
        // Call the method under test with null values for orgId and candidateId
        ApiResponse response = deleteCandidateActivity.run(null, null);

        // Verify the behavior
        assertEquals(403, response.getStatus());
        assertEquals(ERROR_MESSAGE, response.getMessage());

        // Verify that candidateDao.deleteCandidateEntity was not called
        verify(candidateDao, never()).deleteCandidateEntity(any(), any());
    }
}

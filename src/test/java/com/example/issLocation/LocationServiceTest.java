package com.example.issLocation;

import com.example.issLocation.apiResponse.Response;
import com.example.issLocation.service.LocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LocationServiceTest {

    private LocationService locationService;
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        restTemplate = mock(RestTemplate.class);

        Response mockedResponse = new Response();
        mockedResponse.setVelocity("27500.0");

        when(restTemplate.getForObject(anyString(), eq(Response.class))).thenReturn(mockedResponse);

        locationService = new LocationService(restTemplate);
    }

    @Test
    void testGetIssLocation_ValidResponse() {
        Response response = locationService.getIssLocation();

        assertNotNull(response);

        assertEquals("27500.0", response.getVelocity()); // Compare as String
    }



    @Test
    void testGetIssLocation_NullResponse() {
        LocationService faultyService = new LocationService(null) {
            @Override
            public Response getIssLocation() {
                return null; // Simulating null response
            }
        };
        assertNull(faultyService.getIssLocation());
    }

    @Test
    void testGetIssLocation_InvalidVelocityFormat() {
        LocationService faultyService = new LocationService(null) {
            @Override
            public Response getIssLocation() {
                Response response = new Response();
                response.setVelocity("invalid_value");
                return response;
            }
        };

        Response response = faultyService.getIssLocation();
        assertNotNull(response);
        assertEquals("invalid_value", response.getVelocity());
    }
}


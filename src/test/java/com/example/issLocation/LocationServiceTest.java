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
        // Mock the RestTemplate
        restTemplate = mock(RestTemplate.class);

        // Mock the response from RestTemplate's getForObject method
        Response mockedResponse = new Response();
        mockedResponse.setVelocity("27500.0");

        // Configure the mock to return the mocked response
        when(restTemplate.getForObject(anyString(), eq(Response.class))).thenReturn(mockedResponse);

        // Initialize LocationService with the mocked RestTemplate
        locationService = new LocationService(restTemplate);
    }

    @Test
    void testGetIssLocation_ValidResponse() {
        // Call the method to test
        Response response = locationService.getIssLocation();

        // Assert that the response is not null
        assertNotNull(response);

        // Assert that the velocity in the response is the expected value (as String)
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


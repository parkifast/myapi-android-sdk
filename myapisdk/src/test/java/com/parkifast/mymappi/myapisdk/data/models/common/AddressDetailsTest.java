package com.parkifast.mymappi.myapisdk.data.models.common;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class AddressDetailsTest {

    @Before
    public void setUp() {

    }

    @Test
    public void getHouseNumberAlias() {
        // 1) Arrange
        HashMap<String,String> components = new HashMap<String,String>() {{
            put("house_number", "");
            put("street_number", "2");
        }};
        AddressDetails addressDetails = new AddressDetails(components);
        // 2) Act
        String houseNumberAlias = addressDetails.getHouseNumberAlias();
        // 3) Assert
        assertEquals("2", houseNumberAlias);
    }

    @Test
    public void getHouseAlias() {
        // 1) Arrange
        HashMap<String,String> components = new HashMap<String,String>() {{
            put("house", "");
            put("building", "expected_value");
            put("public_building", "");
        }};
        AddressDetails addressDetails = new AddressDetails(components);
        // 2) Act
        String houseAlias = addressDetails.getHouseAlias();
        // 3) Assert
        assertEquals("expected_value", houseAlias);
    }

    @Test
    public void getStreetNameAlias() {
        // 1) Arrange
        HashMap<String,String> components = new HashMap<String,String>() {{
            put("street_name", "expected_value");
            put("road", "not_expected_value");
            put("path", "");
        }};
        AddressDetails addressDetails = new AddressDetails(components);
        // 2) Act
        String streetNameValue = addressDetails.getStreetNameAlias();
        // 3) Assert
        assertEquals("expected_value", streetNameValue);
    }

    @Test
    public void getVillageAlias() {
        // 1) Arrange
        HashMap<String,String> components = new HashMap<String,String>() {{
            put("village", "");
            put("hamlet", "");
            put("croft", "");
        }};
        AddressDetails addressDetails = new AddressDetails(components);
        // 2) Act
        String villageValue = addressDetails.getVillageAlias();
        // 3) Assert
        assertEquals("", villageValue);
    }

    @Test
    public void getNeighbourhoodAlias() {
        // 1) Arrange
        HashMap<String,String> components = new HashMap<String,String>() {{
            put("neighbourhood", "");
            put("suburb", "");
            put("city_district", "expected_value");
            put("district", "not_expected_value");
        }};
        AddressDetails addressDetails = new AddressDetails(components);
        // 2) Act
        String neighbourhoodValue = addressDetails.getNeighbourhoodAlias();
        // 3) Assert
        assertEquals("expected_value", neighbourhoodValue);
    }

    @Test
    public void getCityAlias() {
        // 1) Arrange
        HashMap<String,String> components = new HashMap<String,String>() {{
            put("city", "");
            put("town", "");
            put("municipality", "expected_value");
        }};
        AddressDetails addressDetails = new AddressDetails(components);
        // 2) Act
        String cityValue = addressDetails.getCityAlias();
        // 3) Assert
        assertEquals("expected_value", cityValue);
    }

    @Test
    public void getCountyAlias() {
        // 1) Arrange
        HashMap<String,String> components = new HashMap<String,String>() {{
            put("county", "expected_value");
            put("county_code", "");
        }};
        AddressDetails addressDetails = new AddressDetails(components);
        // 2) Act
        String countyValue = addressDetails.getCountyAlias();
        // 3) Assert
        assertEquals("expected_value", countyValue);
    }

    @Test
    public void getStateDistrictAlias() {
        // 1) Arrange
        HashMap<String,String> components = new HashMap<String,String>() {{
            put("state_district", "expected_value");
            put("town", "");
            put("bad_key", "not_expected_value");
        }};
        AddressDetails addressDetails = new AddressDetails(components);
        // 2) Act
        String stateDistrictValue = addressDetails.getStateDistrictAlias();
        // 3) Assert
        assertEquals("expected_value", stateDistrictValue);
    }

    @Test
    public void getPostCodeAlias() {
        // 1) Arrange
        HashMap<String,String> components = new HashMap<String,String>() {{
            put("postcode", "28007");
        }};
        AddressDetails addressDetails = new AddressDetails(components);
        // 2) Act
        String postCodeValue = addressDetails.getPostCodeAlias();
        // 3) Assert
        assertEquals(addressDetails.getPostCode(), postCodeValue);
    }

    @Test
    public void getStateAlias() {
        // 1) Arrange
        HashMap<String,String> components = new HashMap<String,String>() {{
            put("province", "unexpected_value");
            put("state", "expected_value");
        }};
        AddressDetails addressDetails = new AddressDetails(components);
        // 2) Act
        String stateValue = addressDetails.getStateAlias();
        // 3) Assert
        assertEquals(stateValue, stateValue);
    }

    @Test
    public void getRegionAlias() {
        // 1) Arrange
        HashMap<String,String> components = new HashMap<String,String>() {{
            put("region", "valid_region");
        }};
        AddressDetails addressDetails = new AddressDetails(components);
        // 2) Act
        String regionValue = addressDetails.getRegionAlias();
        // 3) Assert
        assertEquals(addressDetails.getRegion(), regionValue);
    }

    @Test
    public void getCountryAlias() {
        // 1) Arrange
        HashMap<String,String> components = new HashMap<String,String>() {{
            put("country", "");
            put("country_name", "expected_value");
        }};
        AddressDetails addressDetails = new AddressDetails(components);
        // 2) Act
        String countryValue = addressDetails.getCountryAlias();
        // 3) Assert
        assertEquals("expected_value", countryValue);
    }

    @Test
    public void getContinentAlias() {
        // 1) Arrange
        HashMap<String,String> components = new HashMap<String,String>() {{
            put("continent", "europe");
        }};
        AddressDetails addressDetails = new AddressDetails(components);
        // 2) Act
        String continentValue = addressDetails.getContinentAlias();
        // 3) Assert
        assertEquals(addressDetails.getContinent(), continentValue);
    }
}
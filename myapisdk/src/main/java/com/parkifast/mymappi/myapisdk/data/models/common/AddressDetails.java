package com.parkifast.mymappi.myapisdk.data.models.common;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

/**
 * Complex address structure representing full address.
 */
public class AddressDetails {

    //region Attributes

    //region House number aliases
    /**
     * House number. Aliases for this are: street number.
     */
    @SerializedName("house_number")
    private String houseNumber;

    /**
     * Street number (alias for house number)
     */
    @SerializedName("street_number")
    private String streetNumber;
    //endregion
    //region House aliases
    /**
     * House
     */
    @SerializedName("house")
    private String house;

    /**
     * Building (alias for house)
     */
    @SerializedName("building")
    private String building;

    /**
     * Public Building (alias for house)
     */
    @SerializedName("public_building")
    private String publicBuilding;
    //endregion
    //region Road / Street name aliases
    /**
     * Road. Aliases for this are: footway, street, street_name, residential, path, pedestrian,
     * road_reference, road_reference_intl, square, place.
     */
    @SerializedName("road")
    private String road;

    /**
     * Footway (alias for road)
     */
    @SerializedName("footway")
    private String footway;

    /**
     * Street (alias for road)
     */
    @SerializedName("street")
    private String street;

    /**
     * Street name (alias for road)
     */
    @SerializedName("street_name")
    private String streetName;

    /**
     * Residential (alias for road)
     */
    @SerializedName("residential")
    private String residential;

    /**
     * Path (alias for road)
     */
    @SerializedName("path")
    private String path;

    /**
     * Pedestrian (alias for road)
     */
    @SerializedName("pedestrian")
    private String pedestrian;

    /**
     * Road reference (alias for road)
     */
    @SerializedName("road_reference")
    private String roadReference;

    /**
     * Road reference international (alias for road)
     */
    @SerializedName("road_reference_intl")
    private String roadReferenceIntl;

    /**
     * Square (alias for road)
     */
    @SerializedName("square")
    private String square;

    /**
     * Place (alias for road)
     */
    @SerializedName("place")
    private String place;
    //endregion
    //region Village aliases
    /**
     * Village. Aliases for this are: Hamlet, locality, croft.
     */
    @SerializedName("village")
    private String village;

    /**
     * Hamlet (alias for village)
     */
    @SerializedName("hamlet")
    private String hamlet;

    /**
     * Locality (alias for village)
     */
    @SerializedName("locality")
    private String locality;

    /**
     * Croft (alias for village)
     */
    @SerializedName("croft")
    private String croft;
    //endregion
    //region Neighbourhood aliases
    /**
     * Neighbourhood. Aliases for this are: suburb, city_district, district, quarter, commercial,
     * industrial, houses, subdivision.
     */
    @SerializedName("neighbourhood")
    private String neighbourhood;

    /**
     * Suburb (alias for neighbourhood)
     */
    @SerializedName("suburb")
    private String suburb;

    /**
     * City district (alias for neighbourhood)
     */
    @SerializedName("city_district")
    private String cityDistrict;

    /**
     * District (alias for neighbourhood)
     */
    @SerializedName("district")
    private String district;

    /**
     * Quarter (alias for neighbourhood)
     */
    @SerializedName("quarter")
    private String quarter;

    /**
     * Commercial (alias for neighbourhood)
     */
    @SerializedName("commercial")
    private String commercial;

    /**
     * Industrial (alias for neighbourhood)
     */
    @SerializedName("industrial")
    private String industrial;

    /**
     * Houses (alias for neighbourhood)
     */
    @SerializedName("houses")
    private String houses;

    /**
     * Subdivision (alias for neighbourhood)
     */
    @SerializedName("subdivision")
    private String subdivision;

    //endregion
    //region City aliases
    /**
     * City. Aliases for this are: town, municipality.
     */
    @SerializedName("city")
    private String city;

    /**
     * Town (alias for city)
     */
    @SerializedName("town")
    private String town;

    /**
     * Municipality (alias for city)
     */
    @SerializedName("municipality")
    private String municipality;
    //endregion
    //region County aliases
    /**
     * County. Aliases for this are: local_administrative_area, county_code.
     */
    @SerializedName("county")
    private String county;

    /**
     * Local administrative area (alias for county)
     */
    @SerializedName("local_administrative_area")
    private String localAdminArea;

    /**
     * County code (alias for county)
     */
    @SerializedName("county_code")
    private String countyCode;
    //endregion
    //region State district
    /**
     * State district
     */
    @SerializedName("state_district")
    private String stateDistrict;
    //endregion
    //region Postal code
    /**
     * Postal code
     */
    @SerializedName("postcode")
    private String postCode;
    //endregion
    //region State aliases
    /**
     * State. Aliases for this are: province, state_code.
     */
    @SerializedName("state")
    private String state;

    /**
     * Province (alias for state)
     */
    @SerializedName("province")
    private String province;

    /**
     * State code (alias for state)
     */
    @SerializedName("state_code")
    private String stateCode;
    //endregion
    //region Region
    /**
     * Region
     */
    @SerializedName("region")
    private String region;
    //endregion
    //region Country
    /**
     * Country. Aliases for this are: country_name.
     */
    @SerializedName("country")
    private String country;

    /**
     * Country name (alias for country)
     */
    @SerializedName("country_name")
    private String countryName;

    /**
     * Country code (NOT an alias for country)
     */
    @SerializedName("country_code")
    private String countryCode;
    //endregion
    //region Continent
    /**
     * Continent
     */
    @SerializedName("continent")
    private String continent;
    //endregion
    //region Components
    /**
     * HashMap containing all address components, since they evolve rapidly and we cannot characterize
     * them all.
     */
    @SerializedName("address")
    private HashMap<String, String> components;
    //endregion
    //endregion

    //region Getters and setters

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getPublicBuilding() {
        return publicBuilding;
    }

    public void setPublicBuilding(String publicBuilding) {
        this.publicBuilding = publicBuilding;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getFootway() {
        return footway;
    }

    public void setFootway(String footway) {
        this.footway = footway;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getResidential() {
        return residential;
    }

    public void setResidential(String residential) {
        this.residential = residential;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPedestrian() {
        return pedestrian;
    }

    public void setPedestrian(String pedestrian) {
        this.pedestrian = pedestrian;
    }

    public String getRoadReference() {
        return roadReference;
    }

    public void setRoadReference(String roadReference) {
        this.roadReference = roadReference;
    }

    public String getRoadReferenceIntl() {
        return roadReferenceIntl;
    }

    public void setRoadReferenceIntl(String roadReferenceIntl) {
        this.roadReferenceIntl = roadReferenceIntl;
    }

    public String getSquare() {
        return square;
    }

    public void setSquare(String square) {
        this.square = square;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getHamlet() {
        return hamlet;
    }

    public void setHamlet(String hamlet) {
        this.hamlet = hamlet;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCroft() {
        return croft;
    }

    public void setCroft(String croft) {
        this.croft = croft;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        this.neighbourhood = neighbourhood;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCityDistrict() {
        return cityDistrict;
    }

    public void setCityDistrict(String cityDistrict) {
        this.cityDistrict = cityDistrict;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public String getCommercial() {
        return commercial;
    }

    public void setCommercial(String commercial) {
        this.commercial = commercial;
    }

    public String getIndustrial() {
        return industrial;
    }

    public void setIndustrial(String industrial) {
        this.industrial = industrial;
    }

    public String getHouses() {
        return houses;
    }

    public void setHouses(String houses) {
        this.houses = houses;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getLocalAdminArea() {
        return localAdminArea;
    }

    public void setLocalAdminArea(String localAdminArea) {
        this.localAdminArea = localAdminArea;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    public String getStateDistrict() {
        return stateDistrict;
    }

    public void setStateDistrict(String stateDistrict) {
        this.stateDistrict = stateDistrict;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public HashMap<String, String> getComponents() {
        return components;
    }

    public void setComponents(HashMap<String, String> components) {
        this.components = components;
    }

    //endregion

    //region Constructors

    /**
     * Empty basic constructor which initializes everything to empty strings.
     */
    public AddressDetails() {
        this.houseNumber = "";
        this.streetNumber = "";
        this.house = "";
        this.building = "";
        this.publicBuilding = "";
        this.road = "";
        this.footway = "";
        this.street = "";
        this.streetName = "";
        this.residential = "";
        this.path = "";
        this.pedestrian = "";
        this.roadReference = "";
        this.roadReferenceIntl = "";
        this.square = "";
        this.place = "";
        this.village = "";
        this.hamlet = "";
        this.locality = "";
        this.croft = "";
        this.neighbourhood = "";
        this.suburb = "";
        this.cityDistrict = "";
        this.district = "";
        this.quarter = "";
        this.commercial = "";
        this.industrial = "";
        this.houses = "";
        this.subdivision = "";
        this.city = "";
        this.town = "";
        this.municipality = "";
        this.county = "";
        this.localAdminArea = "";
        this.countyCode = "";
        this.stateDistrict = "";
        this.postCode = "";
        this.state = "";
        this.province = "";
        this.stateCode = "";
        this.region = "";
        this.country = "";
        this.countryName = "";
        this.countryCode = "";
        this.continent = "";
        this.components = new HashMap<>();
    }

    /**
     * Complex constructor which initializes all variables contained in components to their
     * proper value, leaving the rest as empty strings.
     * @param addressComponents        {@link HashMap} contaning all key-value pairs that represent the
     *                                         address.
     */
    public AddressDetails(HashMap<String,String> addressComponents) {
        // Make sure address components structure is not empty
        if(addressComponents == null) {
            this.components = new HashMap<>();
        } else {
            this.components = addressComponents;
        }
        // Populate fields if present, otherwise leave them as an empty string
        this.houseNumber = this.components.containsKey("house_number") ? this.components.get("house_number") : "";
        this.streetNumber = this.components.containsKey("street_number") ? this.components.get("street_number") : "";
        this.house = this.components.containsKey("house") ? this.components.get("house") : "";
        this.building = this.components.containsKey("building") ? this.components.get("building") : "";
        this.publicBuilding = this.components.containsKey("public_building") ? this.components.get("public_building") : "";
        this.road = this.components.containsKey("road") ? this.components.get("road") : "";
        this.footway = this.components.containsKey("footway") ? this.components.get("footway") : "";
        this.street = this.components.containsKey("street") ? this.components.get("street") : "";
        this.streetName = this.components.containsKey("street_name") ? this.components.get("street_name") : "";
        this.residential = this.components.containsKey("residential") ? this.components.get("residential") : "";
        this.path = this.components.containsKey("path") ? this.components.get("path") : "";
        this.pedestrian = this.components.containsKey("pedestrian") ? this.components.get("pedestrian") : "";
        this.roadReference = this.components.containsKey("road_reference") ? this.components.get("road_reference") : "";
        this.roadReferenceIntl = this.components.containsKey("road_reference_intl") ? this.components.get("road_reference_intl") : "";
        this.square = this.components.containsKey("square") ? this.components.get("square") : "";
        this.place = this.components.containsKey("place") ? this.components.get("place") : "";
        this.village = this.components.containsKey("village") ? this.components.get("village") : "";
        this.hamlet = this.components.containsKey("hamlet") ? this.components.get("hamlet") : "";
        this.locality = this.components.containsKey("locality") ? this.components.get("locality") : "";
        this.croft = this.components.containsKey("croft") ? this.components.get("croft") : "";
        this.neighbourhood = this.components.containsKey("neighbourhood") ? this.components.get("neighbourhood") : "";
        this.suburb = this.components.containsKey("suburb") ? this.components.get("suburb") : "";
        this.cityDistrict = this.components.containsKey("city_district") ? this.components.get("city_district") : "";
        this.district = this.components.containsKey("district") ? this.components.get("district") : "";
        this.quarter = this.components.containsKey("quarter") ? this.components.get("quarter") : "";
        this.commercial = this.components.containsKey("commercial") ? this.components.get("commercial") : "";
        this.industrial = this.components.containsKey("industrial") ? this.components.get("industrial") : "";
        this.houses = this.components.containsKey("houses") ? this.components.get("houses") : "";
        this.subdivision = this.components.containsKey("subdivision") ? this.components.get("subdivision") : "";
        this.city = this.components.containsKey("city") ? this.components.get("city") : "";
        this.town = this.components.containsKey("town") ? this.components.get("town") : "";
        this.municipality = this.components.containsKey("municipality") ? this.components.get("municipality") : "";
        this.county = this.components.containsKey("county") ? this.components.get("county") : "";
        this.localAdminArea = this.components.containsKey("local_admin_area") ? this.components.get("local_admin_area") : "";
        this.countyCode = this.components.containsKey("county_code") ? this.components.get("county_code") : "";
        this.stateDistrict = this.components.containsKey("state_district") ? this.components.get("state_district") : "";
        this.postCode = this.components.containsKey("postcode") ? this.components.get("postcode") : "";
        this.state = this.components.containsKey("state") ? this.components.get("state") : "";
        this.province = this.components.containsKey("province") ? this.components.get("province") : "";
        this.stateCode = this.components.containsKey("state_code") ? this.components.get("state_code") : "";
        this.region = this.components.containsKey("region") ? this.components.get("region") : "";
        this.country = this.components.containsKey("country") ? this.components.get("country") : "";
        this.countryName = this.components.containsKey("country_name") ? this.components.get("country_name") : "";
        this.countryCode = this.components.containsKey("country_code") ? this.components.get("country_code") : "";
        this.continent = this.components.containsKey("continent") ? this.components.get("continent") : "";
    }
    //endregion

    //region Exposed API

    /**
     * Convenience getter for house number value. It retrieves whatever value is available from
     * all house number aliases (house number and street number)
     * @return          Consolidated value for house number.
     */
    public String getHouseNumberAlias() {
        // Provide default value
        String result = this.houseNumber;
        // Loop through aliases if empty until something is found, if there is any.
        if(result.isEmpty()) {
            result = this.streetNumber;
        }
        // Return result
        return result;
    }

    /**
     * Convenience getter for house value. It retrieves whatever value is available from
     * all house aliases (house, building, public_building)
     * @return          Consolidated value for house.
     */
    public String getHouseAlias() {
        // Provide default value
        String result = this.house;
        // Loop through aliases if empty until something is found, if there is any.
        if(result.isEmpty()) {
            result = this.building;
        }
        if(result.isEmpty()) {
            result = this.publicBuilding;
        }
        // Return result
        return result;
    }

    /**
     * Convenience getter for street name value. It retrieves whatever value is available from
     * all street name aliases (street name, road, footway, street, residential, path, pedestrian,
     * road_reference, road_reference_intl, square, place)
     * @return          Consolidated value for street name.
     */
    public String getStreetNameAlias() {
        // Provide default value
        String result = this.streetName;
        // Loop through aliases if empty until something is found, if there is any.
        if(result.isEmpty()) {
            result = this.road;
        }
        if(result.isEmpty()) {
            result = this.footway;
        }
        if(result.isEmpty()) {
            result = this.street;
        }
        if(result.isEmpty()) {
            result = this.residential;
        }
        if(result.isEmpty()) {
            result = this.path;
        }
        if(result.isEmpty()) {
            result = this.pedestrian;
        }
        if(result.isEmpty()) {
            result = this.roadReference;
        }
        if(result.isEmpty()) {
            result = this.roadReferenceIntl;
        }
        if(result.isEmpty()) {
            result = this.square;
        }
        if(result.isEmpty()) {
            result = this.place;
        }
        // Return result
        return result;
    }

    /**
     * Convenience getter for village value. It retrieves whatever value is available from
     * all village aliases (village, hamlet, locality, croft)
     * @return          Consolidated value for village.
     */
    public String getVillageAlias() {
        // Provide default value
        String result = this.village;
        // Loop through aliases if empty until something is found, if there is any.
        if(result.isEmpty()) {
            result = this.hamlet;
        }
        if(result.isEmpty()) {
            result = this.locality;
        }
        if(result.isEmpty()) {
            result = this.croft;
        }
        // Return result
        return result;
    }

    /**
     * Convenience getter for neighbourhood value. It retrieves whatever value is available from
     * all neighbourhood aliases (neighbourhood, suburb, city_district, district, commercial,
     * industrial, houses, subdivision)
     * @return          Consolidated value for neighbourhood.
     */
    public String getNeighbourhoodAlias() {
        // Provide default value
        String result = this.neighbourhood;
        // Loop through aliases if empty until something is found, if there is any.
        if(result.isEmpty()) {
            result = this.suburb;
        }
        if(result.isEmpty()) {
            result = this.cityDistrict;
        }
        if(result.isEmpty()) {
            result = this.district;
        }
        if(result.isEmpty()) {
            result = this.commercial;
        }
        if(result.isEmpty()) {
            result = this.industrial;
        }
        if(result.isEmpty()) {
            result = this.houses;
        }
        if(result.isEmpty()) {
            result = this.subdivision;
        }
        // Return result
        return result;
    }

    /**
     * Convenience getter for city value. It retrieves whatever value is available from
     * all city aliases (city, town, municipality)
     * @return          Consolidated value for city.
     */
    public String getCityAlias() {
        // Provide default value
        String result = this.city;
        // Loop through aliases if empty until something is found, if there is any.
        if(result.isEmpty()) {
            result = this.town;
        }
        if(result.isEmpty()) {
            result = this.municipality;
        }
        // Return result
        return result;
    }

    /**
     * Convenience getter for county value. It retrieves whatever value is available from
     * all county aliases (county, local_administrative_area, county_code)
     * @return          Consolidated value for county.
     */
    public String getCountyAlias() {
        // Provide default value
        String result = this.county;
        // Loop through aliases if empty until something is found, if there is any.
        if(result.isEmpty()) {
            result = this.localAdminArea;
        }
        if(result.isEmpty()) {
            result = this.countyCode;
        }
        // Return result
        return result;
    }

    /**
     * Convenience getter for state district value. It retrieves whatever value is available from
     * all county aliases (state district)
     * @return          Consolidated value for state district.
     */
    public String getStateDistrictAlias() {
        // Provide default value
        String result = this.stateDistrict;
        // Loop through aliases if empty until something is found, if there is any.
        // --> There isn't any alias
        // Return result
        return result;
    }

    /**
     * Convenience getter for postal code value. It retrieves whatever value is available from
     * all postal code aliases (postal code)
     * @return          Consolidated value for postal code.
     */
    public String getPostCodeAlias() {
        // Provide default value
        String result = this.postCode;
        // Loop through aliases if empty until something is found, if there is any.
        // --> There isn't any alias
        // Return result
        return result;
    }

    /**
     * Convenience getter for state value. It retrieves whatever value is available from
     * all state aliases (state, province, state_code)
     * @return          Consolidated value for state.
     */
    public String getStateAlias() {
        // Provide default value
        String result = this.state;
        // Loop through aliases if empty until something is found, if there is any.
        if(result.isEmpty()) {
            result = this.province;
        }
        if(result.isEmpty()) {
            result = this.stateCode;
        }
        // Return result
        return result;
    }

    /**
     * Convenience getter for region value. It retrieves whatever value is available from
     * all region aliases (region)
     * @return          Consolidated value for region.
     */
    public String getRegionAlias() {
        // Provide default value
        String result = this.region;
        // Loop through aliases if empty until something is found, if there is any.
        // --> There isn't any alias
        // Return result
        return result;
    }

    /**
     * Convenience getter for country value. It retrieves whatever value is available from
     * all country aliases (country, country_name)
     * @return          Consolidated value for country.
     */
    public String getCountryAlias() {
        // Provide default value
        String result = this.country;
        // Loop through aliases if empty until something is found, if there is any.
        if(result.isEmpty()) {
            result = this.countryName;
        }
        // Return result
        return result;
    }

    /**
     * Convenience getter for continent value. It retrieves whatever value is available from
     * all continent aliases (continent)
     * @return          Consolidated value for continent.
     */
    public String getContinentAlias() {
        // Provide default value
        String result = this.continent;
        // Loop through aliases if empty until something is found, if there is any.
        // --> There isn't any alias
        // Return result
        return result;
    }
    //endregion

    //region Public helpers

    /**
     * Standard implementation of toString().
     * @return          A {@link String representation} of this complex object.
     */
    @Override
    public String toString() {
        return "AddressDetails{" +
                "houseNumber='" + houseNumber + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", house='" + house + '\'' +
                ", building='" + building + '\'' +
                ", publicBuilding='" + publicBuilding + '\'' +
                ", road='" + road + '\'' +
                ", footway='" + footway + '\'' +
                ", street='" + street + '\'' +
                ", streetName='" + streetName + '\'' +
                ", residential='" + residential + '\'' +
                ", path='" + path + '\'' +
                ", pedestrian='" + pedestrian + '\'' +
                ", roadReference='" + roadReference + '\'' +
                ", roadReferenceIntl='" + roadReferenceIntl + '\'' +
                ", square='" + square + '\'' +
                ", place='" + place + '\'' +
                ", village='" + village + '\'' +
                ", hamlet='" + hamlet + '\'' +
                ", locality='" + locality + '\'' +
                ", croft='" + croft + '\'' +
                ", neighbourhood='" + neighbourhood + '\'' +
                ", suburb='" + suburb + '\'' +
                ", cityDistrict='" + cityDistrict + '\'' +
                ", district='" + district + '\'' +
                ", quarter='" + quarter + '\'' +
                ", commercial='" + commercial + '\'' +
                ", industrial='" + industrial + '\'' +
                ", houses='" + houses + '\'' +
                ", subdivision='" + subdivision + '\'' +
                ", city='" + city + '\'' +
                ", town='" + town + '\'' +
                ", municipality='" + municipality + '\'' +
                ", county='" + county + '\'' +
                ", localAdminArea='" + localAdminArea + '\'' +
                ", countyCode='" + countyCode + '\'' +
                ", stateDistrict='" + stateDistrict + '\'' +
                ", postCode='" + postCode + '\'' +
                ", state='" + state + '\'' +
                ", province='" + province + '\'' +
                ", stateCode='" + stateCode + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", countryName='" + countryName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", continent='" + continent + '\'' +
                ", components=" + components +
                '}';
    }
    /**
     * Basic comparison implementation by checking every value against each other.
     * @param o         Another {@link AddressDetails} object to compare to.
     * @return          {@code true} when all fields are the equal.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressDetails)) return false;

        AddressDetails that = (AddressDetails) o;

        if (!getHouseNumber().equals(that.getHouseNumber())) return false;
        if (!getStreetNumber().equals(that.getStreetNumber())) return false;
        if (!getHouse().equals(that.getHouse())) return false;
        if (!getBuilding().equals(that.getBuilding())) return false;
        if (!getPublicBuilding().equals(that.getPublicBuilding())) return false;
        if (!getRoad().equals(that.getRoad())) return false;
        if (!getFootway().equals(that.getFootway())) return false;
        if (!getStreet().equals(that.getStreet())) return false;
        if (!getStreetName().equals(that.getStreetName())) return false;
        if (!getResidential().equals(that.getResidential())) return false;
        if (!getPath().equals(that.getPath())) return false;
        if (!getPedestrian().equals(that.getPedestrian())) return false;
        if (!getRoadReference().equals(that.getRoadReference())) return false;
        if (!getRoadReferenceIntl().equals(that.getRoadReferenceIntl())) return false;
        if (!getSquare().equals(that.getSquare())) return false;
        if (!getPlace().equals(that.getPlace())) return false;
        if (!getVillage().equals(that.getVillage())) return false;
        if (!getHamlet().equals(that.getHamlet())) return false;
        if (!getLocality().equals(that.getLocality())) return false;
        if (!getCroft().equals(that.getCroft())) return false;
        if (!getNeighbourhood().equals(that.getNeighbourhood())) return false;
        if (!getSuburb().equals(that.getSuburb())) return false;
        if (!getCityDistrict().equals(that.getCityDistrict())) return false;
        if (!getDistrict().equals(that.getDistrict())) return false;
        if (!getQuarter().equals(that.getQuarter())) return false;
        if (!getCommercial().equals(that.getCommercial())) return false;
        if (!getIndustrial().equals(that.getIndustrial())) return false;
        if (!getHouses().equals(that.getHouses())) return false;
        if (!getSubdivision().equals(that.getSubdivision())) return false;
        if (!getCity().equals(that.getCity())) return false;
        if (!getTown().equals(that.getTown())) return false;
        if (!getMunicipality().equals(that.getMunicipality())) return false;
        if (!getCounty().equals(that.getCounty())) return false;
        if (!getLocalAdminArea().equals(that.getLocalAdminArea())) return false;
        if (!getCountyCode().equals(that.getCountyCode())) return false;
        if (!getStateDistrict().equals(that.getStateDistrict())) return false;
        if (!getPostCode().equals(that.getPostCode())) return false;
        if (!getState().equals(that.getState())) return false;
        if (!getProvince().equals(that.getProvince())) return false;
        if (!getStateCode().equals(that.getStateCode())) return false;
        if (!getRegion().equals(that.getRegion())) return false;
        if (!getCountry().equals(that.getCountry())) return false;
        if (!getCountryName().equals(that.getCountryName())) return false;
        if (!getCountryCode().equals(that.getCountryCode())) return false;
        if (!getContinent().equals(that.getContinent())) return false;
        return getComponents().equals(that.getComponents());
    }


    /**
     * Basic hashing algorithm to identify current object instance.
     * @return      Hashed value representing current instance.
     */
    @Override
    public int hashCode() {
        int result = getHouseNumber().hashCode();
        result = 31 * result + getStreetNumber().hashCode();
        result = 31 * result + getHouse().hashCode();
        result = 31 * result + getBuilding().hashCode();
        result = 31 * result + getPublicBuilding().hashCode();
        result = 31 * result + getRoad().hashCode();
        result = 31 * result + getFootway().hashCode();
        result = 31 * result + getStreet().hashCode();
        result = 31 * result + getStreetName().hashCode();
        result = 31 * result + getResidential().hashCode();
        result = 31 * result + getPath().hashCode();
        result = 31 * result + getPedestrian().hashCode();
        result = 31 * result + getRoadReference().hashCode();
        result = 31 * result + getRoadReferenceIntl().hashCode();
        result = 31 * result + getSquare().hashCode();
        result = 31 * result + getPlace().hashCode();
        result = 31 * result + getVillage().hashCode();
        result = 31 * result + getHamlet().hashCode();
        result = 31 * result + getLocality().hashCode();
        result = 31 * result + getCroft().hashCode();
        result = 31 * result + getNeighbourhood().hashCode();
        result = 31 * result + getSuburb().hashCode();
        result = 31 * result + getCityDistrict().hashCode();
        result = 31 * result + getDistrict().hashCode();
        result = 31 * result + getQuarter().hashCode();
        result = 31 * result + getCommercial().hashCode();
        result = 31 * result + getIndustrial().hashCode();
        result = 31 * result + getHouses().hashCode();
        result = 31 * result + getSubdivision().hashCode();
        result = 31 * result + getCity().hashCode();
        result = 31 * result + getTown().hashCode();
        result = 31 * result + getMunicipality().hashCode();
        result = 31 * result + getCounty().hashCode();
        result = 31 * result + getLocalAdminArea().hashCode();
        result = 31 * result + getCountyCode().hashCode();
        result = 31 * result + getStateDistrict().hashCode();
        result = 31 * result + getPostCode().hashCode();
        result = 31 * result + getState().hashCode();
        result = 31 * result + getProvince().hashCode();
        result = 31 * result + getStateCode().hashCode();
        result = 31 * result + getRegion().hashCode();
        result = 31 * result + getCountry().hashCode();
        result = 31 * result + getCountryName().hashCode();
        result = 31 * result + getCountryCode().hashCode();
        result = 31 * result + getContinent().hashCode();
        result = 31 * result + getComponents().hashCode();
        return result;
    }

    //endregion

    //region Private helpers
    //endregion

}

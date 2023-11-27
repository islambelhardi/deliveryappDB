public class Adress {
    String country, city, street;
    String postalCode;
    private GeoPosition geoPosition;

    public Adress(String country, String city, String street, String postalCode) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }

    public String toString() {
        return "Country: " + country + "\nCity: " + city + "\nStreet: " + street + "\nPostal Code: " + postalCode;
    }

    public String getWilayaCOde() {
        return postalCode.substring(0, 2);
    }

    public void setGeoPosition(GeoPosition geoPosition) {
        this.geoPosition = geoPosition;
    }
    public GeoPosition getGeoPosition() {
        return geoPosition;
    }
}

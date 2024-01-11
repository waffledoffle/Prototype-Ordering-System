package CSCI318.salesms.interfaces.rest.dto;

public class CustomerDTO {
    private String companyName;
    private String country;
    private String name;
    private String email;
    

    public CustomerDTO() {

    }
    
    public String getCName() {
        return companyName;
    }

    public void setCName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

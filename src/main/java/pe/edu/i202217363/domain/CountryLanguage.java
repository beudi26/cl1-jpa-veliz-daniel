package pe.edu.i202217363.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {
    @Id
    private String Language;
    private String IsOfficial;
    private Double Percentage;

    @Id
    @ManyToOne
    @JoinColumn(name = "CountryCode", nullable = false)
    private Country country;

    public CountryLanguage() {
    }

    public CountryLanguage(String language) {
        Language = language;
    }

    public CountryLanguage(String language, String isOfficial, Double percentage, Country country) {
        Language = language;
        IsOfficial = isOfficial;
        Percentage = percentage;
        this.country = country;
    }

    @Override
    public String toString() {
        return "CountryLanguage{" +
                "Language='" + Language + '\'' +
                ", IsOfficial='" + IsOfficial + '\'' +
                ", Percentage=" + Percentage +
                ", country=" + country +
                '}';
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getIsOfficial() {
        return IsOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        IsOfficial = isOfficial;
    }

    public Double getPercentage() {
        return Percentage;
    }

    public void setPercentage(Double percentage) {
        Percentage = percentage;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}

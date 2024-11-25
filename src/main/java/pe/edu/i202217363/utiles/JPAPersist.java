package pe.edu.i202217363.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;
import pe.edu.i202217363.domain.City;
import pe.edu.i202217363.domain.Country;
import pe.edu.i202217363.domain.CountryLanguage;
import pe.edu.i202217363.domain.LanguagePk;

import java.util.Arrays;

public class JPAPersist {

    @Transactional
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cl");
        EntityManager em = emf.createEntityManager();

        Country country = new Country("DVG","Imaginary","South America","South America",23000.00,1821,50000,70.5,630.0,616.0,"Imaginary","Republic","Daniel Veliz",4080,"VG",null,null);

        City city1 = new City(4080,"Imaginario","Ciudad1",31000,country);
        City city2 = new City(4081,"Imaginario2","Ciudad2",35000,country);
        City city3 = new City(4082,"Imaginario3","Ciudad3",4000,country);

        // Creamos las 2 lenguas para el país imaginario
        LanguagePk langPk1 = new LanguagePk("Spanish", "DVG");
        LanguagePk langPk2 = new LanguagePk("English", "DVG");

        CountryLanguage language1 = new CountryLanguage(langPk1,"T",88.0,country);
        CountryLanguage language2 = new CountryLanguage(langPk2,"T",53.0,country);

        //Referenciamos ciudades en paises
        country.setCiudades(Arrays.asList(city1,city2,city3));

        //Referenciamos lenguajes en paises
        country.setIdiomas(Arrays.asList(language1,language2));

        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}

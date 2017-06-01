/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllerBeans;

import hibernate.HibernateUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import model.Bus;
import model.City;
import model.Dromologio;
import model.Roles;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author user
 */
@ManagedBean(name = "dromologioManagedBean")
@ViewScoped
public class DromologioManagedBean implements Serializable {

    private List<Dromologio> dromologioList = new ArrayList();
    private Dromologio selectedDromologio; //epilogi apo to pinaka me xeraki
    private List<Dromologio> filteredDromologioList = new ArrayList();
    private Dromologio dromologioToInsert = new Dromologio();

    private List<City> cityAnaxorisiList = new ArrayList();
    private List<City> cityAfiksiList = new ArrayList();
    private List<Bus> busList = new ArrayList();

    private String cityAnaxorisiString;
    private String cityAfiksiString;
    private String busString;

    /**
     * Creates a new instance of UsersManagedBean
     */
    public DromologioManagedBean() {
    }

    @PostConstruct
    public void init() {

        loadTable();
    }

    public void loadTable() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            dromologioList = session.createCriteria(Dromologio.class).list();

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        filteredDromologioList = dromologioList;

    }

    public List<Dromologio> getDromologio() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            dromologioList = session.createCriteria(Dromologio.class).list();

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return dromologioList;

    }

    public List<City> getCityAnaxorisi() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            cityAnaxorisiList = session.createCriteria(City.class).list();

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return cityAnaxorisiList;

    }
    
    public List<City> getCityAfiksi() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            cityAfiksiList = session.createCriteria(City.class).list();

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return cityAfiksiList;

    }
    
    
    public List<Bus> getBus() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            busList = session.createCriteria(Bus.class).list();

            session.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return busList;

    }
    
    
    public void insert() throws IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            City cityAnaxorisi = new City();
            City cityAfiksi = new City();
            Bus bus = new Bus();

            String stringQueryCityAnaxorisi = "FROM City E WHERE E.cityName = :cityName";
            Query queryCityAnaxorisi = session.createQuery(stringQueryCityAnaxorisi);
            queryCityAnaxorisi.setParameter("cityName", cityAnaxorisiString);
            List<City> resultsCityAnaxorisi = queryCityAnaxorisi.list();
            cityAnaxorisi.setCityId(resultsCityAnaxorisi.get(0).getCityId());
            dromologioToInsert.setCityByCityIdAnaxorisi(cityAnaxorisi);

            String stringQueryCityAfiksi = "FROM City E WHERE E.cityName = :cityName";
            Query queryCityAfiksi = session.createQuery(stringQueryCityAfiksi);
            queryCityAfiksi.setParameter("cityName", cityAfiksiString);
            List<City> resultsCityAfiksi = queryCityAfiksi.list();
            cityAfiksi.setCityId(resultsCityAfiksi.get(0).getCityId());
            dromologioToInsert.setCityByCityIdAfiksi(cityAfiksi);

            String stringQueryBus = "FROM Bus E WHERE E.busArithmosKikloforias = :busArithmosKikloforias";
            Query queryBus = session.createQuery(stringQueryBus);
            queryBus.setParameter("busArithmosKikloforias", busString);
            List<Bus> resultsBus = queryBus.list();
            bus.setBusId(resultsBus.get(0).getBusId());
            dromologioToInsert.setBus(bus);

            session.save(dromologioToInsert);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();

        FacesContext.getCurrentInstance().getExternalContext().redirect("/JSFApp/dromologio/ViewDromologio.xhtml");

    }

    public void delete() throws IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            session.delete(selectedDromologio);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();

        FacesContext.getCurrentInstance().getExternalContext().redirect("/JSFApp/dromologio/ViewDromologio.xhtml");

    }

    //getters and setters
    public List<Dromologio> getDromologioList() {
        return dromologioList;
    }

    public void setDromologioList(List<Dromologio> dromologioList) {
        this.dromologioList = dromologioList;
    }

    public Dromologio getSelectedDromologio() {
        return selectedDromologio;
    }

    public void setSelectedDromologio(Dromologio selectedDromologio) {
        this.selectedDromologio = selectedDromologio;
    }

    public List<Dromologio> getFilteredDromologioList() {
        return filteredDromologioList;
    }

    public void setFilteredDromologioList(List<Dromologio> filteredDromologioList) {
        this.filteredDromologioList = filteredDromologioList;
    }

    public Dromologio getDromologioToInsert() {
        return dromologioToInsert;
    }

    public void setDromologioToInsert(Dromologio dromologioToInsert) {
        this.dromologioToInsert = dromologioToInsert;
    }

    public List<City> getCityAnaxorisiList() {
        return cityAnaxorisiList;
    }

    public void setCityAnaxorisiList(List<City> cityAnaxorisiList) {
        this.cityAnaxorisiList = cityAnaxorisiList;
    }

    public List<City> getCityAfiksiList() {
        return cityAfiksiList;
    }

    public void setCityAfiksiList(List<City> cityAfiksiList) {
        this.cityAfiksiList = cityAfiksiList;
    }

    public List<Bus> getBusList() {
        return busList;
    }

    public void setBusList(List<Bus> busList) {
        this.busList = busList;
    }

    public String getCityAnaxorisiString() {
        return cityAnaxorisiString;
    }

    public void setCityAnaxorisiString(String cityAnaxorisiString) {
        this.cityAnaxorisiString = cityAnaxorisiString;
    }

    public String getCityAfiksiString() {
        return cityAfiksiString;
    }

    public void setCityAfiksiString(String cityAfiksiString) {
        this.cityAfiksiString = cityAfiksiString;
    }

    public String getBusString() {
        return busString;
    }

    public void setBusString(String busString) {
        this.busString = busString;
    }

}

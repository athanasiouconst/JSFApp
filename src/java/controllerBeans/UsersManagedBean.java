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
import model.Roles;
import model.Users;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author costas
 */
@ManagedBean(name = "usersManagedBean")
@ViewScoped
public class UsersManagedBean implements Serializable {

    private List<Users> usersList = new ArrayList();
    private List<Roles> rolesList = new ArrayList();
    private Users selectedUser; //epilogi apo to pinaka me xeraki
    private List<Users> filteredUsersList = new ArrayList();
    private Users usersToInsert = new Users();
    private String rolesString;

    /**
     * Creates a new instance of UsersManagedBean
     */
    public UsersManagedBean() {
    }

    @PostConstruct
    public void init() {

        loadTable();
    }

    public void loadTable() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            usersList = session.createCriteria(Users.class).list();

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        filteredUsersList = usersList;

    }

    public List<Users> getUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            usersList = session.createCriteria(Users.class).list();

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return usersList;

    }

    public List<Roles> getRoles() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            rolesList = session.createCriteria(Roles.class).list();

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();
        return rolesList;

    }

    public void insert() throws IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Roles roles = new Roles();

            String stringQuery = "FROM Roles E WHERE E.roleName = :roleName";
            Query query = session.createQuery(stringQuery);
            query.setParameter("roleName", rolesString);
            List<Roles> results = query.list();
            
            roles.setRoleId(results.get(0).getRoleId());
            usersToInsert.setRoles(roles);
            session.save(usersToInsert);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();

        FacesContext.getCurrentInstance().getExternalContext().redirect("/JSFApp/user/ViewUsers.xhtml");

    }

    public void delete() throws IOException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();

            session.delete(selectedUser);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.close();

        FacesContext.getCurrentInstance().getExternalContext().redirect("/JSFApp/user/ViewUsers.xhtml");

    }

    //getters and setters
    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    public Users getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(Users selectedUser) {
        this.selectedUser = selectedUser;
    }

    public List<Users> getFilteredUsersList() {
        return filteredUsersList;
    }

    public void setFilteredUsersList(List<Users> filteredUsersList) {
        this.filteredUsersList = filteredUsersList;
    }

    public Users getUsersToInsert() {
        return usersToInsert;
    }

    public void setUsersToInsert(Users usersToInsert) {
        this.usersToInsert = usersToInsert;
    }

    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

    public String getRolesString() {
        return rolesString;
    }

    public void setRolesString(String rolesString) {
        this.rolesString = rolesString;
    }

}

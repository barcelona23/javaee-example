package com.arquitecturajava.dao;

public abstract class DAOAbstractFactory {

    public static DAOFactory getInstance() {
        String tipo="JPA";
        if (tipo.equals("Hibernate")) {
            //new DAOHibernateFactory();
            return null;
        } else {
            return new DAOJPAFactory();
        }
    }

}
package com.project2.imfd.utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
public class HibernateConnection {
	 private static StandardServiceRegistry registry;
	    private static SessionFactory sessionFactory;
	    private static Configuration config = null;
	    static String endp = System.getenv("DB_URL");
	    static String db = System.getenv("DB_Name");
	    static String user = System.getenv("DB_USER");
	    static String pass = System.getenv("DB_PASS");
	    static String url = endp+"/"+db;

	    public static SessionFactory getSessionFactory() {
	        if (sessionFactory == null) {
	            try {
	            	Properties prop = new Properties();
	            	prop.put(Environment.DRIVER, "org.postgresql.Driver");
	            	prop.put(Environment.URL, url);
	            	prop.put(Environment.USER, user);
	            	prop.put(Environment.PASS, pass);
	            	prop.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
	            	prop.put(Environment.SHOW_SQL, "true");
	            	prop.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
	            	prop.put(Environment.HBM2DDL_AUTO, "update");
	            	config= new Configuration();
	            	config.setProperties(prop);
	            	//add configured annotated classes below, using the following format.
	            	//config.addAnnotatedClass(com.project2.imfd.test.Test.class);
	            	
	                // Create SessionFactory
	                sessionFactory = config.buildSessionFactory();
	            } catch (Exception e) {
	                e.printStackTrace();
	                if (registry != null) {
	                    StandardServiceRegistryBuilder.destroy(registry);
	                }
	            }
	        }
	        return sessionFactory;
	    }
}

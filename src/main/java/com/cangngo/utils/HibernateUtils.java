package com.cangngo.utils;

import com.cangngo.model.LoaiSanPham;
import com.cangngo.model.SanPham;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtils {
	private final static SessionFactory FACTORY;
	static {
		Configuration conf = new Configuration();
		Properties pros = new Properties();
		pros.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
		pros.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
		pros.put(Environment.URL,
				"jdbc:sqlserver://localhost;databaseName=BANHANG;trustServerCertificate=true;encrypt=true;");
		pros.put(Environment.USER, "sa");
		pros.put(Environment.PASS, "123123");
		pros.put(Environment.SHOW_SQL, "true");
		pros.put(Environment.FORMAT_SQL, "true");
		pros.put(Environment.HBM2DDL_AUTO, "update");

		conf.setProperties(pros);
		conf.addAnnotatedClass(LoaiSanPham.class);
		conf.addAnnotatedClass(SanPham.class);

		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
		FACTORY = conf.buildSessionFactory(registry);
	}

	public static SessionFactory getSessionFactory() {
		return FACTORY;
	}
}

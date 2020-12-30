package com.example.birdspotter;

import domain.BirdSpecie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class BirdspotterApplication {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        try {
            persist(sessionFactory);
            load(sessionFactory);
        } finally {
            sessionFactory.close();
        }
        SpringApplication.run(BirdspotterApplication.class, args);
    }

    private static void load(SessionFactory sessionFactory) {
        System.out.println("-- loading persons --");
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<BirdSpecie> persons = session.createQuery("FROM BirdSpecie").list();
        persons.forEach((x) -> System.out.printf("- %s%n", x));
        session.close();
    }

    private static void persist(SessionFactory sessionFactory) {
        BirdSpecie p1 = new BirdSpecie("Test bird one");
        BirdSpecie p2 = new BirdSpecie("Test bird two");
        System.out.println("-- persisting persons --");
        System.out.printf("- %s%n- %s%n", p1, p2);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(p1);
        session.save(p2);
        session.getTransaction().commit();
    }
}

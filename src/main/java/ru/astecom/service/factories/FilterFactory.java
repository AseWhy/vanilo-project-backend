package ru.astecom.service.factories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.hibernate.SessionFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;
import paa.coder.noodleCriteriaBuilder.NoodleFactory;
import paa.coder.noodleCriteriaBuilder.springAdapters.EnableNoodleFilter;

@Service
@EnableNoodleFilter
public class FilterFactory implements NoodleFactory {
    private final ObjectMapper objectMapper;
    private final LocalSessionFactoryBean sessionFactory;

    public FilterFactory(@NotNull ObjectMapper objectMapper, LocalSessionFactoryBean sessionFactory){
        this.objectMapper = objectMapper.copy().registerModule(new Hibernate5Module());;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public SessionFactory sessionFactory(){
        return sessionFactory.getObject();
    }

    @Override
    public ObjectMapper getObjectMapper(){
        return objectMapper;
    }
}
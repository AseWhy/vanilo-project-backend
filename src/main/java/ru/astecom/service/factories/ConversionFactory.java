package ru.astecom.service.factories;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.asewhy.conversions.ConversionStore;
import io.github.asewhy.conversions.support.annotations.EnableConversions;
import io.github.asewhy.conversions.support.iConversionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import paa.coder.noodleCriteriaBuilder.restFilter.payloads.RestFilter;
import paa.coder.noodleCriteriaBuilder.restFilter.payloads.RestOrder;
import paa.coder.noodleCriteriaBuilder.restFilter.payloads.RestPage;
import ru.astecom.service.factories.support.ConversionFactoryContext;

import java.util.Map;
import java.util.Set;

@Service
@EnableConversions
public class ConversionFactory implements iConversionFactory {
    @Autowired
    protected ObjectMapper objectMapper;
    @Autowired
    protected ConversionFactoryContext conversionFactoryContext;
    @Autowired
    protected ApplicationContext context;

    @Override
    public ConversionStore provideStore() {
        var store = new ConversionStore(context);
        store.from("ru.astecom.DTO", getClass().getClassLoader());
        return store;
    }

    @Override
    public ObjectMapper provideObjectMapper() {
        return objectMapper.copy().setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Override
    public Map<Class<?>, Set<String>> provideExcludes() {
        var excludes = iConversionFactory.super.provideExcludes();
        var anySet = Set.of(ANY);

        excludes.put(RestFilter.class, anySet);
        excludes.put(RestPage.class, anySet);
        excludes.put(RestOrder.class, anySet);

        return excludes;
    }

    @Override
    public ConversionFactoryContext provideContext() {
        return conversionFactoryContext;
    }
}
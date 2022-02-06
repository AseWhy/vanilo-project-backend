package ru.astecom.service.factories.support.converters;

import io.github.asewhy.conversions.ConversionProvider;
import io.github.asewhy.conversions.ConversionResolver;
import io.github.asewhy.conversions.support.annotations.DataResolver;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import paa.coder.noodleCriteriaBuilder.restFilter.payloads.RestPage;

import java.lang.reflect.Type;

@Component
@DataResolver
public class RestPageResponseResolver extends ConversionResolver<RestPage<?>> {
    @Override
    protected RestPage<?> resolveInternalResponse(
        @NotNull RestPage<?> restPage,
        Class<? extends RestPage<?>> aClass,
        @NotNull ConversionProvider conversionProvider,
        String s
    ) {
        return restPage.map(conversionProvider::createResponse);
    }

    @Override
    protected boolean canProcess(Class<?> from, Type generics, ConversionProvider provider, String mapping) {
        return RestPage.class.isAssignableFrom(from);
    }
}

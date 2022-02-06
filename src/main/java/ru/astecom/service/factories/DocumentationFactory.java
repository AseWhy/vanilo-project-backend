package ru.astecom.service.factories;

import io.github.asewhy.apidoc.annotations.EnableApiDocGeneration;
import io.github.asewhy.apidoc.beans.DocumentedApi;
import io.github.asewhy.apidoc.iApiDocumentationFactory;
import io.github.asewhy.apidoc.support.interfaces.iDocumentedApi;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@EnableApiDocGeneration
@Profile({ "dev", "beta", "test" })
public class DocumentationFactory implements iApiDocumentationFactory {
    @Value("${spring.application.name}")
    protected String appName;

    @Override
    public iDocumentedApi provideDocApi() {
        return new DocumentedApi(appName);
    }

    @Override
    public void afterApiInitialize(@NotNull iDocumentedApi iDocumentedApi) {
        // STUB
    }
}

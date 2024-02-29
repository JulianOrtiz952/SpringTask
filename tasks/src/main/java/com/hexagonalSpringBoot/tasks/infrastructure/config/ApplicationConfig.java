package com.hexagonalSpringBoot.tasks.infrastructure.config;

import com.hexagonalSpringBoot.tasks.application.services.TaskService;
import com.hexagonalSpringBoot.tasks.application.usecases.*;
import com.hexagonalSpringBoot.tasks.domain.ports.in.GetAdditionalTaskUseCase;
import com.hexagonalSpringBoot.tasks.domain.ports.out.ExternalServicesPort;
import com.hexagonalSpringBoot.tasks.domain.ports.out.TaskRepositoryPort;
import com.hexagonalSpringBoot.tasks.infrastructure.adapters.ExternalServiceAdapter;
import com.hexagonalSpringBoot.tasks.infrastructure.persistences.repositories.JPATaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskUseCase getAdditionalTaskUseCase) {
        return new TaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                new RetrieveTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                getAdditionalTaskUseCase
                );
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JPATaskRepositoryAdapter jpaTaskRepositoryAdapter){
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskUseCase getAdditionalTaskUseCase(ExternalServicesPort externalServicesPort){
        return new GetAdditionalTaskUseCaseImpl(externalServicesPort);
    }

    @Bean
    public ExternalServicesPort externalServicesPort(){
        return new ExternalServiceAdapter();
    }

}

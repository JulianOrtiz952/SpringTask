package com.hexagonalSpringBoot.tasks.application.usecases;

import com.hexagonalSpringBoot.tasks.domain.models.AdditionalTaskInfo;
import com.hexagonalSpringBoot.tasks.domain.ports.in.GetAdditionalTaskUseCase;
import com.hexagonalSpringBoot.tasks.domain.ports.out.ExternalServicesPort;

public class GetAdditionalTaskUseCaseImpl implements GetAdditionalTaskUseCase {
    private final ExternalServicesPort externalServicesPort;

    public GetAdditionalTaskUseCaseImpl(ExternalServicesPort externalServicesPort) {
        this.externalServicesPort = externalServicesPort;
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return externalServicesPort.getAdditionalTaskInfo(id);
    }
}

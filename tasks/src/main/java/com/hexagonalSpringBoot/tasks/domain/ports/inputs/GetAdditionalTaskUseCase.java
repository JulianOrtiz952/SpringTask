package com.hexagonalSpringBoot.tasks.domain.ports.inputs;


import com.hexagonalSpringBoot.tasks.domain.models.AdditionalTaskInfo;

public interface GetAdditionalTaskUseCase {
    AdditionalTaskInfo getAdditionalTaskInfo(Long id);

}

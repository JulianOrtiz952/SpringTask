package com.hexagonalSpringBoot.tasks.domain.ports.in;


import com.hexagonalSpringBoot.tasks.domain.models.AdditionalTaskInfo;

public interface GetAdditionalTaskUseCase {
    AdditionalTaskInfo getAdditionalTaskInfo(Long id);

}

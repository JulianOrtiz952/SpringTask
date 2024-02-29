package com.hexagonalSpringBoot.tasks.domain.ports.out;

import com.hexagonalSpringBoot.tasks.domain.models.AdditionalTaskInfo;

public interface ExternalServicesPort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}

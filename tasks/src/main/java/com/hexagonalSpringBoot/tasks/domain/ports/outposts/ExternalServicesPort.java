package com.hexagonalSpringBoot.tasks.domain.ports.outposts;

import com.hexagonalSpringBoot.tasks.domain.models.AdditionalTaskInfo;

public interface ExternalServicesPort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}

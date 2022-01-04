package org.github.foxnic.web.domain.job;

import com.github.foxnic.api.transter.Result;

public interface JobExecuter {
    String getName();
    Result execute(Job job);
}

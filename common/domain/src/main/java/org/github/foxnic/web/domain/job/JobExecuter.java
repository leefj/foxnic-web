package org.github.foxnic.web.domain.job;

import com.alibaba.fastjson.JSONObject;
import com.github.foxnic.api.transter.Result;

public interface JobExecuter {
    String getName();
    Result execute(Object context,Job job, JSONObject methodParams);
}

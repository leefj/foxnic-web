package com.scientific.tailoring.framework.feign;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.cloud.nacos.ribbon.NacosRule;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import com.netflix.loadbalancer.ZoneAvoidanceRule;

public enum FeignLoadBalanceRule {

	RANDOM(RandomRule.class),
	NACOS(NacosRule.class),
	RETRY(RetryRule.class),
	ROUND_ROBIN(RoundRobinRule.class),
	WEIGHTED_RESPONSE_TIME(WeightedResponseTimeRule.class),
	BEST_AVAILABLE(BestAvailableRule.class),
	AVAILABILITY_FILTERING(AvailabilityFilteringRule.class),
	ZONE_AVOIDANCE(ZoneAvoidanceRule.class)
	;
	
	private Class<? extends AbstractLoadBalancerRule> rule;
 
	public AbstractLoadBalancerRule getRule() {
		try {
			return rule.newInstance();
		} catch (Exception e) {
			return new NacosRule(); 
		}  
	}

	private FeignLoadBalanceRule(Class<? extends AbstractLoadBalancerRule>  rule) {
		this.rule=rule;
	}
	
	public static FeignLoadBalanceRule parse(String rule) {
		if(StringUtils.isBlank(rule)) return NACOS;
		rule=rule.trim().toUpperCase();
		FeignLoadBalanceRule fbRule=NACOS;
		try {
			fbRule=FeignLoadBalanceRule.valueOf(rule);
		} catch (Exception e) {
			fbRule=NACOS;
		}
		return fbRule;
	}
	
	
}

package org.github.foxnic.web.framework.cluster;

import com.github.foxnic.commons.encrypt.MD5Util;
import com.github.foxnic.commons.lang.DataParser;
import com.github.foxnic.springboot.spring.SpringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClusterConfig {

    public class ServiceCluster {
        private String name=null;
        private Boolean enable=true;
        private List<EndPoint> endPoints=new ArrayList<>();
        private Long hits=0L;

        private void hit() {
            this.hits++;
        }

        public Long getHits() {
            return hits;
        }

        public ServiceCluster(String name) {
            this.name=name;
            this.endPoints=endPoints;
        }

        /**
         * 按权重获得节点
         * */
        public EndPoint getEndPoint() {
            int i=0;
            Double r=0.0;
            EndPoint ep=null;
            for (EndPoint endPoint : endPoints) {
                r=(0.0+endPoint.getHits())/this.getHits();
                if(r<=endPoint.getRate()) {
                    ep=endPoint;
                    break;
                }
            }
            if(ep==null) ep=endPoints.get(0);
            ep.hit();
            this.hit();
            return ep;
        }

        public void addEndPoint(String url,Integer weight) {
            this.endPoints.add(new EndPoint(url,weight));
            Double total=0.0;
            for (EndPoint endPoint : endPoints) {
                total+=endPoint.getWeight();
            }
            for (EndPoint endPoint : endPoints) {
                 endPoint.setRate(endPoint.getWeight()/total);
            }
        }

        public Boolean getEnable() {
            return enable;
        }

        public void setEnable(Boolean enable) {
            this.enable = enable;
        }


    }

    public class EndPoint {

        private Long hits=0L;
        private String url;
        private Integer weight;
        private Double rate = null;

        public EndPoint(String url,Integer weight) {
            this.url=url;
            this.weight=weight;
        }

        public String getUrl() {
            return url;
        }

        public Integer getWeight() {
            return weight;
        }

        public void hit() {
            hits++;
        }

        public Long getHits() {
            return hits;
        }



        public Double getRate() {
            return rate;
        }

        public void setRate(Double rate) {
            this.rate = rate;
        }
    }


    private  String key=null;
    private Map<String, ServiceCluster> configs=new HashMap<>();

    public ClusterConfig() {
        // 获得配置
        this.key = SpringUtil.getEnvProperty("foxnic.cluster.key");
        if(this.key==null) return;
        // 加密 key
        for (int i = 0; i < 4; i++) {
            this.key= MD5Util.encrypt32(this.key);
        }
        //
        Map<String,Object> cfgs= SpringUtil.getEnvProperties("foxnic.cluster.service",true);

        // 解析配置
        for (String key : cfgs.keySet()) {
            String prefix=key.split("\\.")[0];
            if(!configs.keySet().contains(prefix)) {
                configs.put(prefix, new ServiceCluster(prefix));
            }
        }

        for (Map.Entry<String, ServiceCluster> entry : configs.entrySet()) {
            Boolean enable= DataParser.parseBoolean(cfgs.get(entry.getKey()+".enable"));
            if(enable==null) enable=true;
            entry.getValue().setEnable(enable);
            String eps=DataParser.parseString(cfgs.get(entry.getKey()+".end-points"));
            if(eps==null) {
                continue;
            }
            String[] epArr=eps.split("\\|");
            for (String s : epArr) {
                String[] tmp=s.split(",");
                String url=tmp[0];
                Integer weight=1;
                if(tmp.length>1) {
                    weight=DataParser.parseInteger(tmp[1]);
                }
                entry.getValue().addEndPoint(url.trim(),weight);
            }
        }
    }

    public EndPoint getEndPoint(String prefix) {
        ServiceCluster serviceCluster=configs.get(prefix);
        if(serviceCluster==null) {
            throw new IllegalArgumentException("集群节点 "+prefix+" 未配置");
        }
        if(!serviceCluster.getEnable()) {
            throw new IllegalArgumentException("集群节点 "+prefix+" 不可用");
        }
        return serviceCluster.getEndPoint();
    }

    public String getKey() {
        return key;
    }
}

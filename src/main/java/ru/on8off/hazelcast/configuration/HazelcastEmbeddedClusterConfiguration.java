package ru.on8off.hazelcast.configuration;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "hazelcast.embedded-cluster.enable", havingValue = "true")
@Slf4j
public class HazelcastEmbeddedClusterConfiguration {
    @Value("${hazelcast.embedded-cluster.name}")
    private String clusterName;
    @Value("${hazelcast.embedded-cluster.member.name}")
    private String memberName;
    @Value("${hazelcast.embedded-cluster.member.address}")
    private String memberAddress;
    @Value("${hazelcast.embedded-cluster.member.port}")
    private Integer memberPort;
    @Value("${hazelcast.embedded-cluster.members}")
    private String members;



    public Config config(){
        log.info("Configure member: {}", memberName);
        var config = new Config();
        config.setClusterName(clusterName);
        config.setInstanceName(memberName);
        var network = config.getNetworkConfig();
        network.setPort(memberPort).setPortAutoIncrement(false);
//        network.setPublicAddress(memberAddress);
        var join = network.getJoin();
        join.getMulticastConfig().setEnabled(false);
        join.getAutoDetectionConfig().setEnabled(false);
        if(members != null && !memberAddress.isEmpty()){
            join.getTcpIpConfig().addMember(members).setEnabled(true);
        }
        return config;
    }

    @Bean
    public HazelcastInstance hazelcastInstance(){
        return Hazelcast.newHazelcastInstance(config());
    }
}

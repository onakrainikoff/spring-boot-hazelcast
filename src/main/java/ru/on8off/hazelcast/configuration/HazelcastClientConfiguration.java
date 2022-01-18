//package ru.on8off.hazelcast.configuration;
//
//import com.hazelcast.config.Config;
//import com.hazelcast.core.Hazelcast;
//import com.hazelcast.core.HazelcastInstance;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class HazelcastClientConfiguration {
//
//    public Config config(){
//        var config = new Config();
//        var network = config.getNetworkConfig();
//        network.setPort(5701).setPortCount(20);
//        network.setPortAutoIncrement(true);
//        var join = network.getJoin();
//        join.getMulticastConfig().setEnabled(false);
//        join.getTcpIpConfig()
//                .addMember("machine1")
//                .addMember("localhost").setEnabled(true);
//        return config;
//    }
//
//    @Bean
//    public HazelcastInstance hazelcastInstance(){
//        return Hazelcast.newHazelcastInstance(config());
//    }
//}

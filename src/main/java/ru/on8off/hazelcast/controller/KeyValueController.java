package ru.on8off.hazelcast.controller;

import com.hazelcast.core.HazelcastInstance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentMap;

@RestController
@Slf4j
public class KeyValueController {
    @Autowired
    private HazelcastInstance hazelcastInstance;

    private ConcurrentMap<String,String> retrieveMap() {
        return hazelcastInstance.getMap("map");
    }

    @PostMapping("/put")
    public void put(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value) {
        log.info("POST /put: key={}, value={}", key, value);
        retrieveMap().put(key, value);
    }

    @GetMapping("/get")
    public String get(@RequestParam(value = "key") String key) {
        log.info("GET /get: key={}", key);
        String value = retrieveMap().get(key);
        log.info("response: {}", value);
        return value;
    }
}

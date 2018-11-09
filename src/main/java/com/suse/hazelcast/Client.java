package com.suse.hazelcast;

import java.util.Map;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.GroupConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class Client {

    public static void main(String[] args) {
        final ClientConfig config = new ClientConfig();
        final GroupConfig groupConfig = config.getGroupConfig();
        //default username & password
        groupConfig.setName("dev");
        groupConfig.setPassword("dev-pass");
        HazelcastInstance hazelcastInstanceClient = HazelcastClient.newHazelcastClient(config);
        IMap<Long, String> map = hazelcastInstanceClient.getMap("sample");
        for (Map.Entry<Long, String> entry : map.entrySet()) {
            System.out.println(String.format("Key: %d, Value: %s", entry.getKey(), entry.getValue()));
        }
    }
}

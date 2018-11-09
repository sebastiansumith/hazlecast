package com.suse.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.IdGenerator;

public class ServerNode {


    public static void main(String[] args) {
        final HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
        final IdGenerator idGenerator = hazelcastInstance.getIdGenerator("newId");
        final IMap<Long, String> sharedMap = hazelcastInstance.getMap("sample");
        for(int i=0; i<10; i++){
            sharedMap.put(idGenerator.newId(), "message "+ i);
        }
    }
}

package com.rundeck.plugins;

import com.dtolabs.rundeck.core.common.INodeEntry;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class RunningJobsOnNodeRepository {

    private static final RunningJobsOnNodeRepository single_instance = new RunningJobsOnNodeRepository();

    private Map<String, Set<String>> map;

    public RunningJobsOnNodeRepository() {
        map = new ConcurrentHashMap<>();
    }

    private String toKey(INodeEntry node) {
        return node.getFrameworkProject() + "-" + node.getNodename();
    }

    public synchronized void addJob(Collection<INodeEntry> nodes, String jobId) {
        for (INodeEntry node : nodes) {
            map.computeIfAbsent(toKey(node), (k) -> new CopyOnWriteArraySet<>()).add(jobId);
        }
    }

    public synchronized void removeJob(Collection<INodeEntry> nodes, String jobId) {
        for (INodeEntry node : nodes) {
            map.computeIfAbsent(toKey(node), (k) -> new CopyOnWriteArraySet<>()).remove(jobId);
        }
    }

    public int jobCount(INodeEntry node) {
        return Optional.ofNullable(map.get(toKey(node))).map(Set::size).orElse(0);
    }

    public static RunningJobsOnNodeRepository getInstance() {
        return single_instance;
    }
}

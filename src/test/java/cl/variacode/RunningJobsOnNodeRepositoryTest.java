package cl.variacode;

import com.dtolabs.rundeck.core.common.INodeEntry;
import com.dtolabs.rundeck.core.common.NodeEntryImpl;
import com.google.common.collect.Lists;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.llorllale.cactoos.matchers.RunsInThreads;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

public class RunningJobsOnNodeRepositoryTest {
    @Test
    public void addJobAndJobCount() {
        RunningJobsOnNodeRepository repository = new RunningJobsOnNodeRepository();
        NodeEntryImpl node1 = new NodeEntryImpl();
        node1.setFrameworkProject("1");
        node1.setNodename("1");
        NodeEntryImpl node2 = new NodeEntryImpl();
        node1.setFrameworkProject("2");
        node1.setNodename("2");
        NodeEntryImpl node3 = new NodeEntryImpl();
        node1.setFrameworkProject("1");
        node1.setNodename("2");
        Collection<INodeEntry> nodes = Lists.newArrayList(node1, node2, node3);

        MatcherAssert.assertThat(
                t -> {
                    int i = t.getAndIncrement();
                    Long obj = Long.valueOf(i);
                    repository.addJob(nodes, i + "");
                    Thread.sleep(i * 100);
                    repository.removeJob(nodes, i + "");
                    Long aLong = repository.jobCount(node1);
                    System.out.println(aLong + "," + obj + "," + i);
                    return aLong.equals(10 - obj - 1);
                },
                new RunsInThreads<>(new AtomicInteger(), 10)
        );
    }
}
package com.rundeck.plugins;

import com.dtolabs.rundeck.core.plugins.Plugin;
import com.dtolabs.rundeck.plugins.ServiceNameConstants;
import com.dtolabs.rundeck.plugins.descriptions.PluginDescription;
import com.dtolabs.rundeck.plugins.nodes.IModifiableNodeEntry;
import com.dtolabs.rundeck.plugins.nodes.NodeEnhancerPlugin;

@PluginDescription(
        title = "Add count of running jobs",
        description = "Adds a 'running-jobs' attribute in each node, with the count statistic kept by the 'Keep count of running jobs on each node' execution plugin."
)
@Plugin(name = "RunningJobsOnNodeEnhancerPlugin", service = ServiceNameConstants.NodeEnhancer)
public class RunningJobsOnNodeEnhancerPlugin implements NodeEnhancerPlugin {
    @Override
    public void updateNode(String project, IModifiableNodeEntry node) {
        node.addAttribute("running-jobs", "" + RunningJobsOnNodeRepository.getInstance().jobCount(node));
    }
}

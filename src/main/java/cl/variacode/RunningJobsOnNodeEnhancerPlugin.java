package cl.variacode;

import com.dtolabs.rundeck.core.plugins.Plugin;
import com.dtolabs.rundeck.plugins.ServiceNameConstants;
import com.dtolabs.rundeck.plugins.nodes.IModifiableNodeEntry;
import com.dtolabs.rundeck.plugins.nodes.NodeEnhancerPlugin;

@Plugin(name = "cl.variacode.RunningJobsOnNodeEnhancerPlugin", service = ServiceNameConstants.NodeEnhancer)
public class RunningJobsOnNodeEnhancerPlugin implements NodeEnhancerPlugin {
    @Override
    public void updateNode(String project, IModifiableNodeEntry node) {
        node.addAttribute("running-jobs", "" + RunningJobsOnNodeRepository.getInstance().jobCount(node));
    }
}

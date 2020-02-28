package com.rundeck.plugins;

import com.dtolabs.rundeck.core.execution.ExecutionLifecyclePluginException;
import com.dtolabs.rundeck.core.jobs.ExecutionLifecycleStatus;
import com.dtolabs.rundeck.core.jobs.JobExecutionEvent;
import com.dtolabs.rundeck.core.plugins.Plugin;
import com.dtolabs.rundeck.plugins.ServiceNameConstants;
import com.dtolabs.rundeck.plugins.descriptions.PluginDescription;
import com.dtolabs.rundeck.plugins.jobs.ExecutionLifecyclePlugin;

@PluginDescription(
        title = "Running Jobs on Node Lifecycle Plugin",
        description = "Updates 'running-jobs' attribute in nodes"
)
@Plugin(name = "RunningJobsOnNodeExecutionLifecyclePlugin", service = ServiceNameConstants.ExecutionLifecycle)
public class RunningJobsOnNodeExecutionLifecyclePlugin implements ExecutionLifecyclePlugin {

    @Override
    public ExecutionLifecycleStatus beforeJobStarts(JobExecutionEvent event) throws ExecutionLifecyclePluginException {
        RunningJobsOnNodeRepository.getInstance().addJob(event.getNodes().getNodes(), event.getExecutionId());
        return null;
    }

    @Override
    public ExecutionLifecycleStatus afterJobEnds(JobExecutionEvent event) throws ExecutionLifecyclePluginException {
        RunningJobsOnNodeRepository.getInstance().removeJob(event.getNodes().getNodes(), event.getExecutionId());
        return null;
    }
}

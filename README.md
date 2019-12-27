# Rundeck Running Jobs on Node Plugin
This plugin provides a way to obtain the number of running jobs on a node.

Installation
-------------------------
See the [Included Plugins | Rundeck Documentation](http://rundeck.org/docs/plugins-user-guide/installing.html#included-plugins "Included Plugins") for more information on installing rundeck plugins.

## Build
1. Build from source using gradle with `./gradlew build`.
2. Copy jarfile to `$RDECK_BASE/libext`

## Configuration
- Enable the `RunningJobsOnNodeEnhancerPlugin` Node Enhancer Plugin under the `Edit Nodes` configuration screen. 
- Enable the `RunningJobsOnNodeExecutionLifecyclePlugin` Execution Plugin on every job configuration.

## Usage
Check the nodes list for the `running-jobs` attribute.

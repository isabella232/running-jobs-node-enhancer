# Rundeck Running Jobs on Node Plugin

This plugin set provides a way to track the number of running jobs on each node, and add this stat to node attributes.

## Usage

- After installing the plugin, go to the `Edit Nodes...` section under the `Project Settings` menu, and select the the `Enhancers` tab.

![Enhancers Tab](doc/1.png)

- Click on `Add new Node Enhancer`. Select the `Add count of running jobs` enhancer, and click `Save`.

![Adding node enhancer](doc/2.png)

- Go to the job edition page on each job you want to enable tracking, and enable the `Keep count of running jobs on each node` option under the `Execution Plugins` tab. Save the job.

![Adding execution plugin](doc/3.png)

- You will now find the `running-jobs` attribute available on all nodes, with the count of currently running jobs.

![Attribute available](doc/4.png)

## Building and Installing

To build the plugin, run the gradle build command:
```
./gradlew clean build
```
The resulting artifact will be found at `build/libs/running-jobs-node-enhancer-VERSION.jar`

For installing, copy the jar artifact to $RDBASE/libext directory of your rundeck installation.

See the [Included Plugins | Rundeck Documentation](http://rundeck.org/docs/plugins-user-guide/installing.html#included-plugins "Included Plugins") for more information on installing rundeck plugins.


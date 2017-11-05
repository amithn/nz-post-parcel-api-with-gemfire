#### Instructions for setting up Gemfire locally 

* Download Gemfire from the Pivotal network here  https://network.pivotal.io/
* Save it in the directory nz-post-parcel-api-with-gemfire/gemfire/ in the checked out repository folders. 
* Unzip the zip file in the same directory, after the unzipping you should have a path like - nz-post-parcel-api-with-gemfire/gemfire/pivotal-gemfire-9.0.3/ (this is assuming you have downloaded pivotal-gemfire-9.0.3 from Pivotal Network)
* Change directory into the scripts directory in the checked out code - nz-post-parcel-api-with-gemfire/scripts 
* Start the servers by running ./start_nzposts.sh in the scripts directory. 
* You should now see the screen showing the following output
! 

**Instructions for setting up Gemfire locally**

* Download Gemfire from the Pivotal network here https://network.pivotal.io/
* Save it in the directory nz-post-parcel-api-with-gemfire/gemfire/ in the checked out repository folders.
* Unzip the zip file in the same directory, after the unzipping you should have a path like - nz-post-parcel-api-with-gemfire/gemfire/pivotal-gemfire-9.0.3/ (this is assuming you have downloaded pivotal-gemfire-9.0.3 from Pivotal Network)
* Change directory into the scripts directory in the checked out code - nz-post-parcel-api-with-gemfire/scripts
* Start the servers by running ./start_nzposts.sh in the scripts directory.
* You should now see the screen showing the following output like below:

anambiar@pivotal ~/testbed/nz-post-parcel-api/scripts$ ./start_nzpost.sh 
    _________________________     __
   / _____/ ______/ ______/ /____/ /
  / /  __/ /___  /_____  / _____  / 
 / /__/ / ____/  _____/ / /    / /  
/______/_/      /______/_/    /_/    9.0.3

Monitor and Manage Pivotal GemFire
gfsh>
gfsh>start locator --name=loc1
Starting a Geode Locator in /Users/anambiar/testbed/nz-post-parcel-api/gemfire/pivotal-gemfire-9.0.3/bin/loc1...
...
Locator in /Users/anambiar/testbed/nz-post-parcel-api/gemfire/pivotal-gemfire-9.0.3/bin/loc1 on 10.1.1.3[10334] as loc1 is currently online.
Process ID: 5090
Uptime: 3 seconds
GemFire Version: 9.0.3
Java Version: 1.8.0_73
Log File: /Users/anambiar/testbed/nz-post-parcel-api/gemfire/pivotal-gemfire-9.0.3/bin/loc1/loc1.log
JVM Arguments: -Dgemfire.enable-cluster-configuration=true -Dgemfire.load-cluster-configuration-from-dir=false -Dgemfire.launcher.registerSignalHandlers=true -Djava.awt.headless=true -Dsun.rmi.dgc.server.gcInterval=9223372036854775806
Class-Path: /Users/anambiar/testbed/nz-post-parcel-api/gemfire/pivotal-gemfire-9.0.3/lib/geode-core-9.0.3.jar:/Users/anambiar/testbed/nz-post-parcel-api/gemfire/pivotal-gemfire-9.0.3/lib/geode-dependencies.jar

Successfully connected to: JMX Manager [host=10.1.1.3, port=1099]

Cluster configuration service is up and running. </p>

* Login to the local Gemfire cluster:
gfsh>connect
Connecting to Locator at [host=localhost, port=10334] ..
Connecting to Manager at [host=10.1.1.3, port=1099] ..
Successfully connected to: [host=10.1.1.3, port=1099]

gfsh>list member
Command "list member" is not valid.
gfsh>list members
 Name   | Id
------- | ----------------------------------------
loc1    | 10.1.1.3(loc1:5090:locator)<ec><v0>:1024
nzpost1 | 10.1.1.3(nzpost1:5093)<v1>:1025
nzpost2 | 10.1.1.3(nzpost2:5096)<v2>:1026

gfsh>list regions 
List of regions
---------------
parcels






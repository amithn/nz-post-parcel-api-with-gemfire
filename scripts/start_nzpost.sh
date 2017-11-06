#!/bin/bash

ps aux | grep geode | grep -v grep | awk '{ print $2 }' | xargs kill 

cd ../gemfire/pivotal-gemfire-9.1.1/bin
rm -f loc1/vf.gf.locator.pid

./gfsh <<!

start locator --name=loc1

connect --locator=localhost[10334]

stop server --name=nzpost1

start server --name=nzpost1 --group=PARCELS --cache-xml-file=../../../conf/parcels.xml --J=-Xmx2G --log-level=info --J=-Xdebug --J="-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005"

stop server --name=nzpost2

start server --name=nzpost2 --group=PARCELS --cache-xml-file=../../../conf/parcels.xml --classpath=/Users/anambiar/testbed/dui-upload/build/classes/main --J=-Xmx2G --log-level=debug --server-port=40407

destroy index --name=trackingRefIdx
create index --name=trackingRefIdx --region=/parcels --expression=trackingReference --type=range

!


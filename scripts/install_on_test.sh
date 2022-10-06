#!/bin/bash

# remove old version
rm -R /home/marcin/applications/czerniakowskie-lake/app/bin
rm -R /home/marcin/applications/czerniakowskie-lake/app/lib
rm /home/marcin/applications/czerniakowskie-lake/app.zip

# installation of the application
cp /home/marcin/actions-runner/_work/czerniakowskie-lake/czerniakowskie-lake/app/build/distributions/app.zip /home/marcin/applications/czerniakowskie-lake/
cd /home/marcin/applications/czerniakowskie-lake/ && unzip app.zip

# stopping currently running application
echo "Stopping the czerniakowskie-lake app..."
_old_pid = "/home/marcin/applications/czerniakowskie-lake/pid.pid"
kill ${_old_pid}

# running the application
echo "Starting Linux/Unix czerniakowskie-lake app..."
cd /home/marcin/applications/czerniakowskie-lake/app/bin && ./app &
_pid=$!
echo "$_pid" > /home/marcin/applications/czerniakowskie-lake/pid.pid
echo "Pid $_pid stored in /var/run/awesome-app.pid"
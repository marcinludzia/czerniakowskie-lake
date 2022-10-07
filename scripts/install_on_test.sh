#!/bin/bash

# stopping currently running application
echo "Stopping the czerniakowskie-lake app..."
kill $(ps -ef | grep '/home/marcin/applications/czerniakowskie-lake/app/lib/app.jar' | grep -v 'grep' | awk '{printf $2}')

# remove old version
echo "Removing old version of the application..."
rm -R /home/marcin/applications/czerniakowskie-lake/app/bin
rm -R /home/marcin/applications/czerniakowskie-lake/app/lib
rm /home/marcin/applications/czerniakowskie-lake/app.zip

# installation of the application
echo "Installing new version of the czerniakowskie-lake app..."
cp /home/marcin/actions-runner/_work/czerniakowskie-lake/czerniakowskie-lake/app/build/distributions/app.zip /home/marcin/applications/czerniakowskie-lake/
cd /home/marcin/applications/czerniakowskie-lake/ && unzip app.zip
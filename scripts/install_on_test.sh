# remove old version
rm -R /home/marcin/applications/czerniakowskie-lake/app/bin
rm -R /home/marcin/applications/czerniakowskie-lake/app/lib
rm /home/marcin/applications/czerniakowskie-lake/app.zip

# installation of the application
cp /home/marcin/actions-runner/_work/czerniakowskie-lake/czerniakowskie-lake/app/build/distributions/app.zip /home/marcin/applications/czerniakowskie-lake/
cd /home/marcin/applications/czerniakowskie-lake/ && unzip app.zip

# running the application
cd /home/marcin/applications/czerniakowskie-lake/app/bin && ./app
rm -R /home/marcin/applications/czerniakowskie-lake/*
cp /home/marcin/actions-runner/_work/czerniakowskie-lake/czerniakowskie-lake/app/build/distributions/app.zip /home/marcin/applications/czerniakowskie-lake/
cd /home/marcin/applications/czerniakowskie-lake/ && unzip app.zip
cd /home/marcin/applications/czerniakowskie-lake/app/bin && ./app
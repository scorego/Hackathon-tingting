export LANG=en_US.utf8
export LANGUAGE=en_US.utf8
sh stop.sh
rm nohup.out
nohup java -XX:MaxPermSize=512M -XX:PermSize=256M -Dfile.encoding=UTF-8 -jar ./tingting-0.0.1-SNAPSHOT.jar wang.javior.hackathon.tingting.App &
pid=$!
echo $pid >pid
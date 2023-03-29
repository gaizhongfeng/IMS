# !bin/bash
mysql -uroot -p$MYSQL_ROOT_PASSWORD <<EOF
SET NAMES utf8;
source $WORK_PATH/$FILE_1;
source $WORK_PATH/$FILE_2;
ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY '$MYSQL_ROOT_PASSWORD';

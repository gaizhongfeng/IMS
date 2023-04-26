FROM centos:7

RUN rpm --rebuilddb && \
    yum -y install wget hostname mariadb nmap-ncat && \
    wget https://downloads.percona.com/downloads/Percona-XtraBackup-LATEST/Percona-XtraBackup-8.0.9/binary/redhat/7/x86_64/percona-xtrabackup-80-8.0.9-1.el7.x86_64.rpm && \
	yum -y localinstall percona-xtrabackup-80-8.0.9-1.el7.x86_64.rpm

RUN rm percona-xtrabackup-80-8.0.9-1.el7.x86_64.rpm -rf

EXPOSE 3307
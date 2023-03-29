FROM mysql:8.0
ENV AUTO_RUN_DIR /docker-entrypoint-initdb.d
WORKDIR /work
ENV WORK_PATH /work
COPY setup.sh $AUTO_RUN_DIR/
COPY *.sql $WORK_PATH
ENV FILE_1 initSql1.sql
ENV FILE_2 initSql2.sql
RUN chmod a+x $AUTO_RUN_DIR/setup.sh

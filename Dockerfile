
FROM mysql:5.7

ENV MYSQL_ROOT_PASSWORD urubu200

ADD script.sql /docker-entrypoint-initdb.d

EXPOSE 3306


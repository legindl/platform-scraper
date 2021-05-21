FROM tomcat:9.0

EXPOSE 8080

RUN rm -rf /usr/local/tomcat/webapps/*

COPY target/newsPlatform-Scraper.war /usr/local/tomcat/webapps

ENV JAVA_OPTS="-Xmx2g"

CMD ["catalina.sh","run"]
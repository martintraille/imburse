FROM maven:3.6.3-jdk-13
WORKDIR /Tests
COPY /docker/run-tests.sh .
RUN chmod +x /Tests/run-tests.sh
COPY chromedriver.exe .
COPY pom.xml .
COPY serenity.properties .
COPY /src ./src
CMD ["/Tests/run-tests.sh"]
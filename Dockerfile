FROM quay.io/wildfly/wildfly:latest-jdk17
COPY target/basic-rest-api.war /opt/jboss/wildfly/standalone/deployments/

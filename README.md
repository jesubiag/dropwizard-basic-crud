# DropwizardTestApp

How to start the DropwizardTestApp application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/dropwizard-test-app-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

How to start from Eclipse
---
1. Select project > Run As > Run Configurations
2. On "Main" tab, select "Main class": com.test.dropwizard.DropwizardTestAppApplication
3. On "Arguments" tab, add "server config.yml" to "Program arguments"
4. Apply changes and click "Run"

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

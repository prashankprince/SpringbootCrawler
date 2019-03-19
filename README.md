# SpringbootCrawler

This README is intended to provide high-level guidance of the project, and detailed instructions

A Spring Boot project which Crawls website recursively till some maximum depth. 

Sprintboot API solution where response can be rendered as a JSON format and can be viewed from any REST client so that it can work as client/server model.

## Running the code using the command-line

This project can be built with [Apache Maven](http://maven.apache.org/).

Downlaod/Clone code from [here](https://github.com/prashankprince/SpringbootCrawler) and Use the following steps to run the application locally:

1. Execute full Maven build to create the `target/WebCrawlerService-0.0.1-SNAPSHOT.jar` file:

    ```bash
    $ mvn clean install
    ```
    
2. Run Jar file in command prompt using:

    ````
    java -jar WebCrawlerService-0.0.1-SNAPSHOT.jar
    ````
    
3. Check if Tomcat is running on port 8081

4. Go to chrome or any browser and type "http://localhost:8081/crawlservice?domain=<domain_name>" or else go to postman and do a get and 
put example - http://localhost:8081/crawlservice?domain=redhat

5. Check result displayed as JSON.

## Run code using Eclipse/STS or any IDE

Downlaod/Clone code from [here](https://github.com/prashankprince/SpringbootCrawler) and Use the following steps:

1. Import code in STS or any IDE

2. Right click on Project and Click on Run as and do `Maven build`.

3. Right click on Project and then Run as `Spring Boot App `.

4. Check if Tomcat is running on port 8081

5. Go to chrome or any browser and type "http://localhost:8081/crawlservice?domain=<domain_name>" or else go to postman and do a get and 
put example - http://localhost:8081/crawlservice?domain=redhat

6. Check result displayed as JSON.

## Docker

Rename jar file from target folder as WebCrawlerService.jar and use Dockerfile to issue below commands

1.
    ```bash
    docker build -t prashankprince/crawler:1.0 .
    ```
2.
    ```bash
    docker login
    ```
3.  
    ```bash
    docker push prashankprince/crawler:1.0
    ```
    
## Kubernetes


1.
    ```bash
    minikube start
    ```
2.
    ```bash
    kubectl apply -f webcrawler-service.yaml
    ```
3.
    ```bash
    kubectl get svc
    ```
4.
    ```bash
    kubectl get pods
    ```
5.
    ```bash
    minikube service crawlerservice
    ```

     




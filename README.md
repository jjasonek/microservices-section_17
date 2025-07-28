# Udemy Course Microservices with Spring Boot, Docker, Kubernetes Section_17
https://www.udemy.com/course/master-microservices-with-spring-docker-kubernetes/
## spring version: 3.4.5
## gatewayservice version: 3.5.0
## Java 21
## Kubernetes: kind 1.23.5 


## Kubernetes Discovery server setup

### Install spring-cloud-kubernetes-discoveryserver
kubectl apply -f .\kubernetes-discoveryserver.yml
service/spring-cloud-kubernetes-discoveryserver created
serviceaccount/spring-cloud-kubernetes-discoveryserver created
rolebinding.rbac.authorization.k8s.io/spring-cloud-kubernetes-discoveryserver:view created
role.rbac.authorization.k8s.io/namespace-reader created
deployment.apps/spring-cloud-kubernetes-discoveryserver-deployment created

### log from spring-cloud-kubernetes-discoveryserver
Calculating JVM memory based on 6062160K available memory
For more information on this calculation, see https://paketo.io/docs/reference/java-reference/#memory-calculator
Calculated JVM Memory Configuration: -XX:MaxDirectMemorySize=10M -Xmx5624291K -XX:MaxMetaspaceSize=130668K -XX:ReservedCodeCacheSize=240M -Xss1M (Total Memory: 6062160K, Thread Count: 50, Loaded Class Count: 20656, Headroom: 0%)
Enabling Java Native Memory Tracking
Adding 146 container CA certificates to JVM truststore
Spring Cloud Bindings Enabled
Picked up JAVA_TOOL_OPTIONS: -Djava.security.properties=/layers/paketo-buildpacks_bellsoft-liberica/java-security-properties/java-security.properties -XX:+ExitOnOutOfMemoryError -XX:MaxDirectMemorySize=10M -Xmx5624291K -XX:MaxMetaspaceSize=130668K -XX:ReservedCodeCacheSize=240M -Xss1M -XX:+UnlockDiagnosticVMOptions -XX:NativeMemoryTracking=summary -XX:+PrintNMTStatistics -Dorg.springframework.cloud.bindings.boot.enable=true
.   ____          _            __ _ _
/\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
\\/  ___)| |_)| | | | | || (_| |  ) ) ) )
'  |____| .__|_| |_|_| |_\__, | / / / /
=========|_|==============|___/=/_/_/_/
:: Spring Boot ::                (v3.4.7)
2025-07-27T18:45:51.573Z  INFO 1 --- [           main] o.s.c.k.d.DiscoveryServerApplication     : Starting DiscoveryServerApplication v3.2.2 using Java 17.0.15 with PID 1 (/workspace/BOOT-INF/classes started by cnb in /workspace)
2025-07-27T18:45:51.576Z  INFO 1 --- [           main] o.s.c.k.d.DiscoveryServerApplication     : The following 1 profile is active: "kubernetes"
2025-07-27T18:45:53.934Z  INFO 1 --- [           main] o.s.cloud.context.scope.GenericScope     : BeanFactory id=b791e571-f0cd-30c8-995d-7cc9357974a1
2025-07-27T18:45:54.571Z  INFO 1 --- [           main] o.s.c.k.client.KubernetesClientUtils     : Created API client in the cluster.
2025-07-27T18:45:54.715Z  INFO 1 --- [oller-V1Service] i.k.client.informer.cache.Controller     : informer#Controller: ready to run resync & reflector runnable
2025-07-27T18:45:54.716Z  INFO 1 --- [oller-V1Service] i.k.client.informer.cache.Controller     : informer#Controller: resync skipped due to 0 full resync period
2025-07-27T18:45:54.716Z  INFO 1 --- [ler-V1Endpoints] i.k.client.informer.cache.Controller     : informer#Controller: ready to run resync & reflector runnable
2025-07-27T18:45:54.716Z  INFO 1 --- [ler-V1Endpoints] i.k.client.informer.cache.Controller     : informer#Controller: resync skipped due to 0 full resync period
2025-07-27T18:45:54.718Z  INFO 1 --- [s.V1Endpoints-1] i.k.c.informer.cache.ReflectorRunnable   : class io.kubernetes.client.openapi.models.V1Endpoints#Start listing and watching...
2025-07-27T18:45:54.720Z  INFO 1 --- [els.V1Service-1] i.k.c.informer.cache.ReflectorRunnable   : class io.kubernetes.client.openapi.models.V1Service#Start listing and watching...
2025-07-27T18:45:55.714Z  INFO 1 --- [pool-8-thread-1] s.c.k.c.d.KubernetesDiscoveryClientUtils : Waiting for the cache of informers to be fully loaded..
2025-07-27T18:45:55.717Z  INFO 1 --- [           main] s.c.k.c.d.KubernetesDiscoveryClientUtils : Cache fully loaded (total 2 services), discovery client is now available
2025-07-27T18:45:56.425Z  INFO 1 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 1 endpoint beneath base path '/actuator'
2025-07-27T18:45:57.400Z  INFO 1 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8761 (http)
2025-07-27T18:45:57.435Z  INFO 1 --- [           main] o.s.c.k.d.DiscoveryServerApplication     : Started DiscoveryServerApplication in 6.685 seconds (process running for 7.296)


## Docker images

### for all microservices we call following to generate docker images s17:
mvn compile jib:dockerBuild
or .\RunMvnCommandForAllProjects.ps1 -MavenCommand "compile jib:dockerBuild"

docker image ls --filter=reference="jjasonek/*:s17"

Alternatively you can use (on Linux):
docker images | grep s17

### push images to docker hub:
docker image push docker.io/jjasonek/accounts:s17
docker image push docker.io/jjasonek/loans:s17
docker image push docker.io/jjasonek/cards:s17
docker image push docker.io/jjasonek/message:s17
docker image push docker.io/jjasonek/configserver:s17
docker image push docker.io/jjasonek/gatewayserver:s17

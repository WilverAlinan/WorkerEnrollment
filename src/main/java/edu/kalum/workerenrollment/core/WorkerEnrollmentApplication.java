package edu.kalum.workerenrollment.core;

import edu.kalum.workerenrollment.core.verticles.EnrollmentProcessVerticle;
import edu.kalum.workerenrollment.core.verticles.QueueConsummerVerticle;
import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class WorkerEnrollmentApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(WorkerEnrollmentApplication.class);
    private Vertx vertx;

    @Autowired
    private Environment env;

    @Autowired
    private QueueConsummerVerticle queueConsummerVerticle;

    @Autowired
    private EnrollmentProcessVerticle enrollmentProcessVerticle;

    public static void main(String[] args) {
        SpringApplication.run(WorkerEnrollmentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.debug("Iniciando App Consummer Rabbit");
    }
    @PostConstruct
    public void deployVerticle(){
        this.vertx = Vertx.vertx();
        ConfigStoreOptions fileConfig = new ConfigStoreOptions().setType("file").setConfig(new JsonObject().put("path","dev".concat(".json")));
        ConfigStoreOptions sysPropStore = new ConfigStoreOptions().setType("sys");
        ConfigRetrieverOptions configRetrieverOptions = new ConfigRetrieverOptions().addStore(fileConfig).addStore(sysPropStore);
        ConfigRetriever configRetriever = ConfigRetriever.create(vertx,configRetrieverOptions);
        configRetriever.getConfig(config ->{
            if(config.succeeded()){
                this.vertx.deployVerticle(queueConsummerVerticle, new DeploymentOptions().setConfig(config.result())); //desplegar verticle
                this.vertx.deployVerticle(enrollmentProcessVerticle, new DeploymentOptions().setConfig(config.result()));
                logger.info("Se realizo el Deployment de los Verticles exitosamente!!");

            }else{
                logger.error("ERROR AL DESPLEGAR LOS VERTICLES ".concat(config.cause().getMessage()));
            }
        });
    }
}

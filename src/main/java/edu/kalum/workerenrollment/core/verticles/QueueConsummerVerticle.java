package edu.kalum.workerenrollment.core.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.rabbitmq.QueueOptions;
import io.vertx.rabbitmq.RabbitMQClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class QueueConsummerVerticle extends AbstractVerticle {

    private EventBus eventBus;
    private RabbitMQClient rabbitMQClient;
    private static final Logger logger = LoggerFactory.getLogger((QueueConsummerVerticle.class));
    private static final String EVENT_BUS_ENROLLMENT_PROCESS = "EVENT_BUS_ENROLLMENT_PROCESS";

    @Override
    public void start(){
        this.eventBus = vertx.eventBus();
        this.vertx.setTimer(5000, handler->{
            readMessageEvent();
        });
    }

public void readMessageEvent(){
    JsonObject config = new JsonObject()
            .put("user",config().getString("edu.kalum.broker.username"))
            .put("password",config().getString("edu.kalum.broker.password"))
            .put("host",config().getString("edu.kalum.broker.host"))
            .put("port",config().getString("edu.kalum.broker.port"))
            .put("virtualHost",config().getString("edu.kalum.broker.virtualHost"))
            .put("queue",config().getString("edu.kalum.broker.queue"));
    this.rabbitMQClient = RabbitMQClient.create(vertx, config);
    this.rabbitMQClient.start(startResult -> {
        if(startResult.succeeded()){
            logger.info("se realizo la conexion a rabbit satisfactoriamente");
            this.rabbitMQClient.basicQos(1, voidAsyncResult -> {
                logger.info("estableciendo lectura de mensajes a 1");
            });
            this.rabbitMQClient.basicConsumer(config().getString("edu.kalum.broker.queue"), new QueueOptions().setAutoAck(false), consumerResult ->{
                if (consumerResult.succeeded()){
                    consumerResult.result().handler(message -> {
                        DeliveryOptions options = new DeliveryOptions();
                        options.addHeader("count","1");
                        this.eventBus.request(this.EVENT_BUS_ENROLLMENT_PROCESS, message.body().toJsonObject(),options, replyHandler -> {
                            if (replyHandler.succeeded()){
                                if (replyHandler.result().body() != null && replyHandler.result().body().toString().equalsIgnoreCase("ok")){
                                    this.rabbitMQClient.basicAck(message.envelope().deliveryTag(), false, asyncResponse ->{
                                        logger.info("Process enrollment success");
                                    });
                                } else if (replyHandler.result().body() != null && replyHandler.result().body().toString().equalsIgnoreCase("fail")){
                                    this.rabbitMQClient.basicNack(message.envelope().deliveryTag(), false, true, asyncResponse -> {
                                        logger.info("Failed enrollment process");
                                        });
                                    }
                                }
                            });
                        });
                    } else {
                        logger.error("Error: ".concat(consumerResult.cause().getMessage()));
                    }
                });
            } else {
                logger.error("Hubo un error en el proceso de conexión a rabbit (".concat(startResult.cause().getMessage()).concat(")"));
            }
        });
    }
}
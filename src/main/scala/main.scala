import java.util.{Collections, Properties}
import org.apache.kafka.clients.consumer.{ConsumerRecords, KafkaConsumer}
import scala.jdk.CollectionConverters._
import scala.collection.JavaConverters._

object Main extends App {
  // Set topic
  val topic = "gcn.classic.text.SWIFT_ACTUAL_POINTDIR"

  // Set Kafka Consumer Properties
  val props = new Properties()
  props.put("bootstrap.servers", "kafka.gcn.nasa.gov:9092") 
  props.put("group.id", "gcn.nasa.gov/kafka-public-consumer")
  props.put("client.id", "")  
  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("auto.offset.reset", "earliest")
  props.put("enable.auto.commit", "true")

  // Set Client ID and Secret from gcn.nasa.gov
  val clientId = ""
  val clientSecret = ""

  // Set jaas config
  val jaasConfig: String =
  s"""org.apache.kafka.common.security.oauthbearer.OAuthBearerLoginModule required
     |  clientId="$clientId"
     |  clientSecret="$clientSecret";""".stripMargin

  // Set SASL Authentication properties
  props.put("security.protocol", "SASL_SSL")
  props.put("sasl.mechanism", "OAUTHBEARER")
  props.put("sasl.oauthbearer.token.endpoint.url", "https://auth.gcn.nasa.gov/oauth2/token")
  props.put("sasl.login.callback.handler.class","org.apache.kafka.common.security.oauthbearer.OAuthBearerLoginCallbackHandler")
  props.put("sasl.jaas.config", jaasConfig)

  // Create a new Kafka Consumer and subscribe to the above topic
  val consumer = new KafkaConsumer[String, String](props)
  consumer.subscribe(Collections.singletonList(topic))

  // Output strings to indicate we are trying to consume records
  println(s"Subscribed to topic: $topic")
  println("Attempting to consume records...")

  // Use consumer.poll method to check for new records sent from the publisher
  try {
    while (true) {
      val records: ConsumerRecords[String, String] = consumer.poll(java.time.Duration.ofMillis(10000))
      for (record <- asScalaIterator(records.iterator())) {
        println(s"Consumed: ${record.value()} (Partition: ${record.partition()}, Offset: ${record.offset()})")
      }
    }
  } 
  // Catch exception and throw an error message
  catch {
    case e: Exception => 
        println(s"An error occurred: ${e.getMessage}")
  }
  // Close out the consumer
  finally {
    consumer.close()
  }
}


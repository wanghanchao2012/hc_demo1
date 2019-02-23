package com.emarbox.example.springKafka;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class CollectController {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private KafkaTemplate kafkaTemplate;

	@Autowired
	private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;
	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public String sendKafka(HttpServletRequest request, HttpServletResponse response) {
		try {
			kafkaListenerEndpointRegistry.getListenerContainers().stream().forEach(e->System.out.println(e));;
			String message = request.getParameter("message");
			logger.info("kafka的消息={}", message);
			kafkaTemplate.send("test11www", "key", message);
			logger.info("发送kafka成功.");
			return "发送kafka成功";
		} catch (Exception e) {
			logger.error("发送kafka失败", e);
			return "发送kafka失败";
		}
	}

}
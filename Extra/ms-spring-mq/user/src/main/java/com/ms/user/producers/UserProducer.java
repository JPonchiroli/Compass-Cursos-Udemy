package com.ms.user.producers;

import com.ms.user.dto.EmailDto;
import com.ms.user.model.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    @Autowired
    public RabbitTemplate rabbitTemplate;

    @Value("${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserModel userModel) {
        var emailDto = new EmailDto();
         emailDto.setId(userModel.getId());
         emailDto.setEmailTo(userModel.getEmail());
         emailDto.setSubject("Registration completed successfully");
         emailDto.setText("Wellcome " + userModel.getUsername() + "\n Thanks for your registration! Enjoy");

         rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
}

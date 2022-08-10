package com.avaliacaoderestaurantes.usuariosms.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ComunicationsBeans {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}

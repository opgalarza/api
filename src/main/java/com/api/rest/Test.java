package com.api.rest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.dto.MessageDTO;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@Api(value = "api", description = "api", protocols = "http")
public class Test {
	
	
    @ResponseBody
    @ApiOperation(value = "api", response = MessageDTO.class, httpMethod = "GET", notes = "")
    @RequestMapping(value = "/display", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageDTO display(){
    	MessageDTO message = new MessageDTO();
    	message.setMessage("test");
    	return message;
    }

}

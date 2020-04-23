package com.naughtyzombie.aws.handler;

import java.util.HashMap;

import com.amazonaws.services.lambda.runtime.Context;
import com.naughtyzombie.aws.domain.Request;
import com.naughtyzombie.aws.domain.Response;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

public class AwsLambdaFunctionHandler extends SpringBootRequestHandler<Object, Response> {

	  public String handleRequest2(Object input, Context context) {
	return "method2";
	    }
   
	
}

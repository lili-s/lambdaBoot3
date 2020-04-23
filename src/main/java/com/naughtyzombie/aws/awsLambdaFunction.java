package com.naughtyzombie.aws;


import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.naughtyzombie.aws.domain.Response;
import com.naughtyzombie.aws.service.AwsLambaService;

@Component("awsLambdaFunction")
public class awsLambdaFunction implements Function<Object, Response> {

	@Autowired
	private RegisterRepository userRepository;
	
    private AwsLambaService service=null;

    public awsLambdaFunction() {}
    
    public awsLambdaFunction(AwsLambaService service) {
        this.service = service;
    }

    /*
    @Override
    public Response apply(final Object request) {
        final Response result = new Response();
        result.setResult("hello");
        
		  Register r = new Register();
		  r.setPassword("pass"); r.setPhone("phone"); r.setUsername("username");
		  userRepository.save(r); 
      //  result.setResult(service.uppercase(request.getInput()));
        return result;
    }
    */
    
    
    public Response apply(final Object input) {
        final Response result = new Response();
        result.setResult("hello");
        
        HashMap<?, ?> temp=(HashMap<?, ?>)input;
        
        try {
             if(temp.get(("type")+"").equals("register")) { result.setResult(handleRegister(temp));}
        else if(temp.get(("type")+"").equals("login")) { result.setResult(handleLogin(temp));}
        else {result.setResult("invalid input");}
        }catch(Exception e) {result.setResult("error: "+e);} 
        
        
        return result;
    }
    


    public String handleRegister(HashMap<?, ?> input) {
    	try{
    	Register r = new Register();
		  r.setPassword(input.get("password")+""); r.setPhone(input.get("phone")+""); r.setUsername(input.get("username")+"");
		  if(!findExisting(r)){
		  userRepository.save(r); 
		  return "completed register";
		  }else{return "already exist";}
    	}catch(Exception e){return "incomplete register"+e;}
    }
    
    public String handleLogin(HashMap<?, ?> input) {
    	Register r = new Register(); r.setPassword(input.get("password")+""); r.setUsername(input.get("username")+"");
		  if(correctPassword(r)){return "loggeded in";}
		  else{return "not logged in";}
    }
    
    
    
    private boolean findExisting(Register User){
		List<Register> temp=userRepository.findByUsername(User.getUsername());
		if(temp.size()==0){return false;}
		else {return true;}
	}
	
	private boolean correctPassword(Register User){
		List<Register> temp=userRepository.findByUsernameAndPassword(User.getUsername(), User.getPassword());
		if(temp.size()==1){return true;}
		else {return false;}
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
//com.amazonaws.lambda.demo.LambdaFunctionHandler::handleRequest
//  com.naughtyzombie.aws.AwsLambdaFunction::apply 
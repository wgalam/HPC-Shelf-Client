package br.ufc.storm.wservices;

     
   import org.apache.axis2.client.async.AxisCallback; 
   import org.apache.axis2.context.MessageContext; 
   import org.apache.axiom.soap.SOAPBody; 
    
    
   public class MyCallBack implements AxisCallback { 
       public void onMessage(MessageContext messageContext) { 
           SOAPBody msg = messageContext.getEnvelope().getBody(); 
           System.out.println("MyCallBack: "+msg); 
       } 
    
       public void onFault(MessageContext messageContext) { 
           messageContext.getFailureReason().printStackTrace(); 
       } 
    
       public void onError(Exception e) { 
           System.err.println("MyCallBack Error "+e.getMessage()); 
       } 
    
       public void onComplete() { 
           System.out.println("MyCallBack: Invocation is complete"); 
           //In real application you do not need to terminate the program 
           System.exit(0); 
       } 
   } 
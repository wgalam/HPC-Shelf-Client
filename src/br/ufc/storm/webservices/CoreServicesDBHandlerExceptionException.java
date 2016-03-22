
/**
 * CoreServicesDBHandlerExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package br.ufc.storm.webservices;

public class CoreServicesDBHandlerExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1458582048227L;
    
    private br.ufc.storm.webservices.CoreServicesStub.CoreServicesDBHandlerException faultMessage;

    
        public CoreServicesDBHandlerExceptionException() {
            super("CoreServicesDBHandlerExceptionException");
        }

        public CoreServicesDBHandlerExceptionException(java.lang.String s) {
           super(s);
        }

        public CoreServicesDBHandlerExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public CoreServicesDBHandlerExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(br.ufc.storm.webservices.CoreServicesStub.CoreServicesDBHandlerException msg){
       faultMessage = msg;
    }
    
    public br.ufc.storm.webservices.CoreServicesStub.CoreServicesDBHandlerException getFaultMessage(){
       return faultMessage;
    }
}
    

/**
 * CoreServicesIOExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package br.ufc.storm.wservices;

public class CoreServicesIOExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1450375302804L;
    
    private br.ufc.storm.wservices.CoreServicesStub.CoreServicesIOException faultMessage;

    
        public CoreServicesIOExceptionException() {
            super("CoreServicesIOExceptionException");
        }

        public CoreServicesIOExceptionException(java.lang.String s) {
           super(s);
        }

        public CoreServicesIOExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public CoreServicesIOExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(br.ufc.storm.wservices.CoreServicesStub.CoreServicesIOException msg){
       faultMessage = msg;
    }
    
    public br.ufc.storm.wservices.CoreServicesStub.CoreServicesIOException getFaultMessage(){
       return faultMessage;
    }
}
    
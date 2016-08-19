
/**
 * CoreServicesParserConfigurationExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package br.ufc.storm.webservices;

public class CoreServicesParserConfigurationExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1471636402471L;
    
    private br.ufc.storm.webservices.CoreServicesStub.CoreServicesParserConfigurationException faultMessage;

    
        public CoreServicesParserConfigurationExceptionException() {
            super("CoreServicesParserConfigurationExceptionException");
        }

        public CoreServicesParserConfigurationExceptionException(java.lang.String s) {
           super(s);
        }

        public CoreServicesParserConfigurationExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public CoreServicesParserConfigurationExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(br.ufc.storm.webservices.CoreServicesStub.CoreServicesParserConfigurationException msg){
       faultMessage = msg;
    }
    
    public br.ufc.storm.webservices.CoreServicesStub.CoreServicesParserConfigurationException getFaultMessage(){
       return faultMessage;
    }
}
    

/**
 * CoreServicesSAXExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package br.ufc.storm.webservices;

public class CoreServicesSAXExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1462805523693L;
    
    private br.ufc.storm.webservices.CoreServicesStub.CoreServicesSAXException faultMessage;

    
        public CoreServicesSAXExceptionException() {
            super("CoreServicesSAXExceptionException");
        }

        public CoreServicesSAXExceptionException(java.lang.String s) {
           super(s);
        }

        public CoreServicesSAXExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public CoreServicesSAXExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(br.ufc.storm.webservices.CoreServicesStub.CoreServicesSAXException msg){
       faultMessage = msg;
    }
    
    public br.ufc.storm.webservices.CoreServicesStub.CoreServicesSAXException getFaultMessage(){
       return faultMessage;
    }
}
    
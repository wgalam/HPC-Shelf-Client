
/**
 * CoreServicesCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package br.ufc.storm.webservices;

    /**
     *  CoreServicesCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class CoreServicesCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public CoreServicesCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public CoreServicesCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for setObsolete method
            * override this method for handling normal response from setObsolete operation
            */
           public void receiveResultsetObsolete(
                    br.ufc.storm.webservices.CoreServicesStub.SetObsoleteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setObsolete operation
           */
            public void receiveErrorsetObsolete(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addContextContract method
            * override this method for handling normal response from addContextContract operation
            */
           public void receiveResultaddContextContract(
                    br.ufc.storm.webservices.CoreServicesStub.AddContextContractResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addContextContract operation
           */
            public void receiveErroraddContextContract(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addContextParameter method
            * override this method for handling normal response from addContextParameter operation
            */
           public void receiveResultaddContextParameter(
                    br.ufc.storm.webservices.CoreServicesStub.AddContextParameterResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addContextParameter operation
           */
            public void receiveErroraddContextParameter(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addAbstractUnit method
            * override this method for handling normal response from addAbstractUnit operation
            */
           public void receiveResultaddAbstractUnit(
                    br.ufc.storm.webservices.CoreServicesStub.AddAbstractUnitResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addAbstractUnit operation
           */
            public void receiveErroraddAbstractUnit(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAbstractComponentByID method
            * override this method for handling normal response from getAbstractComponentByID operation
            */
           public void receiveResultgetAbstractComponentByID(
                    br.ufc.storm.webservices.CoreServicesStub.GetAbstractComponentByIDResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAbstractComponentByID operation
           */
            public void receiveErrorgetAbstractComponentByID(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for listContract method
            * override this method for handling normal response from listContract operation
            */
           public void receiveResultlistContract(
                    br.ufc.storm.webservices.CoreServicesStub.ListContractResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from listContract operation
           */
            public void receiveErrorlistContract(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getAbstractComponent method
            * override this method for handling normal response from getAbstractComponent operation
            */
           public void receiveResultgetAbstractComponent(
                    br.ufc.storm.webservices.CoreServicesStub.GetAbstractComponentResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getAbstractComponent operation
           */
            public void receiveErrorgetAbstractComponent(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addAbstractComponent method
            * override this method for handling normal response from addAbstractComponent operation
            */
           public void receiveResultaddAbstractComponent(
                    br.ufc.storm.webservices.CoreServicesStub.AddAbstractComponentResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addAbstractComponent operation
           */
            public void receiveErroraddAbstractComponent(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cancelSession method
            * override this method for handling normal response from cancelSession operation
            */
           public void receiveResultcancelSession(
                    br.ufc.storm.webservices.CoreServicesStub.CancelSessionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancelSession operation
           */
            public void receiveErrorcancelSession(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addUnitFile method
            * override this method for handling normal response from addUnitFile operation
            */
           public void receiveResultaddUnitFile(
                    br.ufc.storm.webservices.CoreServicesStub.AddUnitFileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addUnitFile operation
           */
            public void receiveErroraddUnitFile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addInnerComponent method
            * override this method for handling normal response from addInnerComponent operation
            */
           public void receiveResultaddInnerComponent(
                    br.ufc.storm.webservices.CoreServicesStub.AddInnerComponentResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addInnerComponent operation
           */
            public void receiveErroraddInnerComponent(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for releasePlatform method
            * override this method for handling normal response from releasePlatform operation
            */
           public void receiveResultreleasePlatform(
                    br.ufc.storm.webservices.CoreServicesStub.ReleasePlatformResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from releasePlatform operation
           */
            public void receiveErrorreleasePlatform(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getProfile method
            * override this method for handling normal response from getProfile operation
            */
           public void receiveResultgetProfile(
                    br.ufc.storm.webservices.CoreServicesStub.GetProfileResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getProfile operation
           */
            public void receiveErrorgetProfile(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for deploy method
            * override this method for handling normal response from deploy operation
            */
           public void receiveResultdeploy(
                    br.ufc.storm.webservices.CoreServicesStub.DeployResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deploy operation
           */
            public void receiveErrordeploy(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addConcreteUnit method
            * override this method for handling normal response from addConcreteUnit operation
            */
           public void receiveResultaddConcreteUnit(
                    br.ufc.storm.webservices.CoreServicesStub.AddConcreteUnitResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addConcreteUnit operation
           */
            public void receiveErroraddConcreteUnit(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getStatus method
            * override this method for handling normal response from getStatus operation
            */
           public void receiveResultgetStatus(
                    br.ufc.storm.webservices.CoreServicesStub.GetStatusResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getStatus operation
           */
            public void receiveErrorgetStatus(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for list method
            * override this method for handling normal response from list operation
            */
           public void receiveResultlist(
                    br.ufc.storm.webservices.CoreServicesStub.ListResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from list operation
           */
            public void receiveErrorlist(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for instantiate method
            * override this method for handling normal response from instantiate operation
            */
           public void receiveResultinstantiate(
                    br.ufc.storm.webservices.CoreServicesStub.InstantiateResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from instantiate operation
           */
            public void receiveErrorinstantiate(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for instantiateACK method
            * override this method for handling normal response from instantiateACK operation
            */
           public void receiveResultinstantiateACK(
                    br.ufc.storm.webservices.CoreServicesStub.InstantiateACKResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from instantiateACK operation
           */
            public void receiveErrorinstantiateACK(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getContextContract method
            * override this method for handling normal response from getContextContract operation
            */
           public void receiveResultgetContextContract(
                    br.ufc.storm.webservices.CoreServicesStub.GetContextContractResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getContextContract operation
           */
            public void receiveErrorgetContextContract(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getContextParameter method
            * override this method for handling normal response from getContextParameter operation
            */
           public void receiveResultgetContextParameter(
                    br.ufc.storm.webservices.CoreServicesStub.GetContextParameterResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getContextParameter operation
           */
            public void receiveErrorgetContextParameter(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for resolve method
            * override this method for handling normal response from resolve operation
            */
           public void receiveResultresolve(
                    br.ufc.storm.webservices.CoreServicesStub.ResolveResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from resolve operation
           */
            public void receiveErrorresolve(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addQualityFunction method
            * override this method for handling normal response from addQualityFunction operation
            */
           public void receiveResultaddQualityFunction(
                    br.ufc.storm.webservices.CoreServicesStub.AddQualityFunctionResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addQualityFunction operation
           */
            public void receiveErroraddQualityFunction(java.lang.Exception e) {
            }
                


    }
    
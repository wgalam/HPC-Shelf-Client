package br.ufc.storm.core;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Scanner;

import org.apache.axis2.AxisFault;

import br.ufc.storm.wservices.CoreServicesDBHandlerExceptionException;
import br.ufc.storm.wservices.CoreServicesIOExceptionException;
import br.ufc.storm.wservices.CoreServicesParserConfigurationExceptionException;
import br.ufc.storm.wservices.CoreServicesSAXExceptionException;
import br.ufc.storm.wservices.CoreServicesStub;
import br.ufc.storm.wservices.CoreServicesStub.AddAbstractComponentResponse;
import br.ufc.storm.wservices.CoreServicesStub.AddConcreteUnitResponse;
import br.ufc.storm.wservices.CoreServicesStub.AddContextParameterResponse;
import br.ufc.storm.wservices.CoreServicesStub.AddInnerComponentResponse;
import br.ufc.storm.wservices.CoreServicesStub.AddInstantiationTypeResponse;
import br.ufc.storm.wservices.CoreServicesStub.AddUnitFileResponse;
import br.ufc.storm.wservices.CoreServicesStub.GetAbstractComponentResponse;
import br.ufc.storm.wservices.CoreServicesStub.GetContextContractResponse;
import br.ufc.storm.wservices.CoreServicesStub.GetContextParameterResponse;
import br.ufc.storm.wservices.CoreServicesStub.ListContractResponse;
import br.ufc.storm.wservices.CoreServicesStub.ListResponse;
import br.ufc.storm.wservices.CoreServicesStub.ResolveResponse;

public class CoreServiceConsumer {

	public static void main(String [] args){
		//System.out.println(resolve("TesteStormContract.xml"));
    	//System.out.println(getAbstractComponent("Certifier"));
//    	System.out.println(getAbstractComponent("mImgtbl"));
    		//	System.out.println(registerAbstractComponent("./XML/AbstractComponentTest.xml"));
		System.out.println(getContextContract(35));
//		System.out.println(listComponents());
//		System.out.println(listContextContract(19));
//		System.out.println(resolve("XML/m101/mImgTbl.xml"));
//		System.out.println(resolve("XML/m101/mAdd.xml"));
//		registerCUF("XML/concrete_unit_file.xml", "UNITS/teste.c");
		
		
	}

	public static String resolve(String str){
		try {
			str = readFile(str);
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.Resolve request;
		request = new CoreServicesStub.Resolve();
		request.setCmp(str);
		//Invoca o servico
		ResolveResponse response = null;
		try {
			response = stub.resolve(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return();
	}



	private static boolean registerIC(String str) {
		try {
			str = readFile(str);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.AddInnerComponent request;
		request = new CoreServicesStub.AddInnerComponent();
		request.setCmp(str);
		//Invoca o servico
		AddInnerComponentResponse response = null;
		try {
			response = stub.addInnerComponent(request);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return response.get_return();
	}

	public static boolean registerUnitFile(String path, String filename){
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		CoreServicesStub.AddUnitFile request;
		request = new CoreServicesStub.AddUnitFile();
		javax.activation.FileDataSource fileDataSource = new javax.activation.FileDataSource(path);
		javax.activation.DataHandler dh = new javax.activation.DataHandler(fileDataSource);
		request.setData(dh);
		request.setXml(filename);
		AddUnitFileResponse response = null;		
		try {
			response = stub.addUnitFile(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(response.get_return()){
			return true;
		}else{
			return false;
		}
	}
	private static boolean register_context_parameter(String str) {
		try {
			str = readFile(str);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.AddContextParameter request;
		request = new CoreServicesStub.AddContextParameter();
		request.setCmp(str);
		//Invoca o servico
		AddContextParameterResponse response = null;
		try {
			response = stub.addContextParameter(request);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return response.get_return();
	}

	/*private static boolean register_context_argument(String str) {
		try {
			str = readFile(str);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.AddContextArgument request;
		request = new CoreServicesStub.AddContextArgument();
		request.setCmp(str);
		//Invoca o servico
		AddContextArgumentResponse response = null;
		try {
			try {
				response = stub.addContextArgument(request);
			} catch (CoreServicesParserConfigurationExceptionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CoreServicesSAXExceptionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CoreServicesIOExceptionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return response.get_return();
	}*/

	private static String readFile(String pathname) throws IOException {

		File file = new File(pathname);
		StringBuilder fileContents = new StringBuilder((int)file.length());
		Scanner scanner = new Scanner(file);
		String lineSeparator = System.getProperty("line.separator");
		try {
			while(scanner.hasNextLine()) {        
				fileContents.append(scanner.nextLine() + lineSeparator);
			}
			return fileContents.toString();
		} finally {
			scanner.close();
		}
	}

	public static String listComponents(){
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.List request;
		request = new CoreServicesStub.List();
		//Invoca o servico
		ListResponse response = null;
		try {
			response = stub.list(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return();
	}
	
	public static String listContextContract(int ac_id){
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.ListContract request;
		request = new CoreServicesStub.ListContract();
		request.setAc_id(ac_id);
		//Invoca o servico
		ListContractResponse response = null;
		try {
			response = stub.listContract(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return();
	}
	

	public static String getAbstractComponent(String str){
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.GetAbstractComponent request;
		request = new CoreServicesStub.GetAbstractComponent();
		request.setName(str);
		//Invoca o servico
		GetAbstractComponentResponse response = null;

		try {
			response = stub.getAbstractComponent(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return();
	}

	public static String getContextParameter(String str){
		//TODO
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.GetContextParameter request;
		request = new CoreServicesStub.GetContextParameter();
		request.setName(str);
		//Invoca o servico
		GetContextParameterResponse response = null;

		try {
			response = stub.getContextParameter(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return();
	}

	public static String getContextContract(int str){
		//TODO
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();		
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.GetContextContract request;
		request = new CoreServicesStub.GetContextContract();
		request.setId(str);
		//Invoca o servico
		GetContextContractResponse response = null;

		try {
			response = stub.getContextContract(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}



		//		String st = new String(response.get_return());
		return response.get_return().toString();
	}

	/*public static String getContextArgument(String str){
		//TODO
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.GetContextArgument request;
		request = new CoreServicesStub.GetContextArgument();
		request.setName(str);
		//Invoca o servico
		GetContextArgumentResponse response = null;

		try {
			response = stub.getContextArgument(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return();
	}*/


	public static boolean registerAbstractComponent(String str){
		try {
			str = readFile(str);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println(str);
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.AddAbstractComponent request;
		request = new CoreServicesStub.AddAbstractComponent();
		request.setCmp(str);
		//Invoca o servico
		AddAbstractComponentResponse response = null;
		try {
			try {
				try {
					response = stub.addAbstractComponent(request);
				} catch (CoreServicesDBHandlerExceptionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (CoreServicesParserConfigurationExceptionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CoreServicesSAXExceptionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CoreServicesIOExceptionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return();
	}

	public static boolean registerIT(String str){
		try {
			str = readFile(str);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.AddInstantiationType request;
		request = new CoreServicesStub.AddInstantiationType();
		request.setCmp(str);
		//Invoca o servico
		AddInstantiationTypeResponse response = null;
		try {
			response = stub.addInstantiationType(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return();
	}
	/*public static int registerAU(String str){
		try {
			str = readFile(str);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.AddAbstractUnit request;
		request = new CoreServicesStub.AddAbstractUnit();
		request.setCmp(str);
		//Invoca o servico
		AddAbstractUnitResponse response = null;
		try {
			response = stub.addAbstractUnit(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return();
	}*/


	/*	public static boolean registerUnitFile(String path, String filename){  //Delete after testing above code
			CoreServicesStub stub = null;
			try {
				stub = new CoreServicesStub();
			} catch (AxisFault e1) {
				e1.printStackTrace();
			}
			CoreServicesStub.AddUnitFile request;
			request = new CoreServicesStub.AddUnitFile();
			javax.activation.FileDataSource fileDataSource = new javax.activation.FileDataSource(path);
			javax.activation.DataHandler dh = new javax.activation.DataHandler(fileDataSource);
			request.setData(dh);
			request.setFileName(filename);
			AddUnitFileResponse response = null;		
			try {
				response = stub.addUnitFile(request);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			if(response.get_return()){
				return true;
			}else{
				return false;
			}
	}
	 */

	public static int registerCU(String str){
		try {
			str = readFile(str);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.AddConcreteUnit request;
		request = new CoreServicesStub.AddConcreteUnit();
		request.setCmp(str);
		//Invoca o servico
		AddConcreteUnitResponse response = null;
		try {
			response = stub.addConcreteUnit(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return();
	}
	private static boolean registerCUF(String str, String path) {
		try {
			str = readFile(str);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		CoreServicesStub stub = null;
		try {
			stub = new CoreServicesStub();
		} catch (AxisFault e1) {
			e1.printStackTrace();
		}
		//Cria a requisicao para o servico
		CoreServicesStub.AddUnitFile request;
		request = new CoreServicesStub.AddUnitFile();
		javax.activation.FileDataSource fileDataSource = new javax.activation.FileDataSource(path);
		javax.activation.DataHandler dh = new javax.activation.DataHandler(fileDataSource);
		request.setXml(str);
		request.setData(dh);

		//Invoca o servico
		AddUnitFileResponse response = null;
		try {
			response = stub.addUnitFile(request);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return response.get_return();
	}


}




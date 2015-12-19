package br.ufc.storm.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileHandler {

	public static boolean toHardDisk(String path, byte [] content){
		Path pathToFile = Paths.get(path);
		try {
			Files.createDirectories(pathToFile.getParent());
			Files.createFile(pathToFile);
			Files.write(pathToFile, content, StandardOpenOption.WRITE);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	public static boolean toHardDisk(String path, String content){//String
		FileWriter arq = null;
		try {
			arq = new FileWriter(path);
			PrintWriter gravarArq = new PrintWriter(arq); 
			content.replaceAll("\\", "\\\\");
			//content.replaceAll("\""", "");
			gravarArq.printf(content); 
			arq.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return false;

	}
	
	/**
	 * This method read a file from hard disk and return its content as a string
	 * @param pathname Path to file
	 * @return File content as string
	 * @throws IOException
	 */
	
	public static byte[] readFile(String pathname) throws IOException {


		Path path = Paths.get(pathname);
		byte[] data = Files.readAllBytes(path);
		return data;
	}
	public static String readTextFile(String pathname) throws IOException {

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
}

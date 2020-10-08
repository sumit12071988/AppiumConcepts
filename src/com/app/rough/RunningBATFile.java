package com.app.rough;

import java.io.IOException;

public class RunningBATFile {

	public static void main(String[] args) throws IOException, InterruptedException {

		Runtime.getRuntime().exec("C:\\ECLIPSE WORKSPACE\\AppiumPOMFramework\\src\\main\\java\\com\\udemy\\resources\\startServer.bat");
		
		//Emulator takes 8-10 seconds to boot up and get ready
		Thread.sleep(10000);

	}

}

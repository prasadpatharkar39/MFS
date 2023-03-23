package com.newTask.demo;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;

public class Mainclass {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PDDocument document  = new PDDocument();
		
		document.save("D:\\MIT\\MAGICFLARE\\TASKS\\MFS-master\\MFS\\new.pdf");

		System.out.println("PDF CREATED");
		document.close();
		
	}

}

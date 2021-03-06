package com.dan.web.controller;

import com.dan.dto.FileInfo;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;


/**
 * Created by dangao on 3/6/2019.
 */

@RestController
@RequestMapping("/file")
public class FileController
{
	private String folder = "E:\\Practice\\SpringSecurity\\security-demo\\src\\main\\java\\com\\dan\\web\\controller";
	@PostMapping
	public FileInfo upload(MultipartFile file) throws IOException
	{
		System.out.println(file.getName());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());


		File localFile = new File(folder, new Date().getTime() + ".txt");
		file.transferTo(localFile);
		return new FileInfo(localFile.getAbsolutePath());
	}

	@GetMapping("/{id}")
	public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		try(InputStream inputStream = new FileInputStream(new File(folder, id+".txt"));
		OutputStream outputStream = response.getOutputStream())
		{
			response.setContentType("application/x-download");
			response.addHeader("Content-Disposition","attachment;filename=test.txt");

			IOUtils.copy(inputStream, outputStream);
			outputStream.flush();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}

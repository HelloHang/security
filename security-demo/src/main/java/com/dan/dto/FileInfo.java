package com.dan.dto;

/**
 * Created by dangao on 3/6/2019.
 */
public class FileInfo
{
	public FileInfo(String path)
	{
		this.path = path;
	}
	private String path;

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}
}

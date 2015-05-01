package com.example.technicise.shabdo_khoj.swipehelpercalasses;

public class dumpclass
{
	public String filename;
	public String filePath;

	
	public dumpclass(String filename,String filePath)
    {
		this.filename	=	filename;
		this.filePath	=	filePath;
	}

    public String getname()
    {
        return filename;
    }
    public String getpath()
    {
        return filePath;
    }


    public void setpath(String path)
    {
        this.filePath = path;
    }


    public void setname(String name)
    {
        this.filename = name;
    }

}

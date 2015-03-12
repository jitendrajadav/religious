package com.gita.views;

public class Todo {

	int LineNo;
	String Adhyay;
	int ShlokNo;
	String Shlok;
	String MBVersion;
	String Comment;
	String QURAN;
	String KJVBilbe;
	
	public Todo()
	{
		
	}
	
	public Todo(int lineNo, String adhyay, int shlokNo,	String shlok,	String mBVersion,	String comment,	String quran,	String kjvBilbe)
	{
		this.LineNo = lineNo;
		this.Adhyay = adhyay;
		this.ShlokNo = shlokNo;
		this.Shlok = shlok;
		this.MBVersion = mBVersion;
		this.Comment = comment;
		this.QURAN = quran;
		this.KJVBilbe= kjvBilbe;
	}
	
	// getting lineNo
    public int getLineNo(){
        return this.LineNo;
    }
     
    // setting lineNo
    public void setLineNo(int lineNo){
        this.LineNo = lineNo;
    }

    // getting adhyay
    public String getAdhyay(){
        return this.Adhyay;
    }
     
    // setting adhyay
    public void setAdhyay(String adhyay){
        this.Adhyay = adhyay;
    }
    
    // getting shlokNo
    public int getShlokNo(){
        return this.ShlokNo;
    }
     
    // setting ShlokNo
    public void setShlokNo(int shlokNo){
        this.ShlokNo = shlokNo;
    }
    
    // getting Shlok
    public String getShlok(){
        return this.Shlok;
    }
     
    // setting Shlok
    public void setShlok(String shlok){
        this.Shlok = shlok;
    }
 
    // getting MBVersion
    public String getMBVersion(){
        return this.MBVersion;
    }
     
    // setting MBVersion
    public void setMBVersion(String mBVersion){
        this.MBVersion = mBVersion;
    }
    
    // getting Comment
    public String getComment(){
        return this.Comment;
    }
     
    // setting Comment
    public void setComment(String comment){
        this.Comment = comment;
    }
    
    // getting Quran
    public String getQuran(){
        return this.QURAN;
    }
     
    // setting Quran
    public void setQuran(String quran){
        this.QURAN = quran;
    }
    
    // getting KJVBilbe
    public String getKJVBilbe(){
        return this.KJVBilbe;
    }
     
    // setting KJVBilbe
    public void setKJVBilbe(String kjvBilbe){
        this.KJVBilbe = kjvBilbe;
    }
}

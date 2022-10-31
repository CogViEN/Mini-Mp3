


package newpackage;





public class modelJDBC
{
    private String tenBaiHat;
    private String tenCaSi;
    private int time;
    private String src;
    
            
    public modelJDBC(String tenBaiHat,String tenCaSi,int time,String src)
    {
        this.tenBaiHat = tenBaiHat;
        this.tenCaSi = tenCaSi;
        this.time = time;
        this.src = src;
    }

    @Override
    public String toString() {
        return "modelJDBC{" + "tenBaiHat=" + tenBaiHat + ", tenCaSi=" + tenCaSi + ", time=" + time + ", src=" + src + '}';
    }
    
    public String getTenBaiHat()
    {
        return tenBaiHat;
    }
    
    public String getTenCaSi()
    {
        return tenCaSi;
    }
    
    public int getTime()
    {
        return time;
    }
    
    public String getSRC()
    {
        return src;
    }
}

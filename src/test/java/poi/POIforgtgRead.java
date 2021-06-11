package poi;

import java.io.IOException;

public class POIforgtgRead {

	public static void main(String[] args)throws IOException  {
		// TODO Auto-generated method stub
		Readexcel obj=new Readexcel();
		String value=obj.readExcelFun(1,1,"Sheet1");
		System.out.println("value is====="+value);

	}

}

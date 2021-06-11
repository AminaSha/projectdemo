package poi;

import java.io.IOException;

public class POIforgfgRead {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		ReadExcel obj=new ReadExcel();
		String value=obj.readExcelFun(1,1,"student Details");
		System.out.println("value is====="+value);

	}

}

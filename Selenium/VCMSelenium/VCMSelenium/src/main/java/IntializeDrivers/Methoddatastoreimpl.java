package IntializeDrivers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Methoddatastoreimpl {
	
	
	//String Path = "C:\\Users\\ramesh.dumpati\\Desktop\\Book1.xlsx";
	FileInputStream ExcelFile;
	XSSFWorkbook ExcelWBook;
	XSSFSheet ExcelWSheet;
    String TestName;
    
    public Methoddatastoreimpl(String Sheetname , String TestName, String Path) throws IOException {
    	
   	 this.ExcelFile = new FileInputStream(Path);

   	 this.ExcelWBook = new XSSFWorkbook(ExcelFile);

        this.ExcelWSheet = ExcelWBook.getSheet(Sheetname);
        
        this.TestName = TestName;
   	
   	}
    
	public String getvalue(String Dataname) throws Exception {
		
	    Map<String , HashMap> mp = new HashMap<String , HashMap>();
        int rowTotal = ExcelWSheet.getLastRowNum();
        System.out.print(rowTotal);
		
        try {
		  for (int i = 1; i <=rowTotal; i++) {
			XSSFRow Row = ExcelWSheet.getRow(i);
			XSSFCell Cell = Row.getCell(0);
			
			
			String Value = Cell.getStringCellValue();
			 if (mp.containsKey(Value)){
				 
			 }
			 
			 else {
				 
				 HashMap<String ,String> map = new HashMap<String , String>(); 
		         mp.put(Value, map); }
			 
		  }
			 
			 
		  
		  for (Map.Entry<String, HashMap> entry : mp.entrySet()) {
			  String name = entry.getKey();
			  
			  for (int i = 1; i <=rowTotal; i++) {
					XSSFRow Row = ExcelWSheet.getRow(i);
					XSSFCell Cell = Row.getCell(0);
					String Value = Cell.getStringCellValue();
					
					 if (name.equals(Value)){
						 
						 XSSFCell Cell1= Row.getCell(1);
						 XSSFCell Cell2= Row.getCell(2);
						 HashMap<String, String> map = entry.getValue();
						 map.put(Cell1.getStringCellValue() , Cell2.getStringCellValue());
						  }
						 
					 }
			  
			  
		  }
		  
			 
		  
		  
	   HashMap<String , String> val =   mp.get(TestName);
		return val.get(Dataname);
		
}
  catch(Exception e) {
	  
	  return "";
	  
  }
        
	}
}

        
        


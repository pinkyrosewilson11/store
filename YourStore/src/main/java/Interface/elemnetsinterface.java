package Interface;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface elemnetsinterface {
	
	public void Datapath(String fpath) throws IOException;
	public int RowCount(String Sheetname);
	public void xpath_click(WebElement xp);
	public void mouse_hover(WebDriver driver,WebElement mh);

}

package bloc;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@SessionScoped
public class UI {

	private String out = "";

	public String getOut() { return out; }

	public void setOut(String out) { this.out = out; }

	public void up(){
		out = out.concat("\nUp!");
	}

	public void down(){
		out = out.concat("\nDown!");
	}

	public void left(){
		out = out.concat("\nLeft!");
	}

	public void right(){
		out = out.concat("\nRight!");
	}

	public void keypress(){
		out = out.concat("\nKey!");
	}

}

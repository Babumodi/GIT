
package myapps;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.server.ServiceLifecycle;
import javax.xml.rpc.server.ServletEndpointContext;

@WebService(name="manager")
public class AccountManagerServiceImpl implements ServiceLifecycle {
	ServletEndpointContext endPointCtx;
		
	public void init(Object context) throws ServiceException {
		System.out.println("AccountManagerService.init() added");		
		endPointCtx = (ServletEndpointContext) context;		
	}
	
	@WebMethod()
	public void login(String userName, String password) {
		System.out.println("AccountManagerService.login()");
		HttpSession session = endPointCtx.getHttpSession();  
		session.setAttribute("username", userName);
		session.setAttribute("password", password);		
	}

	@WebMethod()
	public String [] getLoginData() {
		System.out.println("AccountManagerService.getLoginData()");
		HttpSession session = endPointCtx.getHttpSession();  
		
		String userName = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
		return new String []{userName, password};
	}	

	@WebMethod()
	public void logout() {
		System.out.println("AccountManagerService.logout()");
		HttpSession session = endPointCtx.getHttpSession();  
		session.invalidate();
	}

	public void destroy() {
		System.out.println("AccountManagerService.destroy()");
	}
	
	
}


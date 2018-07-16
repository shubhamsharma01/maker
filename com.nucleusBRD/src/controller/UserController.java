package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.UserService;




@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UserController() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void UserControl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		User u=new User();
		UserService us=new UserService();
		u.setUser((String)request.getAttribute("user"));
		u.setPass((String)request.getAttribute("pass"));
		System.out.println(u.getUser()+"((((((((((((((((");
		String role=us.Finddb(u.getUser(),u.getPass());
		u.setRole(role);
		System.out.println(role);
		
		/*if(request.getParameter("button").equalsIgnoreCase("LoginPage"))
		{
			response.sendRedirect("UserLogin.jsp");
		}*/
		
		if(request.getParameter("hello").equalsIgnoreCase("submit"))
		{
			
		
			if(u.getRole()==null)
			{
				out.print("UserName/Password Not found");
			}
			else
			{
				if(u.getRole().equalsIgnoreCase("maker"))
				{
					HttpSession session=request.getSession(true);
					session.setAttribute("user", u.getUser());
					session.setAttribute("role",u.getRole());
				    RequestDispatcher rd=request.getRequestDispatcher("options1.jsp");
				    rd.forward(request, response);
					
				}
				else if(u.getRole().equalsIgnoreCase("checker"))
				{
					response.sendRedirect("welcomeChecker.jsp");
				}
				else
				{
					response.sendRedirect("UserLogin.jsp");
				}
			}
		}
		else
		{
			System.out.println("Still in user controller");
		}
		
	}
    
	
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
    	UserControl(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		UserControl(request,response);
	}

}

package testWeb.servlet;

import jakarta.servlet.http.*;
import testWeb.dao.impl.UserDeleteDAOImpl;
import testWeb.vo.UserInfo;

import java.io.IOException;

import jakarta.servlet.*;

public class UserDeleteServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		HttpSession session = req.getSession();
		UserInfo user=new UserInfo();
		user.setUsername((String) session.getAttribute("username"));
		UserDeleteDAOImpl dao = new UserDeleteDAOImpl();
		user.setRobotname(dao.SelectRobotname(user.getUsername()));
		if(dao.userdelete(user)>0) {
			res.sendRedirect("./userdeletesuccess.jsp");
		}else {
			res.sendRedirect("./userdeletefailure.jsp");
		}
	}
}

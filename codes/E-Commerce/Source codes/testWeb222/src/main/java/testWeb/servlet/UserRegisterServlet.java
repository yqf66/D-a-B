package testWeb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import testWeb.dao.*;
import testWeb.dao.impl.*;
import testWeb.vo.UserInfo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserRegisterServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		UserInfo user=new UserInfo();
		user.setUsername(req.getParameter("username"));
		user.setPhonenumber(req.getParameter("phonenumber"));
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("password"));
		user.setRobotname(req.getParameter("robotname"));
		PrintWriter out=res.getWriter();
		UserRegisterDAO dao=new UserRegisterDAOImpl();
		if(dao.UserRegister(user)==1) {
			//out.println("手机号已经被注册，请重新输入！");
			res.sendRedirect("./phonenumber.jsp");
		}
		else if(dao.UserRegister(user)==2) {
			//out.println("邮箱已经被注册，请重新输入！");
			res.sendRedirect("./mail.jsp");
		}
		else if(dao.UserRegister(user)==3) {
			//out.println("用户名已经被注册，请重新输入！");
			res.sendRedirect("./username.jsp");
		}
		else if(dao.UserRegister(user)==4) {
			//out.println("机器人名字已经被注册，请重新输入！");
			res.sendRedirect("./robotname.jsp");
		}
		else {
			res.sendRedirect("./login.jsp");
		}
	}
}
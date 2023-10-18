package testWeb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import testWeb.vo.*;
import testWeb.dao.InfoChangeDAO;
import testWeb.dao.impl.InfoChangeDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet("/changeRecord")
public class InfoChangeServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		/*HttpSession session = req.getSession();
		UserInfo user=new UserInfo();
		HistoryRecord record=new HistoryRecord();
		Exploration e=new Exploration();
        user.setUsername((String) session.getAttribute("username"));
        record.setNewRobotname(req.getParameter("newRobotname")); 
        record.setNewPicture(req.getParameter("newPicture")); 
        record.setNewexploration_time(req.getParameter("newexploration_time"));
        record.setNewtreasure(req.getParameter("newtreasure"));
        e.setNewrobotname(req.getParameter("newRobotname"));
        e.setRobotname(req.getParameter("newRobotname"));
        PrintWriter out = res.getWriter();
        InfoChangeDAO dao=new InfoChangeDAOImpl();
        if(dao.InfoChange(record, user,e)>0) {
        	res.sendRedirect("./return.jsp");
        }else {
        	out.println("数据库更新失败");
        }*/
		
		HistoryRecord record=new HistoryRecord();
        InfoChangeDAO dao=new InfoChangeDAOImpl();
		    record.setHistoryRecordID(Integer.parseInt(req.getParameter("historyRecordID")));
		    record.setRobotname(req.getParameter("robotname")); 
	        record.setPicture(req.getParameter("picture")); 
	        record.setExploration_time(req.getParameter("exploration_time"));
	        record.setTreasure(req.getParameter("treasure"));
	        if (dao.DataChange(record)>0) {
	        	res.sendRedirect("./ChangeSuccess.jsp");
	        }else {
	        	res.sendRedirect("./ChangeError.jsp");
	        }
		
		/*String[] selectedIDs = req.getParameterValues("selectedRecords");
        if (selectedIDs == null || selectedIDs.length == 0) {
            // 没有选择任何记录
            res.sendRedirect("./NoRecordsSelectedError.jsp");
            return;
        }

        int historyRecordID;
        try {
            historyRecordID = Integer.parseInt(selectedIDs[0]); // 只取第一个，因为只允许选择一个
        } catch (NumberFormatException e) {
            res.sendRedirect("./InvalidIDError.jsp");
            return;
        }

        HistoryRecord record = new HistoryRecord();
        record.setHistoryRecordID(historyRecordID);
        record.setNewRobotname(req.getParameter("newRobotname"));
        record.setNewPicture(req.getParameter("newPicture"));
        record.setNewexploration_time(req.getParameter("newexploration_time"));
        record.setNewtreasure(req.getParameter("newtreasure"));
        
        // ... 使用旧值设置record对象，因为DAO中的实现会基于新值是否为空来决定使用哪个值
        // 示例：record.setRobotname(OLD_VALUE); 

        InfoChangeDAO dao = new InfoChangeDAOImpl();
        if (dao.DataChange(record) > 0) {
            res.sendRedirect("./ChangeSuccess.jsp");
        } else {
            res.sendRedirect("./ChangeError.jsp");
        }*/
    }

}
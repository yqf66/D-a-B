package testWeb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import testWeb.vo.*;
import testWeb.dao.HistoryRecordDAO;
import testWeb.dao.InfoChangeDAO;
import testWeb.dao.impl.HistoryRecordDAOImpl;
import testWeb.dao.impl.InfoChangeDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet("/changeFor")
public class InfoChangeForServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		String[] selectedIDs = req.getParameterValues("selectedRecords");
		InfoChangeDAO dao=new InfoChangeDAOImpl();
		HistoryRecord record = dao.selectByID(Integer.valueOf(selectedIDs[0]));
		HttpSession session = req.getSession();
		session.setAttribute("robotname", record.getRobotname());
		session.setAttribute("exploration_time", record.getExploration_time());
		session.setAttribute("treasure", record.getTreasure());
		session.setAttribute("picture", record.getPicture());
		session.setAttribute("historyRecordID", record.getHistoryRecordID());
		req.getRequestDispatcher("change.jsp").forward(req, res);
    }

}
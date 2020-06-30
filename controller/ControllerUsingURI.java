package lmsTeamPro.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lmsTeamPro.command.CommandHandler;
import lmsTeamPro.command.NullHandler;

public class ControllerUsingURI extends HttpServlet{
	private Map<String, CommandHandler> commandHandlerMap =
			new HashMap<String, CommandHandler>();

	@Override
	protected void doGet(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String command = request.getRequestURI();
		
		if(command.indexOf(request.getContextPath())==0) {

			command = command.substring(request.getContextPath().length());
		}
		CommandHandler handler = commandHandlerMap.get(command);
		if(handler==null) {
			handler = new NullHandler();
		}
		String viewPage = null;
		try {
			viewPage = handler.process(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		System.out.println(viewPage);
		if(viewPage !=null) {
			String prefix = "/WEB-INF/view/";
			String suffix = ".jsp";
			viewPage = prefix+ viewPage +suffix;
			System.out.println("viewPage:"+viewPage);
			RequestDispatcher dispatcher=  request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request
			, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	@Override
	public void init() throws ServletException {
		String configFile = getInitParameter("configFile");
		String configFilePath = getServletContext().getRealPath(configFile);
		Properties prop = new Properties();
		try(FileReader fis = new FileReader(configFilePath)) {
			prop.load(fis);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		Iterator keyIter = prop.keySet().iterator();		
		while (keyIter.hasNext()) {
			String command = (String) keyIter.next();
			String handlerClassName = prop.getProperty(command);
			try {
				Class<?> handlerClass = Class.forName(handlerClassName);
				CommandHandler handlerInstance = (CommandHandler) handlerClass.newInstance();
				commandHandlerMap.put(command, handlerInstance);
				
				
			} catch (Exception e) {
				throw new ServletException(e);
			}
			
		}
		
	}
	
	

}

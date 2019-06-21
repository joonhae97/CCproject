package com.register.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.register.db.ApplyDTO;

import com.register.db.ApplyDAO;

public class BoardListCommand implements BoardCommand {

   public void execute(HttpServletRequest request, HttpServletResponse response) {
      
      ApplyDAO dao = new ApplyDAO();
      ArrayList<ApplyDTO> list = dao.list();
      
      request.setAttribute("list", list);
   }

}

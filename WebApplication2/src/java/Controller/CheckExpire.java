/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAO;
import Model.UserAccount;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Legon
 */
@WebServlet(name = "CheckExpire", urlPatterns = {"/CheckExpire"})
public class CheckExpire extends HttpServlet {

    DAO dao;
    int count = 0;

    public void init() {
        dao = new DAO();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CheckExpire</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckExpire at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mail = request.getParameter("id");
        String flag = "0";
        String tf = "0";
        
        ArrayList<UserAccount> list = new ArrayList<UserAccount>();
        list = dao.takeinfor();
        
        int iduser = 0;
        
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCode().equals(mail)) {
                flag = list.get(i).getCreateat();
                tf = "1";
            }
        }
        
        if (tf.equals("0")) {
            request.setAttribute("id", "0");
            request.getRequestDispatcher("errorresetpass.jsp").forward(request, response);
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        
        LocalDateTime now = LocalDateTime.now();
        String time = dtf.format(now).toString();
        for (int i = 0; i < time.length(); i++) {
            if (time.charAt(i) == 47) {
                StringBuilder myName = new StringBuilder(time);
                myName.setCharAt(i, '-');
                time = myName.toString();
            }

        }
        flag = flag + " " + time;

        String[] a = flag.trim().split(" ");

        if (a[0].equals(a[2])) {

            String[] s = a[1].trim().split(":");
            String[] s1 = a[3].trim().split(":");

            int tongs = Integer.parseInt(s[0]) * 3600 + Integer.parseInt(s[1]) * 60 + Integer.parseInt(s[2]);
            int tongs1 = Integer.parseInt(s1[0]) * 3600 + Integer.parseInt(s1[1]) * 60 + Integer.parseInt(s1[2]);
            int hieu = tongs1 - tongs;
            if (hieu > 60) {
                request.setAttribute("id", "1");

                request.getRequestDispatcher("errorresetpass.jsp").forward(request, response);
            }
            else{
                for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCode().equals(mail)) {
                iduser = list.get(i).getId();
            }
        }
                
                 request.setAttribute("id", iduser+"");
//             request.getRequestDispatcher("/profile?id="+iduser+"").forward(request, response);  
            request.getRequestDispatcher("/mailchangepass.jsp").forward(request, response);
            }
          

           
        } else {
            request.setAttribute("id", "1");

            request.getRequestDispatcher("errorresetpass.jsp").forward(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mail = (String) request.getParameter("email");

        String flag = "0";

        ArrayList<UserAccount> list = new ArrayList<UserAccount>();
        list = dao.takeinfor();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMail().equals(mail)) {
                flag = "1";
                try {
                    dao.updateCurrent(mail);
                } catch (Exception ex) {
                    Logger.getLogger(CheckExpire.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        request.setAttribute("flag", flag);
        request.getRequestDispatcher("forgotpass.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

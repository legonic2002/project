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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Legon href="/MyProject/markbook?id=<%=id%>&userName=<%=user%>"
 */
@WebServlet(name = "profile", urlPatterns = {"/profile"})
public class UserProfile extends HttpServlet {

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
            out.println("<title>Servlet Register</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Register at " + request.getContextPath() + "</h1>");
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

        String temp = (String) request.getParameter("id");

        int userid = 0;
        String fullname = "";
        String mail = "";
        String mobie = "";
        String password = "";
        String avatar_url = "";
        String status = "";
        String note = "";
        String createat = "";
        String code = "";
        String company = "";
        String position = "";
        String address = "";

        int id = Integer.parseInt(temp);
        ArrayList<UserAccount> list = new ArrayList<UserAccount>();
        list = dao.takeinfor();

        int iduser = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                userid = list.get(i).getId();
                fullname = list.get(i).getFullname();
                mail = list.get(i).getMail();
                mobie = list.get(i).getMobie();
                password = list.get(i).getPassword();
                avatar_url = list.get(i).getAvatar_url();
                status = list.get(i).getStatus();
                note = list.get(i).getNote();
                createat = list.get(i).getCreateat();
                code = list.get(i).getCode();
                company = list.get(i).getCompany();
                position = list.get(i).getPosition();
                address = list.get(i).getAddress();
            }
        }

        request.setAttribute("userid", "" + userid);
        request.setAttribute("fullname", fullname);
        request.setAttribute("mail", mail);
        request.setAttribute("mobie", mobie);
        request.setAttribute("password", password);
        request.setAttribute("avatar_url", avatar_url);
        request.setAttribute("status", status);
        request.setAttribute("note", note);
        request.setAttribute("createat", createat);
        request.setAttribute("code", code);
        request.setAttribute("company", company);
        request.setAttribute("position", position);
        request.setAttribute("address", address);

        request.getRequestDispatcher("userprofile.jsp").forward(request, response);
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

        String temp = (String) request.getParameter("id");
        String temp2 = (String) request.getParameter("fullname");
        String temp3 = (String) request.getParameter("mobie");
        String temp4 = (String) request.getParameter("avatar_url");
        String temp5 = (String) request.getParameter("note");
        String temp6 = (String) request.getParameter("company");
        String temp7 = (String) request.getParameter("position");
        String temp8 = (String) request.getParameter("address");

        String temp9 = dao.updateprofile(temp, temp2, temp3, temp4, temp5, temp6, temp7, temp8);

        int userid = 0;
        String fullname = "";
        String mail = "";
        String mobie = "";
        String password = "";
        String avatar_url = "";
        String status = "";
        String note = "";
        String createat = "";
        String code = "";
        String company = "";
        String position = "";
        String address = "";
        String role = "";

        int id = Integer.parseInt(temp);
        ArrayList<UserAccount> list = new ArrayList<UserAccount>();
        list = dao.takeinfor();

        int iduser = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                userid = list.get(i).getId();
                fullname = list.get(i).getFullname();
                mail = list.get(i).getMail();
                mobie = list.get(i).getMobie();
                password = list.get(i).getPassword();
                avatar_url = list.get(i).getAvatar_url();
                status = list.get(i).getStatus();
                note = list.get(i).getNote();
                createat = list.get(i).getCreateat();
                code = list.get(i).getCode();
                company = list.get(i).getCompany();
                position = list.get(i).getPosition();
                address = list.get(i).getAddress();
                role = list.get(i).getRole();
            }
        }
        if (role.equals(1)) {
            role = "Admin";
        }
        if (role.equals(2)) {
            role = "Manager";
        }
        if (role.equals(3)) {
            role = "Trainer";
        }
        if (role.equals(4)) {
            role = "Supporter";
        }
        if (role.equals(5)) {
            role = "Expert";
        }
        if (role.equals(6)) {
            role = "Client";
        }

        request.setAttribute("temp", temp9);
        request.setAttribute("userid", "" + userid);
        request.setAttribute("fullname", fullname);
        request.setAttribute("mail", mail);
        request.setAttribute("mobie", mobie);
        request.setAttribute("password", password);
        request.setAttribute("avatar_url", avatar_url);
        request.setAttribute("status", status);
        request.setAttribute("note", note);
        request.setAttribute("createat", createat);
        request.setAttribute("code", code);
        request.setAttribute("company", company);
        request.setAttribute("position", position);
        request.setAttribute("address", address);
        request.setAttribute("role", role);
        request.getRequestDispatcher("userprofile.jsp").forward(request, response);
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

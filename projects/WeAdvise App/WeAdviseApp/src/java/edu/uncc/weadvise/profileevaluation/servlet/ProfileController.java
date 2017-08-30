/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.weadvise.profileevaluation.servlet;

import edu.uncc.weadvise.profileevaluation.beans.Profile;
import edu.uncc.weadvise.profileevaluation.beans.Result;
import edu.uncc.weadvise.utils.ProfileEvaluater;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kapil
 */
public class ProfileController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProfileController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProfileController at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        int acadCount = Integer.parseInt(request.getParameter("academicInfoInput"));
        Profile profile = new Profile();
        profile.setAcademicInfoCount(acadCount);
        for(int i=1; i<= acadCount; i++){
            Profile.AcademicInfo acadInfo = new Profile.AcademicInfo();
            acadInfo.setDegreeName(request.getParameter("degreeName"+i));
            acadInfo.setUniveristyName(request.getParameter("universityName"+i));
            acadInfo.setGpa(Integer.parseInt(request.getParameter("gpa"+i)));
            profile.getAcadInfoList().add(acadInfo);
        }
        
        int workCount = Integer.parseInt(request.getParameter("workInfoInput"));
        profile.setWorkInfoCount(workCount);
        for(int i=1; i<= workCount; i++){
            Profile.WorkInfo workInfo = new Profile.WorkInfo();
            workInfo.setDesignation(request.getParameter("designation"+i));
            workInfo.setEmployer(request.getParameter("employer"+i));
            workInfo.setExperience(Integer.parseInt(request.getParameter("tenure"+i)));
            profile.getWorkInfoList().add(workInfo);
        }
        
        profile.setGreVerbal(Integer.parseInt(request.getParameter("greVerbal")));
        profile.setGreQuant(Integer.parseInt(request.getParameter("greQuant")));
        profile.setGreAWA(Float.parseFloat(request.getParameter("greAwa")));
        
        profile.setToefl(Integer.parseInt(request.getParameter("toefl")));
        profile.setTechnologies(request.getParameter("technology"));
        
        System.out.println(profile);
        
        Result result = ProfileEvaluater.evaluateProfile(profile);
        request.setAttribute("result", result);
        
        getServletContext().getRequestDispatcher("/profile_evaluation_result.jsp").forward(request, response);
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

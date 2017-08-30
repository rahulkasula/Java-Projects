/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.weadvise.discussion.servlet;

import edu.uncc.weadvise.discussion.beans.DiscussionComment;
import edu.uncc.weadvise.discussion.beans.DiscussionTopic;
import edu.uncc.weadvise.facade.WebServiceFacade;
import edu.uncc.weadvise.trainings.beans.Training;
import edu.uncc.weadvise.trainings.beans.TrainingRegistration;
import edu.uncc.weadvise.usermanagement.beans.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DiscussionController extends HttpServlet {
    private static final String ACTION = "action";
    private static final String VIEW_DISCUSSION = "view_discussions";
    private static final String CREATE_DISCUSSION = "create_discussion";
    private static final String GET_DISCUSSION = "get_discussion";
    private static final String POST_DISCUSSION_COMMENT = "post_discussion_comment";
    private static final String EDIT_DISCUSSION = "edit_discussion";
    private static final String DELETE_DISCUSSION = "delete_discussion";
    private static final String UPDATE_DISCUSSION = "update_discussion";
    private static final String DELETE_DISCUSSION_COMMENT = "delete_discussion_comment";

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
            out.println("<title>Servlet DiscussionController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DiscussionController at " + request.getContextPath() + "</h1>");
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
        String action = request.getParameter(ACTION);

        switch (action) {
            case VIEW_DISCUSSION:
                viewDiscussions(request, response);
                break;
            case GET_DISCUSSION:
                getDiscussion(request, response);
                break;
            case EDIT_DISCUSSION:
                editDiscussion(request, response);
                break;
            case DELETE_DISCUSSION:
                deleteDiscussion(request, response);
                break;
            case DELETE_DISCUSSION_COMMENT:
                deleteDiscussionComment(request, response);
                break;
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
        String action = request.getParameter(ACTION);

        switch (action) {
            case CREATE_DISCUSSION:
                createDiscussion(request, response);
                break;
            case POST_DISCUSSION_COMMENT:
                postDiscussionComment(request, response);
                break;
            case UPDATE_DISCUSSION:
                updateDiscussion(request, response);
                break;
        }
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

private void viewDiscussions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<DiscussionTopic> trainingList = WebServiceFacade.getDiscussions();
        request.setAttribute("discussionList", trainingList);
        getServletContext().getRequestDispatcher("/discussion_forum.jsp").forward(request, response);
    }

    private void createDiscussion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DiscussionTopic training = new DiscussionTopic();
        training.setContent(request.getParameter("question"));
        
         if (request.getSession().getAttribute("user") == null) {
             response.sendRedirect("login.jsp");
            return;
        } 
        User currentUser = (User) request.getSession().getAttribute("user");
        
        training.setCreatedBy(currentUser);

        int status = WebServiceFacade.createDiscussion(training);
        System.out.println("@@ response code : " + status);
        if (status == 200) {
            response.sendRedirect("DiscussionController?" + ACTION + "=" + VIEW_DISCUSSION);
        } else {
            getServletContext().getRequestDispatcher("/DiscussionController?" + ACTION + "=" + CREATE_DISCUSSION + "&status=1").forward(request, response);
        }
    }

    private void getDiscussion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<DiscussionTopic> discussionList = WebServiceFacade.getDiscussions();
        DiscussionTopic discussion = null;
        for (DiscussionTopic tr : discussionList) {
            if (tr.getId() == Long.parseLong(request.getParameter("id"))) {
                discussion = tr;
                break;
            }
        }
        boolean isRegistered = false;
        if (request.getSession().getAttribute("user") == null) {
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        } 
        User currentUser = (User) request.getSession().getAttribute("user");

        request.setAttribute("discussion", discussion);
        
        getServletContext().getRequestDispatcher("/discussion_view.jsp").forward(request, response);
    }
    
    private void postDiscussionComment(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DiscussionComment comment = new DiscussionComment();
        
        
         if (request.getSession().getAttribute("user") == null) {
             response.sendRedirect("login.jsp");
            return;
        } 
        User currentUser = (User) request.getSession().getAttribute("user");
        
        comment.setComentedUser(currentUser);
        long id = Long.parseLong(request.getParameter("training_id"));
        comment.setDiscussionId(id);
        comment.setComment(request.getParameter("comment"));

        int status = WebServiceFacade.postComment(comment);
        System.out.println("@@ response code : " + status);
        if (status == 200) {
            response.sendRedirect("DiscussionController?id="+id+"&action=get_discussion");
        } else {
            response.sendRedirect("DiscussionController?id="+id+"&action=get_discussion&status=1");
        }
    }
    
    private void editDiscussion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<DiscussionTopic> discussionList = WebServiceFacade.getDiscussions();
        DiscussionTopic discussion = null;
        for (DiscussionTopic tr : discussionList) {
            if (tr.getId() == Integer.parseInt(request.getParameter("id"))) {
                discussion = tr;
                break;
            }
        }
        request.setAttribute("discussion", discussion);
        getServletContext().getRequestDispatcher("/discussion_edit.jsp").forward(request, response);
    }
    
    private void updateDiscussion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiscussionTopic training = new DiscussionTopic();
        long id = Long.parseLong(request.getParameter("discussionId"));
        training.setId(id);
        training.setContent(request.getParameter("question"));

        int status = WebServiceFacade.updateDiscussion(training);
        System.out.println("@@ response code : " + status);
        if (status == 200) {
            response.sendRedirect("DiscussionController?" + ACTION + "=" + VIEW_DISCUSSION);
        } else {
            getServletContext().getRequestDispatcher("/DiscussionController?" + ACTION + "=" + EDIT_DISCUSSION + "id=" + id + "&status=1").forward(request, response);
        }
    }
    private void deleteDiscussion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DiscussionTopic discussion = new DiscussionTopic();
        long id = Long.parseLong(request.getParameter("id"));
        discussion.setId(id);
        int status = WebServiceFacade.deleteDiscussion(discussion);
        System.out.println("@@ response code : " + status);
        if (status == 200) {
            response.sendRedirect("DiscussionController?" + ACTION + "=" + VIEW_DISCUSSION);
        } else {
            getServletContext().getRequestDispatcher("DiscussionController?id=" + id + "&" + ACTION + "=" + GET_DISCUSSION + "&status=1").forward(request, response);
        }
    }
    private void deleteDiscussionComment(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DiscussionComment comment = new DiscussionComment();
        System.out.println(request.getParameter("discussion_id"));
        long discussionId = Integer.parseInt(request.getParameter("discussion_id"));
        long id = Long.parseLong(request.getParameter("id"));
        comment.setId(id);
        int status = WebServiceFacade.deleteDiscussionComment(comment);
        System.out.println("@@ response code : " + status);
        if (status == 200) {
            response.sendRedirect("DiscussionController?id="+discussionId+"&action=get_discussion");
        } else {
            response.sendRedirect("DiscussionController?id="+discussionId+"&action=get_discussion&status=1");
        }
    }

}

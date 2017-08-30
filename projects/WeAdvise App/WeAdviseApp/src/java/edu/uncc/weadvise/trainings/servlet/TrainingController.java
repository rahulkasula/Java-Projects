/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uncc.weadvise.trainings.servlet;

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

/**
 *
 * @author Kapil
 */
public class TrainingController extends HttpServlet {

    private static final String ACTION = "action";
    private static final String CREATE_TRAINING = "create_training";
    private static final String GET_TRAINING = "get_training";
    private static final String UPDATE_TRAINING = "update_training";
    private static final String APPROVE_TRAINING = "approve_training";
    private static final String EDIT_TRAINING = "edit_training";
    private static final String VIEW_TRAININGS = "view_trainings";
    private static final String DELETE_TRAINING = "delete_training";
    private static final String VIEW_MY_TRAININGS = "view_my_trainings";
    private static final String APPLY_TRAINING = "apply_training";

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
        String action = request.getParameter("action");

        switch (action) {
            case VIEW_TRAININGS:
                viewTrainings(request, response);
                break;
            case GET_TRAINING:
                getTraining(request, response);
                break;
            case EDIT_TRAINING:
                editTraining(request, response);
                break;
            case DELETE_TRAINING:
                deleteTraining(request, response);
                break;
            case APPROVE_TRAINING:
                approveTraining(request, response);
                break;
            case VIEW_MY_TRAININGS:
                viewMyTrainings(request, response);
                break;
            case APPLY_TRAINING:
                applyTraining(request, response);
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
        String action = request.getParameter("action");

        switch (action) {
            case CREATE_TRAINING:
                createTraining(request, response);
                break;
            case UPDATE_TRAINING:
                updateTraining(request, response);
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

    private void viewTrainings(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Training> trainingList = WebServiceFacade.getTrainings();
        request.setAttribute("trainingList", trainingList);
        getServletContext().getRequestDispatcher("/trainings_list.jsp").forward(request, response);
    }

    private void createTraining(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Training training = new Training();
        training.setName(request.getParameter("trainingName"));
        training.setDescription(request.getParameter("trainingDescription"));
        training.setTrainer_name(request.getParameter("trainerName"));
        System.out.println("@@@ session : " + request.getSession().getAttribute("user"));
        training.setCreated_by((User) request.getSession().getAttribute("user"));

        int status = WebServiceFacade.createTraining(training);
        System.out.println("@@ response code : " + status);
        if (status == 200) {
//            getServletContext().getRequestDispatcher("/TrainingController?" + ACTION + "=" + VIEW_TRAININGS).forward(request, response);
            response.sendRedirect("TrainingController?" + ACTION + "=" + VIEW_TRAININGS);
        } else {
            getServletContext().getRequestDispatcher("/TrainingController?" + ACTION + "=" + CREATE_TRAINING + "&status=1").forward(request, response);
        }
    }

    private void updateTraining(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Training training = new Training();
        long id = Long.parseLong(request.getParameter("trainingId"));
        training.setId(id);
        training.setName(request.getParameter("trainingName"));
        training.setDescription(request.getParameter("trainingDescription"));
        training.setTrainer_name(request.getParameter("trainerName"));
        System.out.println("@@@ session : " + request.getSession().getAttribute("user"));
        training.setCreated_by((User) request.getSession().getAttribute("user"));

        int status = WebServiceFacade.updateTraining(training);
        System.out.println("@@ response code : " + status);
        if (status == 200) {
//            getServletContext().getRequestDispatcher("/TrainingController?" + ACTION + "=" + VIEW_TRAININGS).forward(request, response);
            response.sendRedirect("TrainingController?" + ACTION + "=" + VIEW_TRAININGS);
        } else {
            getServletContext().getRequestDispatcher("/TrainingController?" + ACTION + "=" + EDIT_TRAINING + "id=" + id + "&status=1").forward(request, response);
        }
    }

    private void getTraining(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Training> trainingList = WebServiceFacade.getTrainings();
        Training training = null;
        for (Training tr : trainingList) {
            if (tr.getId() == Long.parseLong(request.getParameter("id"))) {
                training = tr;
                break;
            }
        }
        boolean isRegistered = false;
        if (request.getSession().getAttribute("user") == null) {
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        } 
        User currentUser = (User) request.getSession().getAttribute("user");

        ArrayList<TrainingRegistration> registrations = WebServiceFacade.getTrainingRegistrations();
        for (TrainingRegistration tr : registrations) {
            if((tr.getTraining().getId() == training.getId()) && (tr.getUser().getId() == currentUser.getId())){
                isRegistered = true;
            }
        }

        request.setAttribute("training", training);
        request.setAttribute("registered", isRegistered);
        
        System.out.println("displatcher " + getServletContext());
        System.out.println("displatcher " + getServletContext().getRequestDispatcher("/training_view.jsp"));
        getServletContext().getRequestDispatcher("/training_view.jsp").forward(request, response);
    }

    private void editTraining(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Training> trainingList = WebServiceFacade.getTrainings();
        Training training = null;
        for (Training tr : trainingList) {
            if (tr.getId() == Integer.parseInt(request.getParameter("id"))) {
                training = tr;
                break;
            }
        }
        request.setAttribute("training", training);
        getServletContext().getRequestDispatcher("/training_edit.jsp").forward(request, response);
    }

    private void deleteTraining(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Training training = new Training();
        long id = Long.parseLong(request.getParameter("id"));
        training.setId(id);
        int status = WebServiceFacade.deleteTraining(training);
        System.out.println("@@ response code : " + status);
        if (status == 200) {
            response.sendRedirect("TrainingController?" + ACTION + "=" + VIEW_TRAININGS);
        } else {
            getServletContext().getRequestDispatcher("TrainingController?id=" + id + "&" + ACTION + "=" + GET_TRAINING + "&status=1").forward(request, response);
        }
    }

    private void approveTraining(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ArrayList<Training> trainingList = WebServiceFacade.getTrainings();
        Training training = null;
        for (Training tr : trainingList) {
            if (tr.getId() == Integer.parseInt(request.getParameter("id"))) {
                training = tr;
                break;
            }
        }

        long id = Long.parseLong(request.getParameter("id"));
        training.setApproved(true);
        int status = WebServiceFacade.updateTraining(training);
        System.out.println("@@ response code : " + status);
        if (status == 200) {
//            getServletContext().getRequestDispatcher("/TrainingController?" + ACTION + "=" + VIEW_TRAININGS).forward(request, response);
            response.sendRedirect("TrainingController?" + ACTION + "=" + VIEW_TRAININGS);
        } else {
            getServletContext().getRequestDispatcher("TrainingController?id=" + id + "&" + ACTION + "=" + GET_TRAINING + "&status=1").forward(request, response);
        }
    }

    private void viewMyTrainings(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long userId = Long.parseLong(request.getParameter("user_id"));
        ArrayList<TrainingRegistration> registrationList = WebServiceFacade.getTrainingRegistrations();
        ArrayList<Training> trainingList = new ArrayList<Training>();
        for (TrainingRegistration tr : registrationList) {
            if (tr.getUser().getId() == userId) {
                trainingList.add(tr.getTraining());
            }
        }
        request.setAttribute("trainingList", trainingList);
        getServletContext().getRequestDispatcher("/trainings_list.jsp").forward(request, response);
    }

    private void applyTraining(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        long trainingId = Long.parseLong(request.getParameter("id"));
        User currentUser = (User) request.getSession().getAttribute("user");
        ArrayList<Training> trainingList = WebServiceFacade.getTrainings();
        Training training = null;
        for(Training tr : trainingList){
            if(tr.getId() == trainingId) {
                training = tr;
            }
        }
        TrainingRegistration registration = new TrainingRegistration();
        registration.setUser(currentUser);
        registration.setTraining(training);
        
        int status = WebServiceFacade.createTrainingRegistration(registration);
        
        if (status == 200) {
//            getServletContext().getRequestDispatcher("/TrainingController?" + ACTION + "=" + VIEW_TRAININGS).forward(request, response);
            response.sendRedirect("TrainingController?" + ACTION + "=" + VIEW_TRAININGS);
        } else {
            getServletContext().getRequestDispatcher("TrainingController?id=" + trainingId + "&" + ACTION + "=" + GET_TRAINING + "&status=1").forward(request, response);
        }
    }

}

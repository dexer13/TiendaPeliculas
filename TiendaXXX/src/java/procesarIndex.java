/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Mongo.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Copia;
import model.Pelicula;

/**
 *
 * @author Lenovo
 */
@WebServlet(urlPatterns = {"/procesarIndex"})
public class procesarIndex extends HttpServlet {

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
            if (request.getParameter("proceso").equalsIgnoreCase("guardarCopia")) {
                boolean deteriorada = Boolean.parseBoolean(request.getParameter("deteriorada"));
                String formato = request.getParameter("formato");
                float precio = Float.parseFloat(request.getParameter("precio"));
                List<Copia> copias = (List<Copia>) request.getSession().getAttribute("copias");
                if (copias == null) {
                    copias = new ArrayList<Copia>();

                }
                Copia c = new Copia();
                c.setDeteriorada(deteriorada);
                c.setFormato(formato);
                c.setPrecioAlquiler(precio);
                copias.add(c);
                copias.add(c);
                System.out.println(c.toString());
                request.getSession().setAttribute("copias", copias);
                out.print("datos guardados");
            }
            if (request.getParameter("proceso").equalsIgnoreCase("insertarPelicula")) {
                String titulo=request.getParameter("titulo");
                int anio=Integer.parseInt(request.getParameter("anio"));
                String critica=request.getParameter("critica");
                Conexion con=new Conexion();
                Pelicula p=new Pelicula();
                p.setTitulo(titulo);
                p.setAnio(anio);
                p.setCritica(critica);
                p.setCopias((List<Copia>)request.getSession().getAttribute("copias"));                
                con.GuardarPelicula(p); 
                out.print("pelicula registrada");
                request.getSession().setAttribute("copias", null);
            }
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
        processRequest(request, response);
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

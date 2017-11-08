/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uninphu.controller;

import edu.uninphu.ejb.DatosusuFacade;
import edu.uninphu.ejb.LoginFacade;
import edu.uninphu.models.Datosusu;
import edu.uninphu.models.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Portatil-BM
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController {

    private String user;
    private String pass;
    private Usuario usuario;
    private Datosusu datosu;

    private List<Usuario> listUSU;

    @EJB
    private LoginFacade lf;
    @EJB
    private DatosusuFacade duf;

    public LoginController() {
    }

    public String cerrarSesion() {
        FacesContext context = FacesContext.getCurrentInstance();

        ExternalContext externalContext = context.getExternalContext();

        Object session = externalContext.getSession(false);

        HttpSession httpSession = (HttpSession) session;

        httpSession.invalidate();
        return "index";
    }

    public String login() {

        usuario = lf.loginUsuario(user, pass);

        if (usuario != null) {
            datosu = duf.datoslog(usuario);
            return "perfil";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario o contraseña incorrectos intente de nuevo"));

        return "login";
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListUSU() {
        return listUSU;
    }

    public void setListUSU(List<Usuario> listUSU) {
        this.listUSU = listUSU;
    }

    public Datosusu getDatosu() {
        return datosu;
    }

    public void setDatosu(Datosusu datosu) {
        this.datosu = datosu;
    }

}

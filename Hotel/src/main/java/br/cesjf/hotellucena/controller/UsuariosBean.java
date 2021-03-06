/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.hotellucena.controller;

import br.cesjf.hotellucena.dao.UsuariosDAO;
import br.cesjf.hotellucena.model.Usuarios;
import java.util.ArrayList;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import java.io.IOException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.FillPatternType;

/**
 *
 * @author tassio
 */
@ManagedBean(name = "usuariosBean")
@ViewScoped
public class UsuariosBean {

    Usuarios usuario = new Usuarios();

    List usuarios = new ArrayList();
    
    List clientes = new ArrayList();

    //construtor
    public UsuariosBean() {
        usuarios = new UsuariosDAO().buscarTodas();
        usuario = new Usuarios();
        clientes = new UsuariosDAO().buscarClientes();
    }

    //Métodos dos botões 
    public void record(ActionEvent actionEvent) {
        new UsuariosDAO().persistir(usuario);
        usuarios = new UsuariosDAO().buscarTodas();
        usuario = new Usuarios();
    }

    public void exclude(ActionEvent actionEvent) {
        new UsuariosDAO().remover(usuario);
        usuarios = new UsuariosDAO().buscarTodas();
        usuario = new Usuarios();
    }

    //getters and setters
    public Usuarios getUsuarios() {
        return usuario;
    }

    public void setUsuarios(Usuarios usuario) {
        this.usuario = usuario;
    }

    public List getUsuarioss() {
        return usuarios;
    }

    public void setUsuarioss(List usuarios) {
        this.usuarios = usuarios;
    }

    public List getClientes() {
        return clientes;
    }

    public void setClientes(List clientes) {
        this.clientes = clientes;
    }
    
    public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow header = sheet.getRow(0);

        HSSFCellStyle cellStyle = wb.createCellStyle();
        //cellStyle.setFillForegroundColor(HSSFColor.GREEN.index);
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) {
            HSSFCell cell = header.getCell(i);

            cell.setCellStyle(cellStyle);
        }
    }

    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);

        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        //String logo = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "demo" + File.separator + "images" + File.separator + "prime_logo.png";

        // pdf.add(Image.getInstance(logo));
    }
    
    public void login() throws IOException {
        Usuarios usuarioLogado = new UsuariosDAO().getLogin(this.usuario);
        
        if (usuarioLogado != null)
        {
            HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            HttpServletResponse response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
            session.setAttribute("usuario", usuarioLogado);
            
            response.sendRedirect("index.xhtml");
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Login ou senha incorretos!",
							"Favor inserir usuário e senha novamente!"));
        }
    }
}

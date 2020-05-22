/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.hotellucena.controller;

import br.cesjf.hotellucena.dao.ReservasDAO;
import br.cesjf.hotellucena.model.Reservas;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import org.primefaces.model.chart.PieChartModel;


/**
 *
 * @author terra
 */
@Named
@ManagedBean
public class DashboardBean implements Serializable{
      
    private static final long serialVersionUID = 1L;
    private List<Reservas> reservas;
    private PieChartModel pieModel;
    
    public DashboardBean(){
        reservas = new ReservasDAO().buscarTodas();
    }
    
    @PostConstruct
    public void init() {  
        createPieModel();  
    }  
    
    public PieChartModel getPieModel() {  
        return pieModel;  
    }  
    
    
    
    private void createPieModel() {
        pieModel = new PieChartModel();
          
        pieModel.set("Carro", 1000);
        pieModel.set("Ônibus", 600);
        pieModel.set("Metrô", 1500);
        pieModel.set("Trem", 700);
        pieModel.set("Bicicleta", 100);
          
        pieModel.setTitle("Meio de Transporte");
        pieModel.setLegendPosition("w");
    }
    
}

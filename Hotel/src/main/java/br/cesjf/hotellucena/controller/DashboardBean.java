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
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.charts.bar.BarChartOptions;
import org.primefaces.model.charts.axes.cartesian.CartesianScales;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearAxes;
import org.primefaces.model.charts.axes.cartesian.linear.CartesianLinearTicks;
import org.primefaces.model.charts.optionconfig.legend.Legend;
import org.primefaces.model.charts.optionconfig.legend.LegendLabel;
import org.primefaces.model.charts.optionconfig.title.Title;

/**
 *
 * @author bibim
 */
@Named
@ManagedBean
public class DashboardBean implements Serializable{
      
    private static final long serialVersionUID = 1L;
    private List<Reservas> reservas;
    private List<Reservas> reservascheckout;
    private BarChartModel qrtReservados;
    private BarChartModel reservasConcluidas;
    
    public DashboardBean(){
        reservas = new ReservasDAO().buscarAtivos();
        reservascheckout = new ReservasDAO().buscarConcluidos();
    }
    
    @PostConstruct
    public void init() {  
        createQrtReservados();  
        createReservasConcluidas();  
    }  
    
    public BarChartModel getQrtReservados() {  
        return qrtReservados;  
    }  
    
    public BarChartModel getReservasConcluidas() {  
        return reservasConcluidas;  
    }  
    
    private void createQrtReservados() {
        qrtReservados = new BarChartModel();
        
        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        ticks.setBeginAtZero(true);
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);
         
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Gráfico de Reservas");
        options.setTitle(title);
 
        Legend legend = new Legend();
        legend.setDisplay(true);
        legend.setPosition("top");
        LegendLabel legendLabels = new LegendLabel();
        legendLabels.setFontStyle("bold");
        legendLabels.setFontColor("#2980B9");
        legendLabels.setFontSize(24);
        legend.setLabels(legendLabels);
        options.setLegend(legend);
 
    }
    
    private void createReservasConcluidas() {
        reservasConcluidas = new BarChartModel();
        
        BarChartOptions options = new BarChartOptions();
        CartesianScales cScales = new CartesianScales();
        CartesianLinearAxes linearAxes = new CartesianLinearAxes();
        CartesianLinearTicks ticks = new CartesianLinearTicks();
        ticks.setBeginAtZero(true);
        linearAxes.setTicks(ticks);
        cScales.addYAxesData(linearAxes);
        options.setScales(cScales);
         
        Title title = new Title();
        title.setDisplay(true);
        title.setText("Gráfico de Reservas Concluidas");
        options.setTitle(title);
 
        Legend legend = new Legend();
        legend.setDisplay(true);
        legend.setPosition("top");
        LegendLabel legendLabels = new LegendLabel();
        legendLabels.setFontStyle("bold");
        legendLabels.setFontColor("#2980B9");
        legendLabels.setFontSize(24);
        legend.setLabels(legendLabels);
        options.setLegend(legend);
 
    }
    
}

package com.onix.modulo.vista.beans.mantenimientos.aplicacion;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

@ManagedBean(name = "beanPrincipal")
@ViewScoped
public class BeanPrincipal {
	private ScheduleModel modelo;

	private LineChartModel lineModel1;

	@PostConstruct
	public void init() {
		modelo = new DefaultScheduleModel();
		
		lineModel1 = initLinearModel();
        lineModel1.setTitle("Crecimiento Registros Usuarios");
        lineModel1.setLegendPosition("e");
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
        lineModel1.setExtender("skinChart");
	}

	public ScheduleModel getModelo() {
		return modelo;
	}

	public void setModelo(ScheduleModel modelo) {
		this.modelo = modelo;
	}
	
	private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Usuario");

        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);

        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Roles");

        series2.set(1, 6);
        series2.set(2, 3);
        series2.set(3, 2);
        series2.set(4, 7);
        series2.set(5, 9);

        model.addSeries(series1);
        model.addSeries(series2);
        
        return model;
    }
	
	public LineChartModel getLineModel1() {
		return lineModel1;
	}
	
	public void setLineModel1(LineChartModel lineModel1) {
		this.lineModel1 = lineModel1;
	}
}

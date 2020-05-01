package br.com.app.sysacade.grafico;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.LinearAxis;

public class LineChartBean {

	private LineChartModel model;

	public LineChartBean() {

		model = new LineChartModel();

		BarChartSeries serie1 = new BarChartSeries();
		serie1.setLabel("Linha 1");
		serie1.set("2014-01-01", 51);
		serie1.set("2014-01-06", 22);
		serie1.set("2014-01-12", 65);
		serie1.set("2014-01-18", 74);
		serie1.set("2014-01-24", 24);
		serie1.set("2014-01-30", 51);

		LineChartSeries serie2 = new LineChartSeries();
		serie2.setLabel("Linha 2");
		serie2.setXaxis(AxisType.X2);
		serie2.setXaxis(AxisType.Y2);

		serie2.set("A", 52);
		serie2.set("B", 60);
		serie2.set("C", 110);
		serie2.set("D", 135);
		serie2.set("E", 120);

		model.addSeries(serie1);
		model.addSeries(serie2);

		model.setTitle("Multi Axis Chart");
		model.setMouseoverHighlight(false);

		model.getAxes().put(AxisType.X, new CategoryAxis("Anos"));
		model.getAxes().put(AxisType.X2, new CategoryAxis("Período"));

		Axis yAxis = model.getAxis(AxisType.Y);
		yAxis.setLabel("");
		yAxis.setMin(0);
		yAxis.setMax(200);

		Axis y2Axis = new LinearAxis("Número");
		y2Axis.setMin(0);
		y2Axis.setMax(200);

		model.getAxes().put(AxisType.Y2, y2Axis);

	}

	public LineChartModel getModel() {
		return model;
	}
}

package br.com.app.sysacade.grafico;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.LinearAxis;

@ManagedBean
public class GraficoBean {

	private LineChartModel lineChartModel;

	// definindo o modelo e as linhas do gráficos
	LineChartModel modelo = new LineChartModel();
	// definindo os pontos x e y
	LineChartSeries lineCharSerie = new LineChartSeries();

	public LineChartModel getLineModel() {
		return lineChartModel;
	}

	@PostConstruct
	public void init() {
		criarLinhasModelo();
	}

	private LineChartModel iniciarModeloLinear() {
		lineCharSerie.setLabel("Linha 1");

		for (int i = 0; i < 13; i++) {
			int intRandom = (int) (Math.random() * 50);
			//o i representa o eixo x e o intRandom representa o eixo y
			lineCharSerie.getData().put(i, intRandom);
		}

		modelo.addSeries(lineCharSerie);

		return modelo;
	}

	private void criarLinhasModelo() {

		lineChartModel = iniciarModeloLinear();
		
		
		/*
		lineChartModel.setTitle("Exemplo - Gráfico");
		//e = east e n = north
		lineChartModel.setLegendPosition("e");

		Axis yAxis = lineChartModel.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(50);
		yAxis.setTickFormat("%d");//formato decimal
		yAxis.setLabel("Unidade");

		Axis xAxis = lineChartModel.getAxis(AxisType.X);
		xAxis.setMin(0);
		xAxis.setMax(12);
		xAxis.setTickFormat("%d");//formato decimal
		xAxis.setLabel("Tempo");
		*/
		
		lineChartModel.setTitle("Exemplo - Gráfico");
		lineChartModel.setLegendPosition("e");
		
		BarChartSeries barCharSerie = new BarChartSeries();
		barCharSerie.setLabel("Linha 1");
		barCharSerie.set("2014-01-01", 51);
		barCharSerie.set("2014-01-06", 22);
		barCharSerie.set("2014-01-12", 65);
		barCharSerie.set("2014-01-18", 74);
		barCharSerie.set("2014-01-24", 24);
		barCharSerie.set("2014-01-30", 51);

		LineChartSeries lineCharSerie = new LineChartSeries();
		lineCharSerie.setLabel("Linha 2");
		lineCharSerie.setXaxis(AxisType.X2);
		lineCharSerie.setXaxis(AxisType.Y2);

		lineCharSerie.set("A", 52);
		lineCharSerie.set("B", 60);
		lineCharSerie.set("C", 110);
		lineCharSerie.set("D", 135);
		lineCharSerie.set("E", 120);

		modelo.addSeries(barCharSerie);
		modelo.addSeries(lineCharSerie);

		modelo.setTitle("Multi Axis Chart");
		modelo.setMouseoverHighlight(false);

		modelo.getAxes().put(AxisType.X, new CategoryAxis("Anos"));
		modelo.getAxes().put(AxisType.X2, new CategoryAxis("Período"));

		Axis yAxis = modelo.getAxis(AxisType.Y);
		yAxis.setLabel("");
		yAxis.setMin(0);
		yAxis.setMax(200);

		Axis y2Axis = new LinearAxis("Número");
		y2Axis.setMin(0);
		y2Axis.setMax(200);

	}
}

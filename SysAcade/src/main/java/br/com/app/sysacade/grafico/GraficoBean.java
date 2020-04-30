package br.com.app.sysacade.grafico;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

@ManagedBean
public class GraficoBean {

	private LineChartModel lineChartModel;

	// definindo o modelo e as linhas do gráficos
	LineChartModel modelo = new LineChartModel();
	// definindo os pontos x e y
	LineChartSeries serie = new LineChartSeries();

	public LineChartModel getLineModel() {
		return lineChartModel;
	}

	@PostConstruct
	public void init() {
		criarLinhasModelo();
	}

	private LineChartModel iniciarModeloLinear() {
		serie.setLabel("Linha 1");

		for (int i = 0; i < 13; i++) {
			int intRandom = (int) (Math.random() * 50);
			//o i representa o eixo x e o intRandom representa o eixo y
			serie.getData().put(i, intRandom);
		}

		modelo.addSeries(serie);

		return modelo;
	}

	private void criarLinhasModelo() {

		lineChartModel = iniciarModeloLinear();

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

	}
}

<template>
	<v-card
	rounded
	color="#fbfbfb"
	:loading="loading"
	>
		<v-card-actions>
			<v-col cols="12">
				<v-row
				align="start"
				justify="space-around"
				>
					<v-text-field
						flat
						solo
						hide-details
						prepend-inner-icon="mdi-magnify"
						label="Nome do equipamento"
						class="secondary--text"
						background-color="#ecedf0"
						style="border-radius: 5px; margin-left:20px; margin-right:40px;"
						v-model="txtInput"
					></v-text-field>

					<v-btn small color="primary"
					@click="refresh()"
					large
					style="margin-left:0px; margin-right:20px; margin-top:1px;"
					>Buscar</v-btn>
				</v-row>
			</v-col>
		</v-card-actions>

		<apexcharts 
		width="500" 
		height="350" 
		type="bar"
		:options="chartData.chartOptions" 
		:series="chartData.series"></apexcharts>
	</v-card>
</template>

<script>
import VueApexCharts from 'vue-apexcharts'
import EquipamentoService from '@/service/EquipamentoService';

export default {
  name: 'GraficoOee',
  components: {
    apexcharts: VueApexCharts,
  },
  data: function() {
    return {
			tipo: 'anual',
			ano: null,
			mes: null,
			loading: false,
			enableLabels: true,
			txtInput: 'REC-T1-LAMTRE-LF03',
			chartData: {
				series: [{
					name: 'REC-T1-LAMTRE-LF03',
					data: [80.60, 84.28, 83.69, 89.99, 72.50]
				}],
				chartOptions: {
					chart: {
						height: 350,
						type: 'bar',
						events: {
							dataPointSelection: (event, chartContext, config) => {		
								console.log(event);
								console.log(chartContext);
								console.log(config);

								/* Muda o período */
								console.log(this);
								let select = this.chartData.chartOptions.xaxis.categories[
									config.dataPointIndex
								];
								if (this.tipo == 'anual') {
									// Transforma em mensal
									this.enableLabels = false;
									this.ano = select;
									this.refresh();
								} else if (this.tipo == 'mensal') {
									// Transforma em diario
									this.enableLabels = false;
									this.mes = select;
									this.refresh();
								}
							}
						}
					},
					plotOptions: {
						bar: {
							dataLabels: {
								position: 'top', // top, center, bottom
							},
						}
					},
					dataLabels: {
						enabled: true,
						formatter: function (val) {
							return val.toFixed(2) + "%";
						},
						offsetY: -20,
						style: {
							fontSize: '12px',
							colors: ["#304758"]
						}
					},
					xaxis: {
						categories: [2015, 2016, 2017, 2018, 2019],
						position: 'top',
						axisBorder: {
							show: false
						},
						axisTicks: {
							show: false
						},
						crosshairs: {
							fill: {
								type: 'gradient',
								gradient: {
									colorFrom: '#D8E3F0',
									colorTo: '#BED1E6',
									stops: [0, 100],
									opacityFrom: 0.4,
									opacityTo: 0.5,
								}
							}
						},
						tooltip: {
							enabled: true,
						}
					},
					yaxis: {
						axisBorder: {
							show: true
						},
						axisTicks: {
							show: false,
						},
						labels: {
							show: true,
							formatter: function (val) {
								return val + "%";
							}
						},
						min: 0,
						max: 100
					},
					title: {
						text: `OEE anual do equipamento: REC-T1-LAMTRE-LF03`,
						floating: true,
						offsetY: 330,
						align: 'center',
						style: {
							color: '#444'
						}
					}
				}
			}
    }
	},
	methods: {
		refresh() {
			console.log(`Input -> ${this.txtInput}`);
			this.loading = '#ffb900';
			/* Realiza o GET request no backend */
			EquipamentoService.retrieveOee(
				this.txtInput,
				this.ano,
				this.mes
			).then(response => {
				/* Debug */
				console.log(response.data)
				/* Processa a resposta */
				let reqCategories = [];
				let reqData = [];
				for (let [key, value] of Object.entries(response.data['oees'])) {
					reqCategories.push(key);
					reqData.push(value);
				}

				/* Atualiza o DATA */
				this.tipo = response.data['tipoPeriodo'];
				this.chartData = {
					series: [{
						name: response.data['nomeEquipamento'],
						data: reqData
					}],
					chartOptions: {
						chart: {
							height: 350,
							type: 'bar',
							events: {
								dataPointSelection: (event, chartContext, config) => {
									console.log(event);
									console.log(chartContext);
									console.log(config);

									/* Muda o período */
									let select = this.chartData.chartOptions.xaxis.categories[
										config.dataPointIndex
									];
									if (this.tipo == 'anual') {
										// Transforma em mensal
										this.enableLabels = false;
										this.ano = select;
										this.refresh();
									} else if (this.tipo == 'mensal') {
										// Transforma em diario
										this.enableLabels = false;
										this.mes = select;
										this.refresh();
									}
								}
							}
						},
						plotOptions: {
							bar: {
								dataLabels: {
									position: 'top', // top, center, bottom
								},
							}
						},
						dataLabels: {
							enabled: this.enableLabels,
							formatter: function (val) {
								return val.toFixed(2) + "%";
							},
							offsetY: -20,
							style: {
								fontSize: '12px',
								colors: ["#304758"]
							}
						},
						xaxis: {
							categories: reqCategories,
							position: 'top',
							axisBorder: {
								show: false
							},
							axisTicks: {
								show: false
							},
							crosshairs: {
								fill: {
									type: 'gradient',
									gradient: {
										colorFrom: '#D8E3F0',
										colorTo: '#BED1E6',
										stops: [0, 100],
										opacityFrom: 0.4,
										opacityTo: 0.5,
									}
								}
							},
							tooltip: {
								enabled: true,
							}
						},
						yaxis: {
							axisBorder: {
								show: true
							},
							axisTicks: {
								show: false,
							},
							labels: {
								show: true,
								formatter: function (val) {
									return val + "%";
								}
							},
							min: 0,
							max: 100
						},
						title: {
							text: `OEE ${this.tipo} do equipamento: ${response.data['nomeEquipamento']}`,
							floating: true,
							offsetY: 330,
							align: 'center',
							style: {
								color: '#444'
							}
						}
					}
				};

				this.loading = false;
			});
		}
	}
}
</script>
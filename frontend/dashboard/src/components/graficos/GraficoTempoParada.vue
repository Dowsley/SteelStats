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

					<div 
					class="text-center"
					>
						<v-menu 
						origin="top center"
						transition="scale-transition"
						offset-y
						rounded="d-b-xl"
						>
							<template v-slot:activator="{ on, attrs }">
								<v-btn
									color="primary"
									dark
									v-bind="attrs"
									v-on="on"
								>
									{{tipoParada}}
								</v-btn>
							</template>

							<v-list>
								<v-list-item
									v-for="(item, index) in items"
									:key="index"
									@click="tipoParada=item.tipoParada; refresh()"
								>
									<v-list-item-title>{{ item.title }}</v-list-item-title>
								</v-list-item>
							</v-list>
						</v-menu>
					</div>

				</v-row>
			</v-col>
		</v-card-actions>

		<apexcharts 
		width="500" 
		height="350" 
		type="area"
		:options="chartData.chartOptions" 
		:series="chartData.series"></apexcharts>
	</v-card>
</template>

<script>
import VueApexCharts from 'vue-apexcharts';
import TempoParadaService from '@/service/TempoParadaService';

export default {
  name: 'GraficoOee',
  components: {
    apexcharts: VueApexCharts,
  },
  data: function() {
    return {
			/* Misc data */
			tipo: 'anual',
			ano: null,
			mes: null,
			loading: false,
			tipoParada: 'LIVRE',
			/* Dropdown data */
      items: [
        { title: 'Sistemas TI', tipoParada: 'SISTEMAS/TI'},
        { title: 'Utilidades', tipoParada: 'UTILIDADES' },
        { title: 'Ritmo', tipoParada: 'RITMO' },
				{ title: 'Programada', tipoParada: 'PROGRAMADA' },
				{ title: 'Externa', tipoParada: 'EXTERNA' },
				{ title: 'Livre', tipoParada: 'LIVRE' },
				// TODO: Implementar outros tipos de falha
      ],
			/* Chart data */
			chartData: {
				series: [{
						name: "LIVRE",
						data: [10, 41, 35, 51, 49, 62, 69, 91, 148]
				}],
				chartOptions: {
					chart: {
						height: 350,
						type: 'line',
						zoom: {
							enabled: false
						},
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
									this.ano = select;
									this.refresh();
								} else if (this.tipo == 'mensal') {
									// Transforma em diario
									this.mes = select;
									this.refresh();
								}
							}
						}
					},
					dataLabels: {
						enabled: false
					},
					stroke: {
						curve: 'smooth'
					},
					title: {
						text: 'Parada anual da área de Aciaria',
						align: 'left'
					},
					grid: {
						row: {
							colors: ['#f3f3f3', 'transparent'], // takes an array which will be repeated on columns
							opacity: 0.5
						},
					},
					xaxis: {
						categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep'],
					},
					tooltip: {
						enabled: true,
					},
					markers: {
						size: 1
					}
        },
			}
		}
	},
	methods: {
		refresh() {
			this.loading = '#ffb900';
			/* Realiza o GET request no backend */
			TempoParadaService.retrieveTempoParada(
				this.tipoParada,
				this.ano,
				this.mes
			).then(response => {
				/* Debug */
				console.log(response.data)
				/* Processa a resposta */
				let reqCategories = [];
				let reqData = [];
				for (let [key, value] of Object.entries(response.data['paradas'])) {
					reqCategories.push(key);
					reqData.push(value);
				}

				/* Atualiza o DATA */
				this.tipoParada = response.data['tipoParada'];
				this.tipo = response.data['tipoPeriodo'];
				this.chartData = {
					series: [{
						name: this.tipoParada,
						data: reqData
					}],
					chartOptions: {
						chart: {
							height: 350,
							type: 'line',
							zoom: {
								enabled: false
							},
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
										this.ano = select;
										this.refresh();
									} else if (this.tipo == 'mensal') {
										// Transforma em diario
										this.mes = select;
										this.refresh();
									}
								}
							}
						},
						dataLabels: {
							enabled: false
						},
						stroke: {
							curve: 'smooth'
						},
						title: {
							text: `Parada ${this.tipo} da área de Aciaria`,
							align: 'left'
						},
						grid: {
							row: {
								colors: ['#f3f3f3', 'transparent'], // takes an array which will be repeated on columns
								opacity: 0.5
							},
						},
						xaxis: {
							categories: reqCategories,
							tooltip: {
								enabled: true,
							}
						},
					},
				};
				this.loading = false;
			});
		}
	}
}
</script>
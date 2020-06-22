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
									v-if="tipoParada!=null"
								>
									{{tipoParada}}
								</v-btn>
								<v-btn
									color="primary"
									dark
									v-bind="attrs"
									v-on="on"
									v-else
								>
									Todos
								</v-btn>
							</template>

							<v-list>
								<v-list-item
									v-for="(item, index) in items"
									:key="index"
									@click="tipoParada=item.tipoParada; refresh();"
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
			categories: [2019, 2020],
			tipo: 'anual',
			ano: null,
			mes: null,
			loading: false,
			tipoParada: 'Todos',
			/* Dropdown data */
      items: [
        { title: 'Sistemas TI', tipoParada: 'SISTEMAS/TI'},
        { title: 'Utilidades', tipoParada: 'UTILIDADES' },
        { title: 'Ritmo', tipoParada: 'RITMO' },
				{ title: 'Programada', tipoParada: 'PROGRAMADA' },
				{ title: 'Externa', tipoParada: 'EXTERNA' },
				{ title: 'Livre', tipoParada: 'LIVRE' },
				{ title: 'Todos', tipoParada: 'TODOS' },
				// TODO: Implementar outros tipos de falha
      ],
			/* Chart data */
			chartData: {
				series: [{
						name: 'Todos',
						data: [271609,103894]
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
								/* Muda o período */
								console.log(config.dataPointIndex);
								let select = this.chartData.chartOptions.xaxis.categories[
									config.dataPointIndex
								];
								if (this.tipo == 'anual') {
									// Transforma em mensal
									console.log('Ano:'+select);
									this.ano = select;
									this.refresh();
								} else if (this.tipo == 'mensal') {
									// Transforma em diario
									console.log('Mes:'+select);
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
						curve: 'straight'
					},
					title: {
						text: 'Parada da área de Aciaria (anual)',
						align: 'left'
					},
					grid: {
						row: {
							colors: ['#f3f3f3', 'transparent'], // takes an array which will be repeated on columns
							opacity: 0.5
						},
					},
					xaxis: {
						categories: [2019,2020]
					},
					tooltip: {
							intersect: true,
							shared: false
					},
					markers: {
						size: 3,
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
				this.categories = reqCategories;
				this.chartData = {
					series: [{
						name: response.data['tipoParada'],
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
									/* Muda o período */
									console.log(chartContext);
									let select = this.categories[
										config.dataPointIndex
									];
									if (this.tipo == 'anual') {
										// Transforma em mensal
										console.log('Ano:'+select);
										this.ano = select;
										this.refresh();
									} else if (this.tipo == 'mensal') {
										// Transforma em diario
										console.log('Mes:'+select);
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
							curve: 'straight'
						},
						title: {
							text: `Parada da área de Aciaria (${this.tipo})`,
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
						},
						tooltip: {
								intersect: true,
								shared: false
						},
						markers: {
							size: 3,
						}
					},
				};
				this.loading = false;
				console.log(this.categories);
			});
		}
	}
}
</script>
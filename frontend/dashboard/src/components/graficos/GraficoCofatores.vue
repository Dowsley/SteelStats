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
		type="radar"
		height="350" 
		:options="chartData.chartOptions" 
		:series="chartData.series"></apexcharts>
	</v-card>
</template>

<script>
import VueApexCharts from 'vue-apexcharts'
import CofatoresService from '@/service/CofatoresService';

export default {
  name: 'GraficoCofatores',
  components: {
    apexcharts: VueApexCharts,
  },
  data: function() {
    return {
			loading: false,
			txtInput: 'REC-T2-FARP-STH37',
			chartData: {
				series: [{
					name: 'Qualidade',
					data: [80, 50, 30, 40, 100, 20],
				}, {
					name: 'Disponibilidade',
					data: [20, 30, 40, 80, 20, 80],
				}, {
					name: 'Performance',
					data: [44, 76, 78, 13, 43, 10],
				}],
				chartOptions: {
					chart: {
						height: 350,
						type: 'radar',
						dropShadow: {
							enabled: true,
							blur: 1,
							left: 1,
							top: 1
						}
					},
					title: {
						text: 'Cofatores do equipamento REC-T2-FARP-STH37'
					},
					stroke: {
						width: 2
					},
					fill: {
						opacity: 0.1
					},
					markers: {
						size: 0
					},
					xaxis: {
						categories: ['2011', '2012', '2013', '2014', '2015', '2016']
					}
				},
			}
    }
	},
	methods: {
		refresh() {
			console.log(`Input -> ${this.txtInput}`);
			this.loading = '#ffb900';
			/* Realiza o GET request no backend */
			CofatoresService.retrieveCofatores(
				this.txtInput,
			).then(response => {
				/* Debug */
				console.log(response.data)
				/* Processa a resposta */
				let anos = [];
				let qualidade = [];
				let disponibilidade = []
				let performance = [];
				for (let [key, value] of Object.entries(response.data['qualidade'])) {
					anos.push(key);
					qualidade.push(response.data['qualidade'][key]);
					disponibilidade.push(response.data['disponibilidade'][key]);
					performance.push(response.data['performance'][key]);
					console.log(value);
				}
				console.log(qualidade);
				console.log(performance);
				console.log(disponibilidade);
				/* Atualiza o DATA */
				this.chartData = {
					series: [{
						name: 'Qualidade',
						data: qualidade,
					}, {
						name: 'Disponibilidade',
						data: disponibilidade,
					}, {
						name: 'Performance',
						data: performance,
					}],
					chartOptions: {
						chart: {
							height: 350,
							type: 'radar',
							dropShadow: {
								enabled: true,
								blur: 1,
								left: 1,
								top: 1
							}
						},
						title: {
							text: `Cofatores do equipamento ${this.txtInput}`
						},
						stroke: {
							width: 2
						},
						fill: {
							opacity: 0.1
						},
						markers: {
							size: 0
						},
						xaxis: {
							categories: anos
						}
					},
				};

				this.loading = false;
			});
		}
	}
}
</script>
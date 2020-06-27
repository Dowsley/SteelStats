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
					<v-btn 
					icon
					color="#3a3c53"
					@click="refresh()"
					>
						<v-icon>mdi-refresh</v-icon>
					</v-btn>
				</v-row>
			</v-col>
		</v-card-actions>

		<DxSankey
			id="sankey"
			:data-source="data"
			source-field="source"
			target-field="target"
			weight-field="weight"
			title="Representação das Perdas de ACIARIA"
		>
			<DxTooltip
				:enabled="true"
				:customize-link-tooltip="customizeLinkTooltip"
			/>
			<DxNode
				:width="8"
				:padding="30"
			/>
			<DxLink color-mode="gradient"/>
		</DxSankey>
	</v-card>
</template>

<script>
// DOC: https://js.devexpress.com/Demos/WidgetsGallery/Demo/Charts/SankeyChart/Vue/GreenMist/
const staticData = [

];

import DxSankey, {
  DxTooltip,
  DxNode,
  DxLink
} from 'devextreme-vue/sankey';

import TipoPerdaService from '@/service/TipoPerdaService';

export default {
  components: {
    DxSankey,
    DxTooltip,
    DxNode,
    DxLink
  },
  data() {
    return {
			data: staticData,
			loading: false
    };
  },
  methods: {
    customizeLinkTooltip(info) {
      return {
        html: `<b>From:</b> ${info.source}<br/><b>To:</b> ${info.target}<br/><b>Weight:</b> ${info.weight}`
      };
		},
		refresh() {
			this.loading = '#ffb900';

			TipoPerdaService.retrieveTipoPerda(
				null,
				null,
				null
			).then(response => {
				console.log(response.data);
				let data = [];
				for (let i of Object.entries(response.data)) {
					data.push(
						{
							source: 'Total',
							weight: i[1]['segmento'],
							target: i[1]['tipo']
						}
					);
				}
				console.log(data);
				this.data = data;
				this.loading = false;
			});
		}
	},
	mounted () {
		this.refresh();
	}
};
</script>

<style>
#sankey {
	width: 600px;
}
</style>
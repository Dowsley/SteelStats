<template>
	<v-card
	rounded
	color="#fbfbfb"
	>
  <DxSankey
    id="sankey"
    :data-source="staticData"
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
  { source: 'Spain', target: 'United States of America', weight: 20 },
  { source: 'Germany', target: 'United States of America', weight: 80 },
  { source: 'France', target: 'United States of America', weight: 40 },
  { source: 'Germany', target: 'Great Britain', weight: 20 },
  { source: 'France', target: 'Great Britain', weight: 40 },
  { source: 'United States of America', target: 'Australia', weight: 60 },
  { source: 'United States of America', target: 'New Zealand', weight: 50 },
  { source: 'United States of America', target: 'Japan', weight: 30 },
  { source: 'Great Britain', target: 'New Zealand', weight: 40 },
  { source: 'Great Britain', target: 'Japan', weight: 10 }
];

import DxSankey, {
  DxTooltip,
  DxNode,
  DxLink
} from 'devextreme-vue/sankey';

export default {
  components: {
    DxSankey,
    DxTooltip,
    DxNode,
    DxLink
  },
  data() {
    return {
      staticData
    };
  },
  methods: {
    customizeLinkTooltip(info) {
      return {
        html: `<b>From:</b> ${info.source}<br/><b>To:</b> ${info.target}<br/><b>Weight:</b> ${info.weight}`
      };
    }
  }
};
</script>

<style>
#sankey {
    height: 440px;
}
</style>
<template>
  <div id="app">
    <Chart/>
    <RadialChart/>
  </div>
</template>

<script>
import Chart from './components/Chart.component.vue'
import RadialChart from './components/RadialChart.component.vue'

export default {
  name: 'app',
  components: {
    Chart,
    RadialChart
  },
}
</script>

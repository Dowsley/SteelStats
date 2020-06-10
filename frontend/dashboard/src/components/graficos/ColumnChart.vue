<template>
  <div class="example">
    <apexcharts width="500" height="350" type="bar" :options="chartOptions" :series="series"></apexcharts>
  </div>
</template>

<script>
import VueApexCharts from 'vue-apexcharts'

export default {
  name: 'ColumnChart',
  components: {
    apexcharts: VueApexCharts,
  },
  props: [
    'name',
    'data',
    'categories',
  ],
  watch: {
    data: function(newData) {
      this.series = [{
        name: this.series[0].name,
        data: newData
      }]
    },
    categories: function(newCategories) {
      this.chartOptions = {...this.chartOptions, ...{
        xaxis: {
          categories: newCategories,
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
      }}
    },
    name: function(newName) {
      this.series = [{
        name: newName,
        data: this.series[0].data
      }],
      this.chartOptions = {...this.chartOptions, ...{
        title: {
          text: `OEEs anuais do equipamento: ${newName}`,
          floating: true,
          offsetY: 330,
          align: 'center',
          style: {
            color: '#444'
          }
        }
      }}
    }
  },
  data: function() {
    return {
      series: [{
        name: this.name,
        data: this.data
      }],
      chartOptions: {
        chart: {
          height: 350,
          type: 'bar',
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
          categories: this.categories,
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
          text: `OEEs anuais do equipamento: ${this.name}`,
          floating: true,
          offsetY: 330,
          align: 'center',
          style: {
            color: '#444'
          }
        }
      },
    }
  }
}
</script>
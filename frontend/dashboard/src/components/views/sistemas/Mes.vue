<template>
  <v-container fluid>
    <v-row>
      <v-col cols="12">
        <v-row
          align="center"
          justify="space-around"
          style="height: 300px;"
        >
					<GraficoOee/>
					<GraficoCofatores/>

        </v-row>
        <v-row
          align="center"
          justify="space-around"
          style="height: 800px;"
        >
					<GraficoTempoParada/>
					<GraficoTipoPerda/>
        </v-row>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import GraficoOee from "@/components/graficos/GraficoOee.vue";
import GraficoCofatores from "@/components/graficos/GraficoCofatores.vue";
import GraficoTempoParada from "@/components/graficos/GraficoTempoParada.vue";
import GraficoTipoPerda from "@/components/graficos/GraficoTipoPerda.vue";


export default {
    name: "MES",
    components: {
			GraficoOee,
			GraficoCofatores,
			GraficoTempoParada,
			GraficoTipoPerda
    },
}
</script>

<style scoped>

</style>
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
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import GraficoOee from "@/components/graficos/GraficoOee.vue";
import GraficoCofatores from "@/components/graficos/GraficoCofatores.vue";

export default {
    name: "Equipamento",
    components: {
			GraficoOee,
			GraficoCofatores
    },
}
</script>

<style scoped>

</style>
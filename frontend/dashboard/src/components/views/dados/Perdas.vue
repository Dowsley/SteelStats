<template>
  <v-container fluid>
    <v-row>
      <v-col cols="12">
        <v-row
          align="center"
          justify="space-around"
          style="height: 300px;"
        >
					<GraficoTempoParada/>
        </v-row>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import GraficoTempoParada from "@/components/graficos/GraficoTempoParada.vue";

export default {
    name: "Perdas",
    components: {
			GraficoTempoParada,
    },
}
</script>

<style scoped>

</style>
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
        </v-row>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import GraficoOee from "@/components/graficos/GraficoOee.vue";

export default {
    name: "Equipamento",
    components: {
			GraficoOee,
    },
}
</script>

<style scoped>

</style>
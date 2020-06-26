<template>
  <v-container fluid>
    <v-row>
      <v-col cols="12">
        <v-row
          align="center"
          justify="space-around"
          style="height: 300px;"
        >
					<GraficoTipoPerda/>
        </v-row>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import GraficoTipoPerda from "@/components/graficos/GraficoTipoPerda.vue";

export default {
    name: "Aciaria",
    components: {
			GraficoTipoPerda,
    },
}
</script>

<style scoped>

</style>
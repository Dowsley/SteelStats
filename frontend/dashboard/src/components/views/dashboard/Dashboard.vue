<template>
  <v-container fluid>
    <v-row>
      <v-col cols="12">
        <v-row
          align="center"
          justify="center"
          style="height: 300px;"
        >

        </v-row>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: 'Dashboard',
  data () {
    return {
			texts: [
				'Ola',
				'Teste'
			],
			text: '',
			i: 0
    }
	},
	created () {
		this.text = this.texts[this.i];
	},
	methods: {
		update() {
			this.i += 1;
			this.text = this.texts[this.i];
		}
	}
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
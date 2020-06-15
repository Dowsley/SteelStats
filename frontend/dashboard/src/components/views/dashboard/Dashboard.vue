<template>
  <v-container fluid>
    <v-row>
      <v-col cols="12">
        <v-row
          align="center"
          justify="center"
          style="height: 300px;"
        >
					<v-card
						class="mx-auto"
						color="#26c6da"
						dark
						max-width="400"
					>
						<v-card-title>
							<v-icon
								large
								left
							>
								mdi-twitter
							</v-icon>
							<span class="title font-weight-light">Twitter</span>
						</v-card-title>

						<v-card-text class="headline font-weight-bold">
							{{text}}
						</v-card-text>

						<v-card-actions>
							<v-list-item class="grow">
								<v-list-item-avatar color="grey darken-3">
									<v-img
										class="elevation-6"
										src="https://pbs.twimg.com/profile_images/1057631480459886595/9VPdGJJz_400x400.jpg"
									></v-img>
								</v-list-item-avatar>

								<v-list-item-content>
									<v-list-item-title>Jair Bolsonaro</v-list-item-title>
								</v-list-item-content>

								<v-row
									align="center"
									justify="end"
								>
									<v-btn icon @click="update()">
										<v-icon class="mr-1">mdi-heart</v-icon>
									</v-btn>
									<span class="subheading mr-2">256</span>
									<span class="mr-1">·</span>
									<v-icon class="mr-1">mdi-share-variant</v-icon>
									<span class="subheading">45</span>
								</v-row>
							</v-list-item>
						</v-card-actions>
					</v-card>
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
				'ATENÇÃO PAIS: Vejam o conteúdo do kit-gay acaba d chegar nas escolas privadas p/ a criançada. http://bit.ly/NPmVGd',
				'Kkkkkkkkkk',
				'PSOL É O PT DE CALCINHA SUJA',
				'O que é golden shower?',
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
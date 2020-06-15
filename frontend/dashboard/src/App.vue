<template>
  <v-app id="app">
    <v-navigation-drawer
      v-model="drawer"
      clipped
      app
			class="primary"
			width="272"
    >
      <v-list dense>
				<v-text-field
					flat
					solo
					hide-details
					prepend-inner-icon="mdi-magnify"
					label=""
					class="secondary--text hidden-sm-and-down"
					background-color="#ecedf0"
					style="display:block; margin-right:12px; margin-left: 12px; border-radius: 5px;"
					height="38"
				></v-text-field>
        <v-list-item link to="/">
          <v-list-item-action>
            <v-icon>mdi-view-dashboard</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title 
						style="font-size:14px"
						class="secondary--text font-weight-bold neue"
						>
						Dashboard
						</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item link to="equipamento">
          <v-list-item-action>
            <v-icon>mdi-cog</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title
						style="font-size:14px"
						class="secondary--text font-weight-bold neue"
						>
						Equipamento
						</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar
      app
      clipped-left
			class="secondary"
			flat
    >
      <v-app-bar-nav-icon @click.stop="drawer = !drawer">
				<v-icon color="#DFE1E7">mdi-menu</v-icon>
			</v-app-bar-nav-icon>
      <v-toolbar-title class="primary--text">Application</v-toolbar-title>
    </v-app-bar>

    <v-content>
			<router-view/>
    </v-content>
  </v-app>
</template>

<script>
	

  export default {
    props: {
      source: String,
		},

		components: {
			
		},

    data: () => ({
      drawer: true,
    }),

    created () {
			this.$vuetify.theme.dark = false
    },
  }
</script>

<style scoped>
	#app {
		font-family: Helvetica; /* this was it */
		-webkit-font-smoothing: antialiased;
		-moz-osx-font-smoothing: grayscale;
	}
	.neue {
		font-family: "Helvetica Neue" !important;
	}
	.v-application {
    background-color: #ecedf0 !important;
	}
</style>
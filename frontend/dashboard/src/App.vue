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
					label="Buscar"
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

			<v-spacer></v-spacer>

			<v-toolbar-title 
			class="primary--text font-weight-bold neue"
			style = "margin-left: 276px; cursor: pointer;"
			@click="$router.push('/')"
			>
				Início
			</v-toolbar-title>

			<v-spacer></v-spacer>

			<v-btn icon>
				<v-icon color="#FFB900">mdi-bell</v-icon>
			</v-btn>

			<v-card 
			width="258" 
			height="43" 
			color="#222335"
			align-content="center"
			style="border-radius: 100px;"
			>
				<div style="margin-left:-12px; margin-top:-6px;">
					<v-list-item class="grow">
						<v-list-item-avatar>
							<v-img
								class="elevation-6"
								src="@/assets/img/profilepic.png"
							></v-img>
						</v-list-item-avatar>

						<v-row
							align="center"
							justify="space-between"
							>
							<v-list-item-content>
								<v-list-item-title
								style="font-size:16px; margin-left:40px;"
								class="textHelper--text font-weight-bold"
								>Taís Cirne</v-list-item-title>
							</v-list-item-content>
						</v-row>
						<v-row
							align="center"
							justify="end"
							>
							<v-btn icon>
								<v-icon color="#DFE1E7">mdi-chevron-down</v-icon>
							</v-btn>
						</v-row>
					</v-list-item>
				</div>
			</v-card>
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
	

	div.layout {
		text-align: center;
	}

	div.centre {
		display: block;
		margin-left: auto;
		margin-right: auto;
	}
</style>
<template>
  <v-app id="app">
    <v-navigation-drawer
      v-model="drawer"
      clipped
      app
			class="mainWhite"
			width="272"
    >
      <v-list>
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

				<!-- Abas do Menu Hamburguer Lateral -->
				<v-list-group
					v-for="item in items"
					:key="item.title"
					v-model="item.active"
					:prepend-icon="item.icon"
					no-action
				>
					<template v-slot:activator>
						<v-list-item-content>
							<v-list-item-title
							v-text="item.title"
							class="secondary--text font-weight-bold neue"
							></v-list-item-title>
						</v-list-item-content>
					</template>

					<v-list-item
					v-for="subItem in item.items"
          :key="subItem.title"
          @click="$router.push(subItem.link)"
					>
						<v-list-item-content>
							<v-list-item-title 
							v-text="subItem.title"
							class="secondary--text"
							></v-list-item-title>
						</v-list-item-content>
					</v-list-item>

				</v-list-group>

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
			class="mainWhite--text font-weight-bold neue"
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
			items: [
				{
					icon: 'mdi-view-dashboard',
					title: 'Dados',
					items: [
						{ title: 'Evento' , link: '/' },
						{ title: 'Máquina', link: '/equipamento' },
						{ title: 'Perda', link: '/' },
					],
				},
				{
					icon: 'mdi-bell',
					title: 'Área',
					active: false,
					items: [
						{ title: 'Trefila', link: '/' },
						{ title: 'Laminação', link: '/' },
						{ title: 'Sucata', link: '/' },
						{ title: 'Aciaria', link: '/' },
					],
				},
				{
					icon: 'mdi-cog',
					title: 'Sistemas',
					active: false,
					items: [
						{ title: 'PowerBI', link: '/' },
						{ title: 'MES', link: '/' },
						{ title: 'SAP', link: '/' },
					],
				},
			],
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

	.active {
		color: #3a3c53;
	}
</style>
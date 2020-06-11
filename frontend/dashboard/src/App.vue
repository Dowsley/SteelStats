<template>
  <v-app id="app">
    <v-navigation-drawer
      v-model="drawer"
      :clipped="$vuetify.breakpoint.lgAndUp"
      app
			class="primary"
			width="258"
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
						style="display:block; margin-right:12px; margin-left: 12px;"
					></v-text-field>
        <v-list-item link>
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
        <v-list-item link>
          <v-list-item-action>
            <v-icon>mdi-cog</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title
						style="font-size:14px"
						class="secondary--text font-weight-bold neue"
						>
						Settings
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
      <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      <v-toolbar-title class="primary--text">Application</v-toolbar-title>
    </v-app-bar>

    <v-content>
      <v-container
        class="fill-height"
        fluid
      >
        <v-row
          align="center"
          justify="center"
        >
          <v-col class="shrink">
            <v-tooltip right>
              <template v-slot:activator="{ on }">
                <v-btn
                  :href="source"
                  icon
                  large
                  target="_blank"
                  v-on="on"
                >
                  <v-icon large>mdi-code-tags</v-icon>
                </v-btn>
              </template>
              <span>Source</span>
            </v-tooltip>
          </v-col>
        </v-row>
      </v-container>
    </v-content>

    <v-footer app>
      <span>&copy; 2020</span>
    </v-footer>
  </v-app>
</template>

<script>
  export default {
    props: {
      source: String,
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
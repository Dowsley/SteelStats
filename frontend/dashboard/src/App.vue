<template>
  <div id="app">
		<Menu/>
		<main id="page-wrap">
			<router-view/>
		</main>
  </div>
</template>

<script>
import Menu from '@/components/Menu.component.vue';

export default {
	name: 'app',
	components: {
		Menu,
	} 
}
</script>

<!-- Estilização global para todas os componentes -->
<style>
	#app {
		font-family: 'Avenir', Helvetica, Arial, sans-serif;
		-webkit-font-smoothing: antialiased;
		-moz-osx-font-smoothing: grayscale;
		text-align: center;
		color: #2c3e50;
		margin-top: 60px;
	}
</style>
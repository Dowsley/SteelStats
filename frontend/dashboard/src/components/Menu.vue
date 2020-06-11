<template>
	<Push isOpen noOverlay width="258">
		<router-link to="/">Início</router-link>
		<br>
		<router-link to="equipamento">Equipamento</router-link>
		<br>
		<router-link to="perdas">Perdas</router-link>
	</Push>
</template>

<script>
// Import the CSS transitions you wish to use, in this case we are using `Slide`
import { Push } from 'vue-burger-menu';

export default {
	name: 'Menu',
	components: {
		Push,
	}
}
</script>

<style scoped>
	
</style>
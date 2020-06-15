<template>
	<v-card
		class="ma-auto"

	>
		<v-card-text>
			{{text}}
		</v-card-text>
	</v-card>
</template>

<script>
export default {
	name: 'Card',
  props: [
    'text',
	],
}
</script>

<style scoped>
	.v-card {
		color: #fbfbfb;
		border-radius:20px;
	}
</style>
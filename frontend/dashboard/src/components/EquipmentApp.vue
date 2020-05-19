<template>
    <div>
      <input type="text" v-model="txtInput">
      <input id="submitButton" type="submit" value="Pesquisar" v-on:click="refreshOees">
      <ChartComponent
        v-if="childDataLoaded"
        :name="name"
        :categories="categories"
        :data="data"
      />  
    </div>
</template>

<script>
import ChartComponent from "./Chart.component.vue"
import EquipmentDataService from '../service/EquipmentDataService';

export default {
    name: "InstructorApp",
    components: {
      ChartComponent
    },
    // Test
		data(){
			return{
        name: '',
        categories: [],
        data: [],
        childDataLoaded: false,
        txtInput: 'REC-T1-LAMTRE-LF03',
      }
    },
    methods: {
      refreshOees() {
        this.name = this.txtInput;
        EquipmentDataService.retrieveAnnualOees(this.name)
          .then(response => {
            console.log(response.data)
            let categories = [];
            let data = [];
            for (let [key, value] of Object.entries(response.data['oees'])) {
              categories.push(key);
              data.push(value);
            }
            this.name = response.data['equipmentName']
            this.categories = categories;
            this.data = data;
            this.childDataLoaded = true;
            console.log(this.name)
            console.log(this.categories)
            console.log(this.data)
          });
      }
    },
    created() {
      this.refreshOees();
    }
}
</script>

<style scoped>

</style>
import Vue from "vue";
import Router from "vue-router";
import EquipmentStats from "./components/EquipmentStats.vue";
//import Record from "./components/Record.vue";
 
Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/equipment",
      name: "equipment-stats",
      component: EquipmentStats
    }
  ]
});
import Vue from 'vue';
import Router from 'vue-router';

import DashboardComponent from '@/components/views/dashboard/Dashboard.vue';
import EquipmentoComponent from '@/components/views/equipamento/Equipamento.vue' ;
import PerdasComponent from '@/components/views/perdas/Perdas.vue' ;

Vue.use(Router)
export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      props: true,
      component: DashboardComponent
    },
    {
      path: '/perdas',
      name: 'perdas',
      props: true,
      component: PerdasComponent
    },
    {
      path: '/equipamento',
      name: 'equipamento',
      props: true,
      component: EquipmentoComponent
    }
  ]
})
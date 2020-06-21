import Vue from 'vue';
import Router from 'vue-router';

import DashboardView from '@/components/views/Dashboard.vue';
import EquipamentoView from '@/components/views/dados/Equipamento.vue';
import PerdasView from '@/components/views/dados/Perdas.vue';
import TrefilagemView from '@/components/views/area/Trefilagem.vue';
import AciariaView from '@/components/views/area/Aciaria.vue';
import MesView from '@/components/views/sistemas/Mes.vue';

Vue.use(Router)
export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      props: true,
      component: DashboardView
    },
    {
      path: '/perdas',
      name: 'perdas',
      props: true,
      component: PerdasView
    },
    {
      path: '/equipamento',
      name: 'equipamento',
      props: true,
      component: EquipamentoView
    },
    {
      path: '/trefilagem',
      name: 'trefilagem',
      props: true,
      component: TrefilagemView
    },
    {
      path: '/aciaria',
      name: 'aciaria',
      props: true,
      component: AciariaView
    },
    {
      path: '/mes',
      name: 'mes',
      props: true,
      component: MesView
    }
  ]
})
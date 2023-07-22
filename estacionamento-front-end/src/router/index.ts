import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/marcas/lista',
    name: 'marcas',
    component: () => import('../views/marcas/MarcasListView.vue')
  },
  {
    path: '/marcas/formulario',
    name: 'marcas-formulario',
    component: () => import('../views/marcas/MarcasFormView.vue'),
    children: [
      {
        path: '/marcas/formulario',
        name: 'marcas-formulario-editar-view',
        component: () => import('../views/marcas/MarcasFormView.vue')
      },
      {
        path: '/marcas/formulario',
        name: 'marcas-formulario-excluir-view',
        component: () => import('../views/marcas/MarcasFormView.vue')
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router

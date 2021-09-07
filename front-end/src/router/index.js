import Vue from 'vue'
import VueRouter from 'vue-router'
import Friends from '../views/Friends.vue'
import Home from '../views/Home.vue'
import Notifications from '../views/Notifications.vue'
import Questions from '../views/Questions.vue'
import Settings from '../views/Settings.vue'
import SignIn from '../components/SignIn.vue'
import SignUp from '../components/SignUp.vue'


Vue.use(VueRouter)

const routes = [
  
  {
    path: '/signin',
    name: 'SignIn',
    component: SignIn
  },
  {
    path: '/signup',
    name: 'SignUp',
    component: SignUp
  },
  {
    path: '/Friends',
    name: 'Friends',
    component: Friends
  },
  {
    path: '/Home',
    name: 'Home',
    component: Home
  },
  {
    path: '/Notifications',
    name: 'Notifications',
    component: Notifications
  },
  {
    path: '/Questions',
    name: 'Questions',
    component: Questions
  },
  {
    path: '/Settings',
    name: 'Settings',
    component: Settings
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router



// {
//   path: '/',
//   name: 'Home',
//   component: Home
// },
// {
//   path: '/about',
//   name: 'About',
//   // route level code-splitting
//   // this generates a separate chunk (about.[hash].js) for this route
//   // which is lazy-loaded when the route is visited.
//   component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
// },
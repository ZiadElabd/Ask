import Vue from 'vue'
import VueRouter from 'vue-router'
import Friends from '../views/Friends.vue'
import Home from '../views/Home.vue'
import Notifications from '../views/Notifications.vue'
import Questions from '../views/Questions.vue'
import Settings from '../views/Settings.vue'
import AnswerQuestion from '../views/AnswerQuestion.vue'
import AnsweredQuestion from '../views/AnsweredQuestion.vue'
import SignIn from '../components/SignIn.vue'
import SignUp from '../components/SignUp.vue'
import profile from '../views/profile.vue'



Vue.use(VueRouter)

const routes = [
  
  {
    path: '/',
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
    path: '/home',
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
    path: '/AnswerQuestion/:questionID',
    name: 'AnswerQuestion',
    component: AnswerQuestion
  },
  {
    path: '/AnsweredQuestion/:questionID',
    name: 'AnsweredQuestion',
    component: AnsweredQuestion
  },
  {
    path: '/Settings',
    name: 'Settings',
    component: Settings
  },
  {
    path: '/profile/:userName',
    name: 'profile',
    component: profile
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

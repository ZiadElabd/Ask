<template>
  <div id="app">
    <SignIn/>
    <SignUp/>
  </div>
</template>

<script>
import SignIn from './components/SignIn.vue'
import SignUp from './components/SignUp.vue'

export default {
  name: 'App',
  components: {
    SignIn,
    SignUp
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
 margin: auto;
}
</style>

<template>
  <div id="app">
    <Navbar />
   
  <router-view/>
    
  </div>
</template>

<script>
import Navbar from './components/nbar.vue';
export default {
  name: 'App',
  components: {
    Navbar,
    

      }
}
</script>

<style>
#app
{
  background-color: #131619;
  min-width: 100%;
  min-height: 100%;
}
.navbar
{
  display: flex;
  justify-content: space-between;
  background-color: #131619;
  z-index: 10000000;
  
}


</style>



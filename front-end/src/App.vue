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
.navbar
{
  display: flex;
  justify-content: space-between;
  background-color: black;
  
}

</style>



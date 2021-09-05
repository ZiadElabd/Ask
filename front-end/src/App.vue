<template>
  <div id="app">
    
    <div class="navbar ">

   <div class="container">
      <div>
      <b-navbar-brand href="#">ASKfm</b-navbar-brand>
    </div>
    <div>
      <b-nav>
        <b-nav-item active> <font-awesome-icon icon="home" /></b-nav-item>
        <b-nav-item><font-awesome-icon icon="question-circle" /></b-nav-item>
        <b-nav-item><font-awesome-icon icon="user-friends" /></b-nav-item>
        <b-nav-item ><font-awesome-icon icon="bolt" /></b-nav-item>
         
          <b-nav-item-dropdown right>
          <!-- Using 'button-content' slot -->
          <template #button-content>
            <em><font-awesome-icon icon="cog" /></em>
          </template>
          <b-dropdown-item href="#">Profile</b-dropdown-item>
          <b-dropdown-item href="#">Sign Out</b-dropdown-item>
        </b-nav-item-dropdown>

         <b-nav-item-dropdown right>
          <!-- Using 'button-content' slot -->
          <template #button-content>
            <em><font-awesome-icon icon="plus-square" /></em>
          </template>
          <b-dropdown-item href="#">Profile</b-dropdown-item>
          <b-dropdown-item href="#">Sign Out</b-dropdown-item>
        </b-nav-item-dropdown>
          
         
      </b-nav>
    </div>

   </div>


    </div>
  
    
  </div>
</template>

<script>
export default {
  name: 'App',
  components: {
    
    
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



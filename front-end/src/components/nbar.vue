<template>
     <div class="navbar ">

   <div class="container">
      <div>
      <b-navbar-brand href="#"><router-link to="/Home">ASKfm</router-link></b-navbar-brand>
    </div>
    <div>
      <b-nav>
        <b-nav-item active> <router-link to="/Home"><font-awesome-icon icon="home" /></router-link></b-nav-item>
        <b-nav-item><router-link to="/Questions"><font-awesome-icon icon="question-circle" /></router-link></b-nav-item>
        <b-nav-item><router-link to="/Friends"><font-awesome-icon icon="user-friends" /></router-link></b-nav-item>
        <b-nav-item ><router-link to="/Notifications"><font-awesome-icon icon="bolt" /></router-link></b-nav-item>
         
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
</template>
<script>
    export default {
        name: 'Navbar',
    }
</script>

<style scoped>  
  
.nav li a
{
  color: #898B8C;
}
.nav
{
  font-size: 130%;
}

 .navbar-brand a
{
  color: #EE1144;
  font-weight: bolder;
  font-family:'Lobster', cursive;
    text-decoration: none
}
.nav li a:hover ,.navbar-brand:hover
{
  color: #EE1144;
}
.nav li a:hover
{
  font-size: 97.5%;
}

 div > .navbar-brand
{
  font-family:'Lobster', cursive
}
.nav-link a:focus{
  color: #EE1144;
  font-size: 97.5%;
}
.container
{
  width: 60%;
}



 
</style>
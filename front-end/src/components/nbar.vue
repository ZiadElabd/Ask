<template>
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

 .navbar-brand 
{
  color: #EE1144;
  font-weight: bolder;
  font-family:'Lobster', cursive
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
.nav-link:focus{
  color: #EE1144;
  font-size: 97.5%;
}
.container
{
  width: 60%;
}
.nav-link
{
  color: #898B8C;
}


 
</style>
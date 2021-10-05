<template>
  <div class="navbar">
    <div class="container">
      <div>
        <b-navbar-brand href="#"
          ><router-link to="/home">ASKfm</router-link></b-navbar-brand
        >
      </div>
      <div>
        <b-nav>
          <b-nav-item active>
            <router-link to="/home"
              ><font-awesome-icon icon="home" /></router-link
          ></b-nav-item>
          <b-nav-item
            ><router-link to="/Questions"
              ><font-awesome-icon icon="question-circle" /></router-link
          ></b-nav-item>
          <b-nav-item
            ><router-link
              :to="{ name: 'profile', params: { userName: this.userName } }"
            >
              <b-avatar
                :src="decodeImage(userImage)"
                size="1.5rem"
              ></b-avatar></router-link
          ></b-nav-item>
          <b-nav-item
            ><router-link to="/Friends"
              ><font-awesome-icon icon="user-friends" /></router-link
          ></b-nav-item>
          <b-nav-item
            ><router-link to="/Notifications"
              ><font-awesome-icon icon="bolt" /></router-link
          ></b-nav-item>

          <b-nav-item-dropdown right>
            <!-- Using 'button-content' slot -->
            <template #button-content>
              <em><font-awesome-icon icon="cog" /></em>
            </template>
            <b-dropdown-item to="/Settings">Settings</b-dropdown-item>
            <b-dropdown-item  @click.native="reset" to="/">Log Out</b-dropdown-item>
          </b-nav-item-dropdown>
        </b-nav>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "Navbar",
  computed: {
    userName() {
      console.log("in nav bar => " + this.$store.state.userName);
      return this.$store.state.userName;
    },
    userImage(){
      return this.$store.state.userImage;
    }
  },
  methods:{
    reset(){
      fetch(
          "http://localhost:5050/logout/" + this.$store.state.userID ,
          {
            method: "post",
          }
      );
      this.$store.commit('reset');
    },
    decodeImage(image){
      return 'data:image/jpeg;base64,' + image;
    },
  },
  created() {
    console.log("nav created");
    console.log("in nav bar => " + this.$store.state.userName);
  },
};
</script>

<style scoped>
.navbar {
  top: 0;
  width: 100%;
  position: fixed;
}
.nav li a {
  color: #898b8c;
}
.nav {
  font-size: 110%;
}

.navbar-brand a {
  color: #ee1144;
  font-weight: bolder;
  font-family: "Lobster", cursive;
  text-decoration: none;
}
.nav li a:hover,
.navbar-brand:hover {
  color: #ee1144;
}
.nav li a:hover {
  font-size: 97.5%;
}

div > .navbar-brand {
  font-family: "Lobster", cursive;
}
.nav-link a:focus {
  color: #ee1144;
  font-size: 97.5%;
}
.container {
  width: 60%;
}
</style>

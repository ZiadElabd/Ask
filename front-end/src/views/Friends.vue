<template>
  <div class="friends">
    <Navbar />
    <div class="users container">
      <input
        type="search"
        v-model="searchValue"
        @keyup="filter"
        placeholder="Search using username"
      />

      <div
        class="user-content"
        v-for="user in users1"
        :key="user.userName"
        ref="user.userName"
      >
        <div class="user-img" @click="select(user)">
          <span>
            <b-avatar src="" size="3rem"></b-avatar>
          </span>
          <span
            >{{ user.firstName + " " + user.lastname
            }}<span class="username">{{ user.userName }}</span></span
          >
        </div>
        <div class="follow">
          <b-button
            variant="outline-danger"
            v-if="followers.includes(user.userName) == false"
            @click="afterfollow(user)"
            >Follow</b-button
          >
          <b-button
            variant="danger"
            v-if="followers.includes(user.userName) == true"
            @click="afterunfollow(user)"
            >Following</b-button
          >
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Navbar from "../components/nbar.vue";

export default {
  name: "Friends",
  data() {
    return {
      follow: false,
      searchValue: "",
      //followers:['omarrehan0020' , 'omarrehan0010'],
    };
  },
  methods: {
    afterfollow: function(user) {
      // follow this user
      console.log("userId = " + this.userID);
      console.log("userName = " + user.userName);
      fetch(
        "http://localhost:5050/followUser/" + this.userID + "/" + user.userName,
        {
          method: "post",
          headers: { "Content-Type": "application/json" },
        }
      );
      console.log("hhhhhhhhh");
      console.log("followers");
      console.log(this.followers);
      this.followers.push(user.userName);
      console.log("followers");
      console.log(this.followers);
    },
    afterunfollow: function(user) {
      // unfollow this user
      this.followers.splice(this.followers.indexOf(user.userName), 1);
      console.log(this.followers);
    },
    select: function(user) {
      //move to profile page
      this.$router.push({
        name: "profile",
        params: { userName: user.userName },
      });
      console.log(user.userName);
    },
    filter: function(users) {
      if (this.searchValue === "") {
        return users;
      }
      return users.filter(function(user) {
        return user.username.indexOf(this.searchValue) >= 0;
      });
    },
  },
  components: {
    Navbar,
  },
  computed: {
    userName() {
      return this.$store.state.userName;
    },
    userID() {
      return this.$store.state.userID;
    },
    users() {
      return this.$store.state.users;
    },
    followers() {
      return this.$store.state.followers;
    },
    users1() {
      return this.users.filter((user) => {
        return user.userName
          .toLowerCase()
          .includes(this.searchValue.toLowerCase());
      });
    },
  },
  created() {
    console.log("userID in questions page" + this.$store.state.userID);
    this.$store.dispatch("getUsers");
    this.$store.dispatch("getFollowers");
  },
};
</script>
<style scoped>
.friends {
  padding-top: 80px;
}
.users {
  width: 100%;
  height: 1000px;
  background-color: #fff;
  border-radius: 10px;
  padding: 20px;
}
.container {
  width: 40%;
}
.users input {
  width: 100%;
  height: 50px;
  padding: 10px;
  outline: none;
  border: 1px solid #ddd;
  margin-bottom: 50px;
}
.user-content {
  display: flex;
  justify-content: space-between;
  padding: 10px 0;
  border-bottom: 1px solid #ddd;
}
.user-img {
  cursor: pointer;
}
.username {
  display: block;
  font-size: 10px;
  color: rgb(165, 156, 156);
  margin-left: 48px;
  margin-top: -20px;
}
</style>

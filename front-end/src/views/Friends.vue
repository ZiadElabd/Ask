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
          <span class="avatar">
            <b-avatar :src="decodeImage(user.profilePhoto)" size="3rem"></b-avatar>
          </span>
          <span
            >{{ user.firstName + " " + user.lastName
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
  components: {
    Navbar,
  },
  data() {
    return {
      follow: false,
      searchValue: "",
    };
  },
  methods: {
    afterfollow: function(user) {
      fetch(
        "http://localhost:5050/followUser/" + this.userID + "/" + user.userName,
        {
          method: "post",
          headers: { "Content-Type": "application/json" },
        }
      );
      this.followers.push(user.userName);
    },
    afterunfollow: function(user) {
      fetch(
        "http://localhost:5050/unFollowUser/" + this.userID + "/" + user.userName,
        {
          method: "post",
          headers: { "Content-Type": "application/json" },
        }
      );
      this.followers.splice(this.followers.indexOf(user.userName), 1);
    },
    select: function(user) {
      this.$router.push({
        name: "profile",
        params: { userName: user.userName },
      });
    },
    filter: function(users) {
      if (this.searchValue === "") {
        return users;
      }
      return users.filter(function(user) {
        return user.username.indexOf(this.searchValue) >= 0;
      });
    },
    decodeImage(image){
      return 'data:image/jpeg;base64,' + image;
    },
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
.avatar{
  display: inline-block;
  margin-right: 10px;
}
.username {
  display: block;
  font-size: 10px;
  color: rgb(165, 156, 156);
  margin-left: 60px;
  margin-top: -20px;
}
</style>

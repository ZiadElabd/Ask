<template>
  <div class="friends">
    <Navbar />
    <div class="users container">
      <input type="search" v-model="searchValue"  @keyup="filter" placeholder="Search using username" />
      
     
    
     
      <div class="user-content" v-for="user in users1" :key="user.username" ref="user.username">
              <div class="user-img"  @click="select(user)">
                <span>
                  <b-avatar src="" size="3rem"></b-avatar>
                </span>
                <span>{{user.firstName + ' ' + user.lastName}}<span class="username">{{user.username}}</span></span> 
                
              </div>
              <div class="follow">
              <b-button variant="outline-danger" v-if="followers.includes(user.username)== false" @click="afterfollow(user)">Follow</b-button>
              <b-button variant="danger" v-if="followers.includes(user.username)== true" @click="afterunfollow(user)" >Following</b-button>
            </div>
            
      </div>
      
    </div>
  </div>
</template>

<script>
import Navbar from '../components/nbar.vue';

export default {
  name: 'Friends',
   data(){
     return{
       follow: false ,
       searchValue: '',
       followers:['omarrehan0020' , 'omarrehan0010'],
       users:[
         {
           username:'omarrehan0010',
           firstName: 'omar',
           lastName: 'rehan',
         },
         {
           username:'omarrehan0020',
           firstName: 'omar',
           lastName: 'rehan',
         },
         {
           username:'omarrehan0030',
           firstName: 'omar',
           lastName: 'rehan',
         },
         {
           username:'omarrehan0040',
           firstName: 'omar',
           lastName: 'rehan',
         },
       ]
     }
   },
   methods: {
        afterfollow: function(user) { 
            this.followers.push(user.username) ;
            console.log(this.followers);
        },
        afterunfollow:function(user) { 
            this.followers.splice(this.followers.indexOf(user.username),1);
            console.log(this.followers);
        },
        select: function(user){
          console.log( user.username);
        },
       filter: function(users) {

            if (this.searchValue === '') {
                return users;
            }
            return users.filter(function(user) {
              return user.username.indexOf(this.searchValue) >= 0;
            })
       }
    
        
    },
  components: {
    Navbar
  },
  computed:{
    /*
    users(){
      return this.$store.state.users;
    }
    */
   
    users1() {
      return this.users.filter(user => {
        return user.username.toLowerCase().includes(this.searchValue.toLowerCase())
      })
    }
  
  },
  created(){
    console.log('userID in questions page' + this.$store.state.userID);
    this.$store.dispatch('getFriends');
  }
}
</script>
<style scoped>
.friends
{
  padding-top: 80px;
}
.users
{
  width: 100%;
  height: 1000px;
  background-color: #FFF;
  border-radius: 10px ;
  padding: 20px;
}
.container
{
  width: 40%;
}
.users input
{
  width: 100%;
  height: 50px;
  padding: 10px;
  outline: none;
  border: 1px solid #DDD;
  margin-bottom: 50px;
}
.user-content
{
  display: flex;
  justify-content: space-between;
  padding: 10px 0 ;
  border-bottom: 1px solid #DDD;
}
.user-img
{
  cursor: pointer;
}
.username
{
  display: block;
  font-size: 10px;
  color: rgb(165, 156, 156);
 margin-left: 48px;
  margin-top: -20px;
}

</style>

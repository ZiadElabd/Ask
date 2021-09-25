<template>
<div class="home">
  <Navbar />
  <div class="container">
   
     <div v-for="msg in messages" class="home_item" :key="msg.stringID">
      <div class="quetion">
       <div v-if="msg.anoymos==false" class="send"  @click="select(msg.askedUser)" >
          <span>
            <b-avatar :src="msg.photo" size="1.5rem"></b-avatar>
          </span>
            <span class="sender"> {{msg.askedUser}}</span>
       </div>
        <h4>{{msg.questionText}}</h4>
      </div>
      <div class="name" @click="select(msg.replies.userNameAnswered)" >
          <div class="name_photo">
            <b-avatar :src="msg.photo"></b-avatar>
          </div>
          <div class="name_time">
            <h6 class="myname">
               <span> {{msg.replies.userNameAnswered}}</span>
            </h6>
            <div class="time">
                <span>{{msg.replies.time}}</span>
            </div>
          </div>
      </div>
      <div class="answer">
        <span>{{msg.replies.replyText}}</span>
      </div>
      <div class="like">
            <button class="btn btn-default" @click="toggleLike(msg)" ><span :class="[msg.replies.likes.includes(userName) ? 'red' : 'grey']"><i class="fa fa-heart" aria-hidden="true"></i></span>
{{ msg.replies.likes.length }}</button>
      </div>
    </div>
  </div>
  </div>
</template>

<script>
import Navbar from '../components/nbar.vue';
export default {
  name: 'Home',
  data(){
    return{
     liked: false,
     likesCount: 12,
    }
  },
  components: {
    Navbar
  },
  methods: {
    toggleLike: function(msg) { 
      if(msg.replies.likes.includes(this.userName)){
        msg.replies.likes.splice(msg.replies.likes.indexOf(this.userName));
      }else{
        msg.replies.likes.push(this.userName);
      }
      // request for like
    },
    select(userName){ 
      console.log("userName clicked => " + userName);
      this.$router.push({ name: 'profile', params: {userName:  userName } });
    }
        
  },
  computed:{
    messages(){
      return this.$store.state.homeQuestions;
    },
    userName(){
        return this.$store.state.userName;
    },
  },
  created(){
    console.log('userID in home page' + this.$store.state.userID);
    this.$store.dispatch('loadHome');
  }
}
</script>
<style scoped>
.home_item
{
  background-color: #FFF;
  padding: 20px;
  border-radius: 10px;
  margin: 20px;
}
.container 
{width: 60%;}
.sender 
{
  font-size: 13px;
}
.name
{
  display: flex;
}
.name .name_photo , .name .answer
{
  margin: 5px;
}
.name .myname
{
  margin-top: 6px;
  font-size: 90%;
}
.name_time{
  padding-left: 4px;
}
.name .time
{
  font-size: 70%;
  margin-top: -7px;
  color: #B9B9BB;
}
.like
{
  margin-left: -10px;
  margin-top: 5px;
  font-size: 150%;
}
.btn span.grey 
{
  color: #CDCDD9;
}
.btn span.red 
{
  color: #EE4C22;
}
.like .btn
{
  border: 0;
  font-size: 20px;
}
</style>

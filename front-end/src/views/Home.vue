<template>
<div class="home">
  <Navbar />
  <div class="container">
   
     <div v-for="msg in messages" class="home_item" :key="msg.id">
      <div class="quetion">
       <div v-if="msg.anymonous==false" class="send">
          <span>
            <b-avatar :src="msg.photo" size="1.5rem"></b-avatar>
          </span>
            <span class="sender"> {{msg.sender}}</span>
       </div>
        <h4>{{msg.question}}</h4>
      </div>
      <div class="name">
          <div class="name_photo">
            <b-avatar :src="msg.photo"></b-avatar>
          </div>
          <div class="name_time">
            <h6 class="myname">
               <span> {{msg.reciever}}</span>
            </h6>
            <div class="time">
                <span>{{msg.time}}</span>
            </div>
          </div>
      </div>
      <div class="answer">
        <span>{{msg.answer}}</span>
      </div>
      <div class="like">
             <button class="btn btn-default" @click="toggleLike(msg)" ><span :class="[msg.liked==true ? 'red' : 'grey']"><font-awesome-icon icon="home" /></span>
{{ msg.number_of_likes }}</button>
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
     messages: [
       {
         question : "What is your name",
         sender : "Ali Ibrahem",
         reciever : "Ali Ibrahem",
         photo : "https://placekitten.com/300/300",
         time : "10 days ago",
         answer : "My name is omar",
         liked : true ,
         number_of_likes : 12 ,
         anymonous : false ,
       },
       {
         question : "What is your name",
         sender : "Ali Ibrahem",
         reciever : "Ali Ibrahem",
         photo : "https://placekitten.com/300/300",
         time : "10 days ago",
         answer : "My name is omar",
         liked : true ,
         number_of_likes : 12 ,
         anymonous : true ,
       },
       {
         question : "What is your name",
         sender : "Ali Ibrahem",
         reciever : "Ali Ibrahem",
         photo : "https://placekitten.com/300/300",
         time : "10 days ago",
         answer : "My name is omar",
         liked : false ,
         number_of_likes : 11 ,
         anymonous : true ,
       }

     ]
    }
  },
  components: {
    Navbar
  },
  methods: {
        toggleLike: function(msg) { 
            msg.liked = ! msg.liked;

            msg.liked ? msg.number_of_likes++ : msg.number_of_likes--;
        }
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
